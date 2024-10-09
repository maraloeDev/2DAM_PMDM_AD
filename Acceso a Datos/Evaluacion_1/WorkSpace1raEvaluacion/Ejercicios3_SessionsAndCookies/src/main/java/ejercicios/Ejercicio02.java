package ejercicios;

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
	private static ArrayList<String> listadoPersonas = new ArrayList<String>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		if (request.getParameter("nombre") != null) {
			String nombre = request.getParameter("nombre");
			listadoPersonas.add(nombre);
			response.getWriter().append("<html>\r\n"
					+ "    <head>\r\n"
					+ "        <title>Ejercicio02</title>\r\n"
					+ "    </head>\r\n"
					+ "    <body>\r\n"
					+ "        Hola "+ nombre+"\r\n"
					+ "        <br>\r\n"
					+ "        Bienvenido a mi página Web!\r\n"
					+ "        <br>\r\n"
					+ "        Contigo, ya me han visitado:\r\n"
					+ "        <br>\r\n");
			response.getWriter().append("<br>");
			
			for(String listaP : listadoPersonas) {
				
				response.getWriter().append(listaP.toString());
			}
			
			response.getWriter().append("    </body>\r\n"
					+ "</html>");
		} else {
			response.getWriter().append("Falta el parametro 'nombre'");
		}
	}

}
