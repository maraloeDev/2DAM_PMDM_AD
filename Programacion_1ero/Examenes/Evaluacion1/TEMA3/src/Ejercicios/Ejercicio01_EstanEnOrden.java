package Ejercicios;

import java.util.Scanner;


public class Ejercicio01_EstanEnOrden {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce un numero");
        int numero1 = teclado.nextInt();

        System.out.println("Introduce un numero");
        int numero2 = teclado.nextInt();

        System.out.println("Introduce un numero");
        int numero3 = teclado.nextInt();

        if (numero1 > numero2 && numero2 > numero3) {

            System.out.println("Estan ordenados de mayor a menor");

        } else if ((numero1 < numero2 && numero2 < numero3)) {

            System.out.println("Estan ordenados de menor a mayor");
        } else {
            System.out.println("Los numeros estan desordenados");
        }
    }

}
