package ejercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Servlet implementation class Ejercicios02b
 */
public class Ejercicio02b extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Integer> numeroAleatorios = new ArrayList<Integer>();
	Integer valor = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio02b() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Random rndm = new Random();
		int aleatorios = rndm.nextInt(0, 100);
		numeroAleatorios.add(aleatorios);

		for (Integer nAleatorio : numeroAleatorios) {
			valor += nAleatorio;
		}

		for (Integer nAleatorio : numeroAleatorios) {
			valor -= nAleatorio;
		}
		
		response.getWriter().append("El valor es " + valor);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}