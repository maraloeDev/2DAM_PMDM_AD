package Ejercicios;

import java.util.Scanner;

public class Ejercicio01_EstanEnOrden {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Introduce un numero: ");
        int n1 = scanner.nextInt();

        System.out.print("Introduce un numero: ");
        int n2 = scanner.nextInt();

        System.out.print("Introduce un numero: ");
        int n3 = scanner.nextInt();

        if ((n1 > n2) && (n2 > n3) && (n1 > n3)) {
            System.out.println("Estan ordenados de mayor a menor");

        } else if ((n1 < n2) && (n2 < n3) && (n1 < n3)) {
            System.out.println("Estan ordenados de menor a mayor");

        } else {
            System.out.println("Estan desordenados");
        }

    }

}
