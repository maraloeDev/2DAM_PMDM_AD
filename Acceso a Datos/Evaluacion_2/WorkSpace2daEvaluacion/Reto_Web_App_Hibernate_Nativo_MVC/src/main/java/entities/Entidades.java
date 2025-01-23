package entities;

import java.util.HashSet;
import java.util.Set;


public class Entidades implements java.io.Serializable {

	private Integer id;
	private String nombre;
	private Set registroses = new HashSet(0);

	public Entidades() {
	}

	public Entidades(String nombre) {
		this.nombre = nombre;
	}

	public Entidades(String nombre, Set registroses) {
		this.nombre = nombre;
		this.registroses = registroses;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set getRegistroses() {
		return this.registroses;
	}

	public void setRegistroses(Set registroses) {
		this.registroses = registroses;
	}

}
