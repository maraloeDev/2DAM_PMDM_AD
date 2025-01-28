package Problema2;

import java.util.Scanner;

public class App {

    static Cuenta cuenta = new Cuenta("123456789", 150);
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String opcion;
        do {

            System.out.println("""
                           Introduce una opcion: 
                           1. Ingresar dinero
                           2. Retirar dinero
                           3. Mostrar saldo""");

            opcion = scanner.next();
            switch (opcion) {
                case "1":
                    System.out.print("Ingrese el dinero a ingresar: ");
                    double saldoaIngresar = scanner.nextDouble();

                    cuenta.ingresarDinero(saldoaIngresar);
                    break;
                case "2":
                    System.out.print("Ingrese el dinero a retirar: ");
                    double saldoaRetirar = scanner.nextDouble();
                    cuenta.retirarDinero(saldoaRetirar);

                case "3":
                    System.out.println("El saldo actual es: " + cuenta.getSaldo());

                    break;
                default:
                    System.out.println("Opcion no contemplada");
            }
        } while (!"3".equals(opcion));
    }

}
