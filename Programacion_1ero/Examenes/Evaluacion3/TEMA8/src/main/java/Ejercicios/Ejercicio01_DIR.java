package Ejercicios;

import java.io.File;
import java.text.SimpleDateFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Ejercicio01_DIR {

    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
    static String[] opciones = new String[2];
    static String escribirOpt;

    public static void main(String[] args) {
        pidoDatos();
    }

    static void pidoDatos() {
        opciones[0] = "CMD";
        opciones[1] = "PS";

        escribirOpt = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion", "OPCIONES: ", 1, null, opciones, opciones[0]);

        if (escribirOpt.equalsIgnoreCase("CMD")) {
            comandoCMD();
        } else {
            comandoPS();
        }

    }

    static void comandoCMD() {
        //Creacion del objeto JFileChooser
        JFileChooser fileChooser = new JFileChooser();
        // Pido que seleccione solo archivos y directorios
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        // Una vez aplicados los "filtros" muestro la ventana
        int returnValue = fileChooser.showOpenDialog(null);

        // si cuando se muestre la ventana se clica a Open 
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            mostrarDetallesCMD(selectedFile); // Se muestran los detalles del archivo seleccionado
        } else {
            System.out.println("No se seleccionó ningún archivo o directorio.");
        }
    }

    static void comandoPS() {
        //Creacion del objeto JFileChooser
        JFileChooser fileChooser = new JFileChooser();
        // Pido que seleccione solo archivos y directorios
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        // Una vez aplicados los "filtros" muestro la ventana
        int returnValue = fileChooser.showOpenDialog(null);

        // si cuando se muestre la ventana se clica a Open 
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            mostrarDetallesPS(selectedFile); // Se muestran los detalles del archivo seleccionado
        } else {
            System.out.println("No se seleccionó ningún archivo o directorio.");
        }
    }

    static void mostrarDetallesCMD(File f) {

        // Se crean los contadores para los archivos y directorios
        int nDirectorios = 0;
        int nArchivos = 0;

        if (f.isDirectory()) {
            // Se crea un Array con la lista de archivos
            File[] archivos = f.listFiles();

            if (archivos != null) {
                for (File listaArchivos : archivos) {

                    // Creacion de la variable para saber la fecha de la ultima modificacion
                    long ultimaMod = listaArchivos.lastModified();

                    //Muestro por consola los datos
                    System.out.println(
                            sdf.format(ultimaMod) + "\t\t"
                            + (listaArchivos.isDirectory() ? "<DIR>" : "\t\t") + "\t\t"
                            + listaArchivos.getName());

                    if (listaArchivos.isDirectory()) {
                        nDirectorios++;
                    } else {
                        nArchivos++;
                    }
                }
            }
        } else if (f.isFile()) {
            nArchivos++;
        } else {
            System.out.println("Ruta no encontrada o mal escrita");
            return;
        }

        System.out.println(nArchivos + " archivos");
        System.out.println(nDirectorios + " directorios");
    }

    static void mostrarDetallesPS(File f) {

        //Muestro el directorio seleccionado
        System.out.println("Directorio: " + f.getAbsolutePath());
        System.out.println("");

        // Creo una "tabla", para crear las columnas
        System.out.println("Mode\t\t LastWriteTime\t\t\tLength\t\tName");
        System.out.println("- - - -\t\t- - - - - - - - \t\t- - - - -\t- - - - - -");

        // Creo un Array para listar los archivos
        File[] listaArchivos = f.listFiles();

        for (File listaArchivosMod : listaArchivos) {
            long fechaMod = f.lastModified();
            System.out.println("\t\t"
                    + sdf.format(fechaMod) + "\t\t"
                    + listaArchivosMod.length() + "\t\t"
                    + listaArchivosMod.getName());
        }

    }

}
