package Ejercicios;

import java.util.Scanner;

public class Ejercicio01_GetASCIICodeFromChar {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        char dato;
        
        System.out.print("Introduce un caracter: ");
        
        dato = scanner.nextLine().charAt(0);
        
        System.out.println("El valor ASCII del caracter " + dato + " es " + (int) dato);
        
        

    }

}
