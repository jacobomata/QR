package QR;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class QR {

    public static void generarQR(String texto, String path, String formatoImagen){
        QRCodeWriter qrcw = new QRCodeWriter();

        BitMatrix matrizPuntos = null;
        FileOutputStream ficheroSalida = null;

        long startTime = System.currentTimeMillis();

        try {
            matrizPuntos = qrcw.encode(texto, BarcodeFormat.QR_CODE, 400, 400);
            ficheroSalida = new FileOutputStream(new File(path));
            MatrixToImageWriter.writeToStream(matrizPuntos, "png", ficheroSalida);
            System.out.println("QR creado...");
        } catch (WriterException ex) {
            System.out.println("Error al generar QR");
        } catch (FileNotFoundException ex) {
            System.out.println("Error al generar QR");
        } catch (IOException ex) {
            System.out.println("Error al generar QR");
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Tiempo en generar QR :: " + totalTime + "ms");

    }
}
