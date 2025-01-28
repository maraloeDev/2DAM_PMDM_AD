package TEMA5.POO.Televisor;

public class Televisor {

    String nSerie;
    int tamanio;
    int nCanales;
    int canal;
    boolean onOff;
    int volumen;

    public Televisor(String nSerie, int tamanio, int nCanales, int canal, boolean onOff, int volumen) {
        this.nSerie = nSerie;
        this.tamanio = tamanio;
        this.nCanales = nCanales;
        this.canal = canal;
        this.onOff = onOff;
        this.volumen = volumen;
    }

    public String getnSerie() {
        return nSerie;
    }

    public void setnSerie(String nSerie) {
        this.nSerie = nSerie;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public int getnCanales() {
        return nCanales;
    }

    public void setnCanales(int nCanales) {
        this.nCanales = nCanales;
    }

    public int getCanal() {
        return canal;
    }

    public void setCanal(int canal) {
        this.canal = canal;
    }

    public boolean isOnOff() {
        return onOff;
    }

    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    @Override
    public String toString() {
        return
                "Numero de serie: " + nSerie + "\n" +
                        "Tamanio " + tamanio + "\n" +
                        "Numero de canales " + nCanales + "\n" +
                        "Canal " + canal + "\n" +
                        "Encendido o Apagado " + onOff + "\n" +
                        "Volumen " + volumen;
    }

    void cambiarCanal(int nCanal) {

        if (nCanal == canal) {
            System.out.println("Ya estas en el canal");

        } else if (nCanal < nCanales) {
            canal = nCanal;
            System.out.println("Canal cambiado correctamente: " + canal);

        } else {
            System.out.println("El canal no existe");
        }
    }

    void subirCanal() {

        if (canal <= nCanales) {
            canal++;
        } else {
            canal = 1;
        }
    }

    void bajarCanal() {

        if (canal >= 1) {
            canal--;
        } else {
            canal = getCanal();
        }
    }

    void subirVolumen() {
        if (volumen < 30){
            System.out.println("Volumen actual " + volumen);
            volumen++;
        } else if (volumen==30){
            System.out.println("MAX");

        } else{
            System.out.println("No se puede bajar mas... ");
        }
    }

    void bajarVolumen() {
        if (volumen < 30){
            volumen--;
        } else{
            optMute();
            System.out.println("No se puede bajar mas... ");
        }
    }

    void optMute(){
        volumen=0;
    }
}
