package ln;

import dao.PreinscripcionesDAO;
import entities.*;


public class PreinscripcionesLN {

	public static String alta(Preinscripciones p) throws Exception {
		String mensaje = "";
		if(PreinscripcionesDAO.select(p) == null) {
			PreinscripcionesDAO.insert(p);
			mensaje = "La preinscripci�n se ha grabado correctamente";
		} else {
			mensaje = "La preinscripci�n ya ha sido grabada";
		}
		return mensaje;
	}
	
}
