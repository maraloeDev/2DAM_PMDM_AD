package Ejemplos;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;


public class Ejemplo01_EscrituraBinaria {
    
    static JFileChooser jfc;
    static FileOutputStream fos;
    static BufferedOutputStream bos;
    static DataOutputStream dos;
    
    public static void main(String[] args) {
        
        jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int respuesta = jfc.showOpenDialog(null);
        
        if(respuesta==JFileChooser.APPROVE_OPTION){
            try {
                System.out.println("Archivo seleccionado " + jfc.getSelectedFile().getName());
                
                fos = new FileOutputStream(jfc.getSelectedFile());
                bos = new BufferedOutputStream(fos);
                dos = new DataOutputStream(fos);
                
                int numerito=339;
                String txt ="UwU UwU UwU UwU UwU string nombre = (file.GetName() == \"Juan\") ? (file.getSurname() == \"Palomo\") ? \"Si soy yo, Juan Palomo\" : \"Soy Juan, pero no Palomo\" : (file.GetSurname==\"Palomo\") ? \"Soy Palomo, pero no Juan\" : \"Ni soy Juan, ni soy Palomo\";";
                
                try {
                    dos.writeInt(numerito);
                    dos.writeUTF(txt);
                    
                    dos.close();
                } catch (IOException ex) {
                    Logger.getLogger(Ejemplo01_EscrituraBinaria.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Ejemplo01_EscrituraBinaria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
}
