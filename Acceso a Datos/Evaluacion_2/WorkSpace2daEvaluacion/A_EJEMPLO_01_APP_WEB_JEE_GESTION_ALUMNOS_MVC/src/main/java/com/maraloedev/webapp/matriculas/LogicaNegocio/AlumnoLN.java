package com.maraloedev.webapp.matriculas.LogicaNegocio;

import java.sql.SQLException;


public class AlumnoLN {

	public static String alta(com.maraloedev.webapp.matriculas.models.Alumno a) throws SQLException {

		if (com.maraloedev.webapp.matriculas.dao.AlumnoDAO.select(a) == null) {
			com.maraloedev.webapp.matriculas.dao.AlumnoDAO.insert(a);
			return "El alumno s eha guardado correctamente.";
		} else {
			return "El alumno ya existe.";
		}

	}

}
