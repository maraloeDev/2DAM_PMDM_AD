package ejercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		response.getWriter().append("<html>\r\n"
				+ "    <head>\r\n"
				+ "        <title>Untitled-1</title>\r\n"
				+ "    </head>\r\n"
				+ "    <body>\r\n"
				+ "\r\n"
				+ "        <form action=\"Ejercicio04\" method=\"get\">\r\n"
				+ "\r\n"
				+ "            <input type=\"submit\" name=\"valores\" value=\"Acceso\"> <br><br>\r\n"
				+ "            <input type=\"submit\" name=\"valores\" value=\"Nueva Sesión\">\r\n"
				+ "        </form>\r\n"
				+ "    </body>\r\n"
				+ "</html>");
		
		HttpSession session = request.getSession(true);
		
		Integer contador = session.getAttribute("contador") !=null ? (Integer) session.getAttribute("contador") : 0;
		
		if(request.getParameter("valores").contains("Acceso")) {
			 contador++;
			 session.setAttribute("contador", contador);
			 response.getWriter().append("Desde la última vez ha accedido "+contador+" veces");
		} else {
			contador = 1;
			session.setAttribute("contador", contador);
			response.getWriter().append("Es la primera vez que accede a la web");
		}
	}
}
