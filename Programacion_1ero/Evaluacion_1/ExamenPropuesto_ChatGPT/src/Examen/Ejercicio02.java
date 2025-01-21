package Examen;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.temporal.Temporal;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio02 {

    /**
     * Escribe un programa en Java que realice las siguientes acciones:
     *
     * 1. Solicita al usuario ingresar una fecha en el formato "dd/MM/yyyy". 2.
     * Utilizando la clase `DateTimeFormatter`, convierte la fecha ingresada a
     * un objeto `LocalDate`. 3. Calcula y muestra la fecha del día siguiente.
     * 4. Luego, utiliza la clase `Random` para generar un número aleatorio
     * entre 1 y 5 (inclusive) y muestra un mensaje diferente dependiendo del
     * valor generado: - Si el número es 1, imprime "Hoy es un día excelente". -
     * Si el número es 2, imprime "Hoy es un buen día". - Si el número es 3,
     * imprime "Hoy es un día normal". - Si el número es 4, imprime "Hoy es un
     * día complicado". - Si el número es 5, imprime "Hoy es un día difícil". 5.
     * Si el usuario ingresa un formato incorrecto de fecha, muestra un mensaje
     * de error indicando que la fecha no es válida.
     */
    static Scanner scanner = new Scanner(System.in);
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static Random rndm = new Random();

    public static void main(String[] args) {

        //Solicita al usuario ingresar una fecha en el formato "dd/MM/yyyy".
        System.out.println("Introduce una fecha con el formato dia/mes/anio");
        String fecha = scanner.next();

        if (!fecha.contains("/")) {
            System.out.println("La fecha no es valida");
        } else {
            //Utilizando la clase `DateTimeFormatter`, convierte la fecha ingresada a un objeto `LocalDate`.
            LocalDate localDate = LocalDate.parse(fecha, dtf);
            System.out.println("La fecha actual es " + localDate);

            //Calcula y muestra la fecha del día siguiente.
            System.out.println("La fecha del dia siguiente es " + localDate.plusDays(1));
        }

        Random rndm = new Random();

        int aleatorio = rndm.nextInt(1, 5);

        switch (aleatorio) {
            case 1 -> System.out.println("Hoy es un día excelente");
            case 2 -> System.out.println("Hoy es un buen dia");
            case 3 -> System.out.println("Hoy es un día normal");
            case 4 -> System.out.println("Hoy es un día complicado");
            default -> System.out.println("Hoy es un día dificil");
        }
    }

}
