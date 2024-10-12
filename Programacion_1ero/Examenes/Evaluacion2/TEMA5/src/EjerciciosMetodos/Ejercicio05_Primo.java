/**
 * *****************************************************************************
 * Copyright (C) EDUARDO MARTiN-SONSECA (maraloeDev)
 * ****************************************************************************
 */
package EjerciciosMetodos;

import java.util.Scanner;

/**
 *
 * @author marti
 */
public class Ejercicio05_Primo {

    static Scanner teclado = new Scanner(System.in);

    public static void esPrimo() {

        System.out.println("Introduce un numero");
        int primo = teclado.nextInt();
        int contador = 0;
        for (int i = 1; i <= primo; i++) {

            if ((primo % i) == 0) {
                contador++;
            }

        }
        if (contador <= 2) {
            System.out.println("Es primo");
        } else {
            System.out.println("No es primo");
        }
    }

    public static void main(String[] args) {
        esPrimo();
    }

}
