import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Blurs an inputted image by averaging each pixel's colour
 * with its surrounding pixels in a 3x3 area.
 */

public class Grayscale extends Converter {
    /*
     * To run class:
     * javac -d bin src/*.java
     * java -Xss100M -cp bin PixelCraft Grayscale toronto.png
     * (needed since it will recursively call for each pixel
     * and java has a small stack size)
     */

    // main converter method
    @Override
    public void convert(String input, String output) throws IOException {
        BufferedImage image = loadImage(input);
        int width = image.getWidth();
        int height = image.getHeight();

        // Recursion for pixel converter begins at x=0 and y = 0.
        recursivePixelGrayscale(image, 0, 0, width, height);

        saveImage(image, output);
    }

    private void recursivePixelGrayscale(BufferedImage image, int x, int y, int width, int height) {
        /*
         * Base Case:
         * Once y is the same as the image height, stop the recursion calls.
         */
        if (y == height) {
            return; // cannot return a value since the method recursivePixelGrayscale is void.
        }

        // current pixel in recursivePixelGrayscale:
        ARGB pixel = new ARGB(image.getRGB(x, y));

        // Average of colors needed for grayscale class
        int averageOfColors = (pixel.red + pixel.green + pixel.blue) / 3;
        // new ARGB object that has the averged color applied to all Red Green and Blue
        // Elements
        ARGB newPixel = new ARGB(pixel.alpha, averageOfColors, averageOfColors, averageOfColors);
        // Update the image at (x, y) so the new grayscale pixel is added
        image.setRGB(x, y, newPixel.toInt());

        /*
         * Recursive step:
         * Increment x and y coordinates
         */

        if (x + 1 < width) {
            // Checks if the next horizontal pixel is within the image width
            recursivePixelGrayscale(image, x + 1, y, width, height);
        } else {
            // Since the row has been complete, x is reseted and it moves onto the next
            // vertical position
            recursivePixelGrayscale(image, 0, y + 1, width, height);
        }
    }
}