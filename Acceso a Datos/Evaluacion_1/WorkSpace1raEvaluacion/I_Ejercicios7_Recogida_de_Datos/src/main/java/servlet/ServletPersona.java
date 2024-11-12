package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import clases.Persona;

/**
 * Servlet implementation class ServletPersona
 */
public class ServletPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPersona() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("persona",
				new Persona(request.getParameter("dni"), request.getParameter("nombre"),
						request.getParameter("apellidos"), request.getParameter("direccion"),
						request.getParameter("telefono"), request.getParameter("correo")));

		String page = request.getParameter("Enviar") != null ? "MostrarPersona.jsp"
				: request.getParameter("Volver") != null ? "RecogidaPersona.jsp" : "";

		request.getRequestDispatcher(page).forward(request, response);
	}
}
