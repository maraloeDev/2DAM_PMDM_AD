package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
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
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> valoresInfinite = request.getParameterMap();
		
		response.getWriter().append("<html>\r\n"
				+ "    <head>\r\n"
				+ "        <title>Ejercicio04</title>\r\n"
				+ "    </head>\r\n"
				+ "\r\n"
				+ "    <body>\r\n"
				+ "        \r\n"
				+ "        <table border=\"2\">\r\n"
				+ "            <tr>\r\n"
				+ "            <td>Clave</td>        \r\n"
				+ "            <td>Valor</td>\r\n"
				+ "            </tr>\r\n");
		for (Entry<String, String[]> claveValor : valoresInfinite.entrySet()) {
			
			String clave = claveValor.getKey();
			String[] valor = claveValor.getValue();
			
			response.getWriter().append("<tr>"
					+ "<td>"+clave+"</td>");
			
			for(String vaLor : valor) {
				response.getWriter().append("<td>"+vaLor+"</td>"
								+ "</tr>");
			}
		}
		response.getWriter().append("</table></body></html>");
	}
}