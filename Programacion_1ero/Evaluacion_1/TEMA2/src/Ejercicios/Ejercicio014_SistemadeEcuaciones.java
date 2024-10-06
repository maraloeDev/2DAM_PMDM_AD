package Ejercicios;
import java.util.Scanner;

public class Ejercicio014_SistemadeEcuaciones {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir los coeficientes al usuario
        System.out.println("Introduce los coeficientes de la primera ecuación (ax + by = c):");
        System.out.print("a: ");
        double a = scanner.nextDouble();
        System.out.print("b: ");
        double b = scanner.nextDouble();
        System.out.print("c: ");
        double c = scanner.nextDouble();

        System.out.println("Introduce los coeficientes de la segunda ecuación (dx + ey = f):");
        System.out.print("d: ");
        double d = scanner.nextDouble();
        System.out.print("e: ");
        double e = scanner.nextDouble();
        System.out.print("f: ");
        double f = scanner.nextDouble();

        double determinante = (a * e) - (b * d);

        if (determinante == 0) {
            System.out.println("El sistema no tiene solución única.");
        } else {
            double x = (c * e - b * f) / determinante;
            double y = (a * f - c * d) / determinante;

            System.out.println("La solución es: ");
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        }
    }
}
