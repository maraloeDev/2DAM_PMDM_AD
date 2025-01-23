package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import javax.naming.InitialContext;

import entities.Entidades;

public class EntidadesDAO {
	private DataSource dataSource;

	public EntidadesDAO() {
		try {
			InitialContext ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/miDataSource");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Entidades> obtenerEntidades() {
		List<Entidades> entidades = new ArrayList<>();
		String query = "SELECT id, nombre FROM entidades";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Entidades entidad = new Entidades();
				entidad.setId(rs.getInt("id"));
				entidad.setNombre(rs.getString("nombre"));
				entidades.add(entidad);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entidades;
	}
}