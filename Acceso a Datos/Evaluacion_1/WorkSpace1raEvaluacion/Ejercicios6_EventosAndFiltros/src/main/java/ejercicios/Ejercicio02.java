package ejercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Servlet implementation class Ejercicio02
 */
public class Ejercicio02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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

        Map<String, Integer> visitCountMap = (Map<String, Integer>) getServletContext().getAttribute("visitCountMap");

        // Generar el reporte
        response.getWriter().append("<html><body>");
        response.getWriter().append("<h2>Reporte de visitas por URL</h2>");
        
        if (visitCountMap != null) {
            for (Map.Entry<String, Integer> entry : visitCountMap.entrySet()) {
            	response.getWriter().append("<p>" + entry.getKey() + " ha sido visitada " + entry.getValue() + " veces.</p>");
            }
        } else {
        	response.getWriter().append("<p>No hay datos de visitas disponibles.</p>");
        }

        response.getWriter().append("</body></html>");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
