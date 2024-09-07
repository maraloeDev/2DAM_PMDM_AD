package com.maraloedev.Problema1;

import java.util.Scanner;

public class Problema1 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Numero1: ");
        int n1 = scanner.nextInt();

        System.out.print("Numero2: ");
        int n2 = scanner.nextInt();

        if ((n1 < 0) || (n2 < 0)) {
            System.out.println("ERROR. Los numeros tienen que ser positivos.");
        } else {
            
            int suma = 0;

            for (int i = 0; i < n2; i++) {
                suma+=n1;

            }
            System.out.println("Resultado " + suma);
        }

    }
}
