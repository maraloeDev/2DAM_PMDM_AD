package Ejercicios;

import java.util.Scanner;

public class Ejercicio05_EcuacionCuadratica {
    
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar los coeficientes a, b y c
        System.out.print("Introduce el coeficiente a (a ≠ 0): ");
        double a = scanner.nextDouble();
        
        // Verificar que a no sea cero
        if (a == 0) {
            System.out.println("El valor de 'a' no puede ser 0 en una ecuación cuadrática.");
            System.exit(0);
        }

        System.out.print("Introduce el coeficiente b: ");
        double b = scanner.nextDouble();

        System.out.print("Introduce el coeficiente c: ");
        double c = scanner.nextDouble();

        // Calcular el discriminante (Delta)
        double discriminante = (b * b) - (4 * a * c);

        // Evaluar el discriminante para determinar las soluciones
        if (discriminante > 0) {
            // Dos soluciones reales distintas
            double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            System.out.println("Existen dos soluciones reales:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else if (discriminante == 0) {
            // Una solución real única
            double x = -b / (2 * a);
            System.out.println("Existe una única solución real:");
            System.out.println("x = " + x);
        } else {
            // Soluciones complejas (imaginarias)
            double parteReal = -b / (2 * a);
            double parteImaginaria = Math.sqrt(-discriminante) / (2 * a);
            System.out.println("Existen dos soluciones complejas:");
            System.out.println("x1 = " + parteReal + " + " + parteImaginaria + "i");
            System.out.println("x2 = " + parteReal + " - " + parteImaginaria + "i");
        }

        // Cerrar el Scanner
        scanner.close();
    }
}