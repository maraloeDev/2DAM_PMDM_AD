package como.maraloedev.modelo;

public class Votacion {
	
	private String nombre;
	private int nVotos;
	
	public Votacion() {
		
	}
	
	public Votacion(String nombre, int nVotos) {
		super();
		this.nombre = nombre;
		this.nVotos = nVotos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getnVotos() {
		return nVotos;
	}

	public void setnVotos(int nVotos) {
		this.nVotos = nVotos;
	}
}
