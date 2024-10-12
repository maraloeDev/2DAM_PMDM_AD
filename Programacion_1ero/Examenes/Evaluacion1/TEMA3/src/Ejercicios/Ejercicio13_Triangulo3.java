package Ejercicios;

public class Ejercicio13_Triangulo3 {

    public static void main(String[] args) {
        
        int base = 4;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");

            }
            System.out.println("");

        }
        
        int n = 4;
        for (int i = 1; i <= n; i++) {
            int num = 1;
            for (int j = n; j >= i; j--) {
                System.out.print(num);
                num++;

            }
            System.out.println("");

        }

    }
}
