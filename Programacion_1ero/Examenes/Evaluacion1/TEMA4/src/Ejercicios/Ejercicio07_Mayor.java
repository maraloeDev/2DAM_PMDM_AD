package Ejercicios;

import java.util.Random;

public class Ejercicio07_Mayor {

    public static void main(String[] args) {

        Random rndm = new Random();
        int aleatorio;
        int mayorN =0;

        for (int i = 0; i < 20; i++) {
            aleatorio= rndm.nextInt(1,1000);

            if (i==10){
                System.out.println("----------------");
            }

            if (aleatorio > mayorN){
                mayorN=aleatorio;

            }
            System.out.println(aleatorio);

        }

        System.out.println("El numero mas grande de todos es el " + mayorN);
    }
}
