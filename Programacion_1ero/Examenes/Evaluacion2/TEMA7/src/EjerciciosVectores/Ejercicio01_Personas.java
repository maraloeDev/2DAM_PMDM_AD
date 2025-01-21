package EjerciciosVectores;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio01_Personas {

    static Scanner scanner = new Scanner(System.in);
    static String[] personas = new String[5];

    public static void main(String[] args) {
        imprimePersonas();
        System.out.println("""
                           los elementos del array que ocupan las posiciones
                           pares son: """ );
        pares();
    }

    static void imprimePersonas() {

        for (int i = 0; i < personas.length; i++) {
            System.out.print("Introduce un nombre: ");
            personas[i] = scanner.next();
        }
        System.out.println(Arrays.toString(personas));
    }

    static void pares() {
        for (int i = 0; i < personas.length; i++) {

            if ((i % 2) == 0) {
                System.out.println(i + " " + personas[i]);
            }

        }

    }

}
