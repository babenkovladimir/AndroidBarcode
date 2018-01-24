package com.example.vladimirbabenko.barcode;

import android.graphics.Bitmap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

/**
 * Created by VladimirBabenko on 1/24/2018.
 */

public class BarcodeGenerator {


    static Bitmap getGeneratedBarcode(String data, BarcodeFormat format, int width, int height){
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(data, format,width , height);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            return bitmap;
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return null;
    }
}
