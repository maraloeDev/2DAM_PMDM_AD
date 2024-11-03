package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import clases.Persona;

/**
 * Servlet implementation class Ejercicio02b
 */
public class Ejercicio02b extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio02b() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Persona> mostrarPersonas = (ArrayList<Persona>) getServletContext().getAttribute("listaPersonas");
		
		response.getWriter().append("<table border=\"2\">\r\n"
				+ "                <tr>\r\n"
				+ "                    <td>NOMBRE</td>\r\n"
				+ "                    <td>EDAD</td>\r\n"
				+ "                    <td>TELEFONO</td>\r\n"
				+ "                </tr>");
		
		for(Persona lasPersonas : mostrarPersonas) {
			
			response.getWriter().append("<tr>\r\n"
					+ "                    <td>"+lasPersonas.getNombre()+"</td>\r\n"
					+ "                    <td>"+lasPersonas.getEdad()+"</td>\r\n"
					+ "                    <td>"+lasPersonas.getTelefono()+"</td>\r\n"
					+ "                </tr>");
		}
	}

}
