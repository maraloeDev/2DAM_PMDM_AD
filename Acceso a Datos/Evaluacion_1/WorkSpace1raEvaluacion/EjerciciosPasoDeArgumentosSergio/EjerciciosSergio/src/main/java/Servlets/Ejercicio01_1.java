package Servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio01_1
 */
public class Ejercicio01_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio01_1() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/pain");
		if(request.getParameter("idioma") !=null) {
		
			String idioma= request.getParameter("idioma");
			
			if(idioma!=null) {
			switch(idioma) {
			
			case "Espaniol" :
				response.getWriter().append("Hola Mundo");
			break;
			case "Ingles":
				response.getWriter().append("Hello World");
				break;
			case "Aleman":
				response.getWriter().append("Hello Walt");
				break;
				default:
					response.getWriter().append("El idioma no está en nuestra base de datos");
			}
			
			response.getWriter().close();
			
		} else {
			response.getWriter().append("Parametro requerido");
		}
	}
	}
}
