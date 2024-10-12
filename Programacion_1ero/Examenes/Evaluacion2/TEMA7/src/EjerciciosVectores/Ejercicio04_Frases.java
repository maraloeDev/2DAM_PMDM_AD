package EjerciciosVectores;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio04_Frases {

    static Scanner scanner = new Scanner(System.in);
    static String[] frases = new String[5];

    public static void main(String[] args) {
        imprimeFrases();
        System.out.println("------------");
        mayorFrase();
        menorFrase();
    }

    static void imprimeFrases() {
        for (int i = 0; i < frases.length; i++) {
            System.out.print("Introduce una frase: ");
            frases[i] = scanner.nextLine();
        }
        System.out.println(Arrays.toString(frases));

    }

    static void mayorFrase() {
        String frase = "";
        int posicion = 0;

        for (int i = 0; i < frases.length; i++) {

            if (frases[i].length() > frase.length()) {
                frase = frases[i];
                posicion = i;

            }

        }
        System.out.println("La frase mas larga es " + frase + " y esta en la posicion " + posicion);
    }

    static void menorFrase() {
        String frase = frases[0]; // Asigno que la primera frase es la menor
        int posicion = 0;

        for (int i = 0; i < frases.length; i++) {

            if (frases[i].length() < frase.length()) {
                frase = frases[i];
                posicion = i;

            }

        }
        System.out.println("La frase mas pequeaa es " + frase + " y esta en la posicion " + posicion);
    }

}
