package TEMA5.POO.FigurasGeometricas;

import java.text.DecimalFormat;

public class App {

    static Circulo circulo;
    static Cuadrado cuadrado;
    static Rectangulo rectangulo;
    static Triangulo triangulo;
    static DecimalFormat decimalFormat;

    public static void main(String[] args) {

        circulo = new Circulo(12, 98, 29.3);
        cuadrado = new Cuadrado(32, 76, 15);
        rectangulo = new Rectangulo(190, 455, 15, 23, 50);
        triangulo = new Triangulo(10, 43, 34, 54, 32);
        decimalFormat = new DecimalFormat("0.00");


        System.out.println("CIRCULO: " +
                "\t Area = " + decimalFormat.format(circulo.area()) +
                "\t Perimetro = " + decimalFormat.format(circulo.perimetro()));

        System.out.println("RECTANGULO: " +
                " Area = " + decimalFormat.format(rectangulo.area()) +
                "\t Perimetro = " + decimalFormat.format(rectangulo.perimetro()) +
                "\t Diagonal = " + decimalFormat.format(rectangulo.diagonal()));

        System.out.println("CUADRADO " +
                "\t Area = " + decimalFormat.format(cuadrado.area()) +
                "\t Perimetro = " + decimalFormat.format(cuadrado.perimetro()) +
                "\t Diagonal = " + decimalFormat.format(cuadrado.diagonal()));

        System.out.println("TRIANGULO " +
                "\t Area = " + decimalFormat.format(triangulo.area()) +
                "\t Perimetro = " + decimalFormat.format(triangulo.perimetro()));


    }
}
