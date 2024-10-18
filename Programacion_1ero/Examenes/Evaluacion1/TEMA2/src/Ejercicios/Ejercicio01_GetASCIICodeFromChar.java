package Ejercicios;

import java.util.Scanner;

public class Ejercicio01_GetASCIICodeFromChar {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce un caracter: ");
        char caracter = scanner.next().charAt(0);
        
        System.out.println("El caracter introducido convertido a ASCII es " + (int) caracter);
    }
    
}
