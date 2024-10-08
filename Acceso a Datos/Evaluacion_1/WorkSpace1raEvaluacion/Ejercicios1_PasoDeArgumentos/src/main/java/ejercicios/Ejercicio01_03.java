package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio01_3
 */
public class Ejercicio01_3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio01_3() {
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
		// TODO Auto-generated method stub
	}

	/**
	 * Ahora, crea otro servlet con un solo botón en la pantalla con el texto
	 * "Saludar". Para seleccionar el idioma se crearán cuatro radio-buttons, uno
	 * por cada idioma en el que es posible saludar: inglés (Hello World),
	 * español(Hola Mundo), italiano (Ciao a tutti) francés (Bonjour Tout).
	 * 
	 * Cuando pulsemos el botón “Saludar”, se nos mostrará el saludo en el idioma
	 * seleccionado.
	 * 
	 * El servlet deberá ser llamado por el método POST.
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		if (request.getParameter("idioma") != null) {

			String idioma = request.getParameter("idioma");
			String[] btnSaludo = new String[] { "es", "en", "it", "fr" };

			for (String idioms : btnSaludo) {
				if (idioma.equals(idioms)) {
					switch (idioms) {
					case "es":
						response.getWriter().append("Hola Mundo");
						break;
					case "en":
						response.getWriter().append("Hello World");
						break;
					case "it":
						response.getWriter().append("Ciao a tutti");
						break;
					case "fr":
						response.getWriter().append("Bonjour Tout");
						break;
					}
					return;
				}
			}
			response.getWriter().append("Idioma no contemplado");
		} else {
			response.getWriter().append("No se proporcionó ningún parámetro de idioma");
		}
		response.getWriter().close();
	}
}