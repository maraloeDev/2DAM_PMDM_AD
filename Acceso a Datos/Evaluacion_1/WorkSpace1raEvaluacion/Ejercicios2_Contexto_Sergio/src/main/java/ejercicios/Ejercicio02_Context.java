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
 * Servlet implementation class Ejercicio02_Context
 */
public class Ejercicio02_Context extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		
		ArrayList<Persona> listadoPersonas = (ArrayList<Persona>) getServletContext().getAttribute("listaContexto");
		
		response.getWriter().append("<html>\r\n"
				+ "    <head>\r\n"
				+ "        <title>Ejercicio02</title>\r\n"
				+ "    </head>\r\n"
				+ "\r\n"
				+ "    <body>\r\n"
				+ "        <table border=\"2\">\r\n"
				+ "\r\n"
				+ "            <tr>\r\n"
				+ "                <td><b>Nombre</b></td>\r\n"
				+ "                <td><b>Edad</b></td>\r\n"
				+ "                <td><b>Telefono</b></td>\r\n"
				+ "            </tr>\r\n");
		
		for(Persona p : listadoPersonas) {
			
			response.getWriter().append("<tr> "
					+ "<td><b> "+p.getNombre()+"</b></td>"
					+ "<td><b> "+ p.getEdad()+"</b></td>"
					+ "<td><b> "+ p.getTelefono()+"</b></td>"
					+ "</tr>");
		}
		
		response.getWriter().append("</table>\r\n"
				+ "    </body>\r\n"
				+ "</html>");
	}
}
