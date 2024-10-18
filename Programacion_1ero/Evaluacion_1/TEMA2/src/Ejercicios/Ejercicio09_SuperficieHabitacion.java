package Ejercicios;

import java.util.Scanner;

public class Ejercicio09_SuperficieHabitacion {
    
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.println("Introduce la longitud de tu habitacion");
        int longitud = scanner.nextInt();
        
        System.out.println("Introduce la anchura de tu habitacion");
        int anchura = scanner.nextInt();
        
        int superficie = anchura * longitud;
        
        System.out.println("La superficie de mi habitacion es " + superficie);
        
    }
    
}
