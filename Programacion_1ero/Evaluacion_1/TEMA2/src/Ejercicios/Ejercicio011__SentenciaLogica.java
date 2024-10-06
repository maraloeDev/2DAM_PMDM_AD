package Ejercicios;

import java.util.Scanner;

public class Ejercicio011__SentenciaLogica {
    
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean es = true;
        
        System.out.print("Inreoduce un numero: ");
        int x = scanner.nextInt();
        
        if ( x < 0) {
            System.out.println(!es);
        } else if (0 < x || x < 100){
            System.out.println(es);
            
        } else if( x > 100 ){
            System.out.println(es);
        }

        
    }

}
