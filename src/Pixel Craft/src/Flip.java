import java.awt.image.BufferedImage;
import java.io.IOException;

public class Flip extends Converter{
    // 1. Convert Method Overridden
    @Override
    public void convert(String input, String output) throws IOException{
        // 1. Load Image
        BufferedImage image = loadImage(input);

        // 2. Nested for loop
        for(int x = 0; x < image.getWidth(); x++){
            for(int y = 0; y < image.getHeight() / 2; y++){
                // a. get RGB Values
                int top = image.getRGB(x, y);
                int bottom = image.getRGB(x, image.getHeight() - 1 - y);

                // b. set RGB Values
                image.setRGB(x, y, bottom);
                image.setRGB(x, image.getHeight() - 1 - y, top);
            }
        }

        // 3. Save Image
        saveImage(image, output);
    }
}
