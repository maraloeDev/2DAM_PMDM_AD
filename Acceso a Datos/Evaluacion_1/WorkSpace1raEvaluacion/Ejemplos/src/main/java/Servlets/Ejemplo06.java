package Servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Servlet implementation class Ejemplo06
 */
public class Ejemplo06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejemplo06() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append(
		    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">"
		    + "\n"
		    + "<HTML>\n"
		    + "<HEAD><TITLE> MOSTRAR CABECERAS REQUEST </TITLE></HEAD>\n"
		    + "<BODY>\n"
		    + "<H1 ALIGN=\"CENTER\"> MOSTRAR CABECERAS REQUEST</H1>\n"
		    + "<B>Request Method: </B>" + request.getMethod() + "<BR>\n"
		    + "<B>Request URI: </B>" + request.getRequestURI() + "<BR>\n"
		    + "<B>Request Protocol: </B>" + request.getProtocol() + "<BR><BR>\n"
		    + "<TABLE BORDER=1 ALIGN=\"CENTER\">\n"
		    + "<TR>\n"
		    + "<TH>Header Name</TH><TH>Header Value</TH></TR>\n"
		);

		//Devuelve el valor de la cabecera
		Enumeration<String> headerNames = request.getHeaderNames();
		
		//Mientras haya mas elementos,
		while (headerNames.hasMoreElements()) {
		    String headerName = headerNames.nextElement();
		    
		    // Muestras en la resouesta del servidor, el nombre de las cabeceras, y 
		    response.getWriter().append("<TR><TD>" + headerName + "</TD><TD>" + request.getHeader(headerName) + "</TD></TR>\n");
		}
		response.getWriter().append("</TABLE>\n</BODY>\n</HTML>");
		response.getWriter().close();
	}
}
