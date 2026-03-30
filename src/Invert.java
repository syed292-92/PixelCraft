import java.awt.image.BufferedImage;
import java.io.IOException;

public class Invert extends Converter{
    /*
    * To run class:
    * javac -d bin src/*.java
    * java -cp bin PixelCraft Invert toronto.png
    */

    @Override
    public void convert(String input, String output) throws IOException{
        // 1. Load Image
        BufferedImage image = loadImage(input);

        // a. Iterate through each y level (bottom to top)
        for(int y = 0; y < image.getHeight(); y++){
            // b. iterate through each pixel (left to right)
            for(int x = 0; x < image.getWidth(); x++){
                // c. Get the ARGB of current pixel
                ARGB p = new ARGB(image.getRGB(x, y));

                // d. Set inverted RGB
                image.setRGB(x, y, new ARGB(p.alpha, 255 - p.red, 255 - p.green, 255 - p.blue).toInt());
            }
        }

        // 2. Save Image
        saveImage(image, output);
    }
}
