package Clases;

public class Ejercicio02_Persona {
	

	private String nombre;
	private String apellidos;
	private String edad;
	private String contacto;
	
	public Ejercicio02_Persona(String nombre, String apellidos, String edad, String contacto) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.contacto = contacto;
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