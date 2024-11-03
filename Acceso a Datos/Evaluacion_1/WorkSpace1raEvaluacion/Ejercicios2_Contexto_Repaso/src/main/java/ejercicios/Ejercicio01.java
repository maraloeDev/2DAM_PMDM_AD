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
	String color ="";
       
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
		color = config.getServletContext().getInitParameter("color");
		getServletContext().setAttribute("color", color);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("color")!=null) {
			
			String colorP = request.getParameter("color");
			color = colorP;
			
			getServletContext().setAttribute("color", colorP);
			response.getWriter().append("<html>\r\n"
					+ "    <head>\r\n"
					+ "        <title>Untitled-1</title>\r\n"
					+ "    </head>\r\n"
					+ "    <body  style=\"background-color: "+colorP + ";\">\r\n"
					+ "\r\n"
					+ "        <form action=\"Ejercicio01_Contexto\" method=\"get\">\r\n"
					+ "            <input type=\"submit\" value=\"Enviar\">\r\n"
					+ "        </form>\r\n"
					+ "        \r\n"
					+ "    </body>\r\n"
					+ "</html>");
			
		}
		
	}
}