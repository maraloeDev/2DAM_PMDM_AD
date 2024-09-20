package servlet;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejemplo02
 */
@WebServlet("/Ejemplo02")
public class Ejemplo02 extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Ejemplo02() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
		response.setContentType("text/html");
response.getWriter().append("<!DOCTYPE html>\r\n"
		+ "<html>\r\n"
		+ "<head>\r\n"
		+ "<meta charset=\"UTF-8\">\r\n"
		+ "<title>Ejemplo01_webapp-app-example</title>\r\n"
		+ "</head>\r\n"
		+ "<body>\r\n"
		+ "\r\n"
		+ "    <h1>Hola</h1>\r\n"
		+ "    <p>Hello World</p>\r\n"
		+ "\r\n"
		+ "</body>\r\n"
		+ "</html>");
response.getWriter().close();
	}

}
