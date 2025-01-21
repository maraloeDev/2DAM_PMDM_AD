package Servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejemplo03
 */
public class Ejemplo_03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejemplo_03() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    
    // Este metodo inicializa el servlet
    
    //Método que se ejecuta al inicio del ciclo de vida de un servlet.
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	
	//En este metodo, se indica las operaciones que quieres hacer una vez que se destruya el servlet
	
	//método que se ejecuta al final del ciclo de vida del servlet.
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	
	//El método service se usa cuando el servidor web recibe una petición para un servlet, se pasan 2 tipos de parametros
	
						 //HttpServletRequest, representa la petición del cliente
													 //HttpServletResponse, representa la respuesta del servidor
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain"); //Sirve para establecer el tipo de respuesta que se va a dar, si  trata de una página web, se usa "text/html".
		response.getWriter().append("Hola, que tal");
		response.getWriter().close();
	}

}
