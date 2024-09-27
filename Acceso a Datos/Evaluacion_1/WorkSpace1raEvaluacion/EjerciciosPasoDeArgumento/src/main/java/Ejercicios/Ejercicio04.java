 package Ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Servlet implementation class Ejercicio04
 */
public class Ejercicio04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio04() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		// Obtener el mapa de todos los parámetros
		Map<String, String[]> parameterMap = request.getParameterMap();

		if (!parameterMap.isEmpty()) {
			response.getWriter().append("<!DOCTYPE html>\r\n"
					+ "<html lang=\"es\">\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
					+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "<title>EJERCICIO 04</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "<table border=2>"
					+ "<th>Parámetro</th>\r\n"
					+ "<th>Valor</th>\r\n"
					+ "</tr>\r\n");
			
			// Recorrer el mapa de parámetros y agregarlos a la tabla HTML
			for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
				String parameterName = entry.getKey(); // Nombre del parámetro
				String[] parameterValues = entry.getValue(); // Valor(es) del parámetro

				// Mostrar cada valor del parámetro
				for (String value : parameterValues) {
					response.getWriter().append("<tr>\r\n").append("<td>").append(parameterName)
							.append("</td>\r\n").append("<td>").append(value).append("</td>\r\n")
							.append("</tr>\r\n");
				}
			}

			response.getWriter().append("</table>");
			response.getWriter().append("</body>");
			response.getWriter().append("</html>");
			response.getWriter().close();

		} else {
			response.getWriter().append("No se ha recibido ningún parámetro.");
		}
	}
}
