package Ejercicios;

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
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Crear una aplicación que
		 *  desde URL deberá aparecer en pantalla un botón con el texto “Salúdame”.
		 *   Al pulsar este botón aparecerá en pantalla el mensaje “Hola mundo”.
		 *    El botón de la aplicación deberá ser un input de tipo submit de un formulario HTML. 
		 *    El servlet deberá ser llamado mediante el método GET. ¿Qué ocurre?
		 *    
		 *    Cuando se clica en el Boton "Saludame", el servidor responde al cliente un "Hola Mundo"
		 */
		response.setContentType("text/html"); //Tipo de respuesta
		response.getWriter().append("Hola Mundo");
		
		//Diferencias ??
		
		/**
		 * response.getWriter().append("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <p>Hola Mundo</p>\r\n"
				+ "</body>\r\n"
				+ "</html>");
		 */
	}
}
