package ejercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio01c
 */
public class Ejercicio01c extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio01c() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		
		if(request.getParameter("mensaje")!=null || request.getParameter("firma")!=null) {
			String mensaje = request.getParameter("mensaje");
			String firma = request.getParameter("firma");
			
			response.getWriter().append("Mensaje = " + mensaje + "<br>");
			response.getWriter().append("Firma = " + firma);
			
		} else {
			response.getWriter().append("<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>Saludar</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "    <form action=\"Ejercicio01c\" method=\"get\">\r\n"
					+ "        <fieldset>\r\n"
					+ "            <legend>Saludo</legend>\r\n"
					+ "\r\n"
					+ "            Mensaje <input type=\"text\" name=\"mensaje\">\r\n"
					+ "            <br>\r\n"
					+ "            Firma <input type=\"text\" name=\"firma\" size=\"34\">\r\n"
					+ "            <br>\r\n"
					+ "            <input type=\"submit\" value=\"Enviar\">\r\n"
					+ "        </fieldset>\r\n"
					+ "        \r\n"
					+ "    </form>\r\n"
					+ "</body>\r\n"
					+ "</html>\r\n"
					+ "");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		if(request.getParameter("mensaje")!=null || request.getParameter("firma")!=null) {
			String mensaje = request.getParameter("mensaje");
			String firma = request.getParameter("firma");
			
			response.getWriter().append("Mensaje = " + mensaje + "<br>");
			response.getWriter().append("Firma = " + firma);
			
		} 
	}

}
