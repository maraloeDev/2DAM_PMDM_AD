package ejercicios;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio03_ServletDespachador
 */
@WebServlet("/Ejercicio03_ServletDespachador")
public class Ejercicio03_ServletDespachador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio03_ServletDespachador() {
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
		response.setContentType("text/html");
		response.getWriter().append("<html>\r\n"
				+ "	<head>\r\n"
				+ "		<title>Ejercicio03</title>\r\n"
				+ "	</head>\r\n"
				+ "	<body>\r\n"
				+ "			<form action=\"Ejercicio03_ServletDespachador\" method=\"post\">	\r\n"
				+ "				Texto a escribir <input type=\"text\" name=\"texto\">\r\n"
				+ "			<br>\r\n"
				+ "			<input type=\"submit\" value=\"Enviar\">\r\n"
				+ "			</form>\r\n"
				+ "</body>\r\n"
				+ "</html>");
		response.getWriter().close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		response.getWriter().append("<html><body>");
        String textoEscrito = request.getParameter("texto");
        RequestDispatcher laCabecera ;
        if (textoEscrito.isEmpty()) {
        	RequestDispatcher elDespachadorErroneo = request.getRequestDispatcher("/Ejercicio03_ServletError");

            getServletContext().setAttribute("mensajeError", "NO HAS INTRODUCIDO NINGUN TEXTO");
            elDespachadorErroneo.forward(request, response);
        } else {
        	
        	 laCabecera = request.getRequestDispatcher("/cabecera.html");
            laCabecera.include(request, response);
        	 
        	 response.getWriter().append("<h3>Has tecleado "+textoEscrito+" </h3>"
        	 		+ "<p> Has delegado el procesamiento de la petición al servlet servlet.ServletDespachador "+this.getClass().getName()+"</p>");
        	         	 
        	 RequestDispatcher elPie = request.getRequestDispatcher("/pie.html");
        	 elPie.include(request, response);
        	 response.getWriter().append("</body></html>");
        	response.getWriter().close();
        }
	}

}
