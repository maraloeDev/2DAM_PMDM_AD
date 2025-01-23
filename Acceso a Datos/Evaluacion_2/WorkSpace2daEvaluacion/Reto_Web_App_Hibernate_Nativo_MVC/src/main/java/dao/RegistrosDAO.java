package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import entities.Entidades;
import entities.Registros;

public class RegistrosDAO {
	private DataSource dataSource;

	public Registros insertarRegistro(String numeroRegistro, String dniSolicitante, String nombreSolicitante,
			String apellidosSolicitante, String tramite, String entidad) throws Exception {

		// Si todo está correcto, se inserta el registro en la base de datos

		Connection conn = null;
		try {
			dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/miDataSource");
			conn = dataSource.getConnection();
			if (conn != null) {

				String query2 = "SELECT * FROM entidades WHERE id = ?";
				PreparedStatement stmt2 = conn.prepareStatement(query2);
				stmt2.setString(1, entidad);
				ResultSet rs = stmt2.executeQuery();
				Entidades ent = null;
				if (rs.next()) {
					ent = new Entidades();
					ent.setId(rs.getInt("id"));
					ent.setNombre(rs.getString("nombre"));
				}
				if (ent == null) {
					throw new SQLException("No se encontró la entidad con ID: " + entidad);
				}

				String query3 = "SELECT * FROM registros WHERE Numero_Registro = ?";
				PreparedStatement stmt3 = conn.prepareStatement(query3);
				stmt3.setString(1, numeroRegistro);
				ResultSet rs2 = stmt3.executeQuery();
				if (rs2.next()) {
					// Mostrar error de No se ha registrado el tramite. Error al realizar la
					// grabación y envialo a mensaje.jsp hazlo con un request.setAttribute
					// "mensajeError" y redirige a mensaje.jsp"
					throw new Exception("No se ha registrado el tramite. Error al realizar la grabación");
				}

				String query = "INSERT INTO registros (Numero_Registro, DNI_solicitante, Nombre_solicitante, apellidos_solicitante, tramite, entidad) VALUES (?, ?, ?, ?, ?, ?)";
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setString(1, numeroRegistro);
				stmt.setString(2, dniSolicitante);
				stmt.setString(3, nombreSolicitante);
				stmt.setString(4, apellidosSolicitante);
				stmt.setString(5, tramite);
				stmt.setString(6, entidad);
				stmt.executeUpdate();
				stmt.close();

				return new Registros(numeroRegistro, ent, nombreSolicitante, apellidosSolicitante, tramite,
						dniSolicitante);

			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		return null;
	}
}
