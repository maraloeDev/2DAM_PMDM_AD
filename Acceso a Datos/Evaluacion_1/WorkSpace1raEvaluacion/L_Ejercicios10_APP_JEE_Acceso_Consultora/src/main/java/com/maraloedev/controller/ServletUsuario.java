package com.maraloedev.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.maraloedev.model.Usuario;

/**
 * Servlet implementation class ServletUsuario
 */
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recojo datos
		String nombre = request.getParameter("nombre");
		String contrasena = request.getParameter("contrasena");
		
		//Si el usuario no introduce alguno de los datos pedidos se le mostrará el siguiente mensaje
		if(nombre.isEmpty() || contrasena.isEmpty()) {
			getServletContext().setAttribute("errorDatos", "(*) El nombre de usuario y la contraseña no pueden estar vacios");
			request.getRequestDispatcher("Registro.jsp").forward(request, response);
			return;
		}
		
		//tipos de boton
		
		switch(request.getParameter("boton")) {
		
		case "Registro"	:
			request.getRequestDispatcher("Acceso.jsp").forward(request, response);
			break;
		case "Acceso" :
			request.getRequestDispatcher("Aplicacion.jsp").forward(request, response);
			break;
			
			default :
				request.getRequestDispatcher("Acceso.jsp").forward(request, response);
				break;
		}
		HashMap<String, String> mapaCategorias = (HashMap<String, String>) request.getServletContext().getAttribute("mapaCategorias");
		
		//Recojo las categorias
		String categorias [] = request.getParameterValues("categorias");
		
		for(String cats : categorias) {
			for(Entry<String, String> listaCat : mapaCategorias.entrySet()) {
				if(cats.contains(listaCat.getKey())) {
					getServletContext().setAttribute("categoriaSeleccionada", listaCat.getValue().toString());
				}
				
			}
			
			if(listaUsuarios==null) {
				listaUsuarios = new ArrayList<Usuario>();
			}
			
			Usuario usuario = new Usuario(nombre, contrasena);
			
			listaUsuarios.add(usuario);
			
			getServletContext().setAttribute("listaUsuarios", listaUsuarios);
			getServletContext().setAttribute("usuario", usuario);
		}
	}
}