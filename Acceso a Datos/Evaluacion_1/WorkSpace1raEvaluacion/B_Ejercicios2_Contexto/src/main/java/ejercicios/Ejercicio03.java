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
			super.init(config);

			//Recupero el contador de visitas en param-name
			config.getServletContext().getInitParameter("nVisitas");
}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Recuperamos el contador de visitas del contexto
        Integer contadorVisitas = (Integer) getServletContext().getAttribute("contadorVisitas");
        
        // Si es la primera visita, inicializamos el contador
        if (contadorVisitas == null) {
            contadorVisitas = 0;
        }
        
        contadorVisitas++;
        
        // Guardamos el contador actualizado en el contexto de la aplicación
        getServletContext().setAttribute("contadorVisitas", contadorVisitas);
        
        // Mostramos el contador de visitas en la respuesta al usuario
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Contador de visitas</h1>");
        response.getWriter().println("<p>Este servlet ha sido visitado " + contadorVisitas + " veces.</p>");
        response.getWriter().println("</body></html>");
    }

}
