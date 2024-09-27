package Ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import Clases.Ejercicio02_Persona;

/**
 * Servlet implementation class Ejercicio02
 */

public class Ejercicio02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ArrayList<Ejercicio02_Persona> datosPersonas =new ArrayList<Ejercicio02_Persona>();

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

			datosPersonas.add(new Ejercicio02_Persona (nombre, apellido, edad, contacto));

			response.getWriter()
					.append("<!DOCTYPE html>\r\n" + "\r\n" + " <html lang=\"es\">\r\n" + " <head>\r\n"
							+ "     <met"
							+ "a charset=\"UTF-8\">\r\n"
							+ "     <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
							+ "     <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
							+ "     <title>EJERCICIO 02</title>\r\n" + " </head>\r\n" + " <body>\r\n"
							+ "     <table border= 2>\r\n" + "         <tr>\r\n"
							+ "             <td><strong>Nombre</strong></td>\r\n"
							+ "             <td><strong>Apellidos</strong></td>\r\n"
							+ "             <td><strong>Edad</strong></td>\r\n"
							+ "             <td><strong>Contacto</strong></td>\r\n");

			for (Ejercicio02_Persona lasPersonas : datosPersonas) {
				response.getWriter().append("<tr>");
				response.getWriter().append("<td>" + lasPersonas.getNombre() + "</td>");
				response.getWriter().append("<td>" + lasPersonas.getApellidos() + "</td>");
				response.getWriter().append("<td>" + lasPersonas.getEdad() + "</td>");
				response.getWriter().append("<td>" + lasPersonas.getContacto() + "</td>");
				response.getWriter().append("</tr>");
			}
			response.getWriter().append("</table>");
			response.getWriter().append("</body>");
			response.getWriter().append("</html>");
			response.getWriter().close();
			
			datosPersonas.clear();

		} else {
			response.getWriter().append("No se ha recogido ningun parametro");

		}

	}
}
