package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio03
 */
public class Ejercicio03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio03() {
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
		response.setContentType("text/html");
		response.getWriter().append("<html>\r\n"
				+ "    <head>\r\n"
				+ "        <title>Ejercicio03Titulo</title>\r\n"
				+ "    </head>\r\n"
				+ "    <body>\r\n"
				+ "        \r\n"
				+ "        <h2>Bienvendo a Web Libreria. Seleccione libro</h2>\r\n"
				+ "\r\n"
				+ "        <form action=\"Ejercicio03\" method=\"post\">\r\n"
				+ "            <select name=\"libros\">\r\n"
				+ "                <option value=\"Java\">Java</option>\r\n"
				+ "                <option value=\"C\">C</option>\r\n"
				+ "                <option value=\"C++\">C++</option>\r\n"
				+ "                <option value=\"VB\">VB</option>\r\n"
				+ "                <option value=\"Phyton\">Phyton</option> \r\n"
				+ "            </select>\r\n"
				+ "            <h2>Unidades: <input type=\"text\" name=\"unidades\"></h2>\r\n"
				+ "            <input type=\"submit\" value=\"Enviar\">\r\n"
				+ "        </form>\r\n"
				+ "    </body>\r\n"
				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("<html>\r\n"
				+ "    <head>\r\n"
				+ "        <title>Ejercicio03_Compra</title>\r\n"
				+ "    </head>\r\n"
				+ "    <body>\r\n"
				+ "        \r\n"
				+ "        <h2>Bienvendo a Web Libreria. Usted selecciono "+request.getParameter("libros")+"</h2>\r\n"
				+ "\r\n"
				+ "        <form action=\"Ejercicio03\" method=\"get\">\r\n"
				+ "\r\n"
				+ "            <a href=\"Ejercicio03\">Sigue Comprando</a>\r\n"
				+ "            <br>\r\n"
				+ "            <br>\r\n"
				+ "            <a href=\"Ejercicio03_VerCompra\">Ver Compra</a>\r\n"
				+ "            \r\n"
				+ "        </form>\r\n"
				+ "    </body>\r\n"
				+ "</html>");
		Cookie c = new Cookie(request.getParameter("libros"), request.getParameter("unidades"));
		response.addCookie(c);
	}

}
