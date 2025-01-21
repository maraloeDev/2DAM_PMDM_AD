package ejercicios;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Servlet implementation class Ejercicio02
 */
public class Ejercicio02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Integer> numeroAleatorios = new ArrayList<Integer>();
	Integer valor = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio02() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		for (int i = 0; i < 25; i++) {

			response.getWriter()
					.append("<iframe src=\"/Ejercicios5_SincronizacionDeProcesos/Ejercicios02b\" width=\"19%\" >"
							 + " </iframe> " );

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Random rndm = new Random();
		int aleatorios = rndm.nextInt(0, 100);
		numeroAleatorios.add(aleatorios);

		for (Integer nAleatorio : numeroAleatorios) {
			valor += nAleatorio;
		}

		for (Integer nAleatorio : numeroAleatorios) {
			valor -= nAleatorio;
		}

	}

}
