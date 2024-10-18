package Ejercicios;

import java.util.Scanner;

public class Ejercicio08_Not {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce un numero: ");
        String s = teclado.next();

        if (s.length() != 8) {
            System.out.println("Ni ");
        } else {
            int i = 0;
            boolean bit = true;
            while (i < s.length() && bit) {
                char c = s.charAt(i);
                if (c != '1' && c != '0') { 

                    bit = false;
                }
                i++;
            }
            if (bit) {
                System.out.println("NOT(" + s + ") = ");
                i = 0;
                int dec = 0; //decimal del NOT
                while (i < s.length()) {
                    if (s.charAt(i) == '0') {
                        System.out.println("0");

                    }
                    i++;
                }
                System.out.println();
            } else {
                System.out.println("NO");
            }
        }
    }
}