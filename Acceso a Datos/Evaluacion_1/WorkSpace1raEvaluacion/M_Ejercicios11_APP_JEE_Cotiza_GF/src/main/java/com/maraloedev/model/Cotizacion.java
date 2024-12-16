package com.maraloedev.model;

public class Cotizacion {
	
	private String nombre;
	private String codigo_Pin;
	
	public Cotizacion() {
		
	}

	public Cotizacion(String nombre, String codigo_Pin) {
		this.nombre = nombre;
		this.codigo_Pin = codigo_Pin;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo_Pin() {
		return codigo_Pin;
	}

	public void setCodigo_Pin(String codigo_Pin) {
		this.codigo_Pin = codigo_Pin;
	}
}
