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
	private DataSource dataSource; //Obtengo la conexión a la base de datos
	private Connection conn; //Conexión a la base de datos
	private PreparedStatement stmt; //Preparar la consulta SQL
	private ResultSet rs; //Resultado final de la consulta SQL

	/**
	 * Constructor del servlet
	 */
	public ServletRegistro() {
		super();
	}


	/**
	 * Almaceno en una variable el número de registro,
	 * si este no es nulo ni vacío, registro las credenciales del usuario
	 * compuebo si la conexión a la base de datos es correcta, si es así,
	 * hago una consulta SQL para obtener los datos del registro con el número de registro, preparo la consulta,
	 * añado el numero de registro a la consulta
	 * (debido a que lo que le pido al usuario, es el dni, nombre, apellidos, tramite y entidad
	 * Creo una variable booleana para saber si se ha encontrado el registro
	 * si es asi, paso a la siguiente fila, estableciendo un valor a cada fila de la tabla de a base de datos
	 * si no se ha encontrado el registro, muestro un mensaje de error, y lo muestro en el jsp de Mensaje
	 * y si se encuentra el numero de registro, muestro los datos del registro en el jsp de consultar
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
				} //else {
					//request.setAttribute("mensajeError", "No se pudo conectar a la base de datos");
					//request.getRequestDispatcher("/Mensaje.jsp").forward(request, response);
				//}

			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("mensajeError", "Error al buscar el registro en la base de datos");
				request.getRequestDispatcher("/Mensaje.jsp").forward(request, response);
			}
		} else {
			mostrarFormularioRegistro(request, response);
		}

	}
	
	
	/**
	 * Recoge los datos del formulario de registro, genera el número de registro
	 * Creo el codigo del registro con el nombre, apellidos y dni del usuario, 
	 * y si no se puede generar, muestro un mensaje de error,
	 *  debido a que los datos del usuario estan repetidos en la base de datos
	 *  Creo el objeto registrosLN, y si no se puede registrar, muestro un mensaje de error
	 *  Creo un mensaje para mostrar que todo se ha realizado correctamente,
	 *  guardando la fecha de registro, y el codigo de registro (Linea 132-133)
	 */
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String tramite = request.getParameter("tramite");
		String entidadSeleccionada = request.getParameter("entidad");
		String numeroRegistro = null;
		Registros resultado = null;
		
		try {
			numeroRegistro = "REG_" + nombre.substring(0, 2) + apellidos.substring(0, 2) + dni.substring(0, 1)
					+ dni.substring(8);
		} catch (StringIndexOutOfBoundsException e) {
			request.setAttribute("mensaje", "Error al generar el número de registro: datos inválidos.");
			request.getRequestDispatcher("Mensaje.jsp").forward(request, response);
			return;
		}
		
		RegistrosLN registrosLN = new RegistrosLN();
		try {
			resultado = registrosLN.insertarRegistro(numeroRegistro, dni, nombre, apellidos, tramite,
					entidadSeleccionada);
		} catch (Exception e) {
			request.setAttribute("mensajeError", "Error al realizar el registro: " + e.getMessage());
			request.getRequestDispatcher("Mensaje.jsp").forward(request, response);

		}

		String mensaje;
		if (resultado != null) {
			
			mensaje = "La grabación se ha realizado correctamente. Guarde el siguiente número de registro: "
					+ numeroRegistro + "<br>" + "Fecha de registro: " + LocalDate.now();
			request.setAttribute("mensajeError", mensaje);
			request.getRequestDispatcher("Mensaje.jsp").forward(request, response);
		}

	}

	/**
	 * Método para buscar un registro en la base de datos 
	 * Creo una consulta para que comprueba si el registro existe en la base de datos
	 * Preparo la consulta, añadiendo el numero de registro, y pasado a la siguiente fila,
	 * almacenando los datos del registro, si no se encuentra el registro, muestro un mensaje de error
	 */
	private void buscarRegistroPorNumero(HttpServletRequest request, HttpServletResponse response,
			String numeroRegistro) throws ServletException, IOException {

		try {
			
			String query = "SELECT r.DNI_solicitante, r.Nombre_solicitante, r.apellidos_solicitante, r.tramite, e.nombre AS entidad "
					+ "FROM registros r JOIN entidades e ON r.entidad = e.id WHERE r.Numero_Registro = ?";

			stmt = conn.prepareStatement(query);
			stmt.setString(1, numeroRegistro);
			rs = stmt.executeQuery();

			if (rs.next()) {
				request.setAttribute("dni", rs.getString("DNI_solicitante"));
				request.setAttribute("nombre", rs.getString("Nombre_solicitante"));
				request.setAttribute("apellidos", rs.getString("apellidos_solicitante"));
				request.setAttribute("tramite", rs.getString("tramite"));
				request.setAttribute("entidad", rs.getString("entidad"));
				
				request.getRequestDispatcher("/Consultar.jsp").forward(request, response);
			} else {
				request.setAttribute("mensajeError", "El número de registro no existe.");
				request.getRequestDispatcher("/Mensaje.jsp").forward(request, response);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			closeResources(rs, stmt, conn);
		}
	}

	/**
	 * Método para mostrar el formulario de registro con la lista de entidades del la base de datos,
	 *creo un objeto entidadesDAO, 
	 *almacenando las entidades en una lista, y pasadoselas a Registro.jsp
	 * y si no se puede obtener las entidades, muestro un mensaje de error
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
	 * Método que cierra todos los recursos de la base de datos
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
	
	/**
     * Metodo en el que ne conecto a la base de datos, y obtengo todas las entidades,
     * creo una consulta para obtener todas las entidades, preparo la consulta,
     * y mientras haya entidades, almaceno el id y el nombre de la entidad en la lista creada anteriormente
     */

	private List<String> obtenerTodasLasEntidades() throws SQLException {
		List<String> entidades = new ArrayList<>();

		try {
			dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/miDataSource");
			conn = dataSource.getConnection();

			String query = "SELECT * FROM entidades";
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String nombre = rs.getString("nombre");
				entidades.add(id + " - " + nombre);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("Error al obtener entidades: " + e.getMessage());
		} finally {
			closeResources(rs, stmt, conn);
		}

		return entidades;
	}
}
