package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio01_3
 */
public class Ejercicio01_3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio01_3() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		
		String mensaje = request.getParameter("mensaje");
		String firma = request.getParameter("firma");
		
		if(request.getParameter("mensaje") != null || request.getParameter("firma") != null) {
			
			response.getWriter().append(" Mensaje :"+mensaje+" "
					+ "        <br>\r\n"
					+ "        \r\n"
					+ "        Firma : "+firma+" ");
		} else {
			response.getWriter().append("<html>\r\n"
					+ "<head>\r\n"
					+ "    <title>Ejercicio01_3</title>\r\n"
					+ "</head>\r\n"
					+ "\r\n"
					+ "<body>\r\n"
					+ "    <fieldset>\r\n"
					+ "        <legend>Saludo</legend>\r\n"
					+ "\r\n"
					+ "        <form action=\"Ejercicio01_3\" method=\"get\">\r\n"
					+ "        Mensaje <input type=\"text\" name=\"mensaje\" id=\"\">\r\n"
					+ "        <br>\r\n"
					+ "        \r\n"
					+ "        Firma <input type=\"text\" name=\"firma\" id=\"\">\r\n"
					+ "\r\n"
					+ "        <br>\r\n"
					+ "        <input type=\"submit\" value=\"Enviar\">\r\n"
					+ "        <input type=\"submit\" value=\"Borrar\">\r\n"
					+ "    </fieldset>\r\n"
					+ "</form>\r\n"
					+ "</body>\r\n"
					+ "</html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String mensaje = request.getParameter("mensaje");
		String firma = request.getParameter("firma");
		
		if(request.getParameter("mensaje") != null || request.getParameter("firma") != null) {
			
			response.getWriter().append(" Mensaje :"+mensaje+" "
					+ "        <br>\r\n"
					+ "        \r\n"
					+ "        Firma : "+firma+" ");
		}
	}

}
