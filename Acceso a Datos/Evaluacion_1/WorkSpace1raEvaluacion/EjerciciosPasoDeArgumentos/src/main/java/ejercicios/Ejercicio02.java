package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class Ejercicio02
 */

public class Ejercicio02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ArrayList<String[]> datosPersonas = new ArrayList<String[]>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio02() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		datosPersonas.clear();
	}

	/**
	 * Crea la clase Persona con los atributos nombre, apellidos, edad, contacto.
	 * Construye un servlet que cree un array de personas con datos recogidos por
	 * parámetro de URL y muestre en una página web todos los datos de manera
	 * tabulada, a poder ser dentro de una tabla.
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		if ((request.getParameter("nombre") != null) || (request.getParameter("apellido") != null)
				|| (request.getParameter("edad") != null) || (request.getParameter("contacto") != null)) {

			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String edad = request.getParameter("edad");
			String contacto = request.getParameter("contacto");

			datosPersonas.add(new String[] { nombre, apellido, edad, contacto });

			response.getWriter()
					.append("<!DOCTYPE html>\r\n" + "\r\n" + " <html lang=\"es\">\r\n" + " <head>\r\n"
							+ "     <meta charset=\"UTF-8\">\r\n"
							+ "     <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
							+ "     <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
							+ "     <title>EJERCICIO 02</title>\r\n" + " </head>\r\n" + " <body>\r\n"
							+ "     <table border= 2>\r\n" + "         <tr>\r\n"
							+ "             <td><strong>Nombre</strong></td>\r\n"
							+ "             <td><strong>Apellidos</strong></td>\r\n"
							+ "             <td><strong>Edad</strong></td>\r\n"
							+ "             <td><strong>Contacto</strong></td>\r\n");

			for (String[] lasPersonas : datosPersonas) {
				response.getWriter().append("<tr>");
				response.getWriter().append("<td>" + lasPersonas[0] + "</td>");
				response.getWriter().append("<td>" + lasPersonas[1] + "</td>");
				response.getWriter().append("<td>" + lasPersonas[2] + "</td>");
				response.getWriter().append("<td>" + lasPersonas[3] + "</td>");
				response.getWriter().append("</tr>");
			}
			response.getWriter().append("</table>");
			response.getWriter().append("</body>");
			response.getWriter().append("</html>");
			response.getWriter().close();

		} else {
			response.getWriter().append("No se ha recogido ningun parametro");

		}

	}
}
