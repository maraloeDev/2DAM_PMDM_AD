package EjerciciosVectores;

import java.util.Scanner;

public class Ejercicio02_Datos {

    static int enteros[] = new int[10];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0; i < enteros.length; i++) {
            System.out.print("Introduce un numero: ");
            enteros[i] = scanner.nextInt();
        }
        sumaPares();
    }

    static void sumaPares() {
        int suma = 0;

        for (int i = 0; i < enteros.length; i++) {
            if ((i % 2) == 0) {
                System.out.println("Los elementos que ocupan las posiciones pares son: "+ enteros[i]);
                suma += enteros[i];
            }

        }
        System.out.println("La suma de todos los numeros pares es " + suma);
    }

}
