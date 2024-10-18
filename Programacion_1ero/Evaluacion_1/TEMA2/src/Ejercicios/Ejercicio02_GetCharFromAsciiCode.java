package Ejercicios;

import java.util.Scanner;

public class Ejercicio02_GetCharFromAsciiCode {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Introduce un valor decimal: ");

        double dato = scanner.nextDouble();

        System.out.println("El numero decimal " + dato + " en ASCII es " + (char) dato);
    }
}
