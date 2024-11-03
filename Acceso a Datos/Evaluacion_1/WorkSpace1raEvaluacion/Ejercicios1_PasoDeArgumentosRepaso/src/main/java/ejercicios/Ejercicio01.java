package ejercicios;

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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		if(request.getParameter("idioma")!=null) {
			
			String idioma = request.getParameter("idioma"); 
			
			
			switch (idioma) {
			case "es" :
				response.getWriter().append("Hola mundo");
				break;
				
			case "en" :
				response.getWriter().append("Hello world");
				break;
				
			case "de" :
				response.getWriter().append("Halo welt");
				break;
				
				default: response.getWriter().append("El <b>idioma</b> no está en \r\n"
						+ "nuestra base de datos");
			
			}
			
			
		} else {
			response.getWriter().append("El <b>idioma</b> no está en \r\n"
					+ "nuestra base de datos");
		}
	}

}
