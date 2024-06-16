package com.example.flowmessenger.utilities;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ImageCompressor {


    public static void compressImage(String inputImagePath,
                                     String outputImagePath,
                                     float compressionQuality) throws IOException {
        File inputFile = new File(inputImagePath);
        BufferedImage image = ImageIO.read(inputFile);
        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
        if (!writers.hasNext()) {
            throw new IllegalStateException("No writers found for jpg format.");
        }
        ImageWriter writer = writers.next();
        ImageOutputStream ios = ImageIO.createImageOutputStream(
                new File(outputImagePath)
        );
        writer.setOutput(ios);
        ImageWriteParam param = writer.getDefaultWriteParam();
        if (param.canWriteCompressed()) {
            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            param.setCompressionQuality(compressionQuality);
        }
        writer.write(null, new IIOImage(image, null, null), param);
        ios.close();
        writer.dispose();
    }

}