package com.maraloedev.webapp.matriculas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.maraloedev.webapp.matriculas.conection.ConexionBD;

public class AlumnoDAO {

	//En este metodo insertamos un nuevo alumno en la base de datos
	public static int insert(com.maraloedev.webapp.matriculas.models.Alumno a) throws SQLException {
		// Creo la sentencia sql
		String sql = "INSERT INTO matriculas.alumnos VALUES (?,?,?,?,?)";
		try (Connection conn = ConexionBD.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getIdMatricula());
			ps.setString(2, a.getNombre());
			ps.setString(3, a.getApellidos());
			ps.setString(4, a.getCiclo());
			ps.setString(5, a.getCurso());
			return ps.executeUpdate();
		}

	}
	
	public static com.maraloedev.webapp.matriculas.models.Alumno select(com.maraloedev.webapp.matriculas.models.Alumno a) throws SQLException {

		String sql = "SELECT * FROM matriculas.alumnos a WHERE a.nMatricula=?";
		com.maraloedev.webapp.matriculas.models.Alumno alumno = null;
		try (Connection conn = ConexionBD.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getIdMatricula());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				alumno = new com.maraloedev.webapp.matriculas.models.Alumno(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}

		}
		return alumno;
	}
}
