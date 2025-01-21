package TEMA5.POO.FigurasGeometricas;

import TEMA5.POO.Punto.Punto;

public class Cuadrado extends Punto {

    int lado;

    public Cuadrado(int x, int y, int lado) {
        super(x, y);
        this.lado = lado;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    @Override
    public String toString() {
        return "Cuadrado{" +
                "lado=" + lado +
                "} " + super.toString();
    }

    double area() {

        double area = Math.pow(lado,2);

        return area;
    }

    double perimetro(){
        double perimetro = Math.pow(lado,4);

        return perimetro;
    }

    double diagonal() {

        double diagonal = Math.pow(lado,2) + Math.pow(lado,2);

        return diagonal;

    }
}
