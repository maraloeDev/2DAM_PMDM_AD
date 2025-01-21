package EjerciciosArraysObjetos;

import java.util.Arrays;
import java.util.Scanner;

public class App {

    static Contacto[] listaContactos = new Contacto[5];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        String opcion;
        do {
            System.out.println("""
                           Introduce una opcion: : 
                            1. Agregar un contacto 
                            2. Buscar contacto 
                            3. Modificar un contacto 
                            4. ELiminar un contacto 
                            5.Mostrar un listado 
                            6. Vaciar agenda
                            7. Salir""");
            opcion = scanner.next();

            switch (opcion) {
                case "1":
                    agregarContactos();
                    break;

                case "2":
                    subMenu();
                    break;

                case "3":
                    modificarContacto();
                    break;

                case "4":
                    eliminarContacto();
                    break;

                case "5":
                    mostrarListado();
                    break;

                case "6":
                    vaciarAgenda();
                    break;

                case "7":
                    System.out.println("Saliendo...");
                    System.exit(0);

                default:
                    System.out.println("Opcion no contemplada");
            }

        } while (!opcion.equals("7"));
    }

    static void subMenu() {
        String opcion;
        do {
            System.out.println("Introduce una opcion: "
                    + "1. Buscar por Nombre"
                    + "2. Buscar por Telefono"
                    + "3. Volver");
            opcion = scanner.next();
            switch (opcion) {
                case "1":
                    buscarNombre();
                    break;

                case "2":
                    buscarTelefono();
                    break;

                case "3":
                    menu();
                default:
                    System.out.println("Opcion no contemplada");
            }

        } while (!opcion.equals("3"));

    }

    static void agregarContactos() {

        System.out.print("Introduce el nombre del contacto: ");
        String nombre = scanner.next();

        System.out.println("Introduce el telefono del contacto: ");
        String telefono = scanner.next();

        for (int i = 0; i < listaContactos.length; i++) {
            listaContactos[i] = new Contacto(nombre, telefono);
            System.out.println("Contacto agregado correctamente");
            break;
        }
    }

    static void buscarNombre() {

        for (int i = 0; i < listaContactos.length; i++) {
            System.out.print("Introduce un nombre a buscar: ");
            String nombre = scanner.next();

            if (listaContactos[i].getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(Arrays.toString(listaContactos));
            }
        }
    }

    static void buscarTelefono() {

        for (int i = 0; i < listaContactos.length; i++) {
            System.out.print("Introduce un telefono a buscar: ");
            String telefono = scanner.next();

            if (listaContactos[i].getTelefono().equalsIgnoreCase(telefono)) {
                System.out.println(Arrays.toString(listaContactos));
            }
        }
    }

    static void modificarContacto() {
        System.out.print("Introduce un nombre a modificar: ");
        String nombre = scanner.next();

        System.out.print("Introduce un telefono a modificar: ");
        String telefono = scanner.next();

        for (int i = 0; i < listaContactos.length; i++) {

            if (listaContactos[i].getNombre().equalsIgnoreCase(nombre)) {

                System.out.print("Introduce el nuevo nombre: ");
                String nuevoNombre = scanner.next();
                listaContactos[i].setNombre(nuevoNombre);

                System.out.print("Introduce el nuevo telefono: ");
                String NuevoTelefono = scanner.next();
                listaContactos[i].setTelefono(NuevoTelefono);

                System.out.println("Contacto modificado correctamente");
                break;
            }

        }

    }

    static void eliminarContacto() {
        System.out.print("Introduce el nombre del contacto a eliminar: ");
        String nombreEliminar = scanner.next();

        for (int i = 0; i < listaContactos.length; i++) {
            if (listaContactos[i] != null && listaContactos[i].getNombre().equalsIgnoreCase(nombreEliminar)) {
                listaContactos[i] = null;
                System.out.println("Contacto eliminado correctamente.");
                return;
            }
        }

        System.out.println("No se encontró ningún contacto con ese nombre.");
    }

    static void mostrarListado() {
        for (Contacto contactos : listaContactos) {
            System.out.println(contactos);
        }
    }

    static void vaciarAgenda() {
        Arrays.fill(listaContactos, null);
        System.out.println("Agenda vacia");
    }
}
