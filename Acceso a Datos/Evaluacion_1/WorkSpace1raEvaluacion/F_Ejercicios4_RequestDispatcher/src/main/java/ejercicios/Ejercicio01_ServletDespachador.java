package ejercicios;

import jakarta.servlet.RequestDispatcher;
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
@WebServlet ("/Ejercicio01_ServletDespachador")
public class Ejercicio01_ServletDespachador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio01_ServletDespachador() {
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
        
        // Configurar la respuesta
        response.setContentType("text/html");

            response.getWriter().append("<!DOCTYPE html>\r\n"
                    + "<html lang=\"es\">\r\n"
                    + "<head>\r\n"
                    + "    <meta charset=\"UTF-8\">\r\n"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
                    + "    <title>Página de Acceso</title>\r\n"
                    + "</head>\r\n"
                    + "<body>\r\n"
                    + "    <h1>Página de Acceso</h1>\r\n"
                    + "    <form action=\"Ejercicio01_ServletDespachador\" method=\"post\">\r\n"
                    + "        <table>\r\n"
                    + "            <tr>\r\n"
                    + "                <td><label for=\"usuario\">Usuario</label></td>\r\n"
                    + "                <td><input type=\"text\" id=\"usuario\" name=\"usuario\"></td>\r\n"
                    + "            </tr>\r\n"
                    + "            <tr>\r\n"
                    + "                <td><label for=\"clave\">Clave</label></td>\r\n"
                    + "                <td><input type=\"password\" id=\"clave\" name=\"clave\"></td>\r\n"
                    + "            </tr>\r\n"
                    + "            <tr>\r\n"
                    + "                <td colspan=\"2\">\r\n"
                    + "                    <input type=\"submit\" value=\"Entrar\">\r\n"
                    + "                </td>\r\n"
                    + "            </tr>\r\n"
                    + "        </table>\r\n"
                    + "    </form>\r\n"
                    + "</body>\r\n"
                    + "</html>\r\n");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String clave = request.getParameter("clave");
            if (clave.equalsIgnoreCase("admin")) {
            	
            	String usuario = request.getParameter("usuario");
            	
                RequestDispatcher otroServlet = request.getRequestDispatcher("Ejercicio01_ServletBienvenida");
                request.setAttribute("usuario", usuario);
                otroServlet.forward(request, response);
            } else {
            	RequestDispatcher otroServlet = request.getRequestDispatcher("Ejercicio01_ServletError");
                otroServlet.forward(request, response);
            }
        }
		
		
	}