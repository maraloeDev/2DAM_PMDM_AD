package TEMA5.POO.FigurasGeometricas;

import TEMA5.POO.Punto.Punto;

public class Rectangulo extends Punto {

    double ancho;
    double alto;
    int lado;

    public Rectangulo(int x, int y, double ancho, double alto, int lado) {
        super(x, y);
        this.ancho = ancho;
        this.alto = alto;
        this.lado = lado;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    @Override
    public String toString() {
        return "Rectangulo{" +
                "ancho=" + ancho +
                ", alto=" + alto +
                ", lado=" + lado +
                "} " + super.toString();
    }

    double area() {

        double area = alto * ancho;

        return area;
    }

    double perimetro() {
        double perimetro = Math.pow(lado, 4);

        return perimetro;
    }

    double diagonal() {
        double diagonal = Math.sqrt(Math.pow(alto, 2) + Math.pow(ancho, 2));

        return diagonal;
    }
}