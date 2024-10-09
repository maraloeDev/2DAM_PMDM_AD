package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("<html>\r\n"
				+ "    <head>\r\n"
				+ "        <title>Ejercicio02</title>\r\n"
				+ "    </head>\r\n"
				+ "    <body>\r\n"
				+ "        <form action=\"Ejercicio04\" method=\"get\">\r\n"
				+ "\r\n"
				+ "            <input type=\"submit\" value=\"Acceso\" name=\"acceso\">\r\n"
				+ "            <br>\r\n"
				+ "            <br>\r\n"
				+ "            <input type=\"submit\" value=\"Nueva sesion\" name=\"acceso\">\r\n"
				+ "        </form>\r\n"
				+ "\r\n"
				+ "    </body>\r\n"
				+ "</html>");
		
		HttpSession session = request.getSession(true);
		Integer contador = (Integer) session.getAttribute("contador")!=null? (Integer) session.getAttribute("contador"):1;
		
		String valorPulsado = request.getParameter("acceso");
		
		if ("Acceso".equals(valorPulsado)) {
			contador++;
			
			response.getWriter().append("Desde la última vez ha accedido "+ contador +" veces");
		}
		
		if("Nueva sesion".equals(valorPulsado)) {
			response.getWriter().append("Es la primera vez que accede a la web");
			contador=1;
			
		}
		
		// Guardo el valor actualizado del contador en la sesión
		session.setAttribute("contador", contador);
		
	}
}
