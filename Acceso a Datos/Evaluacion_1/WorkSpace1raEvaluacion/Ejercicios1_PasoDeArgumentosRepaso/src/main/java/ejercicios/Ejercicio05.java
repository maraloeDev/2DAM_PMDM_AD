package ejercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio05
 */
public class Ejercicio05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio05() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("<html>\r\n"
				+ "<head>\r\n"
				+ "    <title>Ejercicio05</title>\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<form action=\"Ejercicio05\" method=\"post\">\r\n"
				+ "\r\n"
				+ "        <h1>DATOS MATRICULA</h1>\r\n"
				+ "\r\n"
				+ "        Asignatura/s:   <select name=\"asignaturas\" id=\"\" multiple>\r\n"
				+ "            <option value=\"Matematicas\">Matematicas</option>\r\n"
				+ "            <option value=\"Lengua\">Lengua</option>\r\n"
				+ "            <option value=\"Fisica\">Fisica</option>\r\n"
				+ "            <option value=\"Quimica\">Quimica</option>\r\n"
				+ "            <option value=\"Ingles\">Ingles</option>\r\n"
				+ "        </select>\r\n"
				+ "\r\n"
				+ "        <br>\r\n"
				+ "        <br>\r\n"
				+ "        Sexo: \r\n"
				+ "        <input type=\"radio\" name=\"sexo\" value=\"Hombre\">Hombre \r\n"
				+ "        <input type=\"radio\" name=\"sexo\" value=\"Mujer\">Mujer\r\n"
				+ "        <br>\r\n"
				+ "        <br>\r\n"
				+ "        Actividades extraescolares:\r\n"
				+ "        <input type=\"checkbox\" name=\"actividades\" value=\"Deporte\">Futbol\r\n"
				+ "        <input type=\"checkbox\" name=\"actividades\" value=\"Musica\">Musica\r\n"
				+ "        <input type=\"checkbox\" name=\"actividades\" value=\"Teatro\">Teatro\r\n"
				+ "\r\n"
				+ "        <br>\r\n"
				+ "        <br>\r\n"
				+ "       <input type=\"submit\" value=\"Enviar\">\r\n"
				+ "</form>\r\n"
				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		response.getWriter().append("ASIGNATURAS ELEGIDAS:");
		
		for(String asignaturasElegidas : request.getParameterValues("asignaturas")) {
				response.getWriter().append("<ul><li>"+asignaturasElegidas.toString()+"</li></ul>");
		}
		
		response.getWriter().append("Sexo: " + request.getParameter("sexo") + "<br>");
		
		response.getWriter().append("ACTIVIDADES ELEGIDAS:");
		
		for(String actividadesElegidas : request.getParameterValues("actividades")) {
				response.getWriter().append("<ul><li>"+actividadesElegidas+"</li></ul>");

		}
	}

}
