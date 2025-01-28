package com.maraloedev.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ServletEstadistica
 */
public class ServletEstadistica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEstadistica() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie c = new Cookie(request.getParameter("nombre"),request.getParameter("nombre"));
		Cookie[] cs = request.getCookies();
		
		if(request.getParameter("Volver")!=null) {
			request.getRequestDispatcher("Estadistica.jsp").forward(request, response);
		}
		String nombre = request.getParameter("nombre");
		String respuesta = request.getParameter("respuesta");
		
		if(nombre.isEmpty() || respuesta.isEmpty()) {
			request.getRequestDispatcher("Estadistica.jsp").forward(request, response);
			request.getServletContext().setAttribute("errorSession", "(*) El nombre y la respuesta son obligatorios ");
		}
		request.getSession().setAttribute("nombre", nombre);
		response.addCookie(c);
		Integer contador =(Integer) request.getServletContext().getAttribute("contador")!=null ? (Integer) request.getServletContext().getAttribute("contador") : 0;

			contador++;
			request.getServletContext().setAttribute("contador", contador);
		
		String page = request.getParameter("Enviar")!=null ? "Resultado.jsp" : request.getParameter("Volver")!=null ? "Estadistica.jsp" : "";
		request.getRequestDispatcher(page).forward(request, response);
		
		
		for(Cookie coBuscada : cs) {
			if(coBuscada.getName().equals(nombre)) {
				request.getRequestDispatcher("Resultado.jsp").forward(request, response);
				request.getServletContext().setAttribute("realizado", nombre + "ya has respondido anteriormente, no puedes participar.");
				}
			}
		
	}
}
