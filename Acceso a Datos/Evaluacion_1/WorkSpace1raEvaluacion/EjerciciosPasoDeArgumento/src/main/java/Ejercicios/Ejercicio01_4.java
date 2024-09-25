package Ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio01_4
 */
public class Ejercicio01_4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio01_4() {
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
	 * El método GET recibiendo por parámetro los datos (para concatenar parámetros
	 * en la URL utiliza el carácter &
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
if(request.getParameter("mensaje")!=null || request.getParameter("firma") !=null) {
	
	
	String mensaje = request.getParameter("mensaje");
	String firma = request.getParameter("firma");

	response.getWriter().append("Mensaje: " + mensaje);
	response.getWriter().append("<br>");
	response.getWriter().append("Firma: " + firma);
	response.getWriter().close();
} else {
	response.getWriter().append("No se ha recogido ningun parametro");
}

	}

	/**
	 * Por último, crea la siguiente interfaz que le permita introducir al usuario
	 * el saludo que quiera y su firma. Utilizarás un servlet nuevo implementando el
	 * método POST recibiendo los datos de formulario
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String mensaje = request.getParameter("mensaje");
		String firma = request.getParameter("firma");

		response.getWriter().append("Mensaje: " + mensaje);
		response.getWriter().append("<br>");
		response.getWriter().append("Firma: " + firma);
		response.getWriter().close();
	}

}
