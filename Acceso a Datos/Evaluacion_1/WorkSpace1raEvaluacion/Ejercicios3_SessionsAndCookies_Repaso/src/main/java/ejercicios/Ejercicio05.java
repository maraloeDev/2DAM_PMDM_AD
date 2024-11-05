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

		config.getInitParameter("aleatorioContexto");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		Integer aleatorio1 = rndm.nextInt(1, 10);
		Integer aleatorio2 = rndm.nextInt(1, 10);

		getServletContext().setAttribute("aleatorioContexto", aleatorio2);

		String compara = aleatorio1.equals(getServletContext().getAttribute("aleatorioContexto"))
				? "<b>Los numeros son iguales</b>"
				: "Los numeros no son iguales";

		response.getWriter().append("Aleatorio: " + aleatorio1 + " " + "Contexto: "
				+ getServletContext().getAttribute("aleatorioContexto") + " " + compara);
	}

}
