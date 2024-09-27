package Ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio01
 */
public class Ejercicio01_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio01_1() {
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
	 * Crear una aplicación que desde URL deberá aparecer en pantalla un botón con el texto “Salúdame”
	 * . Al pulsar este botón aparecerá en pantalla el mensaje “Hola mundo”
	 * . El botón de la aplicación deberá ser un input de tipo submit de un formulario HTML. 
	 * El servlet deberá ser llamado mediante el método GET. ¿Qué ocurre?
	 * 
	 * Lo que ocurre es que una vez clicado el boton Salúdame, recibes como respuesta del server
	 * Hola mundo
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html"); // Tipo de contenido a enviar
	    response.getWriter().append("<html><body>Hola Mundo</body></html>").close();
	}

}
