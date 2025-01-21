package Problema1;

import java.util.Random;
import java.util.Scanner;


public class Problema1 {
    
    static Random rndm = new  Random();
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        int adivinar = rndm.nextInt(1, 100);
        int min=1;
        int max=100;
        boolean acertado = false;
        int numero;
        
        System.out.println("El numero secreto esta entre " + min + " y " + max + "\n" + "cual es");
        while(acertado ==false){
            numero=scanner.nextInt();
            
            if (numero==adivinar){
                System.out.println("Has acertado");
                acertado=true;
            } else{
                if (adivinar > (min + max) / 2){
                    min = (min + max) / 2;
                    System.out.println("El numero secreto está entre " + min + " y " + max + "\n" + "cual es");
                    
                } else{
                    max = (min + max) / 2;
                    System.out.println("El numero secreto está entre " + min + " y " + max + "\n" + "cual es");
                }
            }
            
        }
    }
    
}
