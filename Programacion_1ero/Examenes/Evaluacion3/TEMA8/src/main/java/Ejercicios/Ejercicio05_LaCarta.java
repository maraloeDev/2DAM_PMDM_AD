package Ejercicios;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio05_LaCarta {

    //LecturaBinaria
    static FileInputStream fis;
    static BufferedInputStream bis;
    static DataInputStream dis;
    static String archivoBinario = "C:\\Users\\Eduardo\\Desktop\\ProgramacionJava\\Evaluacion3\\TEMA8\\src\\main\\java\\Ejercicios\\Ejercicio05_Empleados.dat";
    static ArrayList<String> listaEmpleados = new ArrayList<>();

    //LecturaTexto
    static FileReader fr;
    static BufferedReader br;
    static String archivoTexto = "C:\\Users\\Eduardo\\Desktop\\ProgramacionJava\\Evaluacion3\\TEMA8\\src\\main\\java\\Ejercicios\\Ejercicio05_Carta.txt";
    static ArrayList<String> listaCarta = new ArrayList<>();

    //EscrituraCarta
    static FileWriter fw;
    static BufferedWriter bw;
    static int nOrden = 1;
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");

    public static void main(String[] args) {
        lecturaBinaria();
        lecturaTexto();
        escribirCarta();
    }

    static void lecturaBinaria() {

        try {
            fis = new FileInputStream(archivoBinario);
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(fis);

            while (dis.available() > 0) {

                String info = dis.readUTF();
                listaEmpleados.add(info);

            }
            dis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio05_LaCarta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio05_LaCarta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static void lecturaTexto() {
        try {
            fr = new FileReader(archivoTexto);
            br = new BufferedReader(fr);

            String linea1 = "";

            while (linea1 != null) {

                linea1 = br.readLine();
                listaCarta.add(linea1);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio05_LaCarta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio05_LaCarta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void escribirCarta() {

        for (int i = 0; i < listaEmpleados.size(); i++) {
            if ((i % 2) != 0) {
                try {
                    String nombre = listaEmpleados.get(i - 1);
                    String direccion = listaEmpleados.get(i);

                    File archivo = new File("C:\\Users\\Eduardo\\Desktop\\Cartas\\carta" + nOrden + ".txt");

                    if (!archivo.exists()) {
                        try {
                            archivo.createNewFile();
                        } catch (IOException ex) {
                            Logger.getLogger(Ejercicio05_LaCarta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    fw = new FileWriter(archivo);
                    bw = new BufferedWriter(fw);

                    bw.write(nombre);
                    bw.newLine();
                    bw.write(direccion + "\t\t Valladolid, " + sdf.format(new Date()));
                    bw.newLine();

                    for (String recorroCarta : listaCarta) {
                        bw.write(String.valueOf(recorroCarta));
                        bw.newLine();
                    }
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(Ejercicio05_LaCarta.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                nOrden++;

            }

        }
    }

}
