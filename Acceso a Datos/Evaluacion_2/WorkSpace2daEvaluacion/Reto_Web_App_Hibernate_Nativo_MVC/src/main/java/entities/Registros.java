package entities;


public class Registros implements java.io.Serializable {

	private String numeroRegistro;
	private Entidades entidades;
	private String dniSolicitante;
	private String nombreSolicitante;
	private String apellidosSolicitante;
	private String tramite;

	public Registros() {
	}

	public Registros(String numeroRegistro, Entidades entidades, String dniSolicitante, String nombreSolicitante,
			String apellidosSolicitante, String tramite) {
		this.numeroRegistro = numeroRegistro;
		this.entidades = entidades;
		this.dniSolicitante = dniSolicitante;
		this.nombreSolicitante = nombreSolicitante;
		this.apellidosSolicitante = apellidosSolicitante;
		this.tramite = tramite;
	}

	public String getNumeroRegistro() {
		return this.numeroRegistro;
	}

	public void setNumeroRegistro(String numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	public Entidades getEntidades() {
		return this.entidades;
	}

	public void setEntidades(Entidades entidades) {
		this.entidades = entidades;
	}

	public String getDniSolicitante() {
		return this.dniSolicitante;
	}

	public void setDniSolicitante(String dniSolicitante) {
		this.dniSolicitante = dniSolicitante;
	}

	public String getNombreSolicitante() {
		return this.nombreSolicitante;
	}

	public void setNombreSolicitante(String nombreSolicitante) {
		this.nombreSolicitante = nombreSolicitante;
	}

	public String getApellidosSolicitante() {
		return this.apellidosSolicitante;
	}

	public void setApellidosSolicitante(String apellidosSolicitante) {
		this.apellidosSolicitante = apellidosSolicitante;
	}

	public String getTramite() {
		return this.tramite;
	}

	public void setTramite(String tramite) {
		this.tramite = tramite;
	}

}
