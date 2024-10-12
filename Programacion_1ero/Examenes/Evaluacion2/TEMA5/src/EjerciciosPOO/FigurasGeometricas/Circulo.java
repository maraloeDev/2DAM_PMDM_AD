package TEMA5.POO.FigurasGeometricas;

import TEMA5.POO.Punto.Punto;

public class Circulo extends Punto {

    double radio;

    public Circulo(int x, int y, double radio) {
        super(x, y);
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public String toString() {
        return "Circulo{" +
                "radio=" + radio +
                "} " + super.toString();
    }

    double area() {

        double area = Math.pow(radio,2);

        return area;
    }

    double perimetro(){
        double perimetro = 2 * Math.PI * radio;

        return perimetro;
    }
}
