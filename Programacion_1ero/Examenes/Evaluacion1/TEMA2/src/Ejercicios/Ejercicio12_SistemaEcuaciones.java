package Ejercicios;

import java.util.Scanner;

public class Ejercicio12_SistemaEcuaciones {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el valor de a: ");
        double a = scanner.nextDouble();

        System.out.print("Ingrese el valor de b: ");
        double b = scanner.nextDouble();

        System.out.print("Ingrese el valor de c: ");
        double c = scanner.nextDouble();

        System.out.print("Ingrese el valor de d: ");
        double d = scanner.nextDouble();

        System.out.print("Ingrese el valor de e: ");
        double e = scanner.nextDouble();

        System.out.print("Ingrese el valor de f: ");
        double f = scanner.nextDouble();

        double determinantePrincipal = a * e - b * d;
        double determinanteX = c * e - b * f;
        double determinanteY = a * f - c * d;

        if (determinantePrincipal != 0) {
            double x = determinanteX / determinantePrincipal;
            double y = determinanteY / determinantePrincipal;

            System.out.println("El valor de x es: " + x);
            System.out.println("El valor de y es: " + y);
        } else {
            // El sistema no tiene solución única
            if (determinanteX == 0 && determinanteY == 0) {
                System.out.println("El sistema tiene infinitas soluciones.");
            } else {
                System.out.println("El sistema no tiene solución.");
            }
        }
    }
}
