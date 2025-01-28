package Ejercicios;

import java.util.Scanner;

public class Ejercicio03_Vocales {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Escribe una frase y te dire cuantas vocales tiene :");

        String cadena = teclado.nextLine();
        int contador = 0;

        for (int i = 0; i < cadena.length(); i++) {

            if (cadena.charAt(i) == 'a' || cadena.charAt(i) == 'e' || cadena.charAt(i) == 'i' || cadena.charAt(i) == 'o' || cadena.charAt(i) == 'u') {
                contador++;

            }
        }
        System.out.println("Las vocales introducidas son " + contador);
    }
}
