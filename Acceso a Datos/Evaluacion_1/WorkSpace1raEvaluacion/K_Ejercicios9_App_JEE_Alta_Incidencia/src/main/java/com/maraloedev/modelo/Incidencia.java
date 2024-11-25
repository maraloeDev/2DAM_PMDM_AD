package com.maraloedev.modelo;

public class Incidencia {
	
	private String tema;
	private String descripcion;
	
	public Incidencia() {
		
	}

	public Incidencia(String tema, String descripcion) {
		super();
		this.tema = tema;
		this.descripcion = descripcion;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
