package TEMA5.POO.Racional;

public class App {

    static Racional racional;

    public static void main(String[] args) {

        racional = new Racional(12,32);

        System.out.println("DATOS RELACIONAL " + racional.toString());
        System.out.println("---------------------------");

        System.out.println("SUMA RACIONAL " + racional.sumar(new Racional(12,14)));
        System.out.println("----------------------------");

        System.out.println("RESTA RACIONAL " + racional.restar(new Racional(11,25)));
        System.out.println("-----------------------------");

        System.out.println("PRODUCTO RACIONAL " + racional.producto(new Racional(35,15)));
        System.out.println("-----------------------------");

        System.out.println("DIVISION RACIONAL " + racional.dividir(new Racional(23,43)));
        System.out.println("-----------------------------");


        System.out.println("REPRESENTACION DECIMAL RACIONAL " + racional.toDecimal());

        // Implementa el/los método/s necesario/s para permitir la ordenación de figuras por área
        //ascendentemente.

    }
}
