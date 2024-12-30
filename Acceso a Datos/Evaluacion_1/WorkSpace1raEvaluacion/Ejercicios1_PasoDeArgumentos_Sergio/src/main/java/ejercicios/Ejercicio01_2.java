package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio01_2
 */
public class Ejercicio01_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio01_2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		response.getWriter().append("<html>\r\n"
				+ "    <head>\r\n"
				+ "        <title>Ejercicio01_2</title>\r\n"
				+ "    </head>\r\n"
				+ "\r\n"
				+ "    <body>\r\n"
				+ "        <form action=\"Ejercicio01_2\" method=\"post\">\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "            <input type=\"radio\" name=\"idioma\" value=\"inglés\"> inglés\r\n"
				+ "            <br>\r\n"
				+ "            <br>\r\n"
				+ "            <input type=\"radio\" name=\"idioma\" value=\"español\"> español\r\n"
				+ "            <br>\r\n"
				+ "            <br>\r\n"
				+ "            <input type=\"radio\" name=\"idioma\" value=\"italiano\"> italiano\r\n"
				+ "            <br>\r\n"
				+ "            <br>\r\n"
				+ "            <input type=\"radio\" name=\"idioma\" value=\"francés\"> francés\r\n"
				+ "            <br>\r\n"
				+ "            <br>\r\n"
				+ "\r\n"
				+ "            <input type=\"submit\" value=\"Enviar\">\r\n"
				+ "        </form>\r\n"
				+ "    </body>\r\n"
				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		if(request.getParameter("idioma") != null) {
			String idioma = request.getParameter("idioma");
			
			switch (idioma) {
			case "inglés":
				response.getWriter().append("Hello World");
				break;
				
			case "español":
				response.getWriter().append("Hola Mundo");
				break;
				
			case "italiano":
				response.getWriter().append("Ciao a tutti");
				break;
				
			case "francés":
				response.getWriter().append("Bonjour Tout");
				break;
			}
		}
	}
}
