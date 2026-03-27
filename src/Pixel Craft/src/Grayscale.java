import java.awt.image.BufferedImage;
import java.io.IOException;

public class Grayscale extends Converter {
    @Override
    public void convert(String input, String output) throws IOException {
        BufferedImage image = loadImage(input);
        int width = image.getWidth();
        int height = image.getHeight();

        // iterate through all pixels
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                // current pixel
                ARGB pixel = new ARGB(image.getRGB(x, y));

                // Average out the colors for grayscale
                int gray = (pixel.red + pixel.green + pixel.blue) / 3;
                ARGB newPixel = new ARGB(pixel.alpha, gray, gray, gray);
                image.setRGB(x, y, newPixel.toInt());
            }
        }

        saveImage(image, output);
    }
}