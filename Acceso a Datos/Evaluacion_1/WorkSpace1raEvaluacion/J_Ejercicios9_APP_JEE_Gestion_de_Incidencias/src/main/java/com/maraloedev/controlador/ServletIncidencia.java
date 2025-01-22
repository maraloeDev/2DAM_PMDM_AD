package com.maraloedev.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.maraloedev.modelo.Incidencia;

/**
 * Servlet implementation class ServletIncidencia
 */
public class ServletIncidencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static HashMap<Integer, Incidencia> mapaIncidencias = new HashMap<Integer, Incidencia>();
	private Random rndm = new Random();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletIncidencia() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recojo los valores que va a escribir el usuario

		String tema = request.getParameter("tema");
		String descripcion = request.getParameter("descripcion");

		/**
		 * Error de campos vacios, almaceno el mensaje de error en el contexto, Lo
		 * redirigo a AltaIncidencia.jsp, y lo vuelvo a pedir con el return
		 */
		if ((tema == null || tema.isEmpty()) || (descripcion == null || descripcion.isEmpty())) {
			getServletContext().setAttribute("ErrorCamposIncidencia", "(*) El tema y la descripción son obligatorios");
			request.getRequestDispatcher("AltaIncidencia.jsp").forward(request, response);
			return;

		} 

			/**
			 * El código de la incidencia va a ser un número generado aleatoriamente entre 1
			 * y 20 y nunca se podrá grabar un código repetido.
			 */

			if (mapaIncidencias == null) {
				mapaIncidencias = new HashMap<Integer, Incidencia>();
			}

			Integer codigos = 0;
			do {
				codigos = rndm.nextInt(1, 20);
			} while (mapaIncidencias.containsKey(codigos));

			

			response.getWriter()
					.append("<html>\r\n" + "\r\n" + "<head>\r\n" + "    <title>VOTACION</title>\r\n" + "</head>\r\n"
							+ "\r\n" + "<body>\r\n" + "    <h1>ALTA INCIDENCIA</h1>\r\n"
							+ "    <form action=\"ConsultaIncidencia.jsp\" method=\"post\">\r\n" + "\r\n"
							+ "        Su incidencia ha sido dada ede alta en nuestros sistemas con el codigo :\r\n"
							+ "        <h4 style=\"text-align: center;\">" + codigos + "</h4>\r\n" + "        <br>\r\n"
							+ "        <input type=\"submit\" name=\"consultar\" value=\"Consultar\">"
							+ "    </form>\r\n" + "</body>\r\n" + "\r\n" + "</html>");

			// Almaceno el objeto incidencia con codigos, tema, descripcion y lo almaceno en
			// el contexto
			mapaIncidencias.put(codigos, new Incidencia(codigos, tema, descripcion));
			getServletContext().setAttribute("mapaIncidencias", mapaIncidencias);

			
		
	}
}
