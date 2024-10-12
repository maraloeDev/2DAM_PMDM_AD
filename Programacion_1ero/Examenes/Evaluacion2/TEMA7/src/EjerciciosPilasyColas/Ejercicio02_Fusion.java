package EjerciciosPilasyColas;

import java.util.Random;
import java.util.Stack;

public class Ejercicio02_Fusion {

    static Stack<Integer> pilaOrdenadaA = new Stack<>();
    static Stack<Integer> pilaOrdenadaD = new Stack<>();
    static Stack<Integer> pilaFusionada = new Stack<>();

    static Random rndm = new Random();

    public static void main(String[] args) {
        pilaAscendente();
        pilaDescentente();
        pilaFusionada();
    }

    static void pilaAscendente() {

        for (int i = 1; i <= rndm.nextInt(1, 10); i++) {
            pilaOrdenadaA.push(rndm.nextInt(1, 20));
        }

        for (Integer pilaAscendente : pilaOrdenadaA) {
            System.out.println(pilaAscendente);
        }
        System.out.println("---------");
    }

    static void pilaDescentente() {

        for (int i = 1; i <= rndm.nextInt(1, 10); i++) {
            pilaOrdenadaD.push(rndm.nextInt(1, 20));
        }

        while (!pilaOrdenadaD.isEmpty()) {
            System.out.println(pilaOrdenadaD.pop());
        }
        System.out.println("---------");
    }

    static void pilaFusionada() {

        while (!pilaOrdenadaA.isEmpty()) {
            pilaFusionada.push(pilaOrdenadaA.pop());
        }

        while (!pilaOrdenadaD.isEmpty()) {
            pilaFusionada.push(pilaOrdenadaD.pop());
        }

        for (Integer pilaFusion : pilaFusionada) {
            System.out.println(pilaFusion);
        }
    }

}
