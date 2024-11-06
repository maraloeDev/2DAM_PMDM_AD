package ejercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio01c
 */
public class Ejercicio01c extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio01c() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("<html>\r\n"
				+ "    <head>\r\n"
				+ "        <title>Ejercicio05</title>\r\n"
				+ "        <meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\">\r\n"
				+ "    </head>\r\n"
				+ "    <body>\r\n"
				+ "        <form action=\"Ejercicio01\" method=\"post\">\r\n"
				+ "            <h2>Error | La clave ingresada no es correcta</h2>\r\n"
				+ "            <a href=\"Ejercicio01\">Volver</a>\r\n"
				+ "        </form>\r\n"
				+ "    </body>\r\n"
				+ "</html>");
	}
}
