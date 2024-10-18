package EjerciciosVectores;

import java.util.Arrays;
import java.util.Random;

public class Ejercicio05_ListaAleatoria {

    static Random rndm = new Random();
    static int[] enteros = new int[10];

    public static void main(String[] args) {

        int aleatorio = rndm.nextInt(1, 10);

        for (int i = 0; i < enteros.length; i++) {
            do {
                enteros[i] = aleatorio;
        System.out.println(Arrays.toString(enteros));
            } while (i != aleatorio);
        }

    }

}
