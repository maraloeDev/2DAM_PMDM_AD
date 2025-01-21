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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		if (request.getParameter("idioma")!=null) {
			
			String idioma = request.getParameter("idioma");
			
			switch (idioma) {
			
			case "espanol" :
				response.getWriter().append("Hola Mundo");
				break;
				
			case "ingles" :
				response.getWriter().append("Hello World");
				break;
				
			case "aleman" :
				response.getWriter().append("Hallo Welt");
				break;
				
				default :
					response.getWriter().append("El idioma no está en nuestra base de datos");
			}
			
		} else {
			response.getWriter().append("No se a pasado el parametro '<b>idioma</b>'");
		}
	}

}
