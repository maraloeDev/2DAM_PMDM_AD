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

        
        // Recuperamos el parámetro de inicialización del contexto de la etiqueta param-name
        paramContext = config.getServletContext().getInitParameter("param");
        
        						 //SetAtribute se usa para almacenar un atributo
// El primer parametro es el identificador del atributo, y el segundo es el valor que deseas asociar con esa clave
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
        																		  //getAttribute, permite consultar el valor de un atributo que hayas guardado previamente en el contexto.	
        response.getWriter().append("Atributo del contexto: " + getServletContext().getAttribute("attribContext"));
    }
}
