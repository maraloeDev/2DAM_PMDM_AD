package Ejercicios;

import java.util.Scanner;


public class Ejercicio08_SentenciaLogica {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        boolean positivo = true;
        
        System.out.print("Introduce un numero: ");
        int numero=scanner.nextInt();
        
        if(numero < 0){
            System.out.println(!positivo);
            
        } else if(numero > 0 && numero < 100){
            System.out.println(positivo);
            
        } else if(numero>=100){
            System.out.println(positivo);
        }
    }
    
}
