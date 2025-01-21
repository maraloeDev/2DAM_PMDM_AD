package Ejercicios;

import java.util.Scanner;

public class Ejercicio02_GetCharFromAsciiCode {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce un numero: ");
        double numero = scanner.nextDouble();
        
        System.out.println("El numero introducido convertido a numero es " + (char) numero);
    }
    
}
