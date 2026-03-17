import java.awt.image.BufferedImage;
import java.io.IOException;

public class Grayscale extends Converter {
    @Override
    public void convert(String input, String output) throws IOException {
        BufferedImage img = loadImage(input);
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                ARGB pixel = new ARGB(img.getRGB(x, y));
                int avg = (pixel.red + pixel.green + pixel.blue) / 3;
                img.setRGB(x, y, new ARGB(pixel.alpha, avg, avg, avg).toInt());
            }
        }
        saveImage(img, output);
    }
}