package QR;

import java.nio.file.Paths;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;

public class barcode {

    //CODIGO DE BARRAS
    public static void generarCodBarras(String texto, String fichero, String formatoImagen){

        long startTime = System.currentTimeMillis();

        try {
            Code128Writer writer = new Code128Writer();
            BitMatrix matrix = writer.encode(texto, BarcodeFormat.CODE_128, 500, 300);

            MatrixToImageWriter.writeToPath(matrix, formatoImagen, Paths.get(fichero));

            System.out.println("Código de barras creado...");

        } catch(Exception e) {
            System.out.println("Error while creating barcode");
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Tiempo en generar codigo de barras :: " + totalTime + "ms");

    }
}
