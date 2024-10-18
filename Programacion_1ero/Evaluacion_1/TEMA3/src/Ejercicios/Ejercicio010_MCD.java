package Ejercicios;

import java.util.Scanner;


public class Ejercicio010_MCD {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el primer número: ");
        int num1 = scanner.nextInt();
        System.out.print("Introduce el segundo número: ");
        int num2 = scanner.nextInt();
        
        System.out.println("El MCD de " + num1 + " y " + num2 + " es: " + calcularMCD(num1, num2));
    }

    public static int calcularMCD(int a, int b) {
        while (b != 0) {
            int resto = a % b;
            a = b;
            b = resto;
        }
        return a;
    }
    
}
