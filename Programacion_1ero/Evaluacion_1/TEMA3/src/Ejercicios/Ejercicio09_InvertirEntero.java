package Ejercicios;

import java.util.Scanner;


public class Ejercicio09_InvertirEntero {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un número entero: ");
        int numero = scanner.nextInt();
        
        String invertido = new StringBuilder(String.valueOf(numero)).reverse().toString();
        System.out.println("Número invertido: " + invertido);
    }
    
}
