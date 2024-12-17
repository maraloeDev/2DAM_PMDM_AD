package com.maraloedev.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

import com.maraloedev.model.Cotizacion;

/**
 * Servlet implementation class ServletCotizacion
 */
public class ServletCotizacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HashMap<Integer,String>valorNuevo = new HashMap<Integer,String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCotizacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 if (request.getParameter("Cerrar") != null) {
		        request.getSession().invalidate();
		        request.setAttribute("errorSession", "La sesión ha expirado.");
		        request.getRequestDispatcher("Acceso.jsp").forward(request, response);
		        return;
		    } else {

		if (request.getParameter("Enviar") != null) {
			request.getRequestDispatcher("ConsultaCotizacion.jsp").forward(request, response);
		}
		
		if(request.getParameter("Volver")!=null) {
			request.getRequestDispatcher("Acceso.jsp").forward(request, response);
		}else {
			// Recojo los datos
			String nombre = request.getParameter("nombre");
			String codigoPin = request.getParameter("codigoPin");

			if ((nombre.isEmpty()) || (codigoPin.isEmpty())) {
				request.setAttribute("errorSession", "(*) El nombre y el codigo pin son obligatorios.");
				request.getRequestDispatcher("Acceso.jsp").forward(request, response);
				return;
			}

			// Credenciales erroneas
			boolean credencialesValidas = false;

			// Recupero el mapa
			HashMap<String, String> mapaUsuarios = (HashMap<String, String>) getServletContext()
					.getAttribute("mapaUsuarios");

			// Recorro el mapa
			for (Entry<String, String> usuarios : mapaUsuarios.entrySet()) {

				String key = usuarios.getKey();
				String value = usuarios.getValue();

				// Comparo si la key y el value es el mismo que em introducido
				if (nombre.equals(key) && codigoPin.equals(value)) {
					credencialesValidas = true;
					break;
				}
			}

			if (credencialesValidas) {
				// Mostrar datos de la session
				request.getSession().setAttribute("fechaSession", LocalDate.now());
				request.getSession().setAttribute("nombre", nombre);

				// Accedes a Cotizacion.jsp
				request.getRequestDispatcher("Cotizacion.jsp").forward(request, response);

				// Creo el objeto Cotizacion para almacenarlo en la session
				Cotizacion cotizacion = new Cotizacion(nombre, codigoPin);
				request.getSession().setAttribute("cotizacion", cotizacion);

			} else {
				// Muestro un mensaje de error
				request.setAttribute("errorSession", "(*) Las credenciales no son correctas.");
				request.getRequestDispatcher("Acceso.jsp").forward(request, response);
				return;
			}
			
			
			if (valorNuevo == null) {
				valorNuevo = new HashMap<Integer,String>();
			}
			
			valorNuevo.put(1,request.getParameter("valorNuevoTURISMO"));
			valorNuevo.put(2,request.getParameter("valorNuevoFARMACIA"));
			valorNuevo.put(3,request.getParameter("valorNuevoDAM"));
			valorNuevo.put(4,request.getParameter("valorNuevoATENCION"));
			valorNuevo.put(5,request.getParameter("valorNuevoVENTAS"));
			valorNuevo.put(6,request.getParameter("valorNuevoISOCIAL"));
			valorNuevo.put(7,request.getParameter("valorNuevoADIF"));
			valorNuevo.put(8,request.getParameter("valorNuevoLA"));
			valorNuevo.put(9,request.getParameter("valorNuevoSMR"));
			valorNuevo.put(10,request.getParameter("valorNuevoADMIN"));
			valorNuevo.put(11,request.getParameter("valorNuevoLABCLIN"));
			valorNuevo.put(12,request.getParameter("valorNuevoEDINF"));
			getServletContext().setAttribute("valorNuevo", valorNuevo);
		}
		
		
	}
	}
}