package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio02_ServletTablas
 */
@WebServlet("/Ejercicio02_ServletTablas")
public class Ejercicio02_ServletTablas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio02_ServletTablas() {
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
		
		String valor = (String) getServletContext().getAttribute("ElNumero");
		String color = (String) getServletContext().getAttribute("colorTable");

	    response.getWriter().append("<html>\r\n"
	        + "    <head>\r\n"
	        + "        <title>Ejercicio02</title>\r\n"
	        + "    </head>\r\n"
	        + "\r\n"
	        + "    <body>\r\n"
	        + "        <hr>\r\n"
	        + "        <h3 style=\"text-align: center;\">Tabla de multiplicar del " + valor + "</h3>\r\n"
	        + "        <hr>\r\n"
	        + "\r\n"
	        + "        <table border=\"2\" style=\"background-color: " + color + ";\">\r\n");

	    for (int i = 1; i <= 10; i++) {
	        int resultado = Integer.parseInt(valor) * i;
	        response.getWriter().append("            <tr>\r\n"
	            + "                <td>" + valor + " x " + i + "</td>\r\n"
	            + "                <td>" + resultado + "</td>\r\n"
	            + "            </tr>\r\n");
	    }

	    response.getWriter().append("        </table>\r\n"
	        + "        <hr>\r\n"
	        + "        <a href=\"Ejercicio02_ServletDespachador\">Volver</a>\r\n"
	        + "    </body>\r\n"
	        + "</html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
