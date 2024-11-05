package ejercicios;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("<html>\r\n"
				+ "    <head>\r\n"
				+ "        <title>Ejercicio01</title>\r\n"
				+ "        <meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\">\r\n"
				+ "    </head>\r\n"
				+ "    <body>\r\n"
				+ "        <form action=\"Ejercicio01\" method=\"post\">\r\n"
				+ "            <h2>Pagina de Acceso</h2> \r\n"
				+ "\r\n"
				+ "            Usuario: <input type=\"text\" name=\"usuario\" size=\"20\" maxlength=\"20\"><br>\r\n"
				+ "            Contraseña: <input type=\"password\" name=\"contrasena\" size=\"20\" maxlength=\"20\"><br>\r\n"
				+ "            <input type=\"submit\" value=\"Enviar\">\r\n"
				+ "        </form>\r\n"
				+ "    </body>\r\n"
				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("contrasena").equals("admin")) {
		
		RequestDispatcher requestDispatcherTrue = request.getRequestDispatcher("/Ejercicio01b");
		request.setAttribute("usuario", request.getParameter("usuario"));
		requestDispatcherTrue.forward(request, response);
	} else {
		RequestDispatcher requestDispatcherFalse = request.getRequestDispatcher("/Ejercicio01c");
		requestDispatcherFalse.forward(request, response);
	}
}
}