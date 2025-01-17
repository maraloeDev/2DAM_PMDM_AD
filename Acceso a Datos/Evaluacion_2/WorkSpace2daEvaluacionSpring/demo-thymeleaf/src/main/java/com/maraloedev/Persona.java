package com.maraloedev;

public class Persona {
	
	private String nombre;
	private String apellidos;
	private int edad;
	
	public Persona(String nombre, String apellidos, int edad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String setNombre(String nombre) {
		return this.nombre = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public String setApellidos(String apellidos) {
		return this.apellidos = apellidos;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public int setEdad(int edad) {
        return this.edad = edad;
            }
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + "]";
	}
}
