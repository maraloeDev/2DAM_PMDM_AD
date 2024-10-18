package TEMA8.EjerciciosSergio;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio03_Escritura_Lectura {

    /*
    Escribe un programa Java que
                    Lea el contenido de un archivo de texto llamado "entrada.txt",
                     Lo procese de alguna manera (por ejemplo, convirtiendo el texto a mayúsculas),
                      Y luego escriba el resultado en otro archivo llamado   "salida.txt".
     */
    //Archivos
    static String entrada = "C:\\Users\\maraloed\\Desktop\\entrada.txt.txt";
    static String salida = "C:\\Users\\maraloed\\Desktop\\salida.txt.txt";

    //Escritura
    static FileWriter fw;
    static BufferedWriter bw;

    //Lectura
    static FileReader fr;
    static BufferedReader br;

    public static void main(String[] args) {
        leerTxt();
        escribirTxt();
    }

    static void leerTxt() {
        try {
            fr = new FileReader(entrada);
            br = new BufferedReader(fr);

            String linea1 = "";

            while (linea1 != null) {
                
                linea1=br.readLine();

                try {
                    linea1 = br.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(Ejercicio03_Escritura_Lectura.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            escribirTxt();
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio03_Escritura_Lectura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio03_Escritura_Lectura.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static void escribirTxt() {
        String texto="";
        
        try {
            fr = new FileReader(entrada);
            br = new BufferedReader(fr);

            String linea1 = "";

            while (linea1 != null) {
                
                texto+=linea1;

                try {
                    linea1 = br.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(Ejercicio03_Escritura_Lectura.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            br.close();
            
            fw = new FileWriter(salida);
            bw = new BufferedWriter(fw);
            
            bw.write(texto.toUpperCase());
            bw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio03_Escritura_Lectura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio03_Escritura_Lectura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       

    }

}
