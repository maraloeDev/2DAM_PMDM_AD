package ejercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletContext;
import java.io.IOException;

/**
 * Servlet implementation class SegundoServlet
 */
@WebServlet("/Ejercicio01_Context")
public class Ejercicio01_Context extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio01_Context() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        // Recuperar el color de param-name y se guarda en la variable color
        String color = (String) getServletContext().getAttribute("color");

        response.setContentType("text/html");
        response.getWriter().append("<!DOCTYPE html>\r\n"
            + "<html>\r\n"
            + "    <head>\r\n"
            + "        <meta charset=\"UTF-8\">\r\n"
            + "        <title>Ejercicio1</title>\r\n"
            + "    </head>\r\n"
            + "    <body style=\"background-color: " + color + ";\">\r\n"
            + "    </body>\r\n"
            + "</html>");
    }
}
