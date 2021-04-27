package QR;

import java.io.IOException;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;

public class Programa {

    public static void main(String[] args) throws NotFoundException, WriterException, IOException {

        //CODIGO QR
        QR.generarQR("https://www.upm.es/", ".//QR.jpg", "png");

        //CODIGO DE BARRAS
        barcode.generarCodBarras("123456", ".//barcode.jpg", "png");

        //Leer los dos codigos
        lector.lectorCodigos();

    }
}
