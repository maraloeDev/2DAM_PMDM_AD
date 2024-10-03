package ejercicios;

public class Persona {
	
	private static String nombre;
	private static int edad;
	private static String telefono;
	
	
	
	public Persona(String nombre, int edad, String telefono) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.telefono = telefono;
	}
	public static String getNombre() {
		return nombre;
	}
	public static void setNombre(String nombre) {
		Persona.nombre = nombre;
	}
	public static int getEdad() {
		return edad;
	}
	public static void setEdad(int edad) {
		Persona.edad = edad;
	}
	public static String getTelefono() {
		return telefono;
	}
	public static void setTelefono(String telefono) {
		Persona.telefono = telefono;
	}
	@Override
	public String toString() {
		return "Persona [toString()=" + super.toString() + "]";
	}
}
