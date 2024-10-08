package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

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
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		response.getWriter().append("<html>\r\n"
				+ "    <head>\r\n"
				+ "        <title>Ejercicio01</title>\r\n"
				+ "    </head>\r\n"
				+ "    <body>\r\n"
				+ "    \r\n"
				+ "    <h1>Tienda LetreA</h1>\r\n"
				+ "        <form action=\"Ejercicio01\" method=\"get\">\r\n"
				+ "\r\n"
				+ "            <input type=\"submit\" name=\"boton\" value=\"A\"></input>\r\n"
				+ "            <input type=\"submit\" name=\"boton\" value=\"B\"></input>\r\n"
				+ "            <input type=\"submit\" name=\"boton\" value=\"C\"></input>\r\n"
				+ "            <input type=\"submit\" name=\"boton\" value=\"D\"></input>\r\n"
				+ "            <br>\r\n"
				+ "            <input type=\"submit\" name=\"boton\" value=\"Ticket\"></input>\r\n"
				+ "        </form>\r\n"
				+ "    </body>\r\n"
				+ "</html>");

        HttpSession session = request.getSession(true);

        // Inicializar el precio y guardas la variable en la session
        Integer precio = (Integer) session.getAttribute("precio");
        
        if (precio == null) {
        	precio =0;
        }

        // Obtener el valor del botón presionado
        String boton = request.getParameter("boton");

        if (boton != null) {
            switch (boton) {
                case "A":
                    precio += 3;
                    break;
                case "B":
                    precio += 4;
                    break;
                case "C":
                    precio += 5;
                    break;
                case "D":
                    precio += 1;
                    break;
                case "Ticket":
                    response.getWriter().append("Valor actual: " + precio);
                    
            }
        }

        // Actualizar el precio en la sesión
        session.setAttribute("precio", precio);

    }
		
	}
