package EjerciciosMatrices;

import java.util.Random;

public class Ejercicio01_Matriz1 {

    static int[][] enteros = new int[5][5];
    static Random rndm = new Random();

    public static void main(String[] args) {

        for (int i = 0; i < enteros.length; i++) {
            for (int j = 0; j < enteros[i].length; j++) {

                if ((i % 2) == 0) {
                    enteros[i][j] = rndm.nextInt(0, 10) * 2;
                } else {
                    enteros[i][j] = rndm.nextInt(0, 10) * 3;
                }
            }
        }
        imprimirMatriz();
        sumaMatriz();
        diagonal();
    }

    static void imprimirMatriz() {
        for (int i = 0; i < enteros.length; i++) {
            for (int j = 0; j < enteros[i].length; j++) {
                System.out.print(enteros[i][j] + " ");

            }
            System.out.println("");

        }
    }
    
    static void sumaMatriz(){
        int suma=0;
        
        for (int i = 0; i < enteros.length; i++) {
            for (int j = 0; j < enteros[i].length; j++) {
                suma+=enteros[i][j];

            }
        }
        System.out.println("La suma de la matriz es " + suma);
    }
    
    static void diagonal(){
        for (int i = 0; i < enteros.length; i++) {
            for (int j = 0; j < enteros[i].length; j++) {
                if (i==j){
                    
                System.out.print(enteros[i][j] + " ");
                }

            }
            System.out.println("");

        }
    }
}
