import java.awt.image.BufferedImage;
import java.io.IOException;

public class Solarize extends Converter{
    /*
     * To run class:
     * javac -d bin src/*.java
     * java -cp bin PixelCraft Solarize toronto.png
     */

  
    // 1. Convert Method Overridden
    @Override
    public void convert(String input, String output) throws IOException{
        // 1. Load Image
        BufferedImage image = loadImage(input);

        // Solarization is when bright pixels are darkened
        // For Red, Green and Blue in the RGB of a pixel's color
        //      if either color is greater than 128, then that ccolor is darkened, 
        //      otherwise, left alone

        // 2. Solarize nested loop
        //    Iterate row by row
        for(int y = 0; y < image.getHeight(); y++){
            // Iterate pixel by pixel
            for(int x = 0; x < image.getWidth(); x++){
                // A. Get the RGB values of the current pixel
                ARGB p = new ARGB(image.getRGB(x, y));

                // B. Darken bright colors
                int red = (p.red > 128) ? 255 - p.red : p.red;
                int green = (p.green > 128) ? 255 - p.green : p.green;
                int blue = (p.blue > 128) ? 255 - p.blue : p.blue;

                // C. Set the RGB values of the current pixel
                image.setRGB(x, y, new ARGB(p.alpha, red, green, blue).toInt());
            }
        }

        // 3. Save Image
        saveImage(image, output);
    }
}
