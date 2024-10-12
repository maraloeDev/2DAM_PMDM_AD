package TEMA5.POO.Persona;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Persona {

    String dni;
    String nombre;
    String apellidos;
    char sexo;
    LocalDate fechaNacimiento;
    int edad;
    double altura;
    double peso;
    boolean casado;

    public Persona(String dni, String nombre, String apellidos, char sexo, LocalDate fechaNacimiento, int edad, double altura, double peso, boolean casado) {

        if (dni.length() != 8) {
            System.out.println("DNI INCORRECTO, VUELVE A INTENTARLO");
        } else {
            this.dni = dni;
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.sexo = sexo;
            this.fechaNacimiento = fechaNacimiento;
            this.edad = edad;
            this.altura = altura;
            this.peso = peso;
            this.casado = casado;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    @Override
    public String toString() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        String fechaNacimientoFormatted = fechaNacimiento.format(formatter);

        return  "dni='" + dni + "\n" +
                " Nombre='" + nombre + '\n' +
                " Apellidos='" + apellidos + '\n' +
                " Sexo=" + sexo + '\n' +
                " Fecha de nacimiento=" + fechaNacimientoFormatted + '\n' +
                " Edad=" + edad + '\n' +
                " Altura=" + altura + '\n' +
                " Peso=" + peso + '\n' +
                " Casado=" + casado;
    }

    String calcularEdad(){

        LocalDate hoy = LocalDate.now();

        if (fechaNacimiento.equals(hoy)){
            return "Usted tiene " + fechaNacimiento + " años";
        } else{
           return"ERROR, fecha erronea";
        }

    }

    String calcularDni(){

        int dni=Integer.parseInt(this.dni);
        int modulo = dni % 23;

        char letra;

        switch (modulo){
            case 0:
                letra = 'T';
                break;
            case 1:
                letra = 'R';
                break;
            case 2:
                letra = 'W';
                break;
            case 3:
                letra = 'A';
                break;
            case 4:
                letra = 'G';
                break;
            case 5:
                letra = 'M';
                break;
            case 6:
                letra = 'Y';
                break;
            case 7:
                letra = 'F';
                break;
            case 8:
                letra = 'P';
                break;
            case 9:
                letra = 'D';
                break;
            case 10:
                letra = 'X';
                break;
            case 11:
                letra = 'B';
                break;
            case 12:
                letra = 'N';
                break;
            case 13:
                letra = 'J';
                break;
            case 14:
                letra = 'Z';
                break;
            case 15:
                letra = 'S';
                break;
            case 16:
                letra = 'Q';
                break;
            case 17:
                letra = 'V';
                break;
            case 18:
                letra = 'H';
                break;
            case 19:
                letra = 'L';
                break;
            case 20:
                letra = 'C';
                break;
            case 21:
                letra = 'K';
                break;
            case 22:
                letra = 'E';
                break;
            default:
                letra = ' ';
        }
        return "Letra: " + letra;

    }

    int calculoPeso(){

        int pesoIdeal = (int) (0.75 * (altura - 150) + 50);

        if (peso < pesoIdeal) {
            return -1;
        } else if (pesoIdeal ==peso) {
            return 0;
        } else {
            return 1;
        }
    }

    boolean mayorEdad(){

        if (edad > 18){
            return true;
        }else {
            return false;
        }
    }

    int edadPersona(){
        return this.edad;
    }
}
