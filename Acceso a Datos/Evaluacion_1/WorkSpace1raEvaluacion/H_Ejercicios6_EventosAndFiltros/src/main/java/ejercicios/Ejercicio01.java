package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Servlet implementation class Ejercicio01
 */
public class Ejercicio01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static HashMap<Integer, String[]> notificaciones = new HashMap<Integer, String[]>();
       
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
		config.getServletContext().getInitParameter("mapaContext");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("<html>\r\n"
				+ "    <head>\r\n"
				+ "        <title>Ejercicio01</title>\r\n"
				+ "    </head>\r\n"
				+ "\r\n"
				+ "    <body>\r\n"
				+ "        \r\n"
				+ "        <form action=\"Ejercicio01\" method=\"get\">\r\n"
				+ "            ID: <input type=\"text\" name=\"tarea\"><br>\r\n"
				+ "            Descripcion: <input type=\"text\" name=\"descripcion\"><br>\r\n"
				+ "            <input type=\"submit\" value=\"Enviar\">\r\n"
				+ "        </form>\r\n"
				+ "    </body>\r\n"
				+ "</html>");
		
		Integer tarea = Integer.parseInt(request.getParameter("tarea"));
		String descripcion[] = request.getParameterValues("descripcion");
		
		notificaciones.put(tarea, descripcion);
		getServletContext().setAttribute("mapaContext", notificaciones);
		
		
		response.getWriter().append("<table border=\"10\">\r\n"
				+ "                <tr>\r\n"
				+ "                    <td>ID</td>\r\n"
				+ "                    \r\n"
				+ "                    <td>Descripcion</td>\r\n"
				+ "                </tr>");
		for (Entry<Integer, String[]> listaNotificaciones : notificaciones.entrySet()) {
            Integer id = listaNotificaciones.getKey();
            String[] descripciones = listaNotificaciones.getValue();

            response.getWriter().append("<tr>\r\n");
            response.getWriter().append("<td>").append(id.toString()).append("</td>\r\n");
            
            response.getWriter().append("<td>");
            for (String descripciona : descripciones) {
                response.getWriter().append(descripciona).append("<br>");
            }
            response.getWriter().append("</td>\r\n");
            response.getWriter().append("</tr>\r\n");
        }

        response.getWriter().append("</table>\r\n");
		}
	}