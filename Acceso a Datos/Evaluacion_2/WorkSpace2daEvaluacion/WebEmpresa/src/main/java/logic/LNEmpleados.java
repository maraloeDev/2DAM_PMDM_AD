package logic;

import java.util.List;

import dao.DAOEmpleado;
import entities.Empleados;

public class LNEmpleados {

	public static String baja(Empleados e) throws Exception {
		String mensaje = "";
		if (DAOEmpleado.select(e)!=null) {
			DAOEmpleado.delete(e);
			mensaje = "Baja empleado realizada correctamente.";
		} else {
			mensaje = "El empleado no existe";
		}
		return mensaje;
	}

	public static String actualiza(Empleados e) throws Exception {
		String mensaje = "";
		Empleados empl=DAOEmpleado.select(e);
		if (empl!=null) {
			if (e.getNombre()!=null)
				empl.setNombre(e.getNombre());
			if (e.getApellido()!=null)
			empl.setApellido(e.getApellido());
			if  (e.getOficio()!=null)
			empl.setOficio(e.getOficio());
			if (e.getSalario()!=0)
			empl.setSalario(e.getSalario());
			
			DAOEmpleado.update(empl);
			mensaje = "Actualización empleado realizada correctamente";
		} else {
			mensaje = "El empleado no existe";
		}
		return mensaje;
	}

	public static String alta(Empleados e) throws Exception {
		String mensaje = "";
		if (DAOEmpleado.select(e)==null) {
			DAOEmpleado.insert(e);
			mensaje = "Alta empleado realizada correctamente";
		} else {
			mensaje = "El empleado existe";
		}
		return mensaje;
	}
	
	public static List<Empleados> listEmpleados() throws Exception {
		List<Empleados> l=null;
			l=DAOEmpleado.getALL();
		return l;
		}

}
