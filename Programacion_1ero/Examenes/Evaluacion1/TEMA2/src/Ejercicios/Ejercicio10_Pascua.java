package Ejercicios;

import java.util.Scanner;

public class Ejercicio10_Pascua {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el año: ");
        int year = scanner.nextInt();

        int A = year % 19;
        int B = year % 4;
        int C = year % 7;
        int D = (19 * A + 24) % 30;
        int E = (2 * B + 4 * C + 6 * D + 5) % 7;
        int N = 22 + D + E;

        int mes = (N <= 31) ? 3 : 4;
        int dia = (N <= 31) ? N : N - 31;

        System.out.println("El domingo de Pascua en el año " + year + " es el " + dia + " de marzo");
    }
}
