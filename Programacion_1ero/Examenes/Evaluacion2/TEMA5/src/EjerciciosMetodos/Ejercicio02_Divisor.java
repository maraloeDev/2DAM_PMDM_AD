package EjerciciosMetodos;

import java.util.Scanner;

public class Ejercicio02_Divisor {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        divisor();
    }

    public static void divisor() {

        System.out.print("Introduce un divisor: ");
           int divisor = scanner.nextInt();

            System.out.print("Introduce un entero: ");
           int entero = scanner.nextInt();
        int mayor = 0;

        do {
            System.out.print("Introduce un divisor: ");
            divisor = scanner.nextInt();

            System.out.print("Introduce un entero: ");
            entero = scanner.nextInt();

            if ((entero == divisor) || (divisor < entero)) {
                System.out.println("El numero entero y el divisor son iguales");
            }
            
            System.out.println("Introduce un numero entero");
            entero = scanner.nextInt();

            System.out.println("Introduce un divisor");
            divisor = scanner.nextInt();

        } while (entero == divisor);

        System.out.println("El divisor mas grande de un entero dado es: " + divisor);
    }

}
