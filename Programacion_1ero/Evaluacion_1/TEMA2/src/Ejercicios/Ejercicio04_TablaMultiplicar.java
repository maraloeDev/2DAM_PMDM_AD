package Ejercicios;

import java.util.Scanner;

public class Ejercicio04_TablaMultiplicar {
    
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
    int n;
    n = scanner.nextInt();
    
        System.out.println("la tabla de multiplicar del " + n + " es:");
        
        for (int i = 0; i <= 10; i++) {
            
            System.out.println(n + " * " + i + " = " + ( n* i));
        }
    } 
}
