package com.maraloedev.listeners;


import java.util.HashMap;
import java.util.Map.Entry;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class EventSession
 *
 */
@WebListener("Acceso.jsp")
public class EventSession implements HttpSessionListener {
	
	private HashMap<Long, String> mapaSessions = new HashMap <Long, String>();

    /**
     * Default constructor. 
     */
    public EventSession() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // Se almacenará la fecha de creación de la misma y su identificador en el contexto
    	
    	if(mapaSessions == null) {
    		mapaSessions = new HashMap <Long, String>();
    	}
    	
    	mapaSessions.put(se.getSession().getCreationTime(), se.getSession().getId());
    	se.getSession().getServletContext().setAttribute("mapaSessions", mapaSessions);
    	
    	}
    
   

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
