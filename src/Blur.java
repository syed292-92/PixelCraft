import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Blurs an inputted image by replacing each pixel's colour with the
 * average colour of itself and its surrounding pixels in a 3x3 area.
 * Edge and corner pixels are handled naturally by only including adjacent
 * pixels that fall within the image boundaries.
 */
public class Blur extends Converter {
    public void convert(String input, String output) throws IOException {
        BufferedImage image = loadImage(input);
        int width = image.getWidth();
        int height = image.getHeight();
        // Output image has the same dimensions as the input
        // TYPE_INT_ARGB tells how to store color data for each pixel
        BufferedImage blurredImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        /*
         * loop conditions:
         * visits every pixel, so 1 outer loops
         * checks every adjacent pixel, so 1 inner loops
         */
        // going through every pixel in the image, row by row and top to bottom
        for (int y = 0; y < height; y++) {
            // For each row, moves left to right across each iteration
            for (int x = 0; x < width; x++) {
                // Recieves ARGB values from adjacents pixels in 3x3 area

                // counts tracks the number of valid adjacent pixels found in the 3x3 area.
                int totalAlpha = 0, totalRed = 0, totalGreen = 0, totalBlue = 0, count = 0;

                // includes top-left pixel if it is within the image boundaries
                if (x - 1 >= 0 && y - 1 >= 0) {
                    ARGB currentPixel = new ARGB(image.getRGB(x - 1, y - 1));
                    totalRed += currentPixel.red;
                    totalGreen += currentPixel.green;
                    totalBlue += currentPixel.blue;
                    totalAlpha += currentPixel.alpha;
                    count++;
                }
                // includes top-middle pixel if the row above exists
                if (y - 1 >= 0) {
                    ARGB currentPixel = new ARGB(image.getRGB(x, y - 1));
                    totalRed += currentPixel.red;
                    totalGreen += currentPixel.green;
                    totalBlue += currentPixel.blue;
                    totalAlpha += currentPixel.alpha;
                    count++;
                }
                // include top-right pixel if it is within the image boundaries
                if (x + 1 < width && y - 1 >= 0) {
                    ARGB currentPixel = new ARGB(image.getRGB(x + 1, y - 1));
                    totalRed += currentPixel.red;
                    totalGreen += currentPixel.green;
                    totalBlue += currentPixel.blue;
                    totalAlpha += currentPixel.alpha;
                    count++;
                }
                // include middle-left pixel if the column to the left exists
                if (x - 1 >= 0) {
                    ARGB currentPixel = new ARGB(image.getRGB(x - 1, y));
                    totalRed += currentPixel.red;
                    totalGreen += currentPixel.green;
                    totalBlue += currentPixel.blue;
                    totalAlpha += currentPixel.alpha;
                    count++;
                }
                // center pixel is alwasy valid
                {
                    ARGB currentPixel = new ARGB(image.getRGB(x, y));
                    totalRed += currentPixel.red;
                    totalGreen += currentPixel.green;
                    totalBlue += currentPixel.blue;
                    totalAlpha += currentPixel.alpha;
                    count++;
                }
                // includes middle-right pixel if the column to the right exists
                if (x + 1 < width) {
                    ARGB currentPixel = new ARGB(image.getRGB(x + 1, y));
                    totalRed += currentPixel.red;
                    totalGreen += currentPixel.green;
                    totalBlue += currentPixel.blue;
                    totalAlpha += currentPixel.alpha;
                    count++;
                }
                // includes bottom-left pixel if it is within the image boundaries
                if (x - 1 >= 0 && y + 1 < height) {
                    ARGB currentPixel = new ARGB(image.getRGB(x - 1, y + 1));
                    totalRed += currentPixel.red;
                    totalGreen += currentPixel.green;
                    totalBlue += currentPixel.blue;
                    totalAlpha += currentPixel.alpha;
                    count++;
                }
                // includes bottom-middle pixel if the row below exists
                if (y + 1 < height) {
                    ARGB currentPixel = new ARGB(image.getRGB(x, y + 1));
                    totalRed += currentPixel.red;
                    totalGreen += currentPixel.green;
                    totalBlue += currentPixel.blue;
                    totalAlpha += currentPixel.alpha;
                    count++;
                }
                // includes bottom-right pixel if it is within the image boundaries
                if (x + 1 < width && y + 1 < height) {
                    ARGB currentPixel = new ARGB(image.getRGB(x + 1, y + 1));
                    totalRed += currentPixel.red;
                    totalGreen += currentPixel.green;
                    totalBlue += currentPixel.blue;
                    totalAlpha += currentPixel.alpha;
                    count++;
                }
                // Divides each colour element by count which is the number of valid adjacent
                // pixels found
                ARGB blurred = new ARGB(totalAlpha / count, totalRed / count,
                        totalGreen / count, totalBlue / count);
                // averaged color is connected to the output image at x and y
                blurredImage.setRGB(x, y, blurred.toInt());
            }
        }
        // Blur image is saved to output file
        saveImage(blurredImage, output);
    }
}