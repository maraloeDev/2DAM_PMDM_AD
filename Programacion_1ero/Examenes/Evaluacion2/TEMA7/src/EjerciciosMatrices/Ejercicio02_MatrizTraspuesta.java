package EjerciciosMatrices;

import java.util.Random;


public class Ejercicio02_MatrizTraspuesta {
    
    static int matriz[][] = new int[4][5];
    static int matrizT[][] = new int[5][4];
    static Random rndm = new Random();
    
    public static void main(String[] args) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j]=rndm.nextInt(1, 100);
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
        matrizTraspuesta(matriz);
    }
    static void matrizTraspuesta(int matriz[][]){
        
        for (int i = 0; i < matrizT.length; i++) {
            for (int j = i; j < matrizT[0].length; j++) {
                matriz[i][j]=matriz[j][i];
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
            
        }
        
    }
 
    }