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
		
		Map<String, String[]> valoresInfinitos = request.getParameterMap();
		response.setContentType("text/html");
		response.getWriter().append("<html>\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <title>Saludar</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    \r\n"
				+ "    <table border=\"2\">\r\n"
				+ "        <tr>\r\n"
				+ "            <td>CLAVE</td>\r\n"
				+ "            <td>VALOR</td>\r\n"
				+ "        </tr>");
		
		for(Entry<String, String[]> mapaInfinito : valoresInfinitos.entrySet()) {
			String key = mapaInfinito.getKey();
			String[] value = mapaInfinito.getValue();
			
			for(String mapaValues : value) {
				
				response.getWriter().append("<tr>\r\n"
						+ "            <td>"+mapaInfinito.getKey()+"</td>\r\n"
						+ "            <td>"+mapaValues+"</td>\r\n"
						+ "        </tr>");
				
			}
		}
		response.getWriter().append("    </table>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
