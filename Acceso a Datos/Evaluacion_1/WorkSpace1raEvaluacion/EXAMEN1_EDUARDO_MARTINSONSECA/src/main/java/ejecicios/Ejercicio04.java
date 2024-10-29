package ejecicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio04
 */
public class Ejercicio04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio04() {
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
	    response.getWriter().append("<html>\r\n"
	            + "<head>\r\n"
	            + "<meta charset=\"ISO-8859-1\">\r\n"
	            + "<title>APP NEWSLETTER</title>\r\n"
	            + "</head>\r\n"
	            + "<body>\r\n"
	            + "    <form action=\"Ejercicio04\" method=\"post\">\r\n"
	            + "        <fieldset>\r\n"
	            + "            <legend>\r\n"
	            + "                <h1>NEWSLETTER'S</h1>\r\n"
	            + "            </legend>\r\n"
	            + "            <table>\r\n"
	            + "                <tr>\r\n"
	            + "                    <td><label>Indique las noticias a las que le gustaria suscribirse:</label></td>\r\n"
	            + "                </tr>\r\n"
	            + "                <tr>\r\n"
	            + "                    <td><input type=\"checkbox\" name=\"opcion\" value=\"Deportes\" />Deportes</td>\r\n"
	            + "                    <td><input type=\"checkbox\" name=\"opcion\" value=\"Moda\" />Moda</td>\r\n"
	            + "                    <td><input type=\"checkbox\" name=\"opcion\" value=\"Gastronomia\" />Gastronomia</td>\r\n"
	            + "                    <td><input type=\"checkbox\" name=\"opcion\" value=\"Turismo\" />Turismo</td>\r\n"
	            + "                </tr>\r\n"
	            + "                <tr>\r\n"
	            + "                    <td><br></td>\r\n"
	            + "                </tr>\r\n"
	            + "                <tr>\r\n"
	            + "                    <td><input type=\"submit\" value=\"Suscribirse\" /></td>\r\n"
	            + "                </tr>\r\n"
	            + "            </table>\r\n"
	            + "        </fieldset>\r\n"
	            + "    </form>\r\n"
	            + "</body>\r\n"
	            + "</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    String[] opcionesSelected = request.getParameterValues("opcion");

	    response.getWriter().append("<html>\r\n"
	            + "<head>\r\n"
	            + "<meta charset=\"ISO-8859-1\">\r\n"
	            + "<title>APP NEWSLETTER</title>\r\n"
	            + "</head>\r\n"
	            + "<body>\r\n"
	            + "<h1>NEWSLETTER'S</h1>\r\n"
	            + "<b>Las noticias de hoy para usted!</b>\r\n"
	            + "<ul>\r\n");

	    if (opcionesSelected != null) {
	        for (String opcion : opcionesSelected) {
	            Cookie c = new Cookie(opcion, "_");
	            response.addCookie(c); //añado la cookie
	            c.setMaxAge(60);
	            response.getWriter().append("<li>Noticia: " + opcion + "</li>\r\n"); //Muestro la noticia
	        }
	    } else {
	        response.getWriter().append("<li>No ha seleccionado ninguna opción.</li>\r\n");
	    }

	    response.getWriter().append("</ul>\r\n"
	            + "</body>\r\n"
	            + "</html>");
	}

}
