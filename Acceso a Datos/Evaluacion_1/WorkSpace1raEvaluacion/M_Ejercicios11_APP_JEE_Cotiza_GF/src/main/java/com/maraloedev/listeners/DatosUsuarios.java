package com.maraloedev.listeners;

import java.util.ArrayList;
import java.util.HashMap;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class DatosUsuarios
 *
 */
public class DatosUsuarios implements ServletContextListener {
	
	private HashMap<String, String> mapaUsuarios = new HashMap<String,String>();

    /**
     * Default constructor. 
     */
    public DatosUsuarios() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  {
    	
    	if(mapaUsuarios == null) {
    		mapaUsuarios = new HashMap<String,String>();
    	}
    	
    	mapaUsuarios.put("Eduardo", "123456");
    	mapaUsuarios.put("Luis", "123456");
    	mapaUsuarios.put("Juan", "1234");
    	mapaUsuarios.put("Carlos", "1234");
    	sce.getServletContext().setAttribute("mapaUsuarios", mapaUsuarios);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}
