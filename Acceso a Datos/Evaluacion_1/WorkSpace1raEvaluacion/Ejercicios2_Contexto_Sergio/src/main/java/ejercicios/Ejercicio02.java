package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import clases.Persona;

/**
 * Servlet implementation class Ejercicio02
 */
public class Ejercicio02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArrayList<Persona> agregarPersona;
	private static String listaContexto ="";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio02() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		listaContexto = config.getServletContext().getInitParameter(listaContexto);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		if (request.getParameter("nombre")!= null || request.getParameter("edad")!=null || request.getParameter("telefono") != null) {
			
			String nombre = request.getParameter("nombre");
			String edad = request.getParameter("edad");
			String telefono = request.getParameter("telefono");
			agregarPersona = (ArrayList<Persona>) getServletContext().getAttribute("listaContexto");
			
			if(agregarPersona == null) {
			agregarPersona = new ArrayList();
			} else {
				agregarPersona.add(new Persona(nombre, Integer.parseInt(edad), telefono));
			
			}
			
			
			/**
			 * Establezco como nuevo param-value el AL de agregarPersona con la persona
			 */
			getServletContext().setAttribute("listaContexto", agregarPersona);
			
			response.getWriter().append("<html>\r\n"
					+ "    <head>\r\n"
					+ "        <title>Ejercicio02</title>\r\n"
					+ "    </head>\r\n"
					+ "\r\n"
					+ "    <body>\r\n"
					+ "        <form action=\"Ejercicio02_Context\" method=\"get\">\r\n"
					+ "\r\n"
					+ "            <p>Persona agregada correctamente</p>\r\n"
					+ "            <br>\r\n"
					+ "            <br>\r\n"
					+ "            <input type=\"submit\" value=\"Mostrar lista de usuarios\">\r\n"
					+ "        </form>\r\n"
					+ "    </body>\r\n"
					+ "</html>");
		} else {
			response.getWriter().append("No se ha establecido los parametros nombre, edad o telefono");
		}
	}
}