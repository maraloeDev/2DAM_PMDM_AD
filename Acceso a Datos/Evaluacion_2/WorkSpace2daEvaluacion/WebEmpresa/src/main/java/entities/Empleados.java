package entities;
// Generated 11 ene 2024 10:00:48 by Hibernate Tools 5.6.15.Final

/**
 * Empleados generated by hbm2java
 */
public class Empleados implements java.io.Serializable {

	private int empNo;
	private Departamentos departamentos;
	private String nombre;
	private String apellido;
	private String oficio;
	private int salario;

	public Empleados() {
	}

	public Empleados(int empNo, Departamentos departamentos, String nombre, String apellido, String oficio,
			int salario) {
		this.empNo = empNo;
		this.departamentos = departamentos;
		this.nombre = nombre;
		this.apellido = apellido;
		this.oficio = oficio;
		this.salario = salario;
	}

	public int getEmpNo() {
		return this.empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public Departamentos getDepartamentos() {
		return this.departamentos;
	}

	public void setDepartamentos(Departamentos departamentos) {
		this.departamentos = departamentos;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getOficio() {
		return this.oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

	public int getSalario() {
		return this.salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

}