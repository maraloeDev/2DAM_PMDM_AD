package Servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionIdListener;

import java.io.IOException;
import java.util.Date;

/**
 * Servlet implementation class Ejemplo08
 */
public class Ejemplo08 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejemplo08() {
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
		
		//Creo la sesion
		HttpSession session = request.getSession(true);
		
		if (session.getAttribute("cont") == null) {
			
			response.getWriter().append("Hola DAM \n");		
			
		} else {
			response.getWriter().append("Hola de nuevo DAMM \n");
			c = (int) session.getAttribute("cont");
			
		}
		
		
		//Reenviar la url concatenandole el jsesion id, en caso de que el navegador no acepte cookies, el jsesion va aqui
				//response.sendRedirect(response.encodeRedirectURL("Ejemplo08"));
		
			session.setAttribute("cont", c+1);
			response.getWriter().append("Accesos de sesion " + c + "\n");
			response.getWriter().append("La sesion fue creada el " + new Date(session.getCreationTime() )+"\n");
			response.getWriter().append("La sesion se identifica como " + session.getId() +"\n");
			response.getWriter().append("Se accedio por ultima vez " + new Date(session.getLastAccessedTime()) +"\n");
			response.getWriter().append("La sesion permanece inactiva por " + session.getMaxInactiveInterval() +"\n");
	}
}
