package Ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio05
 */
public class Ejercicio05 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio05() {
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
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		if(request.getParameter("asignaturas") != null || request.getParameter("sexo")!= null) {
			
			String asignaturas = request.getParameter("asignaturas");
			String sexo = request.getParameter("sexo");
			String actividades[] = request.getParameterValues("actividades");
			
			response.getWriter().append("<html>\r\n"
					+ "    <head>\r\n"
					+ "        <body>\r\n"
					+ "            <p><b>ASIGNATURA: "+ asignaturas +" </b></p>\r\n"
					+ "            <p><b>SEXO: "+ sexo+"</b></p>\r\n");
			
			if (actividades != null) {
	            response.getWriter().append("<p><b>ACTIVIDADES:</b></p>");
	            for (String actividad : actividades) {
	                response.getWriter().append("<ul>\r\n"
	                		+ "            <li>"+actividad +"</li>\r\n"
	                		+ "        </ul>");
	            }
	        } else {
	        	response.getWriter().append("<p>No actividades selected</p>\r\n");
	        }
			
			response.getWriter().append("</body>");
			response.getWriter().append("</html>");
			response.getWriter().close();

		}
	}

}
