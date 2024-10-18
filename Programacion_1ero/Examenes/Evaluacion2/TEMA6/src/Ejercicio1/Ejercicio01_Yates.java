package Ejercicio1;

import java.time.LocalDate;

public class Ejercicio01_Yates extends Ejercicio01_Barco {

    private int potencia;
    private int nCamarotes;

    public Ejercicio01_Yates(int potencia, int nCamarotes, String matricula, int eslora, LocalDate fechaFabricacion) {
        super(matricula, eslora, fechaFabricacion);
        this.potencia = potencia;
        this.nCamarotes = nCamarotes;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getnCamarotes() {
        return nCamarotes;
    }

    public void setnCamarotes(int nCamarotes) {
        this.nCamarotes = nCamarotes;
    }

    @Override
    public String toString() {
        return "Ejercicio01_Yates{" + "potencia=" + potencia + ", nCamarotes=" + nCamarotes + '}';
    }

}
