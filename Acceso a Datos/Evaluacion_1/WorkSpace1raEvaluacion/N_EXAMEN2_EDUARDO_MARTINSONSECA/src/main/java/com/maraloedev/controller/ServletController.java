package com.maraloedev.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.maraloedev.model.Producto;

/**
 * Servlet implementation class ServletController
 */
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArrayList<Producto> listaProductos = new ArrayList<Producto>();
	private static HashMap<String, Producto> mapaProductos = new HashMap<String, Producto>();
	private static HashMap<String, String> mapaSessions = new HashMap<String, String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("productos") != null) {
			index(request, response);
		}
		

		if (request.getParameter("Login") != null) {
			acceso(request, response);
		}
		if (request.getParameter("Acceso") != null) {
			mantenimiento(request, response);
		}
		
		if (request.getParameter("productos") == null) {
			request.getServletContext().setAttribute("errorCesta", "No ha seleccionado ningun articulo");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}

	public static void acceso(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		HttpSession session = request.getSession();
		// ACCESO.jsp
		if (request.getParameter("Login") != null) {
			request.getRequestDispatcher("Acceso.jsp").forward(request, response);
		}

		if (request.getParameter("Salir") != null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

		String nombre = request.getParameter("nombre");
		String contrasena = request.getParameter("contrasena");
		if (nombre.isEmpty() && contrasena.isEmpty()) {
			request.getServletContext().setAttribute("errorSesion", "(*) El nombre y el password son obligatorios");
			request.getRequestDispatcher("Acceso.jsp").forward(request, response);
			return;
		}

		// Recojo el valor del mapaSessions
		mapaSessions = (HashMap<String, String>) session.getAttribute("mapaSession") != null
				? (HashMap<String, String>) session.getAttribute("mapaSession")
				: new HashMap<String, String>();

		boolean correctas = false;
		// Recorro el mapa, y compruebo si el nombre y la contraseña, es diferente que
		// la key y el value
		for (Entry<String, String> mapaSession : mapaSessions.entrySet()) {
			if (!nombre.equals(mapaSession.getKey()) && !contrasena.equals(mapaSession.getValue())) {
				correctas = true;
			}
		}

		// Si es correcta muestro que las credenciales no son correctas, invalido la
		// session
		if (correctas) {
			request.getServletContext().setAttribute("errorSesion",
					"(*) Las credenciales no estan autorizadas. Su sesion queda invalidada");
			request.getRequestDispatcher("Acceso.jsp").forward(request, response);
			session.invalidate();
		}

		// ACCESO.jsp

		// MANTENIMIENTO.jsp
		if (request.getParameter("Acceso") != null) {
			request.getRequestDispatcher("Mantenimiento.jsp").forward(request, response);
		}
	}

	public static void index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		// INDEX.jsp
		// Recojo los producto, y si es null, muestro el error, y me redirije a
		// index.jsp
		if (request.getParameter("productos") == null) {
			request.getServletContext().setAttribute("errorCesta", "No ha seleccionado ningun articulo");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

		if (mapaProductos == null) {
			mapaProductos = new HashMap<String, Producto>();
		}
		if (listaProductos == null) {
			listaProductos = new ArrayList<Producto>();
		}
		
		mapaProductos = request.getServletContext().getAttribute("mapaProductos")!=null ? (HashMap<String, Producto>) request.getServletContext().getAttribute("mapaProductos") : new HashMap<String, Producto>(); 

		// Recoge los valores de los productos
		String productos[] = request.getParameterValues("productos");

		
		if (productos == null) {
			productos = new String[0];
		}

		// Recorro la lista de los productos, y lo agrego al mapa los seleccionados
		for (String producto : productos) {
			listaProductos.add(mapaProductos.get(producto));
		}

		// Almaceno en la session la lista de productos
		session.setAttribute("listaProductos", listaProductos);
		// INDEX.jsp

		// Redirijo a compra
		request.getRequestDispatcher("Compra.jsp").forward(request, response);
	}

	public static void mantenimiento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("Actualizar") != null) {
			request.getRequestDispatcher("Acceso.jsp").forward(request, response);
		}
	}
}