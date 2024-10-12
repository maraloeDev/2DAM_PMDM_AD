package EjerciciosSergio;



public class Ejercicio06_datosGolf{

    private int id;
    private String nombreJugador;
    private int nGolpes;
    private int nHoyos;

    public Ejercicio06_datosGolf(int id, String nombreJugador, int nGolpes, int nHoyos) {
        this.id = id;
        this.nombreJugador = nombreJugador;
        this.nGolpes = nGolpes;
        this.nHoyos = nHoyos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getnGolpes() {
        return nGolpes;
    }

    public void setnGolpes(int nGolpes) {
        this.nGolpes = nGolpes;
    }

    public int getnHoyos() {
        return nHoyos;
    }

    public void setnHoyos(int nHoyos) {
        this.nHoyos = nHoyos;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\n"
                + "Nombre = " + nombreJugador + "\n"
                + "Numero de golpes = " + nGolpes + "\n"
                + "Numero de hoyos = " + nHoyos + "\n";
    }

}
