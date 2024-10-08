package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio01
 */
@WebServlet("/ejercicio01")
public class Ejercicio01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String color="";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio01() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// Inicializar el servlet
		super.init(config);

		// Recupero el color de <param-name> en la variable color
		color = config.getInitParameter("color");

		// Guardar el color inicial en el contexto de la aplicación
		getServletContext().setAttribute("color", color);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Verificar si se ha enviado el parámetro "color" por la URL
		if (request.getParameter("color") != null) {
			color = request.getParameter("color");
			
			// Establezco el nuevo color a param-name
			getServletContext().setAttribute("color", color);
		}
		
		response.setContentType("text/html");
		response.getWriter()
				.append("<!DOCTYPE html>\\r\\n\" + \"<html>\\r\\n\" +\r\n"
						+ "\"\r\n"
						+ "\r\n"
						+ "<head>\\r\\n\" + \"\r\n"
						+ "    <meta charset=\\\"UTF-8\\\">\\r\\n\"\r\n"
						+ "    + \" <title>EJERCICIO 01</title>\\r\\n\" + \"\r\n"
						+ "</head>\\r\\n\"\r\n"
						+ "+ \"\r\n"
						+ "\r\n"
						+ "<body style=\\\"background-color: \" + color + \" ;\\\">\\r\\n\"\r\n"
						+ "    + \"<form action='Ejercicio01_Context' method='get'>\\r\\n\"\r\n"
						+ "        + \" <input type='submit' value='Enviar'>\\r\\n\" + \" </form>\\r\\n\"\r\n"
						+ "    + \" </body>\\r\\n\" + \"\r\n"
						+ "\r\n"
						+ "</html>");
	}
}
