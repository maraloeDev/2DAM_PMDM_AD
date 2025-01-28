package Problema2;

public class Cuenta {

    String numero;
    double saldo;

    public Cuenta(String numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void ingresarDinero(double saldoaIngresar) {

        if (saldoaIngresar <= 0) {
            System.out.println("No se pueden ingresar cantidades negativas");
        } else {
            this.saldo += saldoaIngresar;
            System.out.println("Dinero ingresado correctamente: " + this.saldo);
        }
    }

    public void retirarDinero(double saldoaRetirar) {
        if (saldoaRetirar <= 0) {
            System.out.println("No se pueden retirar cantidades negativas o cero");
        } else if (saldoaRetirar > this.saldo) {
            System.out.println("El saldo a retirar es mayor que el saldo actual");
        } else {
            this.saldo -= saldoaRetirar;
            System.out.println("Dinero retirado correctamente. Saldo actual: " + this.saldo);
        }
    }

}
