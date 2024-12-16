package com.maraloedev.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

import com.maraloedev.model.Cotizacion;

/**
 * Servlet implementation class ServletCotizacion
 */
public class ServletCotizacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCotizacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recojo los datos
		String nombre = request.getParameter("nombre");
		String codigoPin = request.getParameter("codigoPin");
		
		if( (nombre.isEmpty()) || (codigoPin.isEmpty())) {
			request.setAttribute("errorSession", "(*) El nombre y el codigo pin son obligatorios.");
			request.getRequestDispatcher("Acceso.jsp").forward(request, response);
			return;
		}
		
		//Credenciales erroneas
		boolean credencialesValidas = false;
		
		//Recupero el mapa
		HashMap<String, String> mapaUsuarios = (HashMap<String, String>) getServletContext().getAttribute("mapaUsuarios");
		
		//Recorro el mapa
		for(Entry<String, String> usuarios : mapaUsuarios.entrySet()) { 
			
			String key = usuarios.getKey();
			String value = usuarios.getValue();
			
			//Comparo si la key y el value es el mismo que em introducido
			if(nombre.equals(key) && codigoPin.equals(value)) {
				credencialesValidas = true;
				break;
			}
		}
		
		
		if(credencialesValidas) {
			//Accedes a Cotizacion.jsp
			request.getRequestDispatcher("Cotizacion.jsp").forward(request, response);
			
			//Almacenas en la session, la fecha
			request.getSession().setAttribute("fechaSession", new Date().toString().formatted(new SimpleDateFormat("dd-MM-yyyy")));
			
			//Creo el objeto Cotizacion para almacenarlo en la session
			Cotizacion cotizacion = new Cotizacion(nombre, codigoPin);
			request.getSession().setAttribute("cotizacion", cotizacion);
			
		} else {
			//Muestro un mensaje de error 
			request.setAttribute("errorSession", "(*) Las credenciales no son correctas.");
			request.getRequestDispatcher("Acceso.jsp").forward(request, response);
			return;
		}
		
		
	}

}
