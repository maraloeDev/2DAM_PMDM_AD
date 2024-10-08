package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio01_03
 */
public class Ejercicio01_03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio01_03() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		if (request.getParameter("mensaje") != null || request.getParameter("firma") != null) {
			String mensaje = request.getParameter("mensaje");
			String firma = request.getParameter("firma");

			response.getWriter().append("Mensaje: " + mensaje);
			response.getWriter().append("<br>");
			response.getWriter().append("Firma: " + firma);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		if (request.getParameter("mensaje") != null || request.getParameter("firma") != null) {
			String mensaje = request.getParameter("mensaje");
			String firma = request.getParameter("firma");

			response.getWriter().append("Mensaje: " + mensaje);
			response.getWriter().append("<br>");
			response.getWriter().append("Firma: " + firma);

		}
	}
}