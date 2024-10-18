package Ejercicio1;

import java.time.LocalDate;

public class Ejercicio01_Veleros extends Ejercicio01_Barco {

    private int nMastiles;

    public Ejercicio01_Veleros(int nMastiles, String matricula, int eslora, LocalDate fechaFabricacion) {
        super(matricula, eslora, fechaFabricacion);
        this.nMastiles = nMastiles;
    }

    public int getnMastiles() {
        return nMastiles;
    }

    public void setnMastiles(int nMastiles) {
        this.nMastiles = nMastiles;
    }

    @Override
    public String toString() {
        return "Ejercicio01_Veleros{" + "nMastiles=" + nMastiles + '}';
    }

}
