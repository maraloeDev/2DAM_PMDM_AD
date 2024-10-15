package clases;

public class Persona {
	
	 private String nombre;
	    private String apellidos;
	    private int edad;
	    private String contacto;

	    // Constructor
	    public Persona(String nombre, String apellidos, int edad, String contacto) {
	        this.nombre = nombre;
	        this.apellidos = apellidos;
	        this.edad = edad;
	        this.contacto = contacto;
	    }

	    // Métodos getter y setter para el atributo 'nombre'
	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    // Métodos getter y setter para el atributo 'apellidos'
	    public String getApellidos() {
	        return apellidos;
	    }

	    public void setApellidos(String apellidos) {
	        this.apellidos = apellidos;
	    }

	    // Métodos getter y setter para el atributo 'edad'
	    public int getEdad() {
	        return edad;
	    }

	    public void setEdad(int edad) {
	        this.edad = edad;
	    }

	    // Métodos getter y setter para el atributo 'contacto'
	    public String getContacto() {
	        return contacto;
	    }

	    public void setContacto(String contacto) {
	        this.contacto = contacto;
	    }

	    // Método para mostrar información completa de la persona
	    @Override
	    public String toString() {
	        return "Persona [Nombre: " + nombre + ", Apellidos: " + apellidos + 
	               ", Edad: " + edad + ", Contacto: " + contacto + "]";
	    }

}
