package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio03_ServletError
 */
@WebServlet("/Ejercicio03_ServletError")
public class Ejercicio03_ServletError extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio03_ServletError() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String msjErroneo = (String) getServletContext().getAttribute("mensajeError");
		
		response.setContentType("text/html");
		response.getWriter().append("<html>\r\n"
				+ "	<head>\r\n"
				+ "		<title>Ejercicio03</title>\r\n"
				+ "	</head>\r\n"
				+ "	<body>\r\n"
				+ "			<h3 style=\"text-align: center;\">MENSAJE DEL SERVIDOR</h3>\r\n"
				+ "			<hr>\r\n"
				+ "			<h4 style=\"text-align: center; color: red;\">"+ msjErroneo +"</h4>\r\n"
				+ "			<br>\r\n"
				+ "			<a href=\"Ejercicio03_ServletDespachador\" style=\"text-align: center; margin: 47%;\">Vover</a>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}

}
