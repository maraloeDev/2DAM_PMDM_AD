package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio01
 */
public class Ejercicio01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String color="";
       
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
		
		
		/**
		 * Inicializo el valor actual de la variable
		 */
		color = config.getServletContext().getInitParameter("color");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		if(request.getParameter("color") != null) {
			
			String paramColor = request.getParameter("color");
			
			/**
			 * Establezco un nuevo valor al atributo color llamado paramColor
			 */
			getServletContext().setAttribute("color", paramColor);
			
			response.setContentType("text/html");
			response.getWriter().append("<html>\r\n"
					+ "    <head>\r\n"
					+ "        <title>Ejercicio01</title>\r\n"
					+ "        <meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\">\r\n"
					+ "    </head>\r\n"
					+ "    <body style=\"background-color: " + color + ";\">\r\n"
					+ "\r\n"
					+ "        <form action=\"Ejercicio01_Context\" method=\"get\">\r\n"
					+ "\r\n"
					+ "            <input type=\"submit\" value=\"Enviar\">\r\n"
					+ "        </form>\r\n"
					+ "    </body>\r\n"
					+ "</html>");
			
		} else {
			response.getWriter().append("No se a pasado el parametro <b>color</b>");
		}
		
		
	}
}
