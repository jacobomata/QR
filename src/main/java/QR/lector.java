package QR;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class lector {

    // Function to read the QR file
    public static String leer(String path, String charset,
                              Map hashMap)
            throws FileNotFoundException, IOException,
            NotFoundException
    {
        BinaryBitmap binaryBitmap
                = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(
                        ImageIO.read(
                                new FileInputStream(path)))));

        Result result
                = new MultiFormatReader().decode(binaryBitmap);

        return result.getText();
    }

    public static void lectorCodigos()
            throws WriterException, IOException,
            NotFoundException
    {

        String path = ".//QR.jpg";
        String path2 = ".//barcode.jpg";

        String charset = "UTF-8";

        Map<EncodeHintType, ErrorCorrectionLevel> hintMap
                = new HashMap<EncodeHintType,
                ErrorCorrectionLevel>();




        //leer codigo QR
        try{
            long startTime = System.currentTimeMillis();
            System.out.println(
                    "Codigo QR:: "
                            + leer(path, charset, hintMap));
            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            System.out.println("Tiempo en leer codigo QR :: " + totalTime + "ms");
        }
        catch(Exception e){
            System.out.println("No se ha podido leer el QR");
        }

        //leer codigo de barras
        try{
            long startTime2 = System.currentTimeMillis();
            System.out.println(
                    "COdigo de Barras:: "
                            + leer(path2, charset, hintMap));

            long endTime2 = System.currentTimeMillis();
            long totalTime2 = endTime2 - startTime2;
            System.out.println("Tiempo en leer codigo de barras :: " + totalTime2 + "ms");
        }
        catch(Exception e) {
            System.out.println("No se ha podido leer el código de barras");
        }

    }



}
