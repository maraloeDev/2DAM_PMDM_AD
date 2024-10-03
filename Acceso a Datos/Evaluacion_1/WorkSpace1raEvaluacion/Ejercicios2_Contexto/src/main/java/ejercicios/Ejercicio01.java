package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio01
 */
public class Ejercicio01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String color ="";
       
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
			super.init(config);
			
			//recojo el param name en la variable color
			color = config.getServletContext().getInitParameter("color");
	}		

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("color") != null) {
			String colorPasadoPorParametro = request.getParameter("color");
			// Modifico que el param-value, sea el colorPasadoPorParametro
			getServletContext().setAttribute("color", colorPasadoPorParametro);
			
			response.getWriter().append("<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>EJERCICIO 02</title>\r\n"
					+ "</head>\r\n"
					+ "<body style=\"background-color: "+ colorPasadoPorParametro +";\">\r\n"
					+ "    \r\n"
					+ "    <form action=\"Ejercicio01_Context\" method=\"get\">\r\n"
					+ "\r\n"
					+ "        <input type=\"submit\" value=\"Enviar\">\r\n"
					+ "    </form>\r\n"
					+ "</body>\r\n"
					+ "</html>");
		} else {
			response.getWriter().append("No se ha pasado un parametro color");
		}
	}
}
