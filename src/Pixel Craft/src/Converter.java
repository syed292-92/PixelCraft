import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Converter {
    public abstract void convert(String input, String output) throws IOException;

    protected BufferedImage loadImage(String file_Name) throws IOException {
        return ImageIO.read(new File(file_Name));
    }

    protected void saveImage(BufferedImage image, String file_Name) throws IOException {
        ImageIO.write(image, "PNG", new File(file_Name));
    }
}
