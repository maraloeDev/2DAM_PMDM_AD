package Ejercicios;


public class Ejercicio08_Intercambio {
    
    public static void main(String[] args) {
        
        int a = 3;
        int b = 8;
        
        System.out.println("Valor anterior de las variables: " + "\n" + "a=" + a + "\n" + "b= " + b);
        
        a=b;
        b=a;
        
        System.out.println("Valor actual de las variables: " + "\n"  + "a=" + a + "\n" + "b= " + b);
    }
    
}
