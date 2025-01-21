package EjerciciosVectores;

import java.util.Scanner;

public class Ejercicio03_Datos2 {

    static int enteros[] = new int[10];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0; i < enteros.length; i++) {
            System.out.print("Introduce un numero: ");
            enteros[i] = scanner.nextInt();
        }
        posicionesImpares();
    }

    static void posicionesImpares() {
        int suma = 0;
        int cuenta = 0;
        System.out.println("Elementos pares en posiciones impares:");
        for (int i = 1; i < enteros.length; i += 2) {
            if (enteros[i] % 2 == 0) {
                System.out.println("Elemento: " + enteros[i] + ", Posicion: " + i);
                cuenta++;
                suma += enteros[i];
            }
        }
        System.out.println("Cantidad de elementos pares en posiciones impares: " + cuenta);
        System.out.println("Suma de los elementos pares en posiciones impares: " + suma);
    }
}
