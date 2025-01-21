package Problema1;

import java.util.ArrayList;
import java.util.Random;

public class Aleatorios {

    static ArrayList<Integer> a = new ArrayList<>();
    static Random rndm = new Random();

    public static void main(String[] args) {

        int numerosGenerados = 0;

        while (numerosGenerados < 6) {
            int numeroAleatorio = rndm.nextInt(0, 50);

            if (!a.contains(numeroAleatorio)) {
                a.add(numeroAleatorio);
                numerosGenerados++;
            }
            
            

        }
        
        for(Integer integeros : a){
            System.out.println(integeros);
        }
    }

}
