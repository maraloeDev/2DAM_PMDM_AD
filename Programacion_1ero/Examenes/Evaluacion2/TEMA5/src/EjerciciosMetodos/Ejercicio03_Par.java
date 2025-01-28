package EjerciciosMetodos;

import java.util.Scanner;


public class Ejercicio03_Par {
    
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        par();
    }
    
    public static void par(){
        
        System.out.print("Introduce un numero entero: ");
        int entero = scanner.nextInt();
        
        boolean par=true;
        
        if((entero%2) == 0){
            
            System.out.println(par);
        } else{
            par=false;
            System.out.println(par);
        }
        
    }
    
}
