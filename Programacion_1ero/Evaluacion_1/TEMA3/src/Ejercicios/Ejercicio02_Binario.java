package Ejercicios;

import java.util.Scanner;

public class Ejercicio02_Binario {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Introduce un numero [0-1]: ");
        int b2 = scanner.nextInt();

        System.out.print("Introduce un numero [0-1]: ");
        int b1 = scanner.nextInt();

        System.out.print("Introduce un numero [0-1]: ");
        int b0 = scanner.nextInt();

        if ((b2 != 0 && b2 != 1)
                || (b1 != 0 && b1 != 1)
                || (b0 != 0 && b0 != 1)) {
            System.err.println("NO HAS INTRODUCIDO LOS NUMEROS INDICADOS");
            System.exit(0);
        } else {
            double valor = (b2 * 4) + (b1 * 2) + b0;


            System.out.println("El valor decimal introducido es " + valor);
        }
    }

}
