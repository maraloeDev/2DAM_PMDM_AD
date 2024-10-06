package Ejercicios;

import java.util.Scanner;

public class Ejercicio012__DiasDelMes {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        System.out.println("Introduce un número de mes (1 - 12):");
        int diaMes = scanner.nextInt();

        String diaDelMes = (diaMes == 1) ? "Enero" :
                           (diaMes == 2) ? "Febrero" :
                           (diaMes == 3) ? "Marzo" :
                           (diaMes == 4) ? "Abril" :
                           (diaMes == 5) ? "Mayo" :
                           (diaMes == 6) ? "Junio" :
                           (diaMes == 7) ? "Julio" :
                           (diaMes == 8) ? "Agosto" :
                           (diaMes == 9) ? "Septiembre" :
                           (diaMes == 10) ? "Octubre" :
                           (diaMes == 11) ? "Noviembre" :
                           (diaMes == 12) ? "Diciembre" :
                           "Mes inválido"; 

        
        System.out.println("El mes correspondiente es: " + diaDelMes);
    }
}
