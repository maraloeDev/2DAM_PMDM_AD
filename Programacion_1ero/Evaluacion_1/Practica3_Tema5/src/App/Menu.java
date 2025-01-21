package App;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);
    private static Cliente c1 = new Cliente("14785698A", "Carlos Pelayo");
    private static Cuenta_Bancaria cb = new Cuenta_Bancaria("ES12 1458 1457 88 7854123658", 0, LocalDate.EPOCH);

    public static void main(String[] args) {

        if (cb == null && c1 == null) {
            cb = new Cuenta_Bancaria();
            c1 = new Cliente();
        }
        menu();
    }

    private static void menu() {
        String opcion = "0";

        do {
            System.out.println("Las operaciones que se pueden realizar en una cuenta, son: "
                    + "\n0 Salir"
                    + "\n1 Ingresar una cantidad de dinero."
                    + "\n2 Reintegrar una cantidad de dinero."
                    + "\n3 Incrementar el saldo de la cuenta con los intereses"
                    + "\n4 Comprobar saldo"
                    + "\n5 Datos del cliente"
                    + "\n6 Datos de la cuenta Bancaria"
                    + "\nIntroduce una opcion: ");
            opcion = scanner.next();

            switch (opcion) {

                case "0":
                    System.out.println("Adios!!!");
                    System.exit(0);
                    break;

                case "1":
                    ingresarDinero();
                    break;

                case "2":
                    reintegrarDinero();
                    break;

                case "3":
                    incrementarDinero();
                    break;

                case "4":
                    comprobarSaldo();
                    break;

                case "5":
                    datosCliente();
                    break;

                case "6":
                    datosCuentaBancaria();
                    break;

                default:
                    System.err.println("Opcion no contemplada");
            }

            //Mientras que la opcion seleccionada no sea 0, se vuelve a repetir
        } while (!opcion.equals("0"));

    }

    /**
     * Metodo en el que se pregunta la cantidad de dinero a ingresar, Si la
     * cantidad a ingresar es menor o igual a 0, se muestra un mensaje de error
     * Si no, el saldo actual del cliente es el saldo actual mas la cantidad a
     * ingresar
     */
    private static void ingresarDinero() {
        System.out.println("Cuanta cantidad quieres ingresar: ");
        double cantidad_a_Ingresar = scanner.nextDouble();

        if (cantidad_a_Ingresar <= 0) {
            System.err.println("No puedes ingresar numeros negativos");
        } else {
            cb.setSaldo(cb.getSaldo() + cantidad_a_Ingresar);
            System.out.println("Cantidad ingresada");
        }
    }

    /**
     * Metodo en el que se pregunta la cantidad de dinero a retirar, Si la
     * cantidad a retirar es mayor o igual al saldo actual, se muestra un
     * mensaje de error Si no, el saldo actual del cliente es el saldo actual
     * menos la cantidad a retirar
     */
    private static void reintegrarDinero() {
        System.out.println("Cuanta cantidad quieres retirar: ");
        double cantidad_a_Retirar = scanner.nextDouble();

        if (cantidad_a_Retirar > cb.getSaldo()) {
            System.err.println("No puedes retirar dinero, debido a que el dinero a retirar supera tu saldo");
        } else {
            cb.setSaldo(cb.getSaldo() - cantidad_a_Retirar);
            System.out.println("Cantidad retirada");
        }
    }

    private static void incrementarDinero() {
        double saldo = cb.getSaldo();
        double interes = 0.02 * saldo;
        saldo += interes;
    }

    //Metodo en el que se comprueba el saldo actual del cliente
    private static void comprobarSaldo() {
        System.out.println("El saldo actual de la cuenta es: " + cb.getSaldo());
    }

    //Metodo en el que se comprueban los datos del cliente
    private static void datosCliente() {
        System.out.println(c1.toString());
    }

    //Metodo en el que se comprueba los datos de la cuenta bancaria
    private static void datosCuentaBancaria() {
        System.out.println(cb.toString());
    }
}
