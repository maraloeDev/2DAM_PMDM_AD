package com.maraloedev.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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
     * @see HttpServlet#HttpServlet()
     */
    public ServletPersona() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * Creo la persona y la almaceno como atributo
		 */ 
		
		 Persona persona = new Persona(
			        request.getParameter("dni"),
			        request.getParameter("nombre"),
			        request.getParameter("apellidos"),
			        request.getParameter("direccion"),
			        request.getParameter("telefono"),
			        request.getParameter("correo")
			    );
		 request.setAttribute("Persona", persona);

		
		 String page=request.getParameter("Enviar")!=null?"MostrarPersona.jsp":request.getParameter("Volver")!=null?"RecogidaPersona.jsp":"";
			request.getRequestDispatcher(page).forward(request, response);
	}

}
