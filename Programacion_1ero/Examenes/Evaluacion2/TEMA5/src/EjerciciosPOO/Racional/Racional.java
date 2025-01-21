package TEMA5.POO.Racional;

public class Racional {

    int numerador = 12;
    int denominador = 15;

    public Racional(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    @Override
    public String toString() {
        return "<" + numerador + ">/" + "<" + denominador + ">";
    }

    int sumar(Racional r) {

        int suma1 =(r.denominador * r.numerador);
        int suma2=(r.denominador * r.numerador);

        int sumaTotal = (suma1 + suma2) / (numerador*denominador);
        return suma1;
    }

    int restar(Racional r) {

        int resta1 =(r.denominador * r.numerador);
        int resta2 =(r.denominador * r.numerador);

        int restaTotal = (resta1 - resta2) / (numerador*denominador);
        return restaTotal;
    }

    int producto(Racional r) {

        int producto1 =(r.denominador * r.numerador);
        int producto2 =(r.denominador * r.numerador);

        int productoTotal = (producto1 * producto2);
        return productoTotal;
    }

    int dividir(Racional r) {

        int division1 =(r.denominador * r.numerador);
        int division2 =(r.denominador * r.numerador);

        int divisionTotal = (division1 / division2);
        return divisionTotal;
    }

    String toDecimal(){
        return "<" + (double)numerador + ">/" + "<" + (double)denominador + ">";
    }

    // En todos los casos el resultado es un nuevo Racional, simplificado al máximo


    public boolean equals(Racional r) {
        return super.equals(r);
    }

    int compareTo(Racional otro) {

        int comunDenominador = this.denominador * otro.denominador;

        int num1 = this.numerador * (comunDenominador / this.denominador);
        int num2 = otro.numerador * (comunDenominador / otro.denominador);


        if (num1 < num2) {
            return -1;
        } else if (num1 > num2) {
            return 1;
        } else {
            return 0;
        }
    }
}
