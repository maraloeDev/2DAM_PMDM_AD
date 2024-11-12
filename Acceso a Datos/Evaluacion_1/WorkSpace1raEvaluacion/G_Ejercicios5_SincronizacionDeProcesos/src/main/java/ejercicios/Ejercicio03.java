package ejercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Ejercicio03
 */
public class Ejercicio03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio03() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private Object lock = new Object();
	protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		if(request.getParameter("usuario")!=null) {
			String usuario = null;
			HttpSession session = null;
			synchronized (lock) {
				session = request.getSession(true);
				usuario = request.getParameter("usuario");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			session.setAttribute("usuario",usuario);
				
				response.getWriter().append("Usuario :" + session.getAttribute("usuario") + "<br>");
				response.getWriter().append("Id : " + session.getId()+ "<br>");
				response.getWriter().append("Fecha de creacion sesion " + session.getCreationTime()+ "<br>");
				response.getWriter().append("Fecha de ultimo acceso" + session.getLastAccessedTime());
			
		}
	}


}
