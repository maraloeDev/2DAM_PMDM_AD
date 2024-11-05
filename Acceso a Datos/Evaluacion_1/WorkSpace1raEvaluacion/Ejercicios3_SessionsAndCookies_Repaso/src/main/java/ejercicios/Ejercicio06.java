package ejercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio06
 */
public class Ejercicio06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio06() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("<html>\r\n"
				+ "    <head>\r\n"
				+ "        <title>Ejercicio05</title>\r\n"
				+ "        <meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\">\r\n"
				+ "    </head>\r\n"
				+ "    <body>\r\n"
				+ "        <h2>ÑAM ÑAM GALLETAS</h2>\r\n"
				+ "        <form action=\"Ejercicio06\" method=\"post\">\r\n"
				+ "            <fieldset>\r\n"
				+ "                ¿Que galleta quieres?\r\n"
				+ "                <input type=\"text\" name=\"galleta\">\r\n"
				+ "                <br><br>\r\n"
				+ "                <input type=\"radio\" name=\"opcion\" value=\"mostrar\"> Mostrar galletas\r\n"
				+ "                <input type=\"radio\" name=\"opcion\" value=\"cocinar\"> Cocinar galleta\r\n"
				+ "                <input type=\"radio\" name=\"opcion\" value=\"comer\"> Comer galleta \r\n"
				+ "                <br><br>\r\n"
				+ "                <input type=\"submit\" value=\"Oido cocina\">\r\n"
				+ "            </fieldset>\r\n"
				+ "        </form>\r\n"
				+ "    </body>\r\n"
				+ "</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		String opciones = request.getParameter("opcion");
		
		switch(opciones) {
		
		case "mostrar" :
			mostrar(request, response);
			break;
			
		case "cocinar" :
			cocinar(request, response);
			break;
			
		case "comer" :
			comer(request, response);
			break;	
		}
	}

	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cs = request.getCookies();
		
		if(cs == null && cs.length==0) {
			response.getWriter().append("NO HAY GALLETAS DISPONIBLES");
		} else {
			
			for(Cookie cookieBuscada : cs) {
				if (!cookieBuscada.getName().contains("JSESSIONID")) {
					response.getWriter().append("<ul><li>"+cookieBuscada.getName()+"</li></ul>");
				}
			}	
		}	
	}

	private void cocinar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie c = new Cookie(request.getParameter("galleta"), request.getParameter("opcion"));
		response.getWriter().append("GALLETA AÑADIDA");
		response.addCookie(c);
	}

	private void comer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Cookie[] cd = request.getCookies();
		 
		 for(Cookie eliminarCookie : cd) {
			 
			 if(eliminarCookie.getName().contains(request.getParameter("galleta"))) {
				 eliminarCookie.setMaxAge(0);;
				 response.addCookie(eliminarCookie);
			 }
		 }
		 response.getWriter().append("galleta eliminada");
	}
}
