import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Converter {
    public abstract void convert(String input, String output) throws IOException;

    protected BufferedImage loadImage(String fileName) throws IOException {
        return ImageIO.read(new File(fileName));
    }

    protected void saveImage(BufferedImage image, String fileName) throws IOException {
        ImageIO.write(image, "PNG", new File(fileName));
    }
}