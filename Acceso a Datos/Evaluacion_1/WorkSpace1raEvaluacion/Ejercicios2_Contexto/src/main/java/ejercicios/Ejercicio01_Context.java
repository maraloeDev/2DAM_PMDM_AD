package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio01_Context
 */
public class Ejercicio01_Context extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio01_Context() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recupero el atributo actual del parametro color de param-value
		String valorDelValue = (String) getServletContext().getAttribute("color");
		
		response.getWriter().append("<html>\r\n"
				+ "    <head>\r\n"
				+ "        <body style=\"background-color: " + valorDelValue + ";\">\r\n"
				+ "            \r\n"
				+ "        </body>\r\n"
				+ "    </head>\r\n"
				+ "</html>");
	}

}
