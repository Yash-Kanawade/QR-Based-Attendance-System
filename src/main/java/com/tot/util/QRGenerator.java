package com.tot.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRGenerator {
    public static void generateQRCode(String text,int width,int height,String filepath)throws IOException, WriterException {
        QRCodeWriter qrcodewriter = new QRCodeWriter();
        BitMatrix bitmatrix = qrcodewriter.encode(text, BarcodeFormat.QR_CODE,width,height);
        Path path = FileSystems.getDefault().getPath(filepath);
        MatrixToImageWriter.writeToPath(bitmatrix,"PNG",path);
    }
}
