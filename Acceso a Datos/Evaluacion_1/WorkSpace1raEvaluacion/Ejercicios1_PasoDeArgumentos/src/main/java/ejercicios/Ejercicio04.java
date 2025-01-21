package ejercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String[]> losDatos = request.getParameterMap();
		
		response.getWriter().append("response.getWriter().append(\"<html>\\r\\n\"\r\n"
				+ "<head>\\r\\n\"\r\n"
				+ "<title>Ejercicio03</title>\\r\\n\"\r\n"
				+ "<body>\\r\\n\"\r\n"
				+ "<table border=\\\"2\\\">\\r\\n\"\r\n"
				+ "<tr>\\r\\n\"\r\n"
				+ "<td>Nombre</td>\\r\\n\"\r\n"
				+ "<td>Valor</td>\\r\\n\"");
		
		for(Entry<String, String[]> datosPerson : losDatos.entrySet()) {
			
			String datoKey = datosPerson.getKey();
			String[] datosValue = datosPerson.getValue();
			
			for(String datosTotal : datosValue) {
				
						response.getWriter().append("</tr>"
								+ "<tr>\\r\\n\"\r\n"
								+ "<td>\"+ datoKey+\"</td>\\r\\n\"\r\n"
								+ "<td>\"+ datosValue.toString()+\"</td>\\r\\n\"\r\n"
								+ "</tr>\\r\\n\"\r\n"
								+ "</table>\\r\\n\"\r\n"
								+ "</body>\\r\\n\"\r\n"
								+ "</head>\\r\\n\"\r\n"
								+ "</html>");
				
			}
			
		}
	}

}
