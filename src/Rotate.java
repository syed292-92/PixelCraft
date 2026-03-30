import java.awt.image.BufferedImage;
import java.io.IOException;

/*
To run this class:
javac -d bin src/*.java
java -cp bin PixelCraft Rotate toronto.png

Rotates an inputted image by 90 degrees clockwise.
*/
public class Rotate extends Converter {
    // main converter method
    @Override
    public void convert(String input, String output) throws IOException {
        BufferedImage image = loadImage(input);
        int width = image.getWidth();
        int height = image.getHeight();

        // After 90 degree clockwise rotation width and height values are swapped
        BufferedImage rotatedImage = new BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB);

        // Loops through every pixel to perform the rotation
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // current pixel in interation
                int pixel = image.getRGB(x, y);
                // Maps original coordinates to new rotated coordinates
                rotatedImage.setRGB(height - 1 - y, x, pixel);
            }
        }

        saveImage(rotatedImage, output);
    }
}