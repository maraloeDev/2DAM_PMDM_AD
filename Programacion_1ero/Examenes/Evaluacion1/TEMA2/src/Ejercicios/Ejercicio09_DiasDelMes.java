package Ejercicios;

import java.util.Scanner;


public class Ejercicio09_DiasDelMes {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Introduce un numero de mes (1-12)");
        int diaDelMes = scanner.nextInt();
        
        String meses = 
                (1 == diaDelMes) ? "enero" : 
                (2 == diaDelMes) ? "febrero" : 
                (3 == diaDelMes) ? "marzo" :
                (4 == diaDelMes) ? "abril" : 
                (5 == diaDelMes) ? "mayo" : 
                (6 == diaDelMes) ? "junio" : 
                (7 == diaDelMes) ? "julio" : 
                (8 == diaDelMes) ? "agosto" : 
                (9 == diaDelMes) ? "septiempre" : 
                (10 == diaDelMes) ? "octubre" : 
                (11 == diaDelMes) ? "noviembre" :
                (12 == diaDelMes) ? "diciembre" : "0";
        
        String dias =
                (1 == diaDelMes) ? "31" : 
                (2 == diaDelMes) ? "28" : 
                (3 == diaDelMes) ? "31" :
                (4 == diaDelMes) ? "30" : 
                (5 == diaDelMes) ? "31" : 
                (6 == diaDelMes) ? "30" : 
                (7 == diaDelMes) ? "31" : 
                (8 == diaDelMes) ? "31" : 
                (9 == diaDelMes) ? "30" : 
                (10 == diaDelMes) ? "31" : 
                (11 == diaDelMes) ? "30" :
                (12 == diaDelMes) ? "31" : "0";
        
        System.out.println(meses + " " + dias);
    }
    
}