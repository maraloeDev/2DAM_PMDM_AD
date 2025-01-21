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

public class Ejercicio01_EjercicioLecturaEscrituraTxt {

    static Scanner scanner = new Scanner(System.in);
    static JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

    // Leer
    static FileReader fr;
    static BufferedReader br;

    // Escribir
    static FileWriter fw;
    static BufferedWriter bw;

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
            fr = new FileReader(seleccionArchivo());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        br = new BufferedReader(fr);

        String linea;
        try {
            linea = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (linea != null) {
            System.out.println(linea);
            break;
        }
        try {
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static void anadirAlArchivo() {

        try {
            fw = new FileWriter(seleccionArchivo());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        bw = new BufferedWriter(fw);

        System.out.println("Introduce lo que quieras ");
        scanner.nextLine();
        String txt = scanner.nextLine();

        try {
            bw.write(txt);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}