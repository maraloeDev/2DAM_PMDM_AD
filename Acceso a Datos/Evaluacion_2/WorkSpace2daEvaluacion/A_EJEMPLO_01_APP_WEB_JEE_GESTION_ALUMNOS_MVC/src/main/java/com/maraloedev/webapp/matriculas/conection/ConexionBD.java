package com.maraloedev.webapp.matriculas.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

	//Recupero la conexion a la base de datos
	public static Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/matriculas", "root", "");
	}
}
