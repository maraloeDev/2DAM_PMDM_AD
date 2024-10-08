package Servlets;

import java.io.IOException;
import jakarta.*;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejemplo09
 */
@WebServlet("/Ejercicio09")
public class Ejemplo09 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Ejemplo09() {
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
		response.setContentType("text/plain");
		int n = 1;
		boolean flag = false;
		
		//Creacion de cookie
		
		Cookie[] cs = request.getCookies();
		if(cs!=null) {
			
			for(int i=0; i < cs.length && !flag; i++) {
				if(cs[i].getName().equals("cont")) {
					n = Integer.parseInt(cs[i].getValue())+1;
					flag=true;
				}
			}
			
		}
		
		Cookie c = new Cookie("cont", String.valueOf(n));
		
		c.setMaxAge(60*60+24 *365);
		
		//Enviar la cookie al navegador cliente
		response.addCookie(c);
		response.getWriter().append("Visitas registradas " + n);
	}

}
