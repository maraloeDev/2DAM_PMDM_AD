package Ejercicio1;

import java.time.LocalDate;

public class Ejercicio01_aMotor extends Ejercicio01_Barco {

    private int potencia;

    public Ejercicio01_aMotor(int potencia, String matricula, int eslora, LocalDate fechaFabricacion) {
        super(matricula, eslora, fechaFabricacion);
        this.potencia = potencia;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "Ejercicio01_aMotor{" + "potencia=" + potencia + '}';
    }

}
