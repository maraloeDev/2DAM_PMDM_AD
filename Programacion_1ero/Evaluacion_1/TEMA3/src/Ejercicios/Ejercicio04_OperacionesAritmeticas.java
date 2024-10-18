package Ejercicios;

import java.util.Random;

public class Ejercicio04_OperacionesAritmeticas {

    static Random rndm = new Random();

    public static void main(String[] args) {

        int aleatorio1 = rndm.nextInt(0, 10);
        int aleatorio2 = rndm.nextInt(0, 10);

        System.out.println("SUMA " + (aleatorio1 + aleatorio2));
        System.out.println("RESTA " + (aleatorio1 - aleatorio2));
        System.out.println("MULTIPLICACION " + (aleatorio1 * aleatorio2));
        System.out.println("DIVISION " + (aleatorio1 / aleatorio2));
        System.out.println("RESTO " + (aleatorio1 % aleatorio2));
    }

}
