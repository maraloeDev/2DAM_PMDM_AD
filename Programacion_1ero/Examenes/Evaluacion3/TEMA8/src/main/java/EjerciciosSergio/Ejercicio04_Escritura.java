package EjerciciosSergio;

import java.io.*;
import java.util.Scanner;

public class Ejercicio04_Escritura {

    /*
    Escribe un programa Java que genere un archivo HTML con una tabla de multiplicar.

    El programa debe solicitar al usuario ingresar un número
    y luego escribir una tabla de multiplicar del 1 al 10 para ese número en un archivo HTML llamado "tabla_multiplicar_X.html".

    X siendo el numero del usuario.
     */
    static Scanner scanner;
    static int numero;

    //Escritura
    static FileWriter fw;
    static BufferedWriter bw;

    public static void main(String[] args) {
        pidoNumero();
        escrituraArchivo();
    }

    static File archivo;

    static int pidoNumero() {
        scanner = new Scanner(System.in);

        System.out.print("Introduce un numero: ");
        numero = scanner.nextInt();

        return numero;

    }

    static void escrituraArchivo() {

        archivo = new File("tabla_multiplicar_" + numero + ".html");

        if (!archivo.exists()) {
            System.out.print("Archivo creado correctamente en: " + archivo.getAbsolutePath());

            try {
                archivo.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                fw = new FileWriter(archivo);
                bw = new BufferedWriter(fw);

                bw.write("<!DOCTYPE html>");
                bw.newLine();

                bw.write("<html lang=\"en\">");
                bw.newLine();

                bw.write("<head>");
                bw.newLine();

                bw.write("    <meta charset=\"UTF-8\">");
                bw.newLine();

                bw.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
                bw.newLine();

                bw.write("    <title>Tabla del " + numero + "</title>");
                bw.newLine();

                bw.write("</head>");
                bw.newLine();

                bw.write("<body>");
                bw.newLine();

                bw.write("<h1> Tabla del numero " + numero + "</h1>");
                bw.newLine();

                for (int i = 0; i <= 10; i++) {
                    bw.write(" " + i + " * " + numero + " = " + (i * numero));
                    bw.write("<br>");
                    bw.newLine();
                }

                bw.write("</body>");
                bw.newLine();
                bw.write("</html>");
                bw.newLine();

                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else {

            System.out.println("El archivo " + archivo.getName() + " ya existe");
        }
    }
}
