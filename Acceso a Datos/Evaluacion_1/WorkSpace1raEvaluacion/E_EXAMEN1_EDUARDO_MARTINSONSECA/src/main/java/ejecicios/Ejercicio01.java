package ejecicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio01
 */
public class Ejercicio01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio01() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		response.getWriter().append("<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>APPLICATION FORM DAM</title>\r\n" + "</head>\r\n" + "<body>\r\n"
				+ "	<form action=\"Ejercicio01\" method=\"post\">\r\n" + "		<h1>CV EUROPASS</h1>\r\n"
				+ "		<fieldset>\r\n" + "			<table >\r\n" + "				<tr>\r\n"
				+ "					<th>Firts Name</th>\r\n"
				+ "					<td><input type='text' name=\"nombre\"></td>\r\n" + "				</tr>	\r\n"
				+ "				<tr>\r\n" + "					<th>Last Name</th>\r\n"
				+ "					<td><input type='text' name=\"apellidos\"></td>\r\n" + "				</tr>\r\n"
				+ "				<tr>\r\n" + "					<th>Age</th>\r\n"
				+ "					<td><input type='text' name=\"edad\"></td>\r\n" + "				</tr>\r\n"
				+ "				<tr>\r\n" + "					<th>Email Address</th>\r\n"
				+ "					<td><input type='text' name=\"email\"></td>\r\n" + "				</tr>\r\n"
				+ "\r\n" + "				<tr>\r\n" + "					<th>Position Available I</th>\r\n"
				+ "					<td><select name=\"posicion\" multiple>\r\n"
				+ "							<option value=\"Hardware\">Hardware</option>\r\n"
				+ "							<option value=\"Software\">Software</option>\r\n"
				+ "							<option value=\"Maintenance\">Maintenance</option>\r\n"
				+ "					</select></td>\r\n" + "\r\n" + "				</tr>\r\n"
				+ "				<tr>\r\n" + "					<th>Position Available II</th>\r\n"
				+ "					<td><input type='radio' name=\"nivel\" value=\"Junior\">Junior\r\n"
				+ "						<input type='radio' name=\"nivel\" value=\"Mid-level\">Mid-level\r\n"
				+ "						<input type='radio' name=\"nivel\" value=\"Senior\">Senior</td>\r\n"
				+ "				</tr>\r\n" + "				<tr>\r\n"
				+ "					<th>Programming Languages</th>\r\n"
				+ "					<td><input type='checkbox' name=\"lenguaje\" value=\"Java\">Java\r\n"
				+ "						<input type='checkbox' name=\"lenguaje\" value=\"Javascript\">Javascript\r\n"
				+ "						<input type='checkbox' name=\"lenguaje\" value=\"Python\">Python\r\n"
				+ "					</td>\r\n" + "				</tr>\r\n" + "				<tr>\r\n"
				+ "					<td></td>\r\n"
				+ "					<td align=\"right\"><input type='submit' name=''\r\n"
				+ "						value='Send'></td>\r\n" + "				</tr>\r\n" + "			</table>\r\n"
				+ "		</fieldset>\r\n" + "	</form>\r\n" + "</body>\r\n" + "</html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellidos");
		String edad = request.getParameter("edad");
		String email = request.getParameter("email");
		
		String posicion[] = request.getParameterValues("posicion");
		String nivel[] = request.getParameterValues("nivel");
		String lenguaje[] = request.getParameterValues("lenguaje");
		
		
		
		
		response.setContentType("text/html");
		response.getWriter().append("<!DOCTYPE html>\r\n"
		        + "<html lang=\"es\">\r\n"
		        + "<head>\r\n"
		        + "    <meta charset=\"UTF-8\">\r\n"
		        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
		        + "    <title>Tabla de Empleados</title>\r\n"
		        + "</head>\r\n"
		        + "<body>\r\n"
		        + "    <table border=\"2\">\r\n"
		        + "        <tr>\r\n"
		        + "            <th>First Name</th>\r\n"
		        + "            <th>Last Name</th>\r\n"
		        + "            <th>Age</th>\r\n"
		        + "            <th>Email Address</th>\r\n"
		        + "            <th>Position Available I</th>\r\n"
		        + "            <th>Position Available II</th>\r\n"
		        + "            <th>Programming Language</th>\r\n"
		        + "        </tr>\r\n"
		        + "        <tr>\r\n"
		        + "            <td>" + nombre + "</td>\r\n"
		        + "            <td>" + apellido + "</td>\r\n"
		        + "            <td>" + edad + "</td>\r\n"
		        + "            <td>" + email + "</td>\r\n");

		for (String posicionSelect : posicion) {
		    response.getWriter().append("            <td>" + posicionSelect + "</td>\r\n");
		}

		for (String nivelSelect : nivel) {
		    response.getWriter().append("            <td>" + nivelSelect + "</td>\r\n");
		}

		for (String lenguajeSelect : lenguaje) {
		    response.getWriter().append("            <td>" + lenguajeSelect + "</td>\r\n");
		}

		response.getWriter().append("        </tr>\r\n"
		        + "    </table>\r\n"
		        + "</body>\r\n"
		        + "</html>");

	}
}

