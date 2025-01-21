package Problema4;

import java.util.Scanner;

public class Problema4 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce el tamaño del cuadrado (entre 3 y 9): ");
        int lado = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        
        if (lado < 3 || lado > 9) {
            System.out.println("ERROR. Tamaño incorrecto. Debe estar entre 3 y 9.");
            return;
        }
        
        System.out.print("Introduce el color de la X (verde, rojo o amarillo): ");
        String color = scanner.nextLine().toLowerCase();
        
        if (!color.equals("verde") && !color.equals("rojo") && !color.equals("amarillo")) {
            System.out.println("ERROR. Color no válido.");
            return;
        }
        
        pintarX(lado, color);
    }
    
    public static void pintarX(int lado, String color) {
        String reset = "\u001B[0m";
        String colorCode;
        
        switch (color) {
            case "verde":
                colorCode = "\u001B[32m";
                break;
            case "rojo":
                colorCode = "\u001B[31m";
                break;
            case "amarillo":
                colorCode = "\u001B[33m";
                break;
            default:
                return;
        }
        
        for (int i = 0; i < lado; i++) {
            for (int j = 0; j < lado; j++) {
                if (i == j || j == lado - 1 - i) {
                    System.out.print(colorCode + "X" + reset);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
