package com.maraloedev.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.maraloedev.modelo.Votacion;

/**
 * Servlet implementation class ServletVotacion
 */
public class ServletVotacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Creo un papa para almacenar el nombre de los votantes, y el numero de votos
	private static Map<String, Votacion> mapaVotacion = new HashMap<String, Votacion>();
	private static final Integer MAX_VOTOS=5;
	private static Integer nVotos=0;
       
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
    	
    	if(mapaVotacion==null) {
    		mapaVotacion = new HashMap<String, Votacion>();
    	}
    	
    	mapaVotacion.put("Ruth Fernandez", new Votacion("Ruth Fernandez", 0));
    	mapaVotacion.put("Victor Vergel", new Votacion("Victor Vergel", 0));
    	mapaVotacion.put("Blanco", new Votacion("Blanco", 0));
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recogo los el nombre de los delegados
		String delegados[] = request.getParameterValues("delegado");
		
		if(delegados==null) {
			delegados = new String[0];
		}
		
		boolean votoBlanco = true;
		
		//Recorro la lista de delegados, y el mapa con los delegados
		for(String delegado : delegados) {
			for(Entry<String, Votacion> elMapa: mapaVotacion.entrySet()) {
				//Si la key del mapa, contiene el nombre del delegado, aumentas en 1 el numero de votos
				if(elMapa.getKey().contains(delegado)) {
					elMapa.getValue().setnVotos(elMapa.getValue().getnVotos()+1);
					votoBlanco = false;
				}
			}
		}
		
		//Si el usuario no vota nada, recoges el voto en blanco, aumentando el numero de votos a 1
		if(votoBlanco) {
			mapaVotacion.get("Blanco").addVoto();
		}
		nVotos++;
		
		if(nVotos== MAX_VOTOS) {
			for(Entry<String, Votacion> limpiar : mapaVotacion.entrySet()) {
				limpiar.getValue().setnVotos(0);
			}
		}
		
		getServletContext().setAttribute("mapaVotacion", mapaVotacion);
		
		switch (request.getParameter("boton")) {
		case "Enviar" :
			response.sendRedirect("Resultados.jsp");
			break;
		}
	}
}
