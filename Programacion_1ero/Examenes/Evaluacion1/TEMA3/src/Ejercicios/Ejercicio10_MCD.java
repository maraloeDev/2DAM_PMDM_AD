package Ejercicios;

import java.util.Scanner;

public class Ejercicio10_MCD {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el primer numero");
        int n1 = teclado.nextInt();

        System.out.println("Introduce el segundo numero");
        int n2 = teclado.nextInt();

        if (n1 < 0 || n2 < 0) {
            return;
        }

        int a; 
        int b; 
        if (n1 <= n2) {

            a = n1;
            b = n2;
        } else {
            a = n2;
            b = n1;
        }

        int resto = 0;

        do {
            resto = a % b;

            a = b;

        } while (resto != 0);

        System.out.println("MCD" + "( " + a + " y " + b + " ) = " + n1);
    }
}
