package Servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * Servlet implementation class Ejemplo08
 */
public class Ejemplo_08 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejemplo_08() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		
		int c = 1;
		
		//Creo la sesion si no existe
		HttpSession session = request.getSession(true);
		
		if (session.getAttribute("cont") == null) {
			response.getWriter().append("Hola DAM \n");	
			//Reescritura de la URL si el navegador no acepta cookies
			//response.sendRedirect(response.encodeRedirectURL("Ejemplo08"));
			
		} else { // Recoge de la sesion el valor del contador
			response.getWriter().append("Hola de nuevo DAMM \n");
			c = (int) session.getAttribute("cont");
			
		}
		
		//Incrementa el contador guardandolo en la sesion
			session.setAttribute("cont", c+1);
			response.getWriter().append("Accesos de sesion " + c + "\n");
			response.getWriter().append("La sesion fue creada el " + new Date(session.getCreationTime() )+"\n");
			response.getWriter().append("La sesion se identifica como " + session.getId() +"\n");
			response.getWriter().append("Se accedio por ultima vez " + new Date(session.getLastAccessedTime()) +"\n");
			response.getWriter().append("La sesion permanece inactiva por " + session.getMaxInactiveInterval() +"\n");
	}
}
