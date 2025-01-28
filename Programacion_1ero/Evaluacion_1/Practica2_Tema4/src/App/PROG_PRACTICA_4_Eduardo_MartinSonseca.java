package App;
import java.util.Scanner;
import java.util.Random;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PROG_PRACTICA_4_Eduardo_MartinSonseca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        LocalDate hoy = LocalDate.now();
        int totalPagar = 12;
        int diaElegido; 

        do {
            System.out.println("..................");
            System.out.println("PRUEBA TU SUERTE");
            System.out.println("..................");
            System.out.println("1-Jueves");
            System.out.println("2-Sábado");
            System.out.println("0-Salir");
            System.out.print("Elige día: ");
            diaElegido = scanner.nextInt();

            switch (diaElegido) {
                case 1:
                    // Jueves
                    LocalDate proximoJueves = hoy.with(java.time.temporal.TemporalAdjusters.next(java.time.DayOfWeek.THURSDAY));
                    System.out.println("..................");
                    System.out.println("Próxima jornada: " + proximoJueves.format(DateTimeFormatter.ofPattern("EEEE dd 'de' MMMM 'de' yyyy")));

                    
                    scanner.nextLine(); 
                    System.out.print("Elige terminación hasta 3 cifras (ENTER si te da igual): ");
                    String terminacionJueves = scanner.nextLine();
                    if (terminacionJueves.isEmpty()) {
                        terminacionJueves = String.format("%03d", random.nextInt(1000)); 
                    }
                    
                    int numeroBaseJueves = random.nextInt(90000) + 10000;
                    String numeroJueves = String.valueOf(numeroBaseJueves);
                    numeroJueves = numeroJueves.substring(0, 5 - terminacionJueves.length()) + terminacionJueves;

                    
                    String serieJueves = String.format("%03d", random.nextInt(1000));
                    String fraccionJueves = String.format("%02d", random.nextInt(100));

                    
                    System.out.println("Número con el que juegas: " + numeroJueves);
                    System.out.println("Serie: " + serieJueves + " Fracción: " + fraccionJueves);
                    System.out.println("..................");

                    totalPagar += 24; 
                    break;

                case 2:
                    // Sábado
                    LocalDate proximoSabado = hoy.with(java.time.temporal.TemporalAdjusters.next(java.time.DayOfWeek.SATURDAY));
                    System.out.println("..................");
                    System.out.println("Próxima jornada: " + proximoSabado.format(DateTimeFormatter.ofPattern("EEEE dd 'de' MMMM 'de' yyyy")));

                    // Elegir terminación
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Elige terminación hasta 3 cifras (ENTER si te da igual): ");
                    String terminacionSabado = scanner.nextLine();
                    if (terminacionSabado.isEmpty()) {
                        terminacionSabado = String.format("%03d", random.nextInt(1000)); 
                    }

                    
                    int numeroBaseSabado = random.nextInt(90000) + 10000; 
                    String numeroSabado = String.valueOf(numeroBaseSabado);
                    numeroSabado = numeroSabado.substring(0, 5 - terminacionSabado.length()) + terminacionSabado;

                    
                    String serieSabado = String.format("%03d", random.nextInt(1000));
                    String fraccionSabado = String.format("%02d", random.nextInt(100));

                    // Mostrar los resultados
                    System.out.println("Número con el que juegas: " + numeroSabado);
                    System.out.println("Serie: " + serieSabado + " Fracción: " + fraccionSabado);
                    System.out.println("..................");

                    totalPagar += 12;
                    break;

                case 0:
  
                    System.out.println("............................... ");
                    System.out.println("Total a pagar: " + totalPagar + " €");
                    System.out.println("............................... ");
                    scanner.close();
                    break;

                default:
                    System.out.println("Opción no válida, por favor elige una opción del menú.");
            }
        } while (diaElegido != 0);
    }
}
