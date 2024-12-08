package com.maraloedev.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.maraloedev.modelo.Persona;

/**
 * Servlet implementation class ServletPersona
 */
public class ServletPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletPersona() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Creo un objeto Persona para almacenarla en el contexto
		Persona persona = new Persona(
				request.getParameter("dni"),
				request.getParameter("nombre"),
                request.getParameter("apellidos"),
                request.getParameter("direccion"),
                request.getParameter("telefono"),
                request.getParameter("correo"));
		
		getServletContext().setAttribute("persona", persona);
		
		/**
		 * Hago un switch para comprobar los botones
		 * Dependiendo el valor (value), te redirigue a una JSP
		 */
		switch(request.getParameter("boton")) {
		case "Enviar" :
			request.getRequestDispatcher("MostrarPersona.jsp").forward(request, response);
			break;
		case "Volver" :
			request.getRequestDispatcher("RecogidaPersona.jsp").forward(request, response);
		}
	}
}
