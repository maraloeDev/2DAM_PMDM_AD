package Ejercicios.Ejercicio4;

import javax.swing.JOptionPane;


public class Calculadora {
    
    int numero1;
    int numero2;

    public Calculadora(int numero1, int numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    Calculadora() {
        
    }

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }

    @Override
    public String toString() {
        return "Calculadora{" + "numero1=" + numero1 + ", numero2=" + numero2 + '}';
    }
    
    public int operacionSuma(){
        
        int suma = (numero1 + numero2);
        return suma;
    }
    
    public int operacionResta(){
        
        int resta = (numero1 - numero2);
        return resta;
    }
    
    public int operacionMultiplicacion(){
        
        int multiplicacion = (numero1 * numero2);
        return multiplicacion;
    } 
    
    public int operacionDivision(){
        
        int division = (numero1 / numero2);
        if (division==0){
            JOptionPane.showMessageDialog(null, "La division  da como resto 0");
        }
        return division;
    } 
    
}
