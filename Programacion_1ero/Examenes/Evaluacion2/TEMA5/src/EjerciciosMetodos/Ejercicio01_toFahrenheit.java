package EjerciciosMetodos;

import java.util.Scanner;

public class Ejercicio01_toFahrenheit {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("La temperatura de Celsius a Farenheit es: " + toFahrenheit());
    }

    public static double toFahrenheit() {

        System.out.print("Introduce un numero de grados Celsius: ");
        int celsius = scanner.nextInt();

        double formula = (celsius * 9 / 5) + 32;
        return formula;
    }

}
