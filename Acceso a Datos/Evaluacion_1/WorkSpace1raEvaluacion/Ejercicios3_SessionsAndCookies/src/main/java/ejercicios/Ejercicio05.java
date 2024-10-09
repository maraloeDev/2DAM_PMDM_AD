package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * Servlet implementation class Ejercicio05
 */
public class Ejercicio05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Random rndm = new Random();
	private static int datoConextAleatorio;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio05() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		//Recupero el dato del param name en la variable
		datoConextAleatorio = Integer.parseInt(config.getServletContext().getInitParameter("nAleatorioContexto"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nAleatorio = rndm.nextInt(1, 10);
		int nAleatorio2 = rndm.nextInt(1, 10);
		
		//Establezco el atributo nAleatorioContexto, al nAleatorio2
		getServletContext().setAttribute("nAleatorioContexto", nAleatorio2);
		
		datoConextAleatorio = nAleatorio2;
		
		response.getWriter().append("<html>\r\n"
				+ "    <head>\r\n"
				+ "        <title>Ejercicio05</title>\r\n"
				+ "    </head>\r\n"
				+ "\r\n"
				+ "    <body>\r\n"
				+ "        \r\n");
				if(nAleatorio == datoConextAleatorio) {
					response.getWriter().append("Aleatorio: "+ nAleatorio +" &nbsp; Contexto: "+datoConextAleatorio+ " Numeros iguales");
				} else {
					response.getWriter().append("Aleatorio: "+ nAleatorio +" &nbsp; Contexto: "+datoConextAleatorio+ " Numeros distintos");
				}
				response.getWriter().append("</body></html>").close();
		
		
	}
}
