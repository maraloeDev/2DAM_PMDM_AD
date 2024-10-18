package EjerciciosPilasyColas;

import java.util.Stack;


public class Ejercicio01_InvertirArray {
    
    static int[] enteros = new int[5];
    static Stack<Integer> pila = new Stack<>();
    
    public static void main(String[] args) {
        
        for (int i = 0; i <= enteros.length-1; i++) {
        pila.push(i);
        }
        
        for(Integer numerosOrdenados: pila){
            System.out.println(numerosOrdenados);
        }
        
        System.out.println("-----------");
        
        //Dar la vuelta
        
        while(!pila.isEmpty()){
            System.out.println(pila.pop());
        }
    }
    
    
}
