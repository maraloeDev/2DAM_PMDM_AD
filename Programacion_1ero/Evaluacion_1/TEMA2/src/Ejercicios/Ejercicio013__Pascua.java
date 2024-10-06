package Ejercicios;
import java.util.Scanner;

public class Ejercicio013__Pascua {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce un año:");
        int n = scanner.nextInt();

        int A = n % 19;
        int B = n % 4;
        int C = n % 7;
        int D = (19 * A + 24) % 30;
        int E = (2 * B + 4 * C + 6 * D + 5) % 7;
        int N = 22 + D + E;

        String mes = (N <= 31) ? "marzo" : "abril";
        int dia = (N <= 31) ? N : (N - 31);
        
        System.out.println("El domingo de Pascua en el año " + n + " cae el " + dia + " de " + mes);
    }
}
