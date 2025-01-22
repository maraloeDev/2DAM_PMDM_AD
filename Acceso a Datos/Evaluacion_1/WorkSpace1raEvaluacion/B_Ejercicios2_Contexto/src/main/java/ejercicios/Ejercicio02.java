package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class Ejercicio02
 */
public class Ejercicio02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static ArrayList<Persona> agregarPersonas = new ArrayList<Persona>();
	private String personas="";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		super.init(config);
		
		
		// Recupero el nombre de <param-name>
		personas = getServletContext().getInitParameter("listadoPersonas");
		
		// Sustituyo el atributo listaPersonas por la lista
		config.getServletContext().setAttribute("listadoPersonas", personas);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
        String edadStr = request.getParameter("edad");
        String telefono = request.getParameter("telefono");
        
	    if (request.getParameter("nombre") != null || request.getParameter("edad") != null || request.getParameter("telefono") != null) {
	    		int edad = Integer.parseInt(edadStr);
	    		
	    		//Agrego una nueva persona en la lista
	        Persona p = new Persona(nombre, edad, telefono);	        
	        agregarPersonas.add(p);
	        
	        // Sustituyo el atributo listaPersonas por la lista que contiene los nombres
	        getServletContext().setAttribute("listadoPersonas", agregarPersonas);
	        response.setContentType("text/html");
	        
	        response.getWriter().println("Persona agregada correctamente.");
	        response.getWriter().append("<!DOCTYPE html>\r\n"
	        		+ "<html lang=\"en\">\r\n"
	        		+ "<head>\r\n"
	        		+ "    <meta charset=\"UTF-8\">\r\n"
	        		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
	        		+ "    <title>EJERCICIO 02</title>\r\n"
	        		+ "</head>\r\n"
	        		+ "<body>\r\n"
	        		+ "    \r\n"
	        		+ "    <form action=\"Ejercicio02_Context\" method=\"get\">\r\n"
	        		+ "\r\n"
	        		+ "        <input type=\"submit\" value=\"Mostrar listado de personas\">\r\n"
	        		+ "    </form>\r\n"
	        		+ "</body>\r\n"
	        		+ "</html>");
	    } else {
	        response.getWriter().append("No se han recogido los parámetros nombre, edad, telefono y contacto");
	    }
	}

	}
