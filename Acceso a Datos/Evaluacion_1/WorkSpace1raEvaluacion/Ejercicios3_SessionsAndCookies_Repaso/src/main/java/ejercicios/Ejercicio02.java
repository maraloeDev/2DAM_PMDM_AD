package ejercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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
	private static ArrayList<String> listaNombres = new ArrayList<String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio02() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		if (request.getParameter("nombre") != null) {
			String nombre = request.getParameter("nombre");
			listaNombres.add(nombre);

			response.getWriter()
					.append("<html>\r\n" + "    <head>\r\n" + "        <title>Untitled-1</title>\r\n"
							+ "    </head>\r\n" + "    <body>\r\n" + "\r\n"
							+ "        <form action=\"Ejercicio02\" method=\"get\">\r\n" + "            Hola " + nombre
							+ " <br>\r\n" + "            Bienvenido a mi primera pagina web <br>\r\n"
							+ "            Contigo, me han visitado:<br>");

			for (String nombres : listaNombres) {
				response.getWriter().append("<br>" + nombres);
			}

			response.getWriter().append("        </form>\r\n" + "    </body>\r\n" + "</html>");
		}

	}
}
