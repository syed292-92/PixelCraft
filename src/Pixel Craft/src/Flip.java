import java.awt.image.BufferedImage;
import java.io.IOException;

public class Flip extends Converter{
    // 1. Convert Method Overridden
    @Override
    public void convert(String input, String output) throws IOException{
        BufferedImage image = loadImage(input);
    }
}
