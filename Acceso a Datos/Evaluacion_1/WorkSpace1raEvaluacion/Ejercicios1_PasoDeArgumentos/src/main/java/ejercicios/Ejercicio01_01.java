package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.catalina.connector.Response;

/**
 * Servlet implementation class Ejercicio01_01
 */
public class Ejercicio01_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio01_01() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html"); // Recojo el tipo de contenido que se va a mostrar

		if (request.getParameter("idioma") != null) {
			String idioma = request.getParameter("idioma"); // Recojo un parametro llamado "idioma" en la variable
															// idioma
			switch (idioma) {

			case "Espanol", "espanol":
				response.getWriter().append("Hola Mundo!");
				break;
			case "Ingles", "ingles":
				response.getWriter().append("Hello World!");
				break;
			case "Aleman", "aleman":
				response.getWriter().append("Hallo Welt!");
				break;
			default:
				response.getWriter().append("El idioma no está en nuestra base de datos");
			}

		} else {
			response.getWriter().append("No se ha establecido un parametro 'idioma'");
		}
	}
}
