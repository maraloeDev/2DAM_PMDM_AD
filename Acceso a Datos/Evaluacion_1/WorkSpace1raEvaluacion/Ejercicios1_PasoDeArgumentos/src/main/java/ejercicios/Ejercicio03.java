package ejercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio03
 */
public class Ejercicio03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio03() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("nombre") != null || request.getParameter("apellidos") != null
				|| request.getParameter("direccion") != null || request.getParameter("tipo_tarjeta") != null
				|| request.getParameter("tipo_tarjeta") != null || request.getParameter("num_tarjeta") != null) {

			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellidos");
			String direccion = request.getParameter("direccion");
			String tipo_tarjeta = request.getParameter("tipo_tarjeta");
			String num_tarjeta = request.getParameter("num_tarjeta");
			
			response.getWriter()
			.append("<!DOCTYPE html>\r\n" + "<html lang=\"es\">\r\n" + "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>Tabla de Personas</title>\r\n" + "    <style>\r\n" + "        table {\r\n"
					+ "            width: 50%;\r\n" + "            border-collapse: collapse;\r\n"
					+ "            margin: 20px 0;\r\n" + "        }\r\n" + "        table, th, td {\r\n"
					+ "            border: 1px solid black;\r\n" + "        }\r\n" + "        th, td {\r\n"
					+ "            padding: 8px;\r\n" + "            text-align: left;\r\n" + "        }\r\n"
					+ "        th {\r\n" + "            background-color: #f2f2f2;\r\n" + "        }\r\n"
					+ "    </style>\r\n" + "</head>\r\n" + "<body>\r\n" + "\r\n"
					+ "    <h2>MOSTRAR DATOS</h2>\r\n" + "\r\n" + "    <table>\r\n"); 
			
			response.getWriter().append("+ \"        <tr>\\r\\n\"\r\n"
					+ "<th>Nombre</th>\\r\\n\"\r\n"
					+ "<th>Apellido</th>\\r\\n\"\r\n"
					+ "<th>Edad</th>\\r\\n\"\r\n"
					+ "<th>Contacto</th>\\r\\n\"\r\n"
					+ "</tr>\\r\\n\"\r\n"
					+ "<tr>\\r\\n\"\r\n" + "<td>"
					+ "Nombre: " +nombre+ "</td>\\r\\n\"\r\n" + "<td>"
					+ "Apellidos: " +apellidos + "</td>\\r\\n\"\r\n" + "<td>"
					+ "Direccion: " +direccion + "</td>\\r\\n\"\r\n" + "<td>"
					+ "Tipo de tarjeta"+ tipo_tarjeta + "</td>\\r\\n\"\r\n" + "</tr>\");"
			+ "Numero de tarjeta"+ num_tarjeta +"</td>\\r\\n\"\r\n" + "</tr>\");");
		}
		
		response.getWriter().append(" </table>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html>");

		}
	}