package Ejercicios;

import java.util.Scanner;

public class Ejercicio03_Calculo {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        float n1;
        float n2;
        char operacion;

        System.out.print("Introduce un numero: ");
        n1 = scanner.nextFloat();

        System.out.print("Introduce un numero: ");
        n2 = scanner.nextFloat();

        System.out.print("Introduce una operacion (+, -, *, / o %) : ");
        operacion = scanner.next().charAt(0);

        switch (operacion) {
            case '+':
                System.out.println(n1 + " " + operacion + " " +  n2 + " = " + (n1 + n2));
                break;
            case '-':
                System.out.println(n1 + " " + operacion + " " +  n2 + " = " + (n1 - n2));
                break;
            case '*':
                System.out.println(n1 + " " + operacion + " " +  n2 + " = " + (n1 * n2));
                break;
            case '/':
                System.out.println(n1 + " " + operacion + " " +  n2 + " = " + (n1 / n2));
                break;
            case '%':
                System.out.println(n1 + " " + operacion + " " +  n2 + " = " + (n1 % n2));
                break;
            default:
                System.out.println("Operacion no contenplada");
        }

    }

}
