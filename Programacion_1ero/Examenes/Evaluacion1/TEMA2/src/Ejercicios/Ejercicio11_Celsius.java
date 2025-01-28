package Ejercicios;

import java.util.Scanner;

public class Ejercicio11_Celsius {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese la temperatura en grados Celsius: ");
        double celsius = scanner.nextDouble();

        double fahrenheit = (9.0 / 5.0) * celsius + 32;

        System.out.println("La temperatura equivalente en grados Fahrenheit es: " + fahrenheit);

    }
}
