package Ejemplos;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;


public class Ejemplo01_LecturaTxt {
    
    static JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    static FileReader fr;
    static BufferedReader br;
    
    public static void main(String[] args) {
        
        int respuesta = jfc.showOpenDialog(null);
        
       if(respuesta== JFileChooser.APPROVE_OPTION) {
            try {
                System.out.println("El archivo elegido es " + jfc.getSelectedFile());
                
                fr = new FileReader(jfc.getSelectedFile()); // Coges el archivo para lectura
                
                br = new BufferedReader(fr); // lee el archivo
                String linea="";
                
                try {
                    while((linea=br.readLine())!=null){
                        
                        System.out.println(linea);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Ejemplo01_LecturaTxt.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Ejemplo01_LecturaTxt.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
    }
    
}
