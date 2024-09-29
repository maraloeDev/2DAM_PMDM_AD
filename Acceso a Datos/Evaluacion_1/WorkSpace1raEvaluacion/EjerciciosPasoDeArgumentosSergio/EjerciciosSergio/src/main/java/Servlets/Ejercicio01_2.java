package Servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio01_2
 */
public class Ejercicio01_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio01_2() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		if(request.getParameter("idioma")!=null) {
			
			String idioma = request.getParameter("idioma");
			
			switch (idioma) {
			case "ingles":
				response.getWriter().append("Hello World");
				break;
			case "espanol" :
				response.getWriter().append("Hola Mundo");
				break;
			case "italiano" :
				response.getWriter().append("Ciao Tutti");
				break;
			case "frances" :
			response.getWriter().append("Bonjour Tout");
			}
		} else {
			response.getWriter().append("Parametro idioma no contemplado");
		}
		
	
	}
}
