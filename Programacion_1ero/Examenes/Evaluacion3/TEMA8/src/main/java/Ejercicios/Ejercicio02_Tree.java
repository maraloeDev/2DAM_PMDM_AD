package Ejercicios;

import java.io.File;
import java.util.Scanner;

public class Ejercicio02_Tree {
    public static void main(String[] args) {
        Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Introduce la ruta del directorio:");
        String path = scanner.nextLine();
        scanner.close();
        
        File directory = new File(path);

        if (!directory.isDirectory()) {
            System.out.println("La ruta especificada no es un directorio válido.");
            return;
        }
        
        System.out.println("Árbol de directorios para: " + directory.getPath());
        printDirectoryTree(directory, 0);
    }

    private static void printDirectoryTree(File directory, int level) {
        File[] files = directory.listFiles();
        
        if (files != null) {
            for (File file : files) {
                for (int i = 0; i < level; i++) {
                    System.out.print("  ");
                }

                System.out.println("|_" + file.getName());

                if (file.isDirectory()) {
                    printDirectoryTree(file, level + 1);
                }
            }
        }
    }
}
