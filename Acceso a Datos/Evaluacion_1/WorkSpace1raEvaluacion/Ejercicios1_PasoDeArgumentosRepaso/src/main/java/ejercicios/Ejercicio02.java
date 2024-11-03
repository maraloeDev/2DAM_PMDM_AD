package ejercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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
	private static ArrayList<Persona> listaPersona = new ArrayList<Persona>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio02() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		if (request.getParameter("nombre") != null || request.getParameter("apellido") != null
				|| request.getParameter("edad") != null || request.getParameter("contacto") != null) {

			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String edad = request.getParameter("edad");
			String contacto = request.getParameter("contacto");

			if (listaPersona == null) {
				response.getWriter().append("LA LISTA DE PERSONAS ESTA VACIA");
			} else {

				listaPersona.add(new Persona(nombre, apellido, edad, contacto));
				response.getWriter()
						.append("<html>\r\n" + "<head>\r\n" + "    <meta charset=\"UTF-8\">\r\n"
								+ "    <title>Saludar</title>\r\n" + "</head>\r\n" + "<body>\r\n"
								+ "    <form action=\"Ejercicio02\" method=\"post\">\r\n" + "\r\n"
								+ "        <p>Persona añadida correctamente</p>\r\n"
								+ "        <input type=\"submit\" value=\"Mostrar lista de personas\">\r\n"
								+ "    </form>\r\n" + "</body>\r\n" + "</html>");
			}
		} else {
			response.getWriter()
					.append("No se han establecido en los params de la URI <b> nombre, apellido, edad o telefono </b>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("<html>\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <title>Saludar</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    \r\n"
				+ "    <table border=\"2\">\r\n"
				+ "        <tr>\r\n"
				+ "            <td>NOMBRE</td>\r\n"
				+ "            <td>APELLIDOS</td>\r\n"
				+ "            <td>EDAD</td>\r\n"
				+ "            <td>CONTACTO</td>\r\n"
				+ "        </tr>");
		
		for(Persona p : listaPersona) {
			response.getWriter().append("<tr>\r\n"
					+ "            <td>"+p.getNombre()+"</td>\r\n"
					+ "            <td>"+p.getApellidos()+"</td>\r\n"
					+ "            <td>"+p.getEdad()+"</td>\r\n"
					+ "            <td>"+p.getContacto()+"</td>\r\n"
					+ "        </tr>");
		}

	}

}
