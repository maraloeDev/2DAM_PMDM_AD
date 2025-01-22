package com.maraloedev.listener;

import java.util.HashMap;

import com.maraloedev.model.Producto;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ListaProductos
 *
 */
@WebListener("/index.jsp")
public class ListaProductos implements ServletContextListener {
	private HashMap<String, Producto> mapaProductos = new HashMap<String, Producto>();

	/**
	 * Default constructor.
	 */
	public ListaProductos() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		/*
		 * Los artículos se cargarán en la memoria al arrancar la aplicación desde el
		 * servidor Tomcat.
		 */
		
		if(mapaProductos == null) {
			mapaProductos = new HashMap<String, Producto>();
		}
		
		mapaProductos.put("P1", new Producto("P1", "SUDADERA", 18));
		mapaProductos.put("P2", new Producto("P2", "CAMISETA", 15));
		mapaProductos.put("P3", new Producto("P3", "BOLÍGRAFO", 3));
		mapaProductos.put("P4", new Producto("P4", "GORRA", 7));
		mapaProductos.put("P5", new Producto("P5", "TAZA", 4));
		
		
		
		sce.getServletContext().setAttribute("mapaProductos", mapaProductos);
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

}
