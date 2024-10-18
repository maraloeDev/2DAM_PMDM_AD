package Problema2;

import java.util.Scanner;


public class Problema2 {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        int dniNumber;
        do {
            System.out.print("Introduce el número de DNI (8 dígitos): ");
            dniNumber = scanner.nextInt();
            if (String.valueOf(dniNumber).length() != 8) {
                System.out.println("El número de DNI debe tener 8 dígitos. Por favor, inténtalo de nuevo.");
            }
        } while (String.valueOf(dniNumber).length() != 8);

        int remainder = dniNumber % 23;

        char letra;
        switch (remainder) {
            case 0:  letra = 'T'; break;
            case 1:  letra = 'R'; break;
            case 2:  letra = 'W'; break;
            case 3:  letra = 'A'; break;
            case 4:  letra = 'G'; break;
            case 5:  letra = 'M'; break;
            case 6:  letra = 'Y'; break;
            case 7:  letra = 'F'; break;
            case 8:  letra = 'P'; break;
            case 9:  letra = 'D'; break;
            case 10: letra = 'X'; break;
            case 11: letra = 'B'; break;
            case 12: letra = 'N'; break;
            case 13: letra = 'J'; break;
            case 14: letra = 'Z'; break;
            case 15: letra = 'S'; break;
            case 16: letra = 'Q'; break;
            case 17: letra = 'V'; break;
            case 18: letra = 'H'; break;
            case 19: letra = 'L'; break;
            case 20: letra = 'C'; break;
            case 21: letra = 'K'; break;
            default: letra = 'E'; break;
        }
        System.out.println("Letra= " + letra);
    }
        
        
    }