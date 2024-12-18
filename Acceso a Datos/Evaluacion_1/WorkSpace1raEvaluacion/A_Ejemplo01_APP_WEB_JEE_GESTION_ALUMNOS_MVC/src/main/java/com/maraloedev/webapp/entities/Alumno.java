package com.maraloedev.webapp.entities;

public class Alumno {
	
	private String nombre;
	private String apellidos;
	private String curso;
	private String ciclo;

	public Alumno(String nombre, String apellidos, String curso, String ciclo) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.curso = curso;
		this.ciclo = ciclo;
	}
    
    public String getIdMatricula() {
    	return nombre.substring(0,2)+apellidos.substring(0,2);
    }
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

}