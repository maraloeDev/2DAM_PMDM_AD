package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class Ejercicio02_Context
 */
public class Ejercicio02_Context extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio02_Context() {
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

		response.setContentType("text/html");

			getServletContext().getAttribute("listadoPersonas");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Listado de Personas</h1>");
        
        if (listaPersonas != null) {
        	
            response.getWriter().println("<table border='1'>");
            response.getWriter().println("<tr><th>Nombre</th><th>Edad</th><th>Teléfono</th></tr>");
            
            for (Persona persona : listaPersonas) {
                response.getWriter().println("<tr>");
                response.getWriter().println("<td>" + persona.getNombre() + "</td>");
                response.getWriter().println("<td>" + persona.getEdad() + "</td>");
                response.getWriter().println("<td>" + persona.getTelefono() + "</td>");
                response.getWriter().println("</tr>");
            }
            response.getWriter().println("</table>");
        } else {
            response.getWriter().println("<p>No hay personas en la lista.</p>");
        }

        response.getWriter().println("</body></html>");
    }
	}