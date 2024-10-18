package Ejercicios;

public class Ejercicio04_OperacionesAritmeticas {

    public static void main(String[] args) {

        double aleatorios = (int) (Math.random() * 10);
        double aleatorios2 = (int) (Math.random() * 10);

        System.out.println("SUMA" + (aleatorios + aleatorios2));
        System.out.println("RESTA" + (aleatorios - aleatorios2));
        System.out.println("MULTIPLICACION" + (aleatorios * aleatorios2));
        System.out.println("DIVISION" + (aleatorios / aleatorios2));
        System.out.println("RESTO" + (aleatorios % aleatorios2));


    }
}
