package ejercicios;

import jakarta.servlet.ServletConfig;
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
		response.getWriter().append("<html lang=\"es\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <title>Ejercicio05</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <h1>DATOS MATRÍCULA</h1>\r\n"
				+ "\r\n"
				+ "    <form action=\"Ejercicio05\" method=\"post\">\r\n"
				+ "        <!-- Selección de asignaturas -->\r\n"
				+ "        <label for=\"asignaturas\">Asignatura/s:</label><br>\r\n"
				+ "        <select id=\"asignaturas\" name=\"asignaturas\" multiple>\r\n"
				+ "            <option value=\"matematicas\">Matemáticas</option>\r\n"
				+ "            <option value=\"literatura\">Literatura</option>\r\n"
				+ "            <option value=\"ingles\">Inglés</option>\r\n"
				+ "            <option value=\"tecnologia\">Tecnología</option>\r\n"
				+ "        </select><br><br>\r\n"
				+ "\r\n"
				+ "        <!-- Selección de sexo -->\r\n"
				+ "        <label>Sexo:</label><br>\r\n"
				+ "        <input type=\"radio\" id=\"hombre\" name=\"sexo\" value=\"hombre\">\r\n"
				+ "        <label for=\"hombre\">Hombre</label>\r\n"
				+ "        <input type=\"radio\" id=\"mujer\" name=\"sexo\" value=\"mujer\">\r\n"
				+ "        <label for=\"mujer\">Mujer</label><br><br>\r\n"
				+ "\r\n"
				+ "        <!-- Actividades extraescolares -->\r\n"
				+ "        <label>Actividades extraescolares:</label><br>\r\n"
				+ "        <input type=\"checkbox\" id=\"musica\" name=\"actividades\" value=\"musica\">\r\n"
				+ "        <label for=\"musica\">Música</label>\r\n"
				+ "        <input type=\"checkbox\" id=\"futbol\" name=\"actividades\" value=\"futbol\">\r\n"
				+ "        <label for=\"futbol\">Fútbol</label>\r\n"
				+ "        <input type=\"checkbox\" id=\"teatro\" name=\"actividades\" value=\"teatro\">\r\n"
				+ "        <label for=\"teatro\">Teatro</label><br><br>\r\n"
				+ "\r\n"
				+ "        <!-- Botón de envío -->\r\n"
				+ "        <input type=\"submit\" value=\"Enviar\">\r\n"
				+ "    </form>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String[] asignaturasSeleccionadas = request.getParameterValues("asignaturas");
		String[] sexoSeleccionado = request.getParameterValues("sexo");
		String[] actividadesExtraEscolares = request.getParameterValues("actividades");
		
		response.getWriter().append("Usted a seleccionado la asignatura de: ");
		for(String asignatura : asignaturasSeleccionadas) {
			
response.getWriter().append("<html>\r\n"
		+ "    <head>  \r\n"
		+ "        <title>Ejercicio05</title>\r\n"
		+ "    </head>\r\n"
		+ "\r\n"
		+ "    <body>\r\n"
		+ "        <ul>\r\n"
		+ "            <li>"+asignatura+"</li>\r\n"
		+ "        </ul>\r\n"
		+ "    </body>\r\n"
		+ "</html>");
		}
		
		for(String sexoSetect : sexoSeleccionado) {
			
			response.getWriter().append("El sexo seleccionado es " + sexoSetect + "<br>");
					}
		response.getWriter().append("La actividad extra escolar seleccionada es: ");
		for(String actividades : actividadesExtraEscolares) {
			
			response.getWriter().append("<html>\r\n"
					+ "    <head>  \r\n"
					+ "        <title>Ejercicio05</title>\r\n"
					+ "    </head>\r\n"
					+ "\r\n"
					+ "    <body>\r\n"
					+ "        <ul>\r\n"
					+ "            <li>"+actividades+"</li>\r\n"
					+ "        </ul>\r\n"
					+ "    </body>\r\n"
					+ "</html>");
			
					}
	}
}
