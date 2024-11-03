package ejercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio1b
 */
public class Ejercicio01b extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio01b() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter()
				.append("<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n"
						+ "    <meta charset=\"UTF-8\">\r\n"
						+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
						+ "    <title>Saludar</title>\r\n" + "</head>\r\n" + "<body>\r\n"
						+ "    <form action=\"Ejercicio01b\" method=\"post\">\r\n"
						+ "        <h1>Seleccione un idioma para saludar:</h1>\r\n"
						+ "        <input type=\"radio\" id=\"english\" name=\"idioma\" value=\"Hello World\">\r\n"
						+ "        <label for=\"english\">Inglés</label><br>\r\n"
						+ "        <input type=\"radio\" id=\"spanish\" name=\"idioma\" value=\"Hola Mundo\">\r\n"
						+ "        <label for=\"spanish\">Espanol</label><br>\r\n"
						+ "        <input type=\"radio\" id=\"italian\" name=\"idioma\" value=\"Ciao a tutti\">\r\n"
						+ "        <label for=\"italian\">Italiano</label><br>\r\n"
						+ "        <input type=\"radio\" id=\"french\" name=\"idioma\" value=\"Bonjour Tout\">\r\n"
						+ "        <label for=\"french\">Francés</label><br><br>\r\n"
						+ "        <input type=\"submit\" value=\"Saludar\"></input>\r\n" + "    </form>\r\n"
						+ "</body>\r\n" + "</html>\r\n" + "");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain");
		if (request.getParameter("idioma") != null) {
			String lenguajeSeleccionado = request.getParameter("idioma");

			switch (lenguajeSeleccionado) {
			case "Hello World":
				response.getWriter().append("Hello World");
				break;

			case "Hola Mundo":
				response.getWriter().append("Hola Mundo");
				break;

			case "Ciao a tutti":
				response.getWriter().append("Ciao a tutti");
				break;

			case "Bonjour Tout":
				response.getWriter().append("Bonjour Tout");
				break;
			default:
				response.getWriter().append("El <b>idioma</b> no está en \r\n" + "nuestra base de datos");

			}

		} else {
			response.getWriter().append("El <b>idioma</b> no está en \r\n" + "nuestra base de datos");
		}
	}

}
