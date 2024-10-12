package Ejercicios;

import java.util.Scanner;

public class Ejercicio02_Binario {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce bit 2");
        int bit2 = teclado.nextInt();

        System.out.println("Introduce bit 1");
        int bit1 = teclado.nextInt();

        System.out.println("Introduce bit0 ");
        int bit0 = teclado.nextInt();

        if (bit2 != 0 && bit2 != 1 || bit1 != 0 && bit1 != 1 || bit0 != 0 && bit0 != 1) {
            System.out.println("El numero es Incorrecto");
        } else {
            int resultado = (bit2 + 2 * bit1 + bit0 + bit0 * 1);
            System.out.println("El resultado decimal es: " + resultado);
        }
    }
}
