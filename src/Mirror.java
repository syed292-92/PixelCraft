// DONE WITH RECURSION

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Mirror extends Converter{
    /*
    * To run class:
    * javac -d bin src/*.java
    * java -Xss100M -cp bin PixelCraft Mirror toronto.png
    * (needed since it will recursively call for each pixel
    * and java has a small stack size)
    */


    // 1. Convert Method Overridden
    @Override
    public void convert(String input, String output) throws IOException{
        // A. Load Image
        BufferedImage image = loadImage(input);

        // B. InvertImage (row by row, pixel by pixel)
        invertRow(image, 0);

        // C. Save Image
        saveImage(image, output);
    }

    // 2. Inverts the yth Row
    private void invertRow(BufferedImage image, int y){
        // A. Base Case: (Image has fully been inverted)
        //    Since we invert row by row, we should keep going if y < image.getHeight()
        if(y >= image.getHeight()){
            return;
        }
        // B. Inductive Case: (Image hasn't been fully inverted)
        else{
            // a. Work through each row pixel by pixel
            //    Leftmost pixel starts at 0 and rightmost pixel starts at img.getWidth() - 1
            swap(image, 0, image.getWidth() - 1, y);

            // b. Recursive Call
            // Increment y by 1 to move on to the next row
            invertRow(image, y + 1);
        }


    }

    // 3. Swaps leftPixel and rightPixel
    private void swap(BufferedImage image, int leftPixel, int rightPixel, int y){
        // A. Base Case: (Pixels have all been swapped)
        if(leftPixel >= rightPixel){
            return;
        }
        // B. Inductive Case: (Some pixels remain unswapped)
        else{
            // a. get RGB values
            int leftRGB = image.getRGB(leftPixel, y);
            int rightRGB = image.getRGB(rightPixel, y);

            // b. swap RGB values
            image.setRGB(leftPixel, y, rightRGB);
            image.setRGB(rightPixel, y, leftRGB);
            
            // c. Recursive Call
            //    Increment and Decrement both by 1
            swap(image, leftPixel + 1, rightPixel - 1, y);
        }
    }
}
