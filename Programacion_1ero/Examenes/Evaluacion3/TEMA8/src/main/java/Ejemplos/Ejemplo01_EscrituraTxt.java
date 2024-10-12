package Ejemplos;

import java.io.BufferedWriter;
import java.io.FileOutputStream;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;


public class Ejemplo01_EscrituraTxt {
    
    static JFileChooser jfc;
    static FileWriter fw;
    static BufferedWriter bw;
    
    public static void main(String[] args) {
        
        jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        
        int respuesta = jfc.showOpenDialog(null);
        
        if(respuesta==JFileChooser.APPROVE_OPTION){
            
            try {
                System.out.println("El archivo elegido es " + jfc.getSelectedFile().getName());
                System.out.println("");
                
                fw = new FileWriter(jfc.getSelectedFile());
                
                bw = new BufferedWriter(fw);
                
                bw.write("Hola"); // Escribe una frase
                bw.append('a'); // Escribe un caracter
                
                bw.close();
                
            } catch (IOException ex) {
                Logger.getLogger(Ejemplo01_EscrituraTxt.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
        
    }
    
}
