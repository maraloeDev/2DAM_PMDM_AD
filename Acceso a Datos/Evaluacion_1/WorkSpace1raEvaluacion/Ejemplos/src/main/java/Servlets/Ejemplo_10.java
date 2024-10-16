package Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejemolo010
 */
@WebServlet("/Ejemplo_10")
public class Ejemplo_10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejemplo_10() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		config.getServletContext();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    response.getWriter().append("<html><body>")
	        .append("<form name='formulario' action='Ejemplo_10' method='post'>")
	        .append("<input type='submit' name='metodo' value='include'  />")
	        .append("<input type='submit' name='metodo' value='forward' />")
	        .append("</form></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    response.getWriter().append("<html>")
	        .append("<body style='background-color:#AAFF9F'>")
	        .append("<H3>Ejemplo de RequestDispatcher</H3>")
	        .append("<p>Este servlet usar un despachador que nos lleva a un servlet despachador </p>");

	    // Rutas absolutas, no permite rutas relativas para el contexto de la app web
	    // RequestDispatcher dispatcher = sc.getRequestDispatcher("/Ejemplo_10_bis");

	    // Rutas relativas y absolutas pero solo para el contexto de la app web
	    RequestDispatcher dispatcher = request.getRequestDispatcher("Ejemplo_10_bis");

	    if (dispatcher != null) {
	    	request.setAttribute("attribDitpach", "Llega el atributo");
	        if (request.getParameter("metodo") != null) {
	            request.setAttribute("attribDitpach", "Llega atributo");
	            if (request.getParameter("metodo").equalsIgnoreCase("include")) {
	                dispatcher.include(request, response);
	            } else { // forward
	                dispatcher.forward(request, response);
	            }
	        }
	        response.getWriter().append("<p>Final del servlet despachador</p>");
	    } else {
	        response.getWriter().append("<p>No se ha encontrado el despachador</p>");
	    }
	    response.getWriter().append("</body></html>");
	    response.getWriter().close();
	}


}
