public class ARGB {

    public int alpha, red, green, blue;

    public ARGB(int pixel) {

        // extract different bits from pixel that stores the ARGB values
        this.alpha = (pixel >> 24) & 0xff;
        this.red = (pixel >> 16) & 0xff;
        this.green = (pixel >> 8) & 0xff;
        this.blue = pixel & 0xff;
    }

    public ARGB(int a, int r, int g, int b) {
        this.alpha = a;
        this.red = r;
        this.green = g;
        this.blue = b;
    }

    public int toInt() {
        // encode the ARGB values into a single integer
        return (this.alpha << 24) | (this.red << 16) | (this.green << 8) | blue;
    }
}

// -------------------------------------------------------------------------------
// Below are a few lines of code examples that you may find useful, as well as a few links to the relevant API documentation.

// -------------------------------------------------------------------------------
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;


// Read the input image file
File inputFile = new File(inputFileName);
BufferedImage originalImage = ImageIO.read(inputFile);


// Save the output image to a file
File outputFile = new File(outputFileName);
ImageIO.write(processedImage, "PNG", outputFile);


// Create a new image with <width> and <height>, and specifies the type of the colour value
BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);


// Read the documentation of the BufferedImage class at
// https://docs.oracle.com/en/java/javase/21/docs/api/java.desktop/java/awt/image/BufferedImage.html
// Specifically, pay attention to the following methods:
// - getRGB(int x, int y)
// - setRGB(int x, int y, int rgb)
// - getWidth()
// - getHeight()


// Read the documentation of the ImageIO class at
// https://docs.oracle.com/en/java/javase/21/docs/api/java.desktop/javax/imageio/package-summary.html
// Specifically, pay attention to the following methods:
// - read(File input)
// - write(RenderedImage im, String formatName, File output)