package Examen;

import java.util.Scanner;

public class Ejercicio03 {

    /**
     * Diseña una clase en Java llamada `CuentaBancaria` que cumpla con las
     * siguientes especificaciones:
     *
     * 1. La clase debe tener los siguientes atributos: - `titular` (de tipo
     * `String`): el nombre del titular de la cuenta. - `saldo` (de tipo
     * `double`): el saldo actual de la cuenta.
     *
     * 2. La clase debe tener los siguientes métodos: - **Constructor**: un
     * constructor que reciba como parámetros el nombre del titular y el saldo
     * inicial. - **Depositar**: un método que permita ingresar una cantidad de
     * dinero a la cuenta. Si la cantidad es negativa, se debe imprimir un
     * mensaje de error. - **Retirar**: un método que permita retirar una
     * cantidad de dinero de la cuenta. Si la cantidad a retirar es mayor al
     * saldo disponible, se debe imprimir un mensaje de error. -
     * **MostrarSaldo**: un método que muestre el saldo actual de la cuenta. -
     * **Transferir**: un método que permita transferir dinero a otra cuenta
     * bancaria. Si el saldo de la cuenta es insuficiente, se debe imprimir un
     * mensaje de error.
     *
     * 3. En el `main`, crea dos objetos `CuentaBancaria` con diferentes
     * titulares y saldos. Luego, realiza las siguientes operaciones: - Deposita
     * una cantidad en la primera cuenta. - Realiza un retiro en la primera
     * cuenta. - Realiza una transferencia de dinero desde la primera cuenta
     * hacia la segunda. - Muestra los saldos de ambas cuentas después de cada
     * operación.
     */
    static Scanner scanner = new Scanner(System.in);

    public static class CuentaBancaria {

        String titular;
        double saldo;

        public CuentaBancaria(String titular, double saldo) {
            this.titular = titular;
            this.saldo = saldo;
        }

        public String getTitular() {
            return titular;
        }

        public void setTitular(String titular) {
            this.titular = titular;
        }

        public double getSaldo() {
            return saldo;
        }

        public void setSaldo(double saldo) {
            this.saldo = saldo;
        }

        @Override
        public String toString() {
            return "CuentaBancaria{" + "titular=" + titular + ", saldo=" + saldo + '}';
        }

        // Método para depositar dinero
        public void depositarDinero(double cantidad) {
            if (cantidad < 0) {
                System.out.println("La cantidad a depositar no puede ser negativa.");
            } else {
                saldo += cantidad;
                System.out.println("Deposito realizado exitosamente.");
            }
        }

        // Método para retirar dinero
        public void retirarDinero(double cantidad) {
            if (cantidad > saldo) {
                System.out.println("Saldo insuficiente para realizar el retiro.");
            } else {
                saldo -= cantidad;
                System.out.println("Retiro realizado exitosamente.");
            }
        }

        // Método para mostrar el saldo
        public void mostrarSaldo() {
            System.out.println("Saldo actual de la cuenta de " + titular + ": " + saldo);
        }

        // Método para transferir dinero a otra cuenta
        public void transferirDinero(CuentaBancaria cuentaDestino, double cantidad) {
            if (cantidad > saldo) {
                System.out.println("Saldo insuficiente para realizar la transferencia.");
            } else {
                saldo -= cantidad;
                cuentaDestino.depositarDinero(cantidad);
                System.out.println("Transferencia realizada con éxito.");
            }
        }
    }

    public static void main(String[] args) {
        // Crear dos cuentas bancarias
        CuentaBancaria cuenta1 = new CuentaBancaria("Juan Pérez", 1000.00);
        CuentaBancaria cuenta2 = new CuentaBancaria("Ana López", 500.00);

        // Mostrar saldos iniciales
        cuenta1.mostrarSaldo();
        cuenta2.mostrarSaldo();

        // Realizar un depósito en la cuenta1
        System.out.print("Ingrese la cantidad a depositar en la cuenta de " + cuenta1.getTitular() + ": ");
        double deposito = scanner.nextDouble();
        cuenta1.depositarDinero(deposito);
        cuenta1.mostrarSaldo();

        // Realizar un retiro en la cuenta1
        System.out.print("Ingrese la cantidad a retirar de la cuenta de " + cuenta1.getTitular() + ": ");
        double retiro = scanner.nextDouble();
        cuenta1.retirarDinero(retiro);
        cuenta1.mostrarSaldo();

        // Realizar una transferencia de cuenta1 a cuenta2
        System.out.print("Ingrese la cantidad a transferir de " + cuenta1.getTitular() + " a " + cuenta2.getTitular() + ": ");
        double transferencia = scanner.nextDouble();
        cuenta1.transferirDinero(cuenta2, transferencia);

        // Mostrar los saldos después de la transferencia
        cuenta1.mostrarSaldo();
        cuenta2.mostrarSaldo();
    }
}
