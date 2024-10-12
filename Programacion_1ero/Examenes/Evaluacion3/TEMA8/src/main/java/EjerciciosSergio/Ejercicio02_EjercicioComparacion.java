package TEMA8.EjerciciosSergio;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.*;

public class Ejercicio02_EjercicioComparacion {

    /*
    Compara un archivo con otro y dime que lieneas son iguales y cuales diferentes
     */

    static JFileChooser jfc;
    static File[] archivosSeleccionados;
    static BufferedReader br;
    static BufferedReader br2;
    static boolean iguales = true;
    static int lineasIguales=0;
    static int lineasDiferentes=0;
    static int contador=0;

    public static void main(String[] args) {
        seleccionArchivo();
    }

    static void seleccionArchivo() {
        jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setMultiSelectionEnabled(true);

        int respuesta = jfc.showOpenDialog(null);


        if (respuesta == JFileChooser.APPROVE_OPTION) {
            archivosSeleccionados = jfc.getSelectedFiles();

            if (archivosSeleccionados.length != 2) {
                System.out.println("No se han seleccionado mas de 1 archivo");
            } else {
                System.out.println("Los archivos seleccionados son " + archivosSeleccionados[0].getName() + ", " + archivosSeleccionados[1].getName());
                lecturaArchivos();

            }

        }
    }

    static void lecturaArchivos() {

        try {
            br = new BufferedReader(new FileReader(archivosSeleccionados[0]));
            br2 = new BufferedReader(new FileReader(archivosSeleccionados[1]));

            String linea1 = "";
            String linea2 = "";

            while ((linea1 != null) && (linea2 != null)) {
                linea1 = br.readLine();
                linea2 = br2.readLine();
                contador++;

                if ((linea1 == null && linea2 != null) || (linea1 != null && linea2 == null) || (linea1 != null && linea2 != null) && (!linea1.equals(linea2))) {
                    iguales = false;
                    lineasDiferentes++;
                    break;
                } else{
                    lineasIguales++;
                }
            }

            System.out.println(contador + " " + linea1);

            System.out.println(contador + " " + linea2);
                comparacionArchivos();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void comparacionArchivos(){

        if (iguales){
            System.out.println("Los archivos son iguales, y hay " + lineasIguales + " lineas iguales");
        } else{
            System.out.println("Los archivos no son iguales, y hay " + lineasDiferentes + " lineas diferentes");

        }
    }
}
