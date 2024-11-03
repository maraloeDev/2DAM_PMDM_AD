package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Servlet implementation class Ejercicio01
 */
public class Ejercicio01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio01() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		HashMap<String, String[]> tareas = new HashMap();
		getServletContext().setAttribute("notificaciones", tareas);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		// Recoger el HashMap
		// Guardar el HashMap en el contexto

		response.getWriter().append("<html lang=\"es\">\r\n" + "<head>\r\n" + "    <meta charset=\"UTF-8\">\r\n"
				+ "    <title>Añadir Tarea</title>\r\n" + "</head>\r\n" + "<body>\r\n"
				+ "    <h2>Añadir Nueva Tarea</h2>\r\n" + "    <form action=\"Ejercicio01\" method=\"post\">\r\n"
				+ "        <label for=\"tareaId\">ID de Tarea:</label>\r\n"
				+ "        <input type=\"text\" id=\"tareaId\" name=\"tareaId\" required><br>\r\n"
				+ "        <label for=\"descripcion\">Descripción:</label>\r\n"
				+ "        <input type=\"text\" id=\"descripcion\" name=\"descripcion\" required><br>\r\n"
				+ "        <input type=\"submit\" value=\"Agregar Tarea\">\r\n" + "    </form>\r\n" + "</body>\r\n"
				+ "</html>").close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Almaceno los datos introducidos de tarea, y de la descripcion
		
		String tareaId = request.getParameter("tareaId");
		String descripcion = request.getParameter("descripcion");
		
		HashMap<String, String> tareas = (HashMap<String, String>) getServletContext().getAttribute("notificaciones");
		
		tareas.put(tareaId, descripcion);
		
		 response.setContentType("text/html");
	        response.getWriter().append("<html><body>");
	        response.getWriter().append("<h2>Tarea Añadida:</h2>");
	        response.getWriter().append("<p>ID: " + tareaId + "</p>");
	        response.getWriter().append("<p>Descripción: " + descripcion + "</p>");
	        
	        response.getWriter().append("<h3>Todas las tareas:</h3>");
	        for (String key : tareas.keySet()) {
	        	response.getWriter().append("<p>ID: " + key + ", Descripción: " + tareas.get(key) + "</p>");
	        }
	        response.getWriter().append("</body></html>");
	    }
	}