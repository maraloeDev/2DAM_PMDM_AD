package com.maraloedev.webapp.ln;

import java.sql.SQLException;

import com.maraloedev.webapp.dao.AlumnoDAO;
import com.maraloedev.webapp.entities.Alumno;

public class AlumnoLN {
	
	public static String alta(Alumno a) throws SQLException {

		if (AlumnoDAO.select(a) == null) {
			AlumnoDAO.insert(a);
			return "El alumno s eha guardado correctamente.";
		} else {
			return "El alumno ya existe.";
		}

	}

}
