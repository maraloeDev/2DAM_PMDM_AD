package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio01_02
 */
public class Ejercicio01_02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio01_02() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("idioma") != null) {
			
			response.setContentType("text/html");
			String idioma = request.getParameter("idioma");
			
			switch(idioma) {
			case "es" :
				response.getWriter().append("Hola Mundo!");
				break;
			case "en" :
				response.getWriter().append("Hello World!");
				break;
			case "it" :
				response.getWriter().append("Ciao a tutti!");
				break;
			case "fr" :
				response.getWriter().append("Bonjour Tout!");
				break;
				default :
					response.getWriter().append("El idioma no está en nuestra base de datos");
				
			}

		} else {
			response.getWriter().append("No se ha establecido un parametro idioma");
		}
	}
}
