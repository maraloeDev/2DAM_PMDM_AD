package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ln.RegistrosLN;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import dao.EntidadesDAO;
import entities.Entidades;
import entities.Registros;

/**
 * Servlet implementation class ServletRegistro
 */
@WebServlet("/ServletRegistro")
public class ServletRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource dataSource;
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	/**
	 * Constructor del servlet
	 */
	public ServletRegistro() {
		super();
	}

	/**
	 * Método GET para manejar solicitudes de consulta de registros o para mostrar
	 * el formulario de registro.
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String numeroRegistro = request.getParameter("numeroRegistro");
		if (numeroRegistro != null && !numeroRegistro.isEmpty()) {

			try {
				dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/miDataSource");
				conn = dataSource.getConnection();
				if (conn != null) {

					String query = "SELECT r.DNI_solicitante, r.Nombre_solicitante, r.apellidos_solicitante, r.tramite, e.nombre AS entidad "
							+ "FROM registros r JOIN entidades e ON r.entidad = e.id WHERE r.Numero_Registro = ?";
					PreparedStatement stmt = conn.prepareStatement(query);
					stmt.setString(1, request.getParameter("numeroRegistro"));
					ResultSet rs = stmt.executeQuery();
					
					boolean encontrado = false;
					if (rs.next()) {
						// Pasar los datos del registro al JSP
						encontrado = true;
						request.setAttribute("dni", rs.getString("DNI_solicitante"));
						request.setAttribute("nombre", rs.getString("Nombre_solicitante"));
						request.setAttribute("apellidos", rs.getString("apellidos_solicitante"));
						request.setAttribute("tramite", rs.getString("tramite"));
						request.setAttribute("entidad", rs.getString("entidad"));
						request.setAttribute("numeroRegistro", numeroRegistro);
						request.getRequestDispatcher("/Consultar.jsp").forward(request, response);

					} else if(!encontrado) {
						
						request.setAttribute("mensajeError", "El número de registro no existe.");
						request.getRequestDispatcher("/Mensaje.jsp").forward(request, response);
					}
				} else {
					request.setAttribute("mensajeError", "No se pudo conectar a la base de datos");
					request.getRequestDispatcher("/Mensaje.jsp").forward(request, response);
				}

			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("mensajeError", "Error al buscar el registro en la base de datos");
				request.getRequestDispatcher("/Mensaje.jsp").forward(request, response);
			}
		} else {
			// Si no hay número de registro, mostrar las entidades para el formulario de
			// registro
			mostrarFormularioRegistro(request, response);
		}

	}

	/**
	 * Método para buscar un registro en la base de datos por su número de registro.
	 */
	private void buscarRegistroPorNumero(HttpServletRequest request, HttpServletResponse response,
			String numeroRegistro) throws ServletException, IOException {

		try {

			// Consulta SQL para obtener el registro con el numeroRegistro proporcionado
			String query = "SELECT r.DNI_solicitante, r.Nombre_solicitante, r.apellidos_solicitante, r.tramite, e.nombre AS entidad "
					+ "FROM registros r JOIN entidades e ON r.entidad = e.id WHERE r.Numero_Registro = ?";

			stmt = conn.prepareStatement(query);
			stmt.setString(1, numeroRegistro);
			rs = stmt.executeQuery();

			// Si el registro es encontrado
			if (rs.next()) {
				// Pasar los datos del registro al JSP
				request.setAttribute("dni", rs.getString("DNI_solicitante"));
				request.setAttribute("nombre", rs.getString("Nombre_solicitante"));
				request.setAttribute("apellidos", rs.getString("apellidos_solicitante"));
				request.setAttribute("tramite", rs.getString("tramite"));
				request.setAttribute("entidad", rs.getString("entidad"));

				// Redirigir a la página de consulta (consultar.jsp)
				request.getRequestDispatcher("/Consultar.jsp").forward(request, response);
			} else {
				// Si no se encuentra el registro, mostrar mensaje de error
				request.setAttribute("mensajeError", "El número de registro no existe.");
				request.getRequestDispatcher("/Mensaje.jsp").forward(request, response);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			// Cerrar los recursos
			closeResources(rs, stmt, conn);
		}
	}

	/**
	 * Método para mostrar el formulario de registro con la lista de entidades
	 * disponibles.
	 */
	private void mostrarFormularioRegistro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			EntidadesDAO entidadesDAO = new EntidadesDAO();
			List<Entidades> entidades = entidadesDAO.obtenerEntidades();
			request.setAttribute("entidades", entidades);

			request.getRequestDispatcher("/Registro.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error al obtener las entidades.");
			request.getRequestDispatcher("/Registro.jsp").forward(request, response);
		}
	}

	/**
	 * Método POST para manejar la creación de un nuevo registro.
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recoger los datos del formulario
		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String tramite = request.getParameter("tramite");
		String entidadSeleccionada = request.getParameter("entidad");
		String numeroRegistro = null;
		Registros resultado = null;
		
		try {
			// Generar el número de registro
			numeroRegistro = "REG_" + nombre.substring(0, 2) + apellidos.substring(0, 2) + dni.substring(0, 1)
					+ dni.substring(8);
		} catch (StringIndexOutOfBoundsException e) {
			request.setAttribute("mensaje", "Error al generar el número de registro: datos inválidos.");
			request.getRequestDispatcher("Mensaje.jsp").forward(request, response);
			return;
		}

		// Realizar el registro a través de la lógica de negocios (RegistrosLN)
		RegistrosLN registrosLN = new RegistrosLN();
		try {
			resultado = registrosLN.insertarRegistro(numeroRegistro, dni, nombre, apellidos, tramite,
					entidadSeleccionada);
		} catch (Exception e) {
			request.setAttribute("mensajeError", "Error al realizar el registro: " + e.getMessage());
			request.getRequestDispatcher("Mensaje.jsp").forward(request, response);

		}

		// Redirigir dependiendo del resultado
		String mensaje;
		if (resultado != null) {
			// Generar el número de registro
			mensaje = "La grabación se ha realizado correctamente. Guarde el siguiente número de registro: "
					+ numeroRegistro + "<br>" + "Fecha de registro: " + LocalDate.now();
			request.setAttribute("mensajeError", mensaje);
			request.getRequestDispatcher("Mensaje.jsp").forward(request, response);
		}

	}

	/**
	 * Método para cerrar los recursos de la base de datos
	 */
	private void closeResources(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private List<String> obtenerTodasLasEntidades() throws SQLException {
		List<String> entidades = new ArrayList<>();

		try {
			// Obtener conexión del DataSource
			dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/miDataSource");
			conn = dataSource.getConnection();

			// Consulta SQL para recuperar todas las entidades
			String query = "SELECT id, nombre FROM entidades";
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();

			// Recorrer los resultados y añadirlos a la lista
			while (rs.next()) {
				String id = rs.getString("id");
				String nombre = rs.getString("nombre");
				entidades.add(id + " - " + nombre); // Puedes cambiar el formato si usas objetos
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("Error al obtener entidades: " + e.getMessage());
		} finally {
			// Cerrar los recursos
			closeResources(rs, stmt, conn);
		}

		return entidades;
	}
}
