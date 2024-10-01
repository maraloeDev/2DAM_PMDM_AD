package Servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejemplo7
 */
@WebServlet("/Ejemplo07")
public class Ejemplo07 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String paramContext="";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejemplo07() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        
        // No podemos crear o modificar parámetros de inicialización una vez que el contexto está en funcionamiento
        // Este código comentado intenta cambiar un parámetro de inicialización, lo cual no está permitido en tiempo de ejecución
        // config.getServletContext().setInitParameter("paramContext", "paramContext");

        // Recuperamos el parámetro de inicialización del contexto de la aplicación con el nombre "prueba"
        paramContext = config.getServletContext().getInitParameter("prueba");
        
        // Establecemos un atributo en el contexto de la aplicación con el nombre "attribContext" y el valor "ATRIBUTO DE DAM"
        // A diferencia de los parámetros de inicialización, los atributos pueden ser creados y modificados en tiempo de ejecución
        config.getServletContext().setAttribute("attribContext", "ATRIBUTO DE DAM");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        response.setContentType("text/html");

        // Escribimos en el cuerpo de la respuesta el valor del parámetro de inicialización del contexto
        response.getWriter().append("Parametro de inicializacion del contexto: " + paramContext);
        response.getWriter().append("<br>");

        // Escribimos en el cuerpo de la respuesta el valor del atributo del contexto "attribContext"
        response.getWriter().append("Atributo del contexto: " + getServletContext().getAttribute("attribContext"));
    }
}
