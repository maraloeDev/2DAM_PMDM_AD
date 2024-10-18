package Ejemplos;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejemplo03_LecturaCSV {

    static CsvToBean<Ejemplo03_TiempoGolf> csvTB;
    static BufferedReader br;
    static File archivo = new File(".\\src\\main\\java\\Ejemplos\\golf-dataset.csv");

    public static void main(String[] args) {

        try {
            br = new BufferedReader(new FileReader(archivo));
            csvTB = new CsvToBeanBuilder<Ejemplo03_TiempoGolf>(br).withType(Ejemplo03_TiempoGolf.class).withIgnoreLeadingWhiteSpace(true).build();

            for (Ejemplo03_TiempoGolf golf : csvTB.parse()) {

                System.out.println(golf);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejemplo03_LecturaCSV.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
