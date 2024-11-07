package ejercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio02c
 */
public class Ejercicio02c extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio02c() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String errormsg = (String) getServletContext().getAttribute("mensajeError");
		response.getWriter().append("<html>\r\n"
				+ "    <head>\r\n"
				+ "        <title>Ejercicio02</title>\r\n"
				+ "    </head>\r\n"
				+ "\r\n"
				+ "    <body>\r\n"
				+ "        <h3 style=\"text-align: center;\">MENSAJE DEL SERVIDOR</h3>\r\n"
				+ "        <hr>\r\n"
				+ "\r\n"
				+ "        <h4 style=\"text-align: center; color: red;\">"+errormsg+"</h4>\r\n"
				+ "<br>\r\n"
				+ "<a href=\"Ejercicio02\">Volver</a>"
				+ "    </body>\r\n"
				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
