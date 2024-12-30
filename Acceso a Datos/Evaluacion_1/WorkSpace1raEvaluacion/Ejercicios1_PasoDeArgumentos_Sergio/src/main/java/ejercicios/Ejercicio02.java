package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import clases.Persona;

/**
 * Servlet implementation class Ejercicio02
 */
public class Ejercicio02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArrayList<Persona> datosPersona = new ArrayList<Persona>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio02() {
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
		if(request.getParameter("nombre")!=null 
				|| request.getParameter("apellidos")!=null 
				|| request.getParameter("edad")!=null 
				|| request.getParameter("contacto")!=null) {
			
			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellidos");
			String edad = request.getParameter("edad");
			String contacto = request.getParameter("contacto");
			
			datosPersona.add(new Persona(nombre, apellidos, Integer.parseInt(edad), contacto));
			
			response.getWriter().append("<table border=\"2\">\r\n"
					+ "    <tr>\r\n"
					+ "        <td>NOMBRE</td>\r\n"
					+ "        <td>APELLIDOS</td>\r\n"
					+ "        <td>EDAD</td>\r\n"
					+ "        <td>CONTACTO</td>\r\n"
					+ "    </tr>");
			
			for(Persona datosP : datosPersona) {
				response.getWriter().append("<tr>"
						+ "        <td>"+datosP.getNombre()+"</td>\r\n"
						+ "        <td>"+datosP.getApellidos()+"</td>\r\n"
						+ "        <td>"+datosP.getEdad()+" </td>\r\n"
						+ "        <td>"+datosP.getContacto()+"</td>\r\n"
						+ "    </tr>");
			}
			response.getWriter().append("</table></body></html>").close();
			
			
		} else {
			response.getWriter().append("No se han pasado los parametros de nombre, apellidos, edad o contacto");
		}
		datosPersona.clear();
	}

}
