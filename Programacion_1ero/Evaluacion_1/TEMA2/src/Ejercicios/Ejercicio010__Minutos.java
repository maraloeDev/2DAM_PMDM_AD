package Ejercicios;
import java.util.Scanner;

public class Ejercicio010__Minutos {
    
        static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.print("Ingrese el número de segundos: ");
        int segundosTotales = sc.nextInt();

        int minutos = segundosTotales / 60; 
        int segundos = segundosTotales % 60; 

        System.out.println(segundosTotales + " segundos equivalen a " + minutos + " minutos y " + segundos + " segundos.");
    }
}
