package EjerciciosMetodos;

import java.util.Scanner;

public class Ejercicio04_Areas {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String opcion;
        do {

            System.out.println("""
                               Introduce una opcion:
                                1-Circulo
                                2-Cuadrado
                                3-Rectangulo
                                4-Triangulo """);

            opcion = scanner.next();

            switch (opcion) {

                case "1":
                    circulo();
                    break;

                case "2":
                    cuadrado();
                    break;

                case "3":
                    rectangulo();
                    break;

                case "4":
                    triangulo();

                default:
                    System.out.println("Opcion no contemplada");

            }
        } while (!"4".equals(opcion));
    }

    private static void circulo() {
        System.out.println("Introduce un radio");
        int radio = scanner.nextInt();
        double area = Math.PI * (Math.pow(radio, 2));

        System.out.println("Área del círculo A = " + area);
    }

    private static void cuadrado() {
        System.out.print("Introduce un lado: ");
        int lado = scanner.nextInt();
        double area = Math.pow(lado, 2);

        System.out.println("Área del cuadrado A = " + area);
    }

    private static void rectangulo() {
        System.out.print("Introduce una base: ");
        int base = scanner.nextInt();

        System.out.print("Introduce una altura: ");
        int altura = scanner.nextInt();

        double area = base * altura;

        System.out.println("Área del rectangulo A = " + area);

    }

    private static void triangulo() {
        System.out.print("Introduce una base: ");
        int base = scanner.nextInt();

        System.out.print("Introduce una altura: ");
        int altura = scanner.nextInt();

        double area = (base * altura) / 2;

        System.out.println("Área del rectangulo A = " + area);

    }

}
