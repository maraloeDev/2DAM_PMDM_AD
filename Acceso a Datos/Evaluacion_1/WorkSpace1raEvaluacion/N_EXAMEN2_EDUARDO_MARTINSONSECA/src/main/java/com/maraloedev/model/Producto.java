package com.maraloedev.model;

public class Producto {
	
	private String referencia;
	private String descripcion;
	private Integer precio;
	
	public Producto() {
		
	}

	public Producto(String referencia, String descripcion, Integer precio) {
		super();
		this.referencia = referencia;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
}
