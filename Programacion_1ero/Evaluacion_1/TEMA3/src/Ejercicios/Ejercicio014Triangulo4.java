package Ejercicios;


public class Ejercicio014Triangulo4 {
    
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4};
        for (int i : numeros) {
            for (int j : numeros) {
                for (int k : numeros) {
                    for (int l : numeros) {
                        System.out.println(i + " " + j + " " + k + " " + l);
                    }
                }
            }
        }
    }
    
}
