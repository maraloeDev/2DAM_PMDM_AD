package com.maraloedev.modelo;

public class Incidencia {
	
	private Integer incidencia;
	private String tema;
	private String descripcion;

	public Incidencia() {

	}

	public Incidencia(Integer incidencia, String tema, String descripcion) {
		this.incidencia = incidencia;
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

	public Integer getIncidencia() {
		return incidencia;
	}

	public void setIncidencia(Integer incidencia) {
		this.incidencia = incidencia;
	}
}
