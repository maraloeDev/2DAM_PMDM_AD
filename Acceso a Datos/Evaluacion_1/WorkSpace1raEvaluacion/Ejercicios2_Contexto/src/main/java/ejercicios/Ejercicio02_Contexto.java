package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class Ejercicio02_Contexto
 */
public class Ejercicio02_Contexto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArrayList<Persona> mostrarPersonas = new ArrayList<Persona>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio02_Contexto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		mostrarPersonas = (ArrayList<Persona>) getServletContext().getAttribute("listaPersonas");

		response.setContentType("text/html");

		response.getWriter().append("<!DOCTYPE html>\r\n" + "\r\n" + " <html lang=\"es\">\r\n" + " <head>\r\n"
				+ "     <meta charset=\"UTF-8\">\r\n"
				+ "     <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "     <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "     <title>EJERCICIO 02</title>\r\n" + " </head>\r\n" + " <body>\r\n" + "     <table border= 2>\r\n"
				+ "         <tr>\r\n" + "             <td><strong>Nombre</strong></td>\r\n"
				+ "             <td><strong>Edad</strong></td>\r\n"
				+ "             <td><strong>Telefono</strong></td>\r\n");

		for (Persona lasPersonas : mostrarPersonas) {
			response.getWriter().append("<tr>");
			response.getWriter().append("<td>" + Persona.getNombre() + "</td>");
			response.getWriter().append("<td>" + Persona.getEdad() + "</td>");
			response.getWriter().append("<td>" + Persona.getTelefono() + "</td>");
			response.getWriter().append("</tr>");
		}
		response.getWriter().append("</table>");
		response.getWriter().append("</body>");
		response.getWriter().append("</html>");
		response.getWriter().close();
	}

}
