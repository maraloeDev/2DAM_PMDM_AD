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
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		response.getWriter().append("<html>\r\n"
				+ "    <head>\r\n"
				+ "        <title>Untitled-1</title>\r\n"
				+ "    </head>\r\n"
				+ "    <body>\r\n"
				+ "        <h3>Tienda LetreA</h3>\r\n"
				+ "\r\n"
				+ "        <form action=\"Ejercicio01\" method=\"get\">\r\n"
				+ "            <input type=\"submit\" name=\"letra\" value=\"A\">\r\n"
				+ "            <input type=\"submit\" name=\"letra\" value=\"B\">\r\n"
				+ "            <input type=\"submit\" name=\"letra\" value=\"C\">\r\n"
				+ "            <input type=\"submit\" name=\"letra\" value=\"D\">\r\n"
				+ "            <br>\r\n"
				+ "            <br>\r\n"
				+ "            <input type=\"submit\" name=\"letra\" value=\"Ticket\">\r\n"
				+ "        </form>\r\n"
				+ "    </body>\r\n"
				+ "</html>");
		HttpSession session = request.getSession(true);
		
		Integer precio = (Integer)session.getAttribute("precio")!=null ? (Integer)session.getAttribute("precio") : 0;
		
		String precioLetras = request.getParameter("letra");
		switch(precioLetras) {
		
		case "A" :
			precio+=3;
			break;
			
		case "B" :
			precio+=4;
			break;
			
		case "C" :
			precio+=5;
			break;
			
		case "D" :
			precio+=1;
			break;
		case "Ticket" :
			response.getWriter().append("El total de las letras pulsadas es de " + precio);
			
		}
		session.setAttribute("precio", precio);
	}
}