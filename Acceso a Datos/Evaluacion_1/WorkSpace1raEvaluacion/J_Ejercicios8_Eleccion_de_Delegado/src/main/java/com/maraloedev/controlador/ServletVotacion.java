package com.maraloedev.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import com.maraloedev.entities.Votacion;

/**
 * Servlet implementation class ServletVotacion
 */
public class ServletVotacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletVotacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = "";
		HashMap<String, Votacion> mapaVot = getServletConfig().getServletContext().getAttribute("mapVotos") != null
				? (HashMap<String, Votacion>) getServletConfig().getServletContext().getAttribute("mapVotos")
				: new HashMap<String, Votacion>();
		// Número de usuarios que votan. Si llega a 5 reinicializar la votación
		if (getServletConfig().getServletContext().getAttribute("numUsers") != null
				&& (Integer) getServletConfig().getServletContext().getAttribute("numUsers") > 4) {
			mapaVot = new HashMap<String, Votacion>();
			getServletConfig().getServletContext().removeAttribute("numUsers");
		} else {
			getServletConfig().getServletContext().setAttribute("numUsers",
					getServletConfig().getServletContext().getAttribute("numUsers") == null ? 1
							: (Integer) getServletConfig().getServletContext().getAttribute("numUsers") + 1);
			// Recupero la votación del formulario y la almaceno en el mapa d evotaciones
			String[] candidatos = request.getParameterValues("alumno") != null ? request.getParameterValues("alumno")
					: new String[] { "Blancos" };
			for (String c : candidatos) {
				Votacion v = mapaVot.get(c) != null ? mapaVot.get(c) : new Votacion(c);
				v.setNumVotos();
				mapaVot.put(c, v);
			}

		}
		getServletContext().setAttribute("mapVotos", mapaVot);
		request.getRequestDispatcher("Resultados.jsp").forward(request, response);
	}

}
