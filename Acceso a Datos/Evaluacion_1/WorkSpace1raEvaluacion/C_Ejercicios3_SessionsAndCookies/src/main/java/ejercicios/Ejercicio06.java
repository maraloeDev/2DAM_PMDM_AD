package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet implementation class Ejercicio06
 */
public class Ejercicio06 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio06() {
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
		menu(response, request);
	}

	/**
	 * Este metodo, recoje las Cookies del navegador cliente, y comprueba si la
	 * lista esta vacia, o la longitud es 0
	 * 
	 * si es asi Muestra un mensaje de "No hay galletas almacenadas en el navegador"
	 * Si no es asi, muestra en una tabla el nombre de la Cookie, y un boton de
	 * volver
	 */
	private static void mostrar(HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		response.setContentType("text/html");

		Cookie[] cs = request.getCookies();

		if (cs == null || cs.length == 0) {
			response.getWriter().append("No hay galletas disponibles.");
			response.getWriter().append("<a href=\"Ejercicio06\">Volver</a>");
		} else {
			for (Cookie buscarCookie : cs) {

				if (!buscarCookie.getName().contains("JSESSIONID")) {
					response.getWriter().append(" <ul>\r\n"
							+ "            <li>"+buscarCookie.getName()+"</li>\r\n"
							+ "        </ul>");
				}
			}
			response.getWriter().append("</table>" + "</body></head></html>");
			response.getWriter().append("<a href=\"Ejercicio06\"> Volver</a>");
		}
	}

	/**
	 * Este metodo, crea una cookie con los datos que ha introducido el usuario, y
	 * la añade al servidor
	 */
	private static void cocinar(HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		Cookie c = new Cookie(request.getParameter("galleta"), request.getParameter("opciones"));
		response.addCookie(c);
		response.getWriter().append("La galleta se a cocinado");
	}

	/**
	 * Este metodo, recoje todas las cookies del navegador, las recorre, y comprueba
	 * si la cookie introducida en el input, es la que hay en la lista, si es asi la
	 * eliminas, y añade la cookie eliminada
	 */
	private static void comer(HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {

		Cookie[] cd = request.getCookies();

		for (Cookie cookieEliminada : cd) {
			if (cookieEliminada.getName().contains(request.getParameter("galleta"))) {
				cookieEliminada.setMaxAge(0);
				response.addCookie(cookieEliminada);
			}
		}
		response.getWriter().append("La galleta se a comido");
	}

	private static void menu(HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter()
				.append("<html lang=\"es\">\r\n" + "<head>\r\n" + "    <meta charset=\"UTF-8\">\r\n"
						+ "    <title>ÑAM ÑAM GALLETAS</title>\r\n" + "</head>\r\n" + "<body>\r\n"
						+ "    <h1>ÑAM ÑAM GALLETAS</h1>\r\n" + "    <form action=\"Ejercicio06\" method=\"get\">\r\n"
						+ "        <fieldset>\r\n" + "            <legend>¿Qué galleta quieres?</legend>\r\n"
						+ "            <input type=\"text\" name=\"galleta\">\r\n" + "            <br><br>\r\n"
						+ "            <input type=\"radio\" id=\"mostrar\" name=\"opcion\" value=\"mostrar\">\r\n"
						+ "            <label for=\"mostrar\">Mostrar galletas</label>\r\n"
						+ "            <input type=\"radio\" id=\"cocinar\" name=\"opcion\" value=\"cocinar\">\r\n"
						+ "            <label for=\"cocinar\">Cocinar galleta</label>\r\n"
						+ "            <input type=\"radio\" id=\"comer\" name=\"opcion\" value=\"comer\">\r\n"
						+ "            <label for=\"comer\">Comer galleta</label>\r\n" + "            <br><br>\r\n"
						+ "            <input type=\"submit\" value=\"Oído Cocina\"></input>\r\n"
						+ "        </fieldset>\r\n" + "    </form>\r\n" + "</body>\r\n" + "</html>");

		if (request.getParameter("galleta") != null && request.getParameter("opcion") != null) {
			String opciones = request.getParameter("opcion");

			switch (opciones) {

			case "mostrar":
				mostrar(response, request);
				break;

			case "cocinar":
				cocinar(response, request);
				break;

			case "comer":
				comer(response, request);
				break;
			}
		} else {
			response.getWriter().append("No has elegido galleta");
		}

	}
}