package Ejercicio2;

import java.util.Calendar;

public class EmpleadoFijo {
    
    private String dni;
    private String nombre;
    private String apellidos;
    private int telefono;
    private double sueldo;
    private Calendar altaEmpresa;

    public EmpleadoFijo(String dni, String nombre, String apellidos, int telefono, double sueldo, Calendar altaEmpresa) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.sueldo = sueldo;
        this.altaEmpresa = altaEmpresa;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Calendar getAltaEmpresa() {
        return altaEmpresa;
    }

    public void setAltaEmpresa(Calendar altaEmpresa) {
        this.altaEmpresa = altaEmpresa;
    }

    @Override
    public String toString() {
        return "EmpleadoFijo{" + "dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", sueldo=" + sueldo + ", altaEmpresa=" + altaEmpresa + '}';
    }
    public void calculoSueldo(){
        int calculo = (int) (this.sueldo + (this.altaEmpresa.get(Calendar.DAY_OF_YEAR)));
    }
    
}
