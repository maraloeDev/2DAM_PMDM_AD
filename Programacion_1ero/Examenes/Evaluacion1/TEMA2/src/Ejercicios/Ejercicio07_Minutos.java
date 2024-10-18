package Ejercicios;

import java.util.Scanner;


public class Ejercicio07_Minutos {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Introduce un numero de segundos: ");
        int segundos= scanner.nextInt();
        
        int minutos = segundos / 60;
        int segundosRestantes = segundos % 60;
        
        System.out.println(segundos + "s =" + minutos + "m " + segundosRestantes + "s");
    }
    
}
