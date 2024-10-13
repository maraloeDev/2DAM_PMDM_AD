package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Ejercicio01
 */
public class Ejercicio01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio01() {
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
		response.getWriter().append("<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Ejercicio01</title>\r\n" + "</head>\r\n" + "<body>\r\n" + "\r\n"
				+ "    <h1>Tienda Letrea</h1>\r\n" + "\r\n" + "    <form action=\"Ejercicio01\" method=\"get\">\r\n"
				+ "        <input type=\"submit\" name=\"boton\" value=\"A\">\r\n"
				+ "        <input type=\"submit\" name=\"boton\" value=\"B\">\r\n"
				+ "        <input type=\"submit\" name=\"boton\" value=\"C\">\r\n"
				+ "        <input type=\"submit\" name=\"boton\" value=\"D\">\r\n" + "        <br>\r\n"
				+ "        <input type=\"submit\" name=\"boton\" value=\"Ticket\">\r\n" + "    </form>\r\n" + "    \r\n"
				+ "</body>\r\n" + "</html>");

		// Recupero la session
		HttpSession session = request.getSession(true);

		// Establezco el valor a la session
		Integer precio = (Integer) session.getAttribute("precio")!=null?(Integer) session.getAttribute("precio"):0;
		
		
			// Recojo el valor pulsado
			String botonPulsado = request.getParameter("boton");

			switch (botonPulsado) {
			case "A":
				precio += 3;
				break;

			case "B":
				precio += 4;
				break;

			case "C":
				precio += 5;
				break;

			case "D":
				precio += 1;
				break;
				
			case "Ticket" :
				response.getWriter().append("El precio de las letras introducidas son " + precio);
	}
			
			//Establezco el valor del atributo al precio
			session.setAttribute("precio", precio);
	}
}
