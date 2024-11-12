package com.maraloedev.entities;

public class Votacion {
	
	private String alumno;
	private int nVotos;
	
	public Votacion() {
		
	}
	
	public Votacion(String alumno) {
		super();
		this.alumno = alumno;
	}

	public String getAlumno() {
		return alumno;
	}

	public void setAlumno(String alumno) {
		this.alumno = alumno;
	}

	public int getnVotos() {
		return nVotos;
	}

	public void setnVotos(int nVotos) {
		this.nVotos = nVotos;
	}
	public void setNumVotos() {
		this.nVotos++;
	}
}
