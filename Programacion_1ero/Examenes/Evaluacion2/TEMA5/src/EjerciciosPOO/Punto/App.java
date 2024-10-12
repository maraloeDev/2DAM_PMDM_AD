package TEMA5.POO.Punto;

public class App {

    static Punto punto1;
    public static void main(String[] args) {

        punto1 = new Punto(21,23);

        System.out.println("LOS PUNTOS INICIALES " + punto1.toString());
        punto1.setX(99);
        punto1.setY(80);

        System.out.println("PUNTO MODIFICADO " + punto1.toString());

        punto1.desplazarPunto(4,4);
        System.out.println("DESPLAZAR PUNTO " + punto1.toString());

        punto1.moverPunto(30,198);
        System.out.println("PUNTO MOVIDO A " + punto1.toString());

        punto1.distanciaPunto(20,99);
        System.out.println("PUNTO DISTANCIA " + punto1.toString());

        punto1.centroPunto(12,999);
        System.out.println("CENTRO DEL PUNTO " + punto1.toString());


    }
}
