package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio03_VerCompra
 */
public class Ejercicio03_VerCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio03_VerCompra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recojo las cookies del usuario
		Cookie[] cs = request.getCookies();
		response.setContentType("text/html");
		
		response.getWriter().append("<html>\r\n"
				+ "    <head>\r\n"
				+ "        \r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "    <h1>Compra Total</h1>\r\n"
				+ "\r\n"
				+ "    <table border = 2>\r\n"
				+ "        <tr>\r\n"
				+ "            <th>Título del Libro</th>\r\n"
				+ "            <th>Unidades</th>\r\n"
				+ "            <th>Precio</th>\r\n"
				+ "        </tr>");
		int total = 0;
		
		//Si la cookie buscada no sea JSESSIONID, se muestre, el nombre de la cookie, el valor y el 
		for(Cookie cokkieBuscada : cs) {
			
			if(!cokkieBuscada.getName().contains("JSESSIONID")) {
				response.getWriter().append("<tr>\r\n"
						+ "            <td> "+ cokkieBuscada.getName()+"</td>\r\n"
						+ "            <td> " + cokkieBuscada.getValue() +"</td>\r\n"
						+ "            <td>"+ Integer.parseInt(cokkieBuscada.getValue()) *30+"</td>\r\n"
						+ "        </tr>\r\n"
						+ "");
				total += Integer.parseInt(cokkieBuscada.getValue()) *30;
			}
		}
		response.getWriter().append("</table><h1>Total: " + total+ " </h1>");
	}

}
