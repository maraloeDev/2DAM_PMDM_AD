package entities;
// Generated 14 ene 2025, 14:02:17 by Hibernate Tools 6.5.1.Final

/**
 * Preinscripciones generated by hbm2java
 */
public class Preinscripciones implements java.io.Serializable {

	private String dni;
	private Titulos titulos;
	private String nombre;
	private String apellidos;
	private String fecha;

	public Preinscripciones() {
	}

	public Preinscripciones(String dni, Titulos titulos, String nombre, String apellidos, String fecha) {
		this.dni = dni;
		this.titulos = titulos;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha = fecha;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Titulos getTitulos() {
		return this.titulos;
	}

	public void setTitulos(Titulos titulos) {
		this.titulos = titulos;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
