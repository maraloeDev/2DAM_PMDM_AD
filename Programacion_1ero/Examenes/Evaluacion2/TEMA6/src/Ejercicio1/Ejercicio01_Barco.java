package Ejercicio1;

import java.time.LocalDate;

public class Ejercicio01_Barco {

    private String matricula;
    private int eslora;
    private LocalDate fechaFabricacion;

    public Ejercicio01_Barco(String matricula, int eslora, LocalDate fechaFabricacion) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.fechaFabricacion = fechaFabricacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getEslora() {
        return eslora;
    }

    public void setEslora(int eslora) {
        this.eslora = eslora;
    }

    public LocalDate getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(LocalDate fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    @Override
    public String toString() {
        return "Ejercicio01_Barco{" + "matricula=" + matricula + ", eslora=" + eslora + ", fechaFabricacion=" + fechaFabricacion + '}';
    }

    public int modulo() {
        int modulo = (10 * this.eslora) * 2;

        return modulo;
    }

}
