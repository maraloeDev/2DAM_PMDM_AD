package Ejemplos;


import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class Ejemplo02_LecturaBinaria {

    static JFileChooser jfc;
    static FileInputStream fis;
    static BufferedInputStream bis;
    static DataInputStream dis;

    public static void main(String[] args) {

        jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int respuesta = jfc.showOpenDialog(null);

        if (respuesta == JFileChooser.APPROVE_OPTION) {

            try {
                System.out.println("Archivo seleccionado " + jfc.getSelectedFile().getName());

                fis = new FileInputStream(jfc.getSelectedFile());
                bis = new BufferedInputStream(fis);
                dis = new DataInputStream(fis);
                
                int numero= dis.readInt();
                String texto = dis.readUTF();
                
                System.out.println(numero);
                System.out.println(texto);

                dis.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Ejemplo02_LecturaBinaria.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Ejemplo02_LecturaBinaria.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
