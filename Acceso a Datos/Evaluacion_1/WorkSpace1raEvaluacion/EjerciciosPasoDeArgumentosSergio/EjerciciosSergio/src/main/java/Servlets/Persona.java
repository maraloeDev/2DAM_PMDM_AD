package Servlets;

public class Persona {
	private String nombre;
	private String apellido;
	private String edad;
	private String contacto;

    public Persona(String nombre, String apellido, String edad, String contacto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.contacto = contacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
	
	
        

}
