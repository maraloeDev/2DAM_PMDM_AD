package Ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio01_2
 */
public class Ejercicio01_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio01_2() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * Modifica el método GET para que recibiendo de la URL un parámetro llamado
	 * “idioma” muestre en pantalla el saludo en el idioma indicado por parámetro,
	 * si no está contemplado el idioma mostrará el mensaje “El idioma no está en
	 * nuestra base de datos”.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/plain");
	    
	    String idioma = request.getParameter("idioma");

	    if (idioma != null) {
	        switch (idioma) {
	            case "Hola Mundo":
	                response.getWriter().append("El idioma es Español");
	                break;
	            case "Hello World":
	                response.getWriter().append("El idioma es Ingles");
	                break;
	            case "Hallo Welt":
	                response.getWriter().append("El idioma es Aleman");
	                break;
	            default:
	                response.getWriter().append("El idioma no está en nuestra base de datos");
	                break;
	        }
	    } else {
	        response.getWriter().append("No hay param idioma");
	    }
	}

}
