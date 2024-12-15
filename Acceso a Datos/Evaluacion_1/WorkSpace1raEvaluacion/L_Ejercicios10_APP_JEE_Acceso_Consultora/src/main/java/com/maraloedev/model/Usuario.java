package com.maraloedev.model;

public class Usuario {
	
	private String nombre;
	private String contrasena;
	private String categoria;
	
	public Usuario() {
		
	}

	public Usuario(String nombre, String contrasena, String categoria) {
		super();
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
