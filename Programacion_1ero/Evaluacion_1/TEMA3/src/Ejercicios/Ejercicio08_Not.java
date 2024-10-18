package Ejercicios;

import java.util.Scanner;


public class Ejercicio08_Not {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un número binario de 8 bits: ");
        String binario = scanner.nextLine();
        
        // Complemento
        String complemento = notBinario(binario);
        int decimal = Integer.parseInt(complemento, 2);
        
        System.out.println("NOT(" + binario + ") = " + complemento);
        System.out.println("En decimal: " + decimal);
    }

    public static String notBinario(String binario) {
        StringBuilder complemento = new StringBuilder();
        for (int i = 0; i < binario.length(); i++) {
            complemento.append(binario.charAt(i) == '0' ? '1' : '0');
        }
        return complemento.toString();
    }
    
}
