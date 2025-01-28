package Ejemplos;

import com.opencsv.CSVWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejemplo03_EscrituraCSV {

    static BufferedWriter bw;
    static Ejemplo03_TiempoGolf partidos = new Ejemplo03_TiempoGolf();
    static CSVWriter csvW;
    static File archivo = new File(".\\src\\main\\java\\Ejemplos\\golf-dataset.csv");

    public static void main(String[] args) {

        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Ejemplo03_EscrituraCSV.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            bw = new BufferedWriter(new FileWriter(archivo));
            csvW = new CSVWriter(bw);
            csvW.writeNext(partidos.toArray(), false);

            partidos = new Ejemplo03_TiempoGolf("Calido", "Frio", "Normal", true, "Si");

            bw.write(String.valueOf(partidos));
        } catch (IOException ex) {
            Logger.getLogger(Ejemplo03_EscrituraCSV.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (csvW != null) {
                try {
                    csvW.close();
                } catch (IOException ex) {
                    Logger.getLogger(Ejemplo03_EscrituraCSV.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

    }

}
