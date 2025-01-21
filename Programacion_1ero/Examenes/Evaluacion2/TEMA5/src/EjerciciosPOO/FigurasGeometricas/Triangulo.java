package TEMA5.POO.FigurasGeometricas;

import TEMA5.POO.Punto.Punto;

public class Triangulo extends Punto {

    double base;
    double altura;
    int lado;

    public Triangulo(int x, int y, double base, double altura, int lado) {
        super(x, y);
        this.base = base;
        this.altura = altura;
        this.lado = lado;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Triangulo{" +
                "base=" + base +
                ", altura=" + altura +
                "} " + super.toString();
    }

    double area() {

        double area = base * altura /2;

        return area;
    }

    double perimetro(){
        double perimetro = Math.pow(lado, 3);

        return perimetro;
    }
}
