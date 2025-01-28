package TEMA5.POO.Persona;


import java.time.LocalDate;

public class App {

    static Persona persona;

    public static void main(String[] args) {

        persona = new Persona(
                "47583974",
                "Eduardo",
                "Lopez",
                'M',
                LocalDate.of(1999, 12, 4),
                15,
                1.86,
                55,
                false);

        System.out.println("DATOS PERSONA " + persona.toString());
        System.out.println("------------------");

        System.out.println("CALCULAR EDAD " + persona.calcularEdad());
        System.out.println("--------------------------");

        System.out.println("CALCULAR DNI " + persona.calcularDni());
        System.out.println("--------------------------");

        System.out.println("PESO IDEAL " + persona.calculoPeso());
        System.out.println("---------------------");

        System.out.println("MAYOR DE EDAD " + persona.mayorEdad());
        System.out.println("---------------");

        System.out.println("EDAD PERSONA " + persona.edadPersona());

    }
}
