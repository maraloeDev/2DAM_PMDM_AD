package App;

import java.time.LocalDate;

public class Cuenta_Bancaria {
    
    //Creacion de atributos para darles valor mas adelante
    private String numero_Cuenta;
    private double saldo = 0;
    private LocalDate fecha_Apertura;

    public Cuenta_Bancaria() {
    }
    
    
    
    //Creacion de un constructor que da valor a cada atributo de la clase
    public Cuenta_Bancaria(String numero_Cuenta, double saldo, LocalDate fecha_Apertura) {
        this.numero_Cuenta = numero_Cuenta;
        this.saldo = saldo;
        this.fecha_Apertura = fecha_Apertura;
    }

    //Metodos para recoger o modificar los atributos
    public String getNumero_Cuenta() {
        return numero_Cuenta;
    }

    public void setNumero_Cuenta(String numero_Cuenta) {
        this.numero_Cuenta = numero_Cuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getFecha_Apertura() {
        return fecha_Apertura;
    }

    public void setFecha_Apertura(LocalDate fecha_Apertura) {
        this.fecha_Apertura = fecha_Apertura;
    }

    //Metodo toString, que muestra los datos que se van a visualizar
    @Override
    public String toString() {
        return "Datos de la cuenta bancaria :"
                + "\nNumero de cuenta: "+ numero_Cuenta
                + "\nSaldo: " +saldo
                + "\nFecha actual: " + fecha_Apertura;
    } 
}
