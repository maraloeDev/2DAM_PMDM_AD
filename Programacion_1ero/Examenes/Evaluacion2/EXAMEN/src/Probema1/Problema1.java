package Probema1;

public class Problema1 {

    static int[][] enteros = new int[10][10];

    public static void main(String[] args) {

        for (int i = 1; i < 10; i++) {
            System.out.println("");
            for (int j = 0; j < enteros[i].length; j++) {

                if (enteros[i][j] % 2 == 0) {
                    System.out.print(i + " ");

                } else{
                    System.out.print(j + " ");
                }

            }
            System.out.print("");

        }
    }

}
