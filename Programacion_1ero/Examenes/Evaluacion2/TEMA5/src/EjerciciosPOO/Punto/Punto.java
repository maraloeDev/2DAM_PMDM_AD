package TEMA5.POO.Punto;

import java.awt.*;

public class Punto {

    int x;
    int y;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return x + ", " + y;
    }

    void desplazarPunto(int desplazaY, int desplazaX){

        x += desplazaX;
        y += desplazaY;

    }

    void moverPunto(int moverY, int moverX){

        x = moverX;
        y = moverY;
    }

    void distanciaPunto(int distanciaY, int distanciaX){

        double formula = Math.sqrt((Math.pow(distanciaX - x,2)) + Math.pow(distanciaY - y, 2));

    }

    void centroPunto(int otroX, int otroY) {
        double centroX = (this.x + otroX) / 2.0;
        double centroY = (this.y + otroY) / 2.0;

        System.out.println("El centro del punto es: (" + centroX + ", " + centroY + ")");
    }
}
