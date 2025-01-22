package com.maraloedev.modelo;

public class Incidencia {

	private Integer codigo_Incidencia;
	private String tema;
	private String descripcion;
	
	public Incidencia() {
		
	}

	public Incidencia(Integer codigo_Incidencia, String tema, String descripcion) {
		this.codigo_Incidencia = codigo_Incidencia;
		this.tema = tema;
		this.descripcion = descripcion;
	}

	public Integer getCodigo_Incidencia() {
		return codigo_Incidencia;
	}

	public void setCodigo_Incidencia(Integer codigo_Incidencia) {
		this.codigo_Incidencia = codigo_Incidencia;
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
