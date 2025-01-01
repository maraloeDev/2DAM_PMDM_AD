package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Servlet implementation class Ejercicio03
 */
public class Ejercicio03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio03() {
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
		response.getWriter().append("<!DOCTYPE html>\r\n"
				+ "<html lang=\"es\">\r\n"
				+ "\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Recogida de datos</title>\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body>\r\n"
				+ "    <h2>Recogida de datos</h2>\r\n"
				+ "\r\n"
				+ "    <form action=\"Ejercicio03\" method=\"post\">\r\n"
				+ "        <label for=\"nombre\">Nombre</label><br>\r\n"
				+ "        <input type=\"text\" id=\"nombre\" name=\"nombre\"><br><br>\r\n"
				+ "\r\n"
				+ "        <label for=\"apellidos\">Apellidos</label><br>\r\n"
				+ "        <input type=\"text\" id=\"apellidos\" name=\"apellidos\"><br><br>\r\n"
				+ "\r\n"
				+ "        <label for=\"direccion\">Dirección</label><br>\r\n"
				+ "        <textarea id=\"direccion\" name=\"direccion\" rows=\"4\" cols=\"50\"></textarea><br><br>\r\n"
				+ "\r\n"
				+ "        <label>Tipo de tarjeta:</label><br>\r\n"
				+ "        <input type=\"radio\" id=\"visa\" name=\"tarjeta\" value=\"Visa\" checked>\r\n"
				+ "        <label for=\"visa\">Visa</label><br>\r\n"
				+ "\r\n"
				+ "        <input type=\"radio\" id=\"mastercard\" name=\"tarjeta\" value=\"MasterCard\">\r\n"
				+ "        <label for=\"mastercard\">MasterCard</label><br>\r\n"
				+ "\r\n"
				+ "        <input type=\"radio\" id=\"amex\" name=\"tarjeta\" value=\"American Express\">\r\n"
				+ "        <label for=\"amex\">American Express</label><br><br>\r\n"
				+ "\r\n"
				+ "        <label for=\"numero_tarjeta\">Número de tarjeta de crédito</label><br>\r\n"
				+ "        <input type=\"text\" id=\"numero_tarjeta\" name=\"numero_tarjeta\"><br><br>\r\n"
				+ "\r\n"
				+ "        <input type=\"submit\" value=\"Enviar\">\r\n"
				+ "        <input type=\"reset\" value=\"Borrar\">\r\n"
				+ "    </form>\r\n"
				+ "</body>\r\n"
				+ "\r\n"
				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		if (request.getParameter("nombre") != null || request.getParameter("apellidos") != null
				|| request.getParameter("direccion") != null || request.getParameter("tarjeta") != null
				|| request.getParameter("numero_tarjeta") != null) {

			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellidos");
			String direccion = request.getParameter("direccion");
			String tarjeta = request.getParameter("tarjeta");
			String numero_tarjeta = request.getParameter("numero_tarjeta");
			
			response.getWriter().append("<table border=\"2\">\r\n"
					+ "    <tr>\r\n"
					+ "        <td>NOMBRE</td>\r\n"
					+ "        <td>APELLIDOS</td>\r\n"
					+ "        <td>DIRECCION</td>\r\n"
					+ "        <td>TARJETA</td>\r\n"
					+ "        <td>NUMERO TARJETA</td>\r\n"
					+ "    </tr>");
			
				response.getWriter().append("<tr>"
						+ "        <td>"+nombre+"</td>\r\n"
						+ "        <td>"+apellidos+"</td>\r\n"
						+ "        <td>"+direccion+" </td>\r\n"
						+ "        <td>"+tarjeta+"</td>\r\n"
						+ "        <td>"+numero_tarjeta+"</td>\r\n"
						+ "    </tr>");
			
			response.getWriter().append("</table></body></html>").close();
		}
	}

}
