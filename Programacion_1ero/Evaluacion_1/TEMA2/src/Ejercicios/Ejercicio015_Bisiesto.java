package Ejercicios;

import java.util.Scanner;

public class Ejercicio015_Bisiesto {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Introduce un año:");
        int año = scanner.nextInt();
        
        boolean esBisiesto = (año % 4 == 0) && ((año % 100 != 0) || (año % 400 == 0));

        if (esBisiesto) {
            System.out.println("El año " + año + " es bisiesto.");
        } else {
            System.out.println("El año " + año + " no es bisiesto.");
        }
    }
}
