package entities;
// Generated 14 ene 2025, 14:02:17 by Hibernate Tools 6.5.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Titulos generated by hbm2java
 */
public class Titulos implements java.io.Serializable {

	private String codtitulo;
	private String especialidad;
	private String ciclo;
	private String descripcion;
	private Set preinscripcioneses = new HashSet(0);

	public Titulos() {
	}

	public Titulos(String codtitulo, String especialidad, String ciclo, String descripcion) {
		this.codtitulo = codtitulo;
		this.especialidad = especialidad;
		this.ciclo = ciclo;
		this.descripcion = descripcion;
	}

	public Titulos(String codtitulo, String especialidad, String ciclo, String descripcion, Set preinscripcioneses) {
		this.codtitulo = codtitulo;
		this.especialidad = especialidad;
		this.ciclo = ciclo;
		this.descripcion = descripcion;
		this.preinscripcioneses = preinscripcioneses;
	}

	public String getCodtitulo() {
		return this.codtitulo;
	}

	public void setCodtitulo(String codtitulo) {
		this.codtitulo = codtitulo;
	}

	public String getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getCiclo() {
		return this.ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set getPreinscripcioneses() {
		return this.preinscripcioneses;
	}

	public void setPreinscripcioneses(Set preinscripcioneses) {
		this.preinscripcioneses = preinscripcioneses;
	}

}
