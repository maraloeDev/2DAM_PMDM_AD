package entities;
// Generated 11 ene 2024 10:00:48 by Hibernate Tools 5.6.15.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Departamentos generated by hbm2java
 */
public class Departamentos implements java.io.Serializable {

	private int depNo;
	private String dnombre;
	private String dloc;
	private Set empleadoses = new HashSet(0);

	public Departamentos() {
	}

	public Departamentos(int depNo, String dnombre, String dloc) {
		this.depNo = depNo;
		this.dnombre = dnombre;
		this.dloc = dloc;
	}

	public Departamentos(int depNo, String dnombre, String dloc, Set empleadoses) {
		this.depNo = depNo;
		this.dnombre = dnombre;
		this.dloc = dloc;
		this.empleadoses = empleadoses;
	}

	public int getDepNo() {
		return this.depNo;
	}

	public void setDepNo(int depNo) {
		this.depNo = depNo;
	}

	public String getDnombre() {
		return this.dnombre;
	}

	public void setDnombre(String dnombre) {
		this.dnombre = dnombre;
	}

	public String getDloc() {
		return this.dloc;
	}

	public void setDloc(String dloc) {
		this.dloc = dloc;
	}

	public Set getEmpleadoses() {
		return this.empleadoses;
	}

	public void setEmpleadoses(Set empleadoses) {
		this.empleadoses = empleadoses;
	}

}
