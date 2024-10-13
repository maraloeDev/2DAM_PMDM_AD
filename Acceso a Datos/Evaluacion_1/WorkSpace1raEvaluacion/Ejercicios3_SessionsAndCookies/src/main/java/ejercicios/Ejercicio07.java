package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class Ejercicio07
 */
public class Ejercicio07 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Map<String, Integer> mapaSintomas = new HashMap<String, Integer>();
	private static String sintomasContexto = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio07() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		config.getServletContext().getInitParameter("SintomasContexto");
		
		sintomasContexto = (String) getServletContext().getAttribute("SintomasContexto");
		
		mapaSintomas.put("fiebre", 0);
		mapaSintomas.put("tos", 0);
		mapaSintomas.put("diarrea", 0);
		mapaSintomas.put("olfato", 0);
		mapaSintomas.put("mulcular", 0);
		
		//Establezco los valores del mapa al contexto
		getServletContext().setAttribute("SintomasContexto", mapaSintomas);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Verifico si el usuario ya ha realizado el test mediante cookies
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("testRealizado")) {
                    // Si ya ha hecho el test, muestro un mensaje y no permito repetirlo
                    response.setContentType("text/html");
                    response.getWriter().append("<html lang=\"es\">\r\n"
                        + "<head>\r\n"
                        + "    <meta charset=\"UTF-8\">\r\n"
                        + "    <title>Test COVID-19</title>\r\n"
                        + "</head>\r\n"
                        + "<body>\r\n"
                        + "<h3> No puede volver a repetir el test.</h3>\r\n"
                        + "</body>\r\n"
                        + "</html>");
                }
            }
        }

        // Genero el formulario HTML para seleccionar los síntomas
        response.setContentType("text/html");
        response.getWriter().append("<html lang=\"es\">\r\n"
                + "<head>\r\n"
                + "    <meta charset=\"UTF-8\">\r\n"
                + "    <title>Test COVID-19</title>\r\n"
                + "</head>\r\n"
                + "<body>\r\n"
                + "\r\n"
                + "    <h3>TEST COVID-19</h3>\r\n"
                + "    <hr color=\"blue\">\r\n"
                + "    <form action= Ejercicio07 method = get>\r\n"
                + "        <input type=\"checkbox\" id=\"fiebre\" name=\"sintoma\" value=\"fiebre\">\r\n"
                + "        <label for=\"fiebre\">FIEBRE</label><br>\r\n"
                + "        \r\n"
                + "        <input type=\"checkbox\" id=\"tos\" name=\"sintoma\" value=\"tos\">\r\n"
                + "        <label for=\"tos\">TOS SECA</label><br>\r\n"
                + "        \r\n"
                + "        <input type=\"checkbox\" id=\"diarrea\" name=\"sintoma\" value=\"diarrea\">\r\n"
                + "        <label for=\"diarrea\">DIARREA</label><br>\r\n"
                + "        \r\n"
                + "        <input type=\"checkbox\" id=\"olfato\" name=\"sintoma\" value=\"olfato\">\r\n"
                + "        <label for=\"olfato\">PÉRDIDA DE OLFATO</label><br>\r\n"
                + "        \r\n"
                + "        <input type=\"checkbox\" id=\"muscular\" name=\"sintoma\" value=\"muscular\">\r\n"
                + "        <label for=\"muscular\">DOLOR MUSCULAR</label><br><br>\r\n"
                + "        \r\n"
                + "        <input type=\"submit\" value=\"Enviar\">\r\n"
                + "    </form>\r\n"
                + "    <hr color=\"blue\">\r\n"
                + "\r\n"
                + "</body>\r\n"
                + "</html>\r\n");

        // Si el usuario seleccionó algún síntoma
        if (request.getParameterValues("sintoma") != null) {

            // Recojo los valores de los síntomas seleccionados
            String[] sintomasSeleccionados = request.getParameterValues("sintoma");

            // Introduzco en el mapa los valores del contexto tiposSintomas
            mapaSintomas = (Map<String, Integer>) getServletContext().getAttribute("SintomasContexto");

            // Recorro el array de los tipos de síntomas seleccionados y actualizo el mapa
            for (String sintoma : sintomasSeleccionados) {
                mapaSintomas.put(sintoma, mapaSintomas.getOrDefault(sintoma, 0) + 1);
            }

            // Actualizo la variable del contexto con los síntomas actuales
            getServletContext().setAttribute("SintomasContexto", mapaSintomas);

            // Después de que el usuario complete el test, creo una cookie que indica que ya realizó el test
            Cookie testCookie = new Cookie("testRealizado", "true");
            response.addCookie(testCookie);

            // Creo la tabla con las estadísticas de síntomas
            response.getWriter().append("<h3>Estadísticas de síntomas:</h3>\r\n");
            response.getWriter().append("<table border='1' cellpadding='10' cellspacing='0'>"
                    + "<tr><th>Síntoma</th><th>Personas que lo tienen</th></tr>");

            // Recorro el mapa añadiendo la key y el valor
            for (Map.Entry<String, Integer> entry : mapaSintomas.entrySet()) {
                response.getWriter().append("<tr><td>" + entry.getKey() + "</td><td>" + entry.getValue() + "</td></tr>");
            }

            response.getWriter().append("</table>");
            response.getWriter().append("</html>");

        } else {
            response.getWriter().append("No has seleccionado ningún síntoma.");
        }
    }
}