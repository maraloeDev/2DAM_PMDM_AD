package com.maraloedev.listeners;

import java.util.HashMap;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ListenerCategorias
 *
 */
@WebListener("Registro.jsp")
public class ListenerCategorias implements ServletContextListener {
	
	private HashMap<String, String> mapaCategorias = new HashMap <String, String>();

    /**
     * Default constructor. 
     */
    public ListenerCategorias() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	
          //Las categorías profesionales están asignadas a distintos perfiles de puestos de trabajo
    	if(mapaCategorias == null) {
    		mapaCategorias = new HashMap<String, String>();
    	}
    	
    	mapaCategorias.put("C1A", "Programador Senior");
    	mapaCategorias.put("C1B", "Programador Junior");
    	mapaCategorias.put("C2A", "Analista");
    	mapaCategorias.put("C2B", "Analista-Programador");
    	mapaCategorias.put("C3", "Jefe de Proyecto");
    	
    	sce.getServletContext().setAttribute("mapaCategorias", mapaCategorias);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}
