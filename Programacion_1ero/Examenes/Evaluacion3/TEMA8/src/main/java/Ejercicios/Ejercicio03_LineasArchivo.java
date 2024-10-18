package Ejercicios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class Ejercicio03_LineasArchivo {

    static JFileChooser jfc;
    static FileReader fr;
    static BufferedReader br;

    public static void main(String[] args) {

        jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int respuesta = jfc.showOpenDialog(null);

        if (respuesta == JFileChooser.APPROVE_OPTION) {
            try {
                System.out.println("Archivo seleccionado " + jfc.getSelectedFile());

                fr = new FileReader(jfc.getSelectedFile());
                br = new BufferedReader(fr);

                int contador = 1;
                String linea = br.readLine();

                while (linea != null) {
                    System.out.println(contador + " " + linea);
                    linea = br.readLine();
                    contador++;
                }
                br.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Ejercicio03_LineasArchivo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Ejercicio03_LineasArchivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
