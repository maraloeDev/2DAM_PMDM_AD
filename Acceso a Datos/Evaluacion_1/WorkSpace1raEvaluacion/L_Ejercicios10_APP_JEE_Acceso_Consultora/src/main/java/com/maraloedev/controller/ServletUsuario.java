package com.maraloedev.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.maraloedev.model.Usuario;

/**
 * Servlet implementation class ServletUsuario
 */
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, String> listaUsuarios = new HashMap<String, String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		// Recojo los datos de nombre, la contraseña y la categoria
		String nombre = request.getParameter("nombre");
		String contrasena = request.getParameter("contrasena");
		String categoria = request.getParameter("categoria");

		// Compruebo si los datos introducidos no estan vacios
		if ((nombre == null || nombre.isEmpty()) || (contrasena == null || contrasena.isEmpty())) {
			request.setAttribute("errorDatos", "(*) El nombre de usuario o la contraseña no pueden estar vacios");
			request.getRequestDispatcher("Registro.jsp").forward(request, response);
			return;
		} else {

			// Almaceno el nombre, la contraseña y la categoria
			Usuario usuario = new Usuario(nombre, contrasena, categoria);

			// Compruebo si la lista es nula, si no es asi, almaceno el usuario
			if (listaUsuarios == null) {
				listaUsuarios = new HashMap<String, String>();
			}
			listaUsuarios.put(nombre, contrasena);

			// Almaceno en la session tanto la lista, como el usuario
			session.setAttribute("listaUsuarios", listaUsuarios);
			session.setAttribute("usuario", usuario);
			
			String page = request.getParameter("Registro") != null ? "Acceso.jsp"
					: request.getParameter("Acceso") != null ? "Aplicacion.jsp"
							: request.getParameter("AccesoApp") != null ? "Acceso.jsp" : "";
			
			request.getRequestDispatcher(page).forward(request, response);
			session.invalidate();
		}
	}

}
