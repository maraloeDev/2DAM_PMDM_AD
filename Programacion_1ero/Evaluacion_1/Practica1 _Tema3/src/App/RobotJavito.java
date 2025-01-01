package App;

import java.util.Random;
import java.util.Scanner;

public class RobotJavito {

    static Scanner scanner = new Scanner(System.in);
    static Random rndm = new Random();

    public static void main(String[] args) {
        System.out.print("Hola Javito, que juguete has perdido ");
        String juguete = scanner.nextLine();

        int sumaAscii = 0;
        for (int i = 0; i < juguete.length(); i++) {
            sumaAscii += (int) juguete.charAt(i);
        }

        int nPasos = 0;
        int aciertos = 0;
        int fallos = 0;
        int numero;

        do {
            int aleatorio1 = rndm.nextInt(1, 10);
            int aleatorio2 = rndm.nextInt(1, 10);

            System.out.println("""
                    ¿Qué operación quieres hacer? 
                    1. Sumar (+)
                    2. Restar (-)
                    3. Multiplicar (*)
                    4. Módulo (%)""");

            numero = scanner.nextInt();
            int resultado = 0;
            int respuestaJavito = 0;

            switch (numero) {
                case 1 -> {
                    System.out.println("Cuanto es " + aleatorio1 + " + " + aleatorio2 + " = ?");
                    respuestaJavito = scanner.nextInt();
                    resultado = aleatorio1 + aleatorio2;
                }
                case 2 -> {
                    System.out.println("Cuanto es " + aleatorio1 + " - " + aleatorio2 + " = ?");
                    respuestaJavito = scanner.nextInt();
                    resultado = aleatorio1 - aleatorio2;
                }
                case 3 -> {
                    System.out.println("Cuanto es " + aleatorio1 + " * " + aleatorio2 + " = ?");
                    respuestaJavito = scanner.nextInt();
                    resultado = aleatorio1 * aleatorio2;
                }
                case 4 -> {
                    System.out.println("Cuanto es " + aleatorio1 + " % " + aleatorio2 + " = ?");
                    respuestaJavito = scanner.nextInt();
                    resultado = aleatorio1 % aleatorio2;
                }
                default -> {
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    continue;
                }
            }

            if (respuestaJavito == resultado) {
                System.out.println("¡Wow!!!!! MUY BIEN :)");
                nPasos += 10;
                aciertos++;
            } else {
                System.out.println("¡Wow!!!!! MUY MAL :(");
                nPasos -= 10;
                fallos++;
            }

            System.out.println("Javito ha avanzado " + nPasos + " pasos.");

        } while (nPasos < sumaAscii);

        System.out.println("¡Yuju!! Mi " + juguete + "!");
        System.out.println("Aciertos: " + aciertos + "\nFallos: " + fallos);
    }
}
