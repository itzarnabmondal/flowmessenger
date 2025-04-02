package com.example.flowmessenger.utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PngToJpgConverter {
    public static void convertPngToJpg(File pngFile, File jpgFile) throws IOException {
        // Read the PNG file
        BufferedImage bufferedImage = ImageIO.read(pngFile);

        // Create a new BufferedImage with RGB format (JPG doesn't support transparency)
        BufferedImage newBufferedImage = new BufferedImage(
                bufferedImage.getWidth(),
                bufferedImage.getHeight(),
                BufferedImage.TYPE_INT_RGB);

        // Draw the PNG image onto the new RGB image (white background for transparent areas)
        newBufferedImage.createGraphics()
                .drawImage(bufferedImage, 0, 0, java.awt.Color.WHITE, null);

        // Write the image as JPG
        ImageIO.write(newBufferedImage, "jpg", jpgFile);
    }
}