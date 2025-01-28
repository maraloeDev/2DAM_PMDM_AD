package Ejercicio1;

import java.util.Calendar;

public class Ejercicio01_Alquiler {

    private String nombre;
    private String dni;
    private Calendar fechaInicial;
    private Calendar fechaFinal;
    private int posicion;
    private Ejercicio01_Barco barcoaOcupar;

    public Ejercicio01_Alquiler(String nombre, String dni, Calendar fechaInicial, Calendar fechaFinal, int posicion, Ejercicio01_Barco barcoaOcupar) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.posicion = posicion;
        this.barcoaOcupar = barcoaOcupar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Calendar getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Calendar fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Calendar getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Calendar fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public Ejercicio01_Barco getBarcoaOcupar() {
        return barcoaOcupar;
    }

    public void setBarcoaOcupar(Ejercicio01_Barco barcoaOcupar) {
        this.barcoaOcupar = barcoaOcupar;
    }

    @Override
    public String toString() {
        return "Ejercicio01_Alquiler{" + "nombre=" + nombre + ", dni=" + dni + ", fechaInicial=" + fechaInicial + ", fechaFinal=" + fechaFinal + ", posicion=" + posicion + ", barcoaOcupar=" + barcoaOcupar + '}';
    }

    public double calculoAlquiler() {
        double calculo = (fechaInicial.get(Calendar.DAY_OF_WEEK) + fechaFinal.get(Calendar.DAY_OF_WEEK) * barcoaOcupar.modulo());
        int valor = 0;

        if (barcoaOcupar instanceof Ejercicio01_Veleros) {  // pregunta de este obj es esto?
            valor = ((Ejercicio01_Veleros) barcoaOcupar).modulo();

        } else if (barcoaOcupar instanceof Ejercicio01_aMotor) {
            valor = ((Ejercicio01_aMotor) barcoaOcupar).modulo();

        } else if (barcoaOcupar instanceof Ejercicio01_Yates) {
            valor = ((Ejercicio01_Yates) barcoaOcupar).modulo();

        }

        return valor;
    }

}
