package Ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class Ejercicio04_CompararArchivos {

    static JFileChooser jfc = new JFileChooser();

    static BufferedReader br;
    static BufferedReader br2;
    static File archivos[];
    static boolean iguales = true;

    public static void main(String[] args) {
        seleccionArchivos();
    }

    static void seleccionArchivos() {

        jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        jfc.setMultiSelectionEnabled(true);

        int respuesta = jfc.showOpenDialog(null);

        archivos = jfc.getSelectedFiles();

        if (respuesta == JFileChooser.APPROVE_OPTION) {
            if (archivos.length != 2) {
                System.out.println("No has seleccionado 2 archivos");
            } else {

                System.out.println("Los archivos seleccionados son: " + archivos[0].getName() + ", " + archivos[1].getName());
                lecturaArchivos();
            }
        }
    }

    static void lecturaArchivos() {
        try {

            br = new BufferedReader(new FileReader(archivos[0]));
            br2 = new BufferedReader(new FileReader(archivos[1]));

            String linea1 = "";
            String linea2 = "";

            while ((linea1 != null) && (linea2 != null)) {
                try {
                    linea1 = br.readLine();
                    linea2 = br.readLine();

                    if ((linea1 == null && linea2 != null) || (linea1 != null && linea2 == null) || (linea1 != null && linea2 != null) && (!linea1.equals(linea2))) {
                        iguales = false;
                        break;
                    }

                } catch (IOException ex) {
                    Logger.getLogger(Ejercicio04_CompararArchivos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            compararArchivos();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio04_CompararArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void compararArchivos() {

        if (iguales) {
            System.out.println("Los archivos son iguales");
        } else {
            System.out.println("Los archivos no son iguales");
        }

    }
}
