package Ejercicios;

import java.util.Scanner;

public class Ejercicio03_MiNota {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Introduce un numero ente 0 y 100");
        int n1 = scanner.nextInt();

        System.out.print("Introduce un numero ente 0 y 100");
        int n2 = scanner.nextInt();

        System.out.print("Introduce un numero ente 0 y 100");
        int n3 = scanner.nextInt();

        System.out.print("Introduce un numero ente 0 y 100");
        int n4 = scanner.nextInt();

        int media = (n1 + n2 + n3 + n4) / 4;

        if ((media >= 90) || (media <= 100)) {
            System.out.println("A");
        } else if ((media >= 80) || (media <= 89)) {
            System.out.println("B");
        } else if ((media >= 70) || (media <= 79)) {
            System.out.println("C");
        } else if ((media >= 60) || (media <= 69)) {
            System.out.println("D");
        } else if ((media >= 0) || (media <= 59)) {
            System.out.println("E");
        } else {
            System.out.println("Has superado los rangos");
        }
    }
}
