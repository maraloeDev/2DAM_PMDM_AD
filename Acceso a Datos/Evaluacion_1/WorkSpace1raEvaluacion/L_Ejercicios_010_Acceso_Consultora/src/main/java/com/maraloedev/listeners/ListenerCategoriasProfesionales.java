package com.maraloedev.listeners;

import java.util.HashMap;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ListenerCategoriasProfesionales
 *
 */
@WebListener("*")
public class ListenerCategoriasProfesionales implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ListenerCategoriasProfesionales() {
        // TODO Auto-generated constructor stub
    }

    
	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         HashMap<String, String> mapaCategorias = new HashMap<String, String>();
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
