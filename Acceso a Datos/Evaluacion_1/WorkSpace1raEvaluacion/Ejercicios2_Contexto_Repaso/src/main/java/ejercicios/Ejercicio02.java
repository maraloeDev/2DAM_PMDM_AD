package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import clases.Persona;

/**
 * Servlet implementation class Ejercicio02
 */
public class Ejercicio02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArrayList<Persona> agregarPersonas = new ArrayList<Persona>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio02() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		config.getServletContext().getInitParameter("listaPersonas");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (request.getParameter("nombre") != null || request.getParameter("edad") != null
				|| request.getParameter("telefono") != null) {
			
			String nombre = request.getParameter("nombre");
			String edad = request.getParameter("edad");
			String telefono = request.getParameter("telefono");
			
				
				agregarPersonas.add(new Persona(nombre, Integer.parseInt(edad), telefono));
				getServletContext().setAttribute("listaPersonas", agregarPersonas);
				response.getWriter().append("<html>\r\n"
						+ "    <head>\r\n"
						+ "        <title>Untitled-1</title>\r\n"
						+ "    </head>\r\n"
						+ "    <body>\r\n"
						+ "\r\n"
						+ "        <form action=\"Ejercicio02b\" method=\"post\">\r\n"
						+ "\r\n"
						+ "            <p>Persona agregada correctamente</p>\r\n"
						+ "            <input type=\"submit\" value=\"Enviar\">\r\n"
						+ "            \r\n"
						+ "        </form>\r\n"
						+ "        \r\n"
						+ "    </body>\r\n"
						+ "</html>");
				
		} else {
			response.getWriter().append("NO SE HAN ESTABLECIDO LOS PARAMETROS DE NOMBRE, EDAD O TELEFONO");
		}
	}
}