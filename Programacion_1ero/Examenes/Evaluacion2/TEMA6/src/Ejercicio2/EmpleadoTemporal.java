package Ejercicio2;

import java.util.Calendar;


public class EmpleadoTemporal extends EmpleadoFijo{
    
    private Calendar fechaAlta;
    private Calendar fechaBaja;

    public EmpleadoTemporal(Calendar fechaAlta, Calendar fechaBaja, String dni, String nombre, String apellidos, int telefono, double sueldo, Calendar altaEmpresa) {
        super(dni, nombre, apellidos, telefono, sueldo, altaEmpresa);
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
    }

    public Calendar getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Calendar fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Calendar getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Calendar fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    @Override
    public String toString() {
        return "EmpleadoTemporal{" + "fechaAlta=" + fechaAlta + ", fechaBaja=" + fechaBaja + '}';
    }
    
    public void calculoSueldo(){
        this.getSueldo();
    }
}
