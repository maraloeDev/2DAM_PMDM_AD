package Ejercicios;

import java.util.Scanner;


public class Ejercicio03_Calculo {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce un numero ");
        int numero1=scanner.nextInt();
        
        System.out.print("Introduce un numero ");
        int numero2=scanner.nextInt();
        
        System.out.println("SUMA " + (numero1 + numero2));
        System.out.println("RESTA " + (numero1 - numero2));
        System.out.println("MULTIPLICACION " + (numero1 * numero2));
        System.out.println("DIVISION " + (numero1 / numero2));
        System.out.println("RESTO " + (numero1 % numero2));
        
        
        
    }
    
}
