package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejemplo05
 */
public class Ejemplo05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejemplo05() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		response.setContentType("text/html");		
		response.getWriter().append("Nombre:" + request.getParameter("nombre"));
		response.getWriter().append("<br>");
		if(request.getParameter("apellidos") == null || request.getParameter("apellidos").isEmpty()) {
			response.getWriter().append("Valor no especificado");
		}	else {
			response.getWriter().append("Apellidos:" + request.getParameter("apellidos")); 
		}	
	}
}