package Servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class Ejercicio02
 */
public class Ejercicio02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArrayList<Persona> datosPersonas;

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

		datosPersonas = new ArrayList();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getParameter("text/html");
		if (request.getParameter("nombre") != null || request.getParameter("apellido") != null
				|| request.getParameter("edad") != null || request.getParameter("contacto") != null) {

			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String edad = request.getParameter("edad");
			String contacto = request.getParameter("contacto");

			datosPersonas.add(new Persona(nombre, apellido, edad, contacto));

			response.getWriter().append("<!DOCTYPE html>\r\n" + "<html lang=\"es\">\r\n" + "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>Mostrar Datos</title>\r\n" + "</head>\r\n" + "<body>\r\n" + "\r\n"
					+ "    <h1>Mostrar Datos</h1>\r\n" + "\r\n" + "    <table border=\"1\" cellpadding=\"8\">\r\n"
					+ "        <tr>\r\n" + "            <th>Nombre</th>\r\n" + "            <th>Apellidos</th>\r\n"
					+ "            <th>edad</th>\r\n" + "            <th>Contacto</th>\r\n" + "        <tr>\r\n");

			for (Persona datosP : datosPersonas) {

				response.getWriter()
						.append("<tr>\r\n" + "<td> " + datosP.getNombre() + "</td>\r\n" + "<td>" + datosP.getApellido()
								+ "</td>\r\n" + "<td>" + datosP.getEdad() + "</td>\r\n" + "<td>" + datosP.getContacto()
								+ "</td>\r\n" + "</tr>");
			}

			response.getWriter().append("</table>");
			response.getWriter().append("</body>");
			response.getWriter().append("</html>");
			response.getWriter().close();

		} else {
			response.getWriter().append("Params no encontrados");
		}
		datosPersonas.clear();
	}

}
