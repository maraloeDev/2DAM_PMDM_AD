package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
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
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
			// Datos a recojer del parametro
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String direccion = request.getParameter("direccion");
			String tarjeta = request.getParameter("tarjeta");
			String numTarjeta = request.getParameter("numTarjeta");

			response.getWriter()
					.append("<!DOCTYPE html>\r\n" + "\r\n" + " <html lang=\"es\">\r\n" + " <head>\r\n"
							+ "     <meta charset=\"UTF-8\">\r\n"
							+ "     <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
							+ "     <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
							+ "     <title>EJERCICIO 03</title>\r\n" + " </head>\r\n" + " <body>\r\n"
							+ "     <table border= 2>\r\n" + "         <tr>\r\n"
							+ "             <td><strong>Nombre</strong></td>\r\n"
							+ "             <td><strong>Apellidos</strong></td>\r\n"
							+ "             <td><strong>Dirección</strong></td>\r\n"
							+ "             <td><strong>Tarjeta</strong></td>\r\n"
							+ "             <td><strong>Número Tarjeta</strong></td>\r\n");

			response.getWriter().append("<tr>");
			response.getWriter().append("<td>" + nombre + "</td>");
			response.getWriter().append("<td>" + apellido + "</td>");
			response.getWriter().append("<td>" + direccion + "</td>");
			response.getWriter().append("<td>" + tarjeta + "</td>");
			response.getWriter().append("<td>" + numTarjeta + "</td>");
			response.getWriter().append("</tr>");
			response.getWriter().append("</table>");
			response.getWriter().append("</body>");
			response.getWriter().append("</html>");
			response.getWriter().close();

		}
	}
