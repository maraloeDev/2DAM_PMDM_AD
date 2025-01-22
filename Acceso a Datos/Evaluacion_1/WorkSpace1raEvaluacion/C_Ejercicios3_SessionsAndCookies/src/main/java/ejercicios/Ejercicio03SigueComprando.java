package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio03SigueComprando
 */
public class Ejercicio03SigueComprando extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio03SigueComprando() {
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
		
		// Recojo en la cookie, lo que va a introducir el usuario y guardarlo
		Cookie c = new Cookie(request.getParameter("listadoLibros"), request.getParameter("Unidades"));
		c.setMaxAge(60 * 60);
		
		response.getWriter().append("<html>\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <title>Ejercicio03</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <h1>Bienvenido a Web Librería. Usted selecciono "+request.getParameter("listadoLibros")+" </h1>\r\n"
				+ "\r\n"
				+ "    <a href=\"Ejercicio03.html\"> Seguir Compando</a>\r\n"
				+ "    <br>\r\n"
				+ "    <br>\r\n"
				+ "    <a href=\"Ejercicio03_VerCompra\"> Ver compra</a>\r\n"
				+ "\r\n"
				+ "</form>\r\n"
				+ "</body>\r\n"
				+ "</html>\r\n"
				+ "");
		
		//Una vez clicado en Enviar, se guarda la cookie del lado del cliente
		response.addCookie(c);
		
	}

}
