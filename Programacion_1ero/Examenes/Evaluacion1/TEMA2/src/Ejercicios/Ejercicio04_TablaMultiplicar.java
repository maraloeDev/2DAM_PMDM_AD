package Ejercicios;

import java.util.Scanner;


public class Ejercicio04_TablaMultiplicar {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce un numero: ");
        int numero = scanner.nextInt();
        
        System.out.println("TABLA DE MULTIPLICAR DEL " + numero);
        
        for (int i = 0; i <= 10; i++) {
            
            System.out.println(numero + " * " + i + " = " + (numero*i));
            
        }
    }
    
}
