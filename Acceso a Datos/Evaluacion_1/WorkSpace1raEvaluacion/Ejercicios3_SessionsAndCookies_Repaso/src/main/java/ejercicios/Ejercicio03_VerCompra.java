package ejercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio03_VerCompra
 */
public class Ejercicio03_VerCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio03_VerCompra() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();

		response.setContentType("text/html");
		response.getWriter().append("<table border=\"2\">\r\n"
				+ "    <tr>\r\n"
				+ "        <th>Titulo del libro</th>\r\n"
				+ "        <th>Unidades</th>\r\n"
				+ "        <th>Precio</th>\r\n"
				+ "    </tr>");

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				
				if(!cookie.getName().contains("JSESSIONID")) {
				try {
					int unidades = Integer.parseInt(cookie.getValue());
					int precio = unidades * 30;
					response.getWriter().append("<tr>\r\n"
							+ "    <td>" + cookie.getName() + "</td>\r\n"
							+ "    <td>" + unidades + "</td>\r\n"
							+ "    <td>" + precio + "</td>\r\n"
							+ "</tr>");
				} catch (NumberFormatException e) {
					response.getWriter().append("<tr>\r\n"
							+ "    <td>" + cookie.getName() + "</td>\r\n"
							+ "    <td colspan=\"2\">Valor no válido</td>\r\n"
							+ "</tr>");
				}
			}
			}
		} else {
			response.getWriter().append("<tr><td colspan=\"3\">No hay compras registradas</td></tr>");
		}
		
		response.getWriter().append("</table>");
	}
}

