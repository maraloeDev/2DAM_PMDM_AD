package clases;

public class Votacion {

	private String nombreAlumno;
	private int nVotos;
	
	public Votacion(String nombreAlumno, int nVotos) {
		super();
		this.nombreAlumno = nombreAlumno;
		this.nVotos = nVotos;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public int getnVotos() {
		return nVotos;
	}

	public void setnVotos(int nVotos) {
		this.nVotos = nVotos;
	}

	@Override
	public String toString() {
		return "Votacion [nombreAlumno=" + nombreAlumno + ", nVotos=" + nVotos + "]";
	}
	
	
	
	

}
