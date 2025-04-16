package com.tot.util;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.io.File;
import java.io.IOException;

public class QRDecoder {
    public static String decoder(String filepath)throws IOException, WriterException, NotFoundException {
        BufferedImage bufferedImage = ImageIO.read(new File(filepath));
        LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer((luminanceSource)));
        Result result = new MultiFormatReader().decode(bitmap);
        return result.getText();
    }
}
