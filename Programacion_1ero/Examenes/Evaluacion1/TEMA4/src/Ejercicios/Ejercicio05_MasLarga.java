package Ejercicios;

import java.util.Scanner;

public class Ejercicio05_MasLarga {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String cadena = "";
        String masLarga = "";

        do {
            System.out.println("Introduce una frase");
            cadena = teclado.nextLine();
            if (cadena.length() > masLarga.length()) {
                masLarga = cadena;
            }

        } while (!cadena.isEmpty());
        System.out.println("La cadena mas larga es " + masLarga);

    }

}
