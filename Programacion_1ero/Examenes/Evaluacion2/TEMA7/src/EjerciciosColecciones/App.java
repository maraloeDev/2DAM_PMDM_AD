package EjerciciosColecciones;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    static ArrayList<Contacto> listaContactos = new ArrayList<>();
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

            scanner.nextLine();
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
            System.out.println("""
                               Introduce una opcion: 
                               1. Buscar por Nombre
                               2. Buscar por Telefono
                               3. Volver""");
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

        System.out.print("Introduce un nombre: ");
        String nombre = scanner.next();

        System.out.print("Introduce un telefono: ");
        String telefono = scanner.next();

        Contacto nuevoContacto = new Contacto(nombre, telefono);
        listaContactos.add(nuevoContacto);
        System.out.println("Contacto agregado correctamente");

    }

    static void buscarNombre() {

        System.out.print("Untroduce nombre a buscar: ");
        String nombreBuscar = scanner.next();

        for (Contacto c : listaContactos) {
            if (c.getNombre().equalsIgnoreCase(nombreBuscar)) {

                System.out.println("Contacto encontrado: ");
                System.out.println(c.getNombre());
                break;
            }
        }

    }

    static void buscarTelefono() {

        System.out.print("Untroduce telefono a buscar: ");
        String telefonoBuscar = scanner.next();

        for (Contacto c : listaContactos) {
            if (c.getTelefono().equalsIgnoreCase(telefonoBuscar)) {

                System.out.println("Contacto encontrado: ");
                System.out.println(c.getTelefono());
                break;
            }
        }

    }

    static void modificarContacto() {

        System.out.print("Introduce nombre a modificar: ");
        String nombre = scanner.next();

        for (Contacto c : listaContactos) {

            if (c.getNombre().equalsIgnoreCase(nombre)) {

                System.out.print("Introduce un nombre nuevo: ");
                String nuevoNombre = scanner.next();

                System.out.print("Introduce un telefono nuevo: ");
                String nuevoTelefono = scanner.next();

                c.setNombre(nuevoNombre);
                c.setTelefono(nuevoTelefono);
                System.out.println("Contacto modificado correctamente");
                break;
            }
        }
    }

    static void eliminarContacto() {
        System.out.print("Introduce un conttacto a eliminar: ");
        String nombreEliminar = scanner.next();

        for (Contacto c : listaContactos) {
            if (c.getNombre().equalsIgnoreCase(nombreEliminar)) {
                listaContactos.remove(c);
                System.out.println("Contacto eliminado correctamente");
                break;
            }
        }

    }

    static void mostrarListado() {

        for (Contacto c : listaContactos) {
            if (c != null) {
                System.out.println(c.toString());
            }
        }

    }

    static void vaciarAgenda() {

        listaContactos.clear();
        System.out.println("Agenda vacia");
    }
}
