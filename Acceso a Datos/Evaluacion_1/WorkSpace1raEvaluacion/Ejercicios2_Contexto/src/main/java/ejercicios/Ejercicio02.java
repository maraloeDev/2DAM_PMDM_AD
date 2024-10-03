package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class Ejercicio02
 */
public class Ejercicio02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArrayList<Persona> agregarPersona = new ArrayList<Persona>();
	private static Persona p;
	private String listaPersonas = "";

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

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String edad = request.getParameter("edad");
		String telefono = request.getParameter("telefono");
		if (request.getParameter("nombre") != null || request.getParameter("edad") != null || request.getParameter("telefono") != null) {

			agregarPersona.add(	new Persona(nombre, Integer.parseInt(edad), telefono));

			getServletContext().setAttribute("listaPersonas", agregarPersona);
			
			response.setContentType("text/html");
			response.getWriter().append("Persona añadida correctamente a la lista");
			response.getWriter().append("<html>\r\n"
					+ "    <head>\r\n"
					+ "        <body>\r\n"
					+ "            <form action=\"Ejercicio02_Contexto\" method=\"get\">\r\n"
					+ "                <input type=\"submit\" value=\"Mostrar datos\">\r\n"
					+ "            </form>\r\n"
					+ "        </body>\r\n"
					+ "    </head>\r\n"
					+ "</html>");
			response.getWriter().close();

		} else {
			response.getWriter().append("No se han pasado por parametro, el nombre, la edad y el telefono");
		}
	}

}
