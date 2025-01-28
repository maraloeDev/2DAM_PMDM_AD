package TEMA8.EjerciciosSergio;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.util.Scanner;

/*
    Utilizando ambos estilos de lectura y escritura,
    
    haz dos programas uno para binario y otro para texto plano.
    
    En ambos, será un proceso similar,
            tu puedes leer el archivo.
            Al escribir, no borrará lo anteriror, si no añadirá lo que tu le pases por consola.
            El programa tendrá dos opciones, 
                    leer archvio y añadir al archivo.
    
    
    Extra, añade una opción que permita quitar los úlimos X caracteres del archivo.
 */
public class Ejercicio01_EjercicioLecturaEscrituraBinaria {

    static Scanner scanner = new Scanner(System.in);
    static JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

    // Leer
    static FileInputStream fis;
    static BufferedInputStream bis;
    static DataInputStream dis;

    // Escribir
    static FileOutputStream fos;
    static BufferedOutputStream bos;
    static DataOutputStream dos;

    public static void main(String[] args) {
        menu();
    }

    static File seleccionArchivo() {

        int respuesta = jfc.showOpenDialog(null);

        if (respuesta == JFileChooser.APPROVE_OPTION) {
            System.out.println("Archivo seleccionado : " + jfc.getSelectedFile().getName());
        }

        return jfc.getSelectedFile();
    }

    static void menu() {

        seleccionArchivo();
        int opcion;
        do {

            System.out.println("""
                    Introduce que quiere realizar: \

                    1. Leer archivo\

                    2. Aniadir al archivo""");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    leerArchivo();
                    break;
                case 2:
                    anadirAlArchivo();
                    break;
                default:
                    System.out.println("Opcion no contemplada");
                    System.out.println("----------------------");
            }
        } while (opcion != 3);
    }

    static void leerArchivo() {

        try {
            fis = new FileInputStream(seleccionArchivo());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        bis = new BufferedInputStream(fis);
        dis = new DataInputStream(bis);

        try {
            String texto = dis.readUTF();

            System.out.println(texto);
            dis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static void anadirAlArchivo() {

        try {
            fos = new FileOutputStream(seleccionArchivo());
            bos = new BufferedOutputStream(fos);
            dos = new DataOutputStream(fos);

            System.out.println("Introduce lo que quieras ");
            scanner.nextLine();
            String txt = scanner.nextLine();

            try {
                dos.writeUTF(txt);
                dos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }


}
