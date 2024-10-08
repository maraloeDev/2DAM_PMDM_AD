package ejercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import clase.Persona;

/**
 * Servlet implementation class Ejercicio02
 */
public class Ejercicio02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArrayList<Persona> listaPersonas = new ArrayList<Persona>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio02() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("nombre") != null || request.getParameter("apellidos") != null
				|| request.getParameter("edad") != null || request.getParameter("contacto") != null) {

			// Recupero los datos de la persona en variables
			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellidos");
			String edad = request.getParameter("edad");
			String contacto = request.getParameter("contacto");
			
			listaPersonas.add(new Persona(nombre, apellidos, edad, contacto));

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
							+ "    <h2>Lista de Personas</h2>\r\n" + "\r\n" + "    <table>\r\n");

			for (Persona lasPersonas : listaPersonas) {

				response.getWriter().append("+ \"        <tr>\\r\\n\"\r\n"
						+ "<th>Nombre</th>\\r\\n\"\r\n"
						+ "<th>Apellido</th>\\r\\n\"\r\n"
						+ "<th>Edad</th>\\r\\n\"\r\n"
						+ "<th>Contacto</th>\\r\\n\"\r\n"
						+ "</tr>\\r\\n\"\r\n"
						+ "<tr>\\r\\n\"\r\n" + "<td>"
						+ lasPersonas.getNombre() + "</td>\\r\\n\"\r\n" + "<td>"
						+ lasPersonas.getApellidos() + "</td>\\r\\n\"\r\n" + "<td>"
						+ lasPersonas.getEdad() + "</td>\\r\\n\"\r\n" + "<td>"
						+ lasPersonas.getContacto() + "</td>\\r\\n\"\r\n" + "</tr>\");");
			}
			
			response.getWriter().append(" </table>\r\n"
					+ "\r\n"
					+ "</body>\r\n"
					+ "</html>");

		} else {
			response.getWriter().append("No se han pasado los parametros de nombre, apellidos, edad y telefono");
		}
		listaPersonas.clear();

	}

}
