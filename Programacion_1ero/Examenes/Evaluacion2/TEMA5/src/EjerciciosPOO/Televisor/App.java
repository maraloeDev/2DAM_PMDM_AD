package TEMA5.POO.Televisor;

import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);
    static Televisor televisor;

    public static void main(String[] args) {

        televisor = new Televisor(
                "111111110",
                55,
                120,
                1,
                false,
                15);
        menu();
    }

    static void menu() {
        int opcion;

        do {
            System.out.println("Selecciona una opcion: " +
                    "\n" +
                    "1. Encender" +
                    "\n" +
                    "2. Apagado" +
                    "\n" +
                    "3. Canales" +
                    "\n" +
                    "4. Volumen" +
                    "\n" +
                    "5.Canal actual" +
                    "\n" +
                    "6.Volumen actual" +
                    "\n" +
                    "7. Mute" +
                    "\n" +
                    "8. Salir");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    televisor.setOnOff(true);
                    System.out.println("El televisor se ha encendido");
                    break;
                case 2:

                    if (!televisor.isOnOff()) {
                        System.out.println("La television tiene que estar encendida");
                    } else {
                        televisor.setOnOff(false);
                        System.out.println("El televisor se ha apagado");
                    }

                    break;
                case 3:
                    subMenu();
                    break;
                case 4:
                    subMenuVolumen();
                    break;

                case 5:
                    System.out.println("El canal actual es " + televisor.getCanal());
                    break;
                case 6:
                    System.out.println("El volumen actual es " + televisor.getVolumen());
                    break;
                case 7:
                    televisor.optMute();
                    System.out.println("Volumen = " + televisor.getVolumen());
                    break;

                case 8:
                    System.out.println("Has salido...");
                    System.exit(0);

                default:
                    System.out.println("Opcion no contemplada");

            }
        } while (opcion != 4);
    }

    static void subMenu() {
        int opcion;
        do {

            System.out.println("Selecciona una opcion: " +
                    "\n" +
                    "1. Cambiar canal" +
                    "\n" +
                    "2. Subir canal" +
                    "\n" +
                    "3. Bajar canal" +
                    "\n" +
                    "4. Volver");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:

                    if (!televisor.isOnOff()) {
                        System.out.println("El televisor tiene que estar encendido");
                    } else {
                        System.out.println("Selecciona un canal a cambiar: ");
                        int canal = scanner.nextInt();

                        televisor.cambiarCanal(canal);
                    }
                    break;
                case 2:

                    if (!televisor.isOnOff()) {
                        System.out.println("El televisor tiene que estar encendido");
                    } else {
                        televisor.subirCanal();
                    }

                    break;
                case 3:

                    if (!televisor.isOnOff()) {
                        System.out.println("El televisor tiene que estar encendido");
                    } else {

                        televisor.bajarCanal();
                    }

                    break;
                case 4:
                    menu();
                    break;

                default:
                    System.out.println("Opcion no contemplada");
            }
        } while (opcion != 4);
    }

    static void subMenuVolumen() {
        int opcion;

        do {
            System.out.println("Seleccione una opcion: " +
                    "\n" +
                    "1. Subir Volumen" +
                    "\n" +
                    "2. Bajar Volumen" +
                    "\n" +
                    "3. Volver");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:

                    if (!televisor.isOnOff()) {
                        System.out.println("El televisor tiene que estar encendido");
                    } else {

                        televisor.subirVolumen();
                    }
                    break;

                case 2:

                    if (!televisor.isOnOff()) {
                        System.out.println("El televisor tiene que estar encendido");
                    } else {

                        televisor.bajarVolumen();
                    }
                    break;
                case 3:
                    menu();
                default:
                    System.out.println("Opcion no contemplada");
            }

        } while (opcion != 3);
    }
}
