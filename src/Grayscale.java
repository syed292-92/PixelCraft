import java.awt.image.BufferedImage;
import java.io.IOException;

public class Grayscale extends Converter {
    public void convert(String input, String output) throws IOException {
        BufferedImage image = loadImage(input);
        int width = image.getWidth();
        int height = image.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                ARGB pixel = new ARGB(image.getRGB(x, y));
                // Averaging RGB values for grayscale effect
                int gray = (pixel.red + pixel.green + pixel.blue) / 3;
                ARGB newPixel = new ARGB(pixel.alpha, gray, gray, gray);
                image.setRGB(x, y, newPixel.toInt());
            }
        }
        saveImage(image, output);
    }
}