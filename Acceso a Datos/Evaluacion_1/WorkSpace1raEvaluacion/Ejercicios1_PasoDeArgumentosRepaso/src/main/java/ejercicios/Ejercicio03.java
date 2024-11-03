package ejercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("<html>\r\n"
				+ "<head>\r\n"
				+ "    <title>Ejercicio03</title>\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<form action=\"Ejercicio03\" method=\"post\">\r\n"
				+ "    <fieldset>\r\n"
				+ "        <legend>\r\n"
				+ "            <h1>Recogida de datos</h1>\r\n"
				+ "        </legend>\r\n"
				+ "        Nombre <input type=\"text\" name=\"nombre\" required><br>\r\n"
				+ "\r\n"
				+ "        Apellidos <input type=\"text\" name=\"apellidos\" required><br>\r\n"
				+ "\r\n"
				+ "        Direccion <br><textarea name=\"direccion\" id=\"\" cols=\"40\" rows=\"5\"></textarea>\r\n"
				+ "\r\n"
				+ "        <br>\r\n"
				+ "        Tipo de tarjeta\r\n"
				+ "        <br>\r\n"
				+ "        <br>\r\n"
				+ "        <input type=\"radio\" name=\"tipoTarjeta\" id=\"\" value=\"Visa\"> Visa <br>\r\n"
				+ "        <input type=\"radio\" name=\"tipoTarjeta\" id=\"\" value=\"Master Card\"> Master Card <br>\r\n"
				+ "        <input type=\"radio\" name=\"tipoTarjeta\" id=\"\" value=\"amex\"> American Express <br>\r\n"
				+ "\r\n"
				+ "        <br>\r\n"
				+ "\r\n"
				+ "        Numero de tarjeta de credito <input type=\"text\" name=\"numeroTarjeta\" required><br>\r\n"
				+ "    </fieldset>\r\n"
				+ "\r\n"
				+ "    <input type=\"submit\" value=\"Enviar\"> <input type=\"reset\" value=\"Borrar\">\r\n"
				+ "</form>\r\n"
				+ "\r\n"
				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		if(request.getParameter("nombre") !=null ||
				request.getParameter("apellidos") !=null ||
				request.getParameter("direccion")!=null ||
				request.getParameter("tipoTarjeta")!=null ||
				request.getParameter("numeroTarjetas")!=null) {
			
			String nombre = request.getParameter("nombre");
			String apellidos= request.getParameter("apellidos");
			String direccion= request.getParameter("direccion");
			String tipoTarjeta[]= request.getParameterValues("tipoTarjeta");
			String numeroTarjeta = request.getParameter("numeroTarjeta");
			
			response.getWriter().append("<table border=\"2\">\r\n"
					+ "        <tr>\r\n"
					+ "            <td>NOMBRE</td>\r\n"
					+ "            <td>APELLIDOS</td>\r\n"
					+ "            <td>DIRECCION</td>\r\n"
					+ "            <td>TIPO DE TARJETA</td>\r\n"
					+ "            <td>NUMERO DE TARJETA</td>\r\n"
					+ "        </tr>");
			
			response.getWriter().append("<tr>\r\n"
					+ "            <td>"+nombre+"</td>\r\n"
					+ "            <td>"+apellidos+"</td>\r\n"
					+ "            <td>"+direccion+"</td>\r\n");
			
			for(String tarjetaElegida : tipoTarjeta) {
				response.getWriter().append("<td>"+tarjetaElegida+"</td>");
			}
			
			response.getWriter().append("            <td>"+numeroTarjeta+"</td>\r\n"
					+ "        </tr>\r\n"
					+ "    </table>\r\n"
					+ "</body>\r\n"
					+ "</html>");
		}
	}
}