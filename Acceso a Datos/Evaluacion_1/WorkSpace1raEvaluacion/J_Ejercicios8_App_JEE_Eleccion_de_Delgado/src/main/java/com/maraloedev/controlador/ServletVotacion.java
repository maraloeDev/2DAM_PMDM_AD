package com.maraloedev.controlador;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import como.maraloedev.modelo.Votacion;

/**
 * Servlet implementation class ServletVotacion
 */
public class ServletVotacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Votacion> mapaVotos;
	private String[] delegados = new String[0];
	private int totalVotos=0;
	private final Integer VOTOS_MAX=5;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletVotacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		mapaVotos = new HashMap<String, Votacion>();
		mapaVotos.put("Ruth Fernandez", new Votacion("Ruth Fernandez", 0));
		mapaVotos.put("Victor Vergel", new Votacion("Victor Vergel", 0));
		mapaVotos.put("Blancos", new Votacion("Blancos", 0));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		delegados = request.getParameterValues("delegados");
		if(mapaVotos!=null) {
			if(delegados!= null) {
				
				
				for (Entry<String, Votacion> recorroDelegados : mapaVotos.entrySet()) {
					String key = recorroDelegados.getKey();
					Votacion value = recorroDelegados.getValue();

					for (String listaDelegados : delegados) {
						if (key.contains(listaDelegados)) {
							mapaVotos.get(key).setnVotos(mapaVotos.get(key).getnVotos() + 1);
						}
					}
				}
				totalVotos++;
				
				
			} else {
				mapaVotos.get("Blancos").setnVotos(mapaVotos.get("Blancos").getnVotos() + 1);
				totalVotos++;
			}
		}
		if(totalVotos==VOTOS_MAX) {
			totalVotos = 0;
			
			for(Entry<String, Votacion> eliminacionVotos : mapaVotos.entrySet()) {
				eliminacionVotos.getValue().setnVotos(0);
			}
		}
		getServletContext().setAttribute("mapaVotos", mapaVotos);
		String page = request.getParameter("Enviar")!=null ? "Resultados.jsp" : request.getParameter("Volver")!=null ? "Votacion.jsp" : "";
		request.getRequestDispatcher(page).forward(request, response);
	}

}
