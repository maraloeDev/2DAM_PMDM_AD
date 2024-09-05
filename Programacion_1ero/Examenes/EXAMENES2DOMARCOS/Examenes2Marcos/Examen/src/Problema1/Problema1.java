package Problema1;

import java.util.Scanner;

public class Problema1 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Número1:");
        int n1 = scanner.nextInt();

        System.out.println("Número2: ");
        int n2 = scanner.nextInt();

        if ((n1 < 0) || (n2 < 0)) {

            System.out.println("ERROR. Los números deben ser positivos.");
        } else {
            laSuma(n1, n2);
        }


    }

    private static void laSuma(int n1, int n2) {

        int suma= 0;
        for (int i = 0; i < n2; i++) {

            suma+=n1;

        }
        System.out.println("Resultado " + suma);


    }
}
