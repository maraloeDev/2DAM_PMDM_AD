package Ejercicios;

import java.util.Scanner;

public class Ejercicio02_Invertir {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Cadena original : ");
        String cadena = teclado.nextLine();
        String invertido = "";

        for (int i = 0; i < cadena.length(); i++) {
            char caract = cadena.charAt(i);

            if (Character.isUpperCase(caract)) {
                invertido = invertido + Character.toLowerCase(caract);
            } else {
                invertido = invertido + Character.toUpperCase(caract);
            }

        }
        System.out.println(invertido);

    }

}
