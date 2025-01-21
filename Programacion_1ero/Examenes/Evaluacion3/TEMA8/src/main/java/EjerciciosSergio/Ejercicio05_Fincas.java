package EjerciciosSergio;

public class Ejercicio05_Fincas {
    
    

    int numeroIdentificacion;
    String nombreFinca;
    double metrosFinca;
    int habitantes;
    boolean esEscologico;

    public Ejercicio05_Fincas(int numeroIdentificacion, String nombreFinca, double metrosFinca, int habitantes, boolean esEscologico) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombreFinca = nombreFinca;
        this.metrosFinca = metrosFinca;
        this.habitantes = habitantes;
        this.esEscologico = esEscologico;
    }

    

    public int getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(int numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombreFinca() {
        return nombreFinca;
    }

    public void setNombreFinca(String nombreFinca) {
        this.nombreFinca = nombreFinca;
    }

    public double getMetrosFinca() {
        return metrosFinca;
    }

    public void setMetrosFinca(double metrosFinca) {
        this.metrosFinca = metrosFinca;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }

    public boolean isEsEscologico() {
        return esEscologico;
    }

    public void setEsEscologico(boolean esEscologico) {
        this.esEscologico = esEscologico;
    }

    @Override
    public String toString() {
        return "Id= " + numeroIdentificacion + "\n"
                + "Nombre= " + nombreFinca + "\n"
                + "Metros= " + metrosFinca + "\n"
                + "Habitantes= " + habitantes + "\n"
                + "Escologico= " + esEscologico;
    }

}
