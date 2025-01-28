package Problema3;

import java.time.LocalDateTime;


public class Problema3 {
    
    public static void main(String[] args) {
        
        LocalDateTime now = LocalDateTime.now();
        
        int operando1 = now.getDayOfMonth() + now.getMonthValue() + now.getYear();
        int operando2 = now.getHour() + now.getMinute();
        

        int producto = calcularProducto(operando1, operando2);
        

        System.out.println("El producto de " + operando1 + " y " + operando2 + " es: " + producto);
    }
    
    public static int calcularProducto(int operando1, int operando2) {
        int producto = 0;
        for (int i = 0; i < operando2; i++) {
            producto += operando1;
        }
        return producto;
    }
    
}
