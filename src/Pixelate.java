import java.awt.image.BufferedImage;
import java.io.IOException;

/*
Converts an image into a pixelated copy by grouping pixels into blocks.
With a defined block size this class uses nested loops and sub loops to fill spatial areas.
*/
public class Pixelate extends Converter {
    /*
     * javac -d bin src/*.java
     * java -cp bin PixelCraft Pixelate toronto.png
     */

    @Override
    public void convert(String input, String output) throws IOException {
        BufferedImage image = loadImage(input);
        int width = image.getWidth();
        int height = image.getHeight();

        // Defines the size of the pixel blocks. Higher numbers increase pixelation.
        int blockSize = 10;

        // Outer loops jump by the block size to find the start of each square
        for (int y = 0; y < height; y += blockSize) {
            for (int x = 0; x < width; x += blockSize) {

                // Get the color of the first pixel for the current block
                int referenceColor = image.getRGB(x, y);

                // Nested sub-loops to fill the block with the reference pixel color
                for (int blockY = 0; blockY < blockSize && (y + blockY) < height; blockY++) {
                    for (int blockX = 0; blockX < blockSize && (x + blockX) < width; blockX++) {

                        // Assign the reference color to the current pixel in the block
                        image.setRGB(x + blockX, y + blockY, referenceColor);
                    }
                }
            }
        }

        // Save the modified image to the output path
        saveImage(image, output);
    }
}