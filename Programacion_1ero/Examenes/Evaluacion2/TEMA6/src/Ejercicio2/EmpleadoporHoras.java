package Ejercicio2;

import java.util.Calendar;

public class EmpleadoporHoras extends EmpleadoFijo{
    
    private int precioHora = 8;
    private int numeroHoras;

    public EmpleadoporHoras(int numeroHoras, String dni, String nombre, String apellidos, int telefono, double sueldo, Calendar altaEmpresa) {
        super(dni, nombre, apellidos, telefono, sueldo, altaEmpresa);
        this.numeroHoras = numeroHoras;
    }



    public int getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(int precioHora) {
        this.precioHora = precioHora;
    }

    public int getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(int numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    @Override
    public String toString() {
        return "EmpleadoporHoras{" + "precioHora=" + precioHora + ", numeroHoras=" + numeroHoras + '}';
    }
    
    public void calculoSueldo(){
        int calculo = (int) (this.getSueldo() * this.numeroHoras);
    }
}
