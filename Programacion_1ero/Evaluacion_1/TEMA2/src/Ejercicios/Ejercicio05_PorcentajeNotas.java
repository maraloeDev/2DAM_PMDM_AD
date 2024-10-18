package Ejercicios;

import java.util.Scanner;

public class Ejercicio05_PorcentajeNotas {
    
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {

        int sobreSalientes;
        int notables;
        int aprobados;
        int suspensos;
        int noPresentados;
        int totalAlumnos;
        int totalPresentados;
        int totalAprobados;
        int totalSuspensos;
        int totalNoPresentados;

        System.out.print("Introduce el numero de sobresalientes: ");
        sobreSalientes = scanner.nextInt();

        System.out.print("Introduce el numero de notables: ");
        notables = scanner.nextInt();

        System.out.print("Introduce el numero de aprobados: ");
        aprobados = scanner.nextInt();

        System.out.print("Introduce el numero de suspensos: ");
        suspensos = scanner.nextInt();

        System.out.print("Introduce el numero de no presentados: ");
        noPresentados = scanner.nextInt();

        totalAlumnos = sobreSalientes + notables + aprobados + suspensos + noPresentados;
        totalPresentados = sobreSalientes + notables + aprobados + suspensos;
        totalAprobados = sobreSalientes + notables + aprobados;
        totalSuspensos = suspensos;
        totalNoPresentados = noPresentados;
        
        System.out.println("El numero de alumos es: " + totalAlumnos);
        
        System.out.println("SB=" + sobreSalientes + "(" +((double)sobreSalientes * 100) / totalAlumnos + ")");
        System.out.println("N=" + notables + "(" +((double)notables * 100) / totalAlumnos + ")");
        System.out.println("A=" + aprobados + "(" +((double)aprobados * 100) / totalAlumnos + ")");
        System.out.println("S=" + suspensos + "(" +((double)suspensos * 100) / totalAlumnos + ")");
        System.out.println("NP=" + noPresentados + "(" +((double)noPresentados * 100) / totalAlumnos + ")");
        System.out.println("Total=" + totalAlumnos + "(" +((double)totalAlumnos * 100) / totalAlumnos + ")");
        System.out.println("Total presentados=" + totalPresentados + "(" +((double)totalPresentados * 100) / totalAlumnos + ")");
        System.out.println("Total aprobados=" + totalAprobados + "(" +((double)totalAprobados * 100) / totalAlumnos + ")");
        System.out.println("Total suspensos=" + totalSuspensos + "(" +((double)totalSuspensos * 100) / totalAlumnos + ")");
        System.out.println("Total no presentados=" + totalNoPresentados + "(" +((double)totalNoPresentados * 100) / totalAlumnos + ")");
    }
    
}
