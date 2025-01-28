package Ejercicios;

import com.opencsv.bean.CsvBindByName;

public class Ejercicio07_datosEmpleados{
    
    @CsvBindByName(column = "ID")
    private int id;
    
    @CsvBindByName(column = "APELLIDOS")
    private String apellidos;
    
    @CsvBindByName(column = "NOMBRE DEPARTAMENTO")
    private String nombreDepartamento;

    public Ejercicio07_datosEmpleados() {
    }

    public Ejercicio07_datosEmpleados(int id, String apellidos, String nombreDepartamento) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombreDepartamento = nombreDepartamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    //Cabecera CSV
    public String[] toArray(){
        
        String[] datos = {"ID", "APELLIDOS", "NOMBRE DEPARTAMENTO"};
        return datos;
    }
    
    //Ordenado por ID
    @Override
    public String toString() {
        return id + "," + apellidos + "," + nombreDepartamento;
    }
    
    //Cabecera CSV
    public String[] toArrayApellidos(){
        
        String[] datos = {"APELLIDOS", "ID", "NOMBRE DEPARTAMENTO"};
        return datos;
    }
    
    //Ordenado por apellidos
    
    public String toStringApellidos() {
        return apellidos + "," + id + "," + nombreDepartamento;
    }
    
    
    //Cabecera CSV
    public String[] toArrayDepartamento(){
        
        String[] datos = {"NOMBRE DEPARTAMENTO", "APELLIDOS", "ID"};
        return datos;
    }
    
    //Ordenado por departamento
    
    public String toStringDepartamentos() {
        return nombreDepartamento + "," + apellidos + "," + id;
    }
    
    
}
