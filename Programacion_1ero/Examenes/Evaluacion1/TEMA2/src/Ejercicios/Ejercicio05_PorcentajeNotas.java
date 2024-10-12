package Ejercicios;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Ejercicio05_PorcentajeNotas {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        System.out.print("Introduce el numero de sobresalientes ");
        int SB = scanner.nextInt();

        System.out.print("Introduce el numero de notables ");
        int N = scanner.nextInt();

        System.out.print("Introduce el numero de aprobados ");
        int A = scanner.nextInt();

        System.out.print("Introduce el numero de suspensos ");
        int S = scanner.nextInt();

        System.out.print("Introduce el numero de no presentados ");
        int NP = scanner.nextInt();

        int total = (SB + N + A + S + NP);
        int totalPresentados = (SB + N + A + S);
        int totalAprobados = (SB + N + A);
        int totalSuspensos = S;
        int totalNoPresentados = NP;

        String porcentajeSB = decimalFormat.format((double) SB / total * 100);
        String porcentajeN = decimalFormat.format((double) N / total * 100);
        String porcentajeA = decimalFormat.format((double) A / total * 100);
        String porcentajeS = decimalFormat.format((double) S / total * 100);
        String porcentajeNP = decimalFormat.format((double) NP / total * 100);
        String porcentajeTotal = decimalFormat.format((double) total / total * 100);
        String porcentajeTotalPresentados = decimalFormat.format((double) totalPresentados / total * 100);
        String porcentajeTotalA = decimalFormat.format((double) totalAprobados / total * 100);
        String porcentajeTotalS = decimalFormat.format((double) totalSuspensos / total * 100);
        String porcentajeTotalNP = decimalFormat.format((double) totalNoPresentados / total * 100);

        // VARIABLES PARA FORMATO
        System.out.println("SB= " + SB + "(" + porcentajeSB + " %)");
        System.out.println("N= " + N + "(" + porcentajeN + " %)");
        System.out.println("A= " + A + "(" + porcentajeA + " %)");
        System.out.println("S= " + S + "(" + porcentajeS + " %)");
        System.out.println("NP= " + NP + "(" + porcentajeNP + " %)");
        System.out.println("Total= " + total + "(" + porcentajeTotal + " %)");
        System.out.println("Total presentados= " + totalPresentados + "(" + porcentajeTotalPresentados + " %)");
        System.out.println("Total aprobados= " + totalAprobados + "(" + porcentajeTotalA + " %)");
        System.out.println("Total suspensos= " + totalSuspensos + "(" + porcentajeTotalS + " %)");
        System.out.println("Total no presentados= " + totalNoPresentados + "(" + porcentajeTotalNP + " %)");
    }

}
