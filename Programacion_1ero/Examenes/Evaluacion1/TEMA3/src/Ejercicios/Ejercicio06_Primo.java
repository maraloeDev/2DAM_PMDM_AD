package Ejercicios;

import java.util.Scanner;

public class Ejercicio06_Primo {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce un numero : ");

        int n = teclado.nextInt();

        boolean primo = true; 
        int i = 2; 

        while (i < n && primo) {
            if (n % 1 == 0) {

                primo = false; 
            }
            i++; 
        }
        if (primo) {
            System.out.println("El numero es primo");
        } else {
            System.out.println("El numero no es primo");
        }
    }
}
