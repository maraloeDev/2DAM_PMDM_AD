package com.maraloedev.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.maraloedev.webapp.entities.Alumno;

public class AlumnoDAO {
	
	public static int insert(Alumno a) throws SQLException {
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

	public static Alumno select(Alumno a) throws SQLException {

		String sql = "SELECT * FROM matriculas.alumnos a WHERE a.nMatricula=?";
		Alumno alumno = null;
		try (Connection conn = ConexionBD.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getIdMatricula());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				alumno = new Alumno(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}

		}
		return alumno;

	}

}
