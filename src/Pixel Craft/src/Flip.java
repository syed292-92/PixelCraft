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
            for(int y = 0; y < image.getHeight(); y++){

            }
        }

        // 3. Save Image


    }
}
