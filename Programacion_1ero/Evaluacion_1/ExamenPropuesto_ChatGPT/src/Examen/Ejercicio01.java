package Examen;

import java.util.Scanner;


public class Ejercicio01 {
    
    /**
     * Escribe un programa en Java que cumpla con las siguientes especificaciones:

            1. Solicita al usuario ingresar un número entero positivo.
            2. Utiliza un bucle para calcular la suma de todos los números desde 1 hasta el número ingresado por el usuario.
            3. Si el número ingresado es menor o igual a 0, imprime el mensaje: "El número debe ser mayor que 0".
            4. Si el número ingresado es mayor a 0, muestra el resultado de la suma de los números en pantalla.
            5. Si el número ingresado es par, imprime además "El número es par", en caso contrario, "El número es impar".
     */
    
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        // Solicita al usuario ingresar un número entero positivo.
        System.out.println("Introduce un numero positivo");
        int numero = scanner.nextInt();
        
        /**
         * Utiliza un bucle para calcular la suma de todos los números desde 1 
         * hasta el número ingresado por el usuario.
         */
        
        int suma = 0;
        for (int i = 1; i <= numero; i++) {
            suma+=i;
        }
        
        /**
         * Si el número ingresado es menor o igual a 0, imprime el mensaje: "El número debe ser mayor que 0".
         */
        
        if(numero <=0) {
            System.out.println("El numero debe ser mayor que 0");
            
            /**
             * Si el número ingresado es mayor a 0, muestra el resultado de la suma de los números en pantalla.
             */
        } else if(numero > 0) {
        System.out.println("La suma de todos los numeros desde 1 hasta el número ingresado por el usuario es de " + suma);
        
        /**
         * Si el número ingresado es par, imprime además "El número es par", en caso contrario, "El número es impar".
         */
        } if( (numero % 2)==0 ) {
            System.out.println("El numero es par");
        } else {
            System.out.println("El numero es impar");
        }
    }
}
