package com.maraloedev.events;

import java.util.HashMap;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class DatosSession
 *
 */
@WebListener("Acceso.jsp")
public class DatosSession implements HttpSessionListener {
	
	HashMap<Long, String> mapaSesions = new HashMap<Long, String>();

    /**
     * Default constructor. 
     */
    public DatosSession() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         
    	if(mapaSesions==null) {
    		mapaSesions = new HashMap<Long, String>();
    	}
    	
    	mapaSesions.put(se.getSession().getCreationTime(),se.getSession().getId());
    	se.getSession().getServletContext().setAttribute("mapaSessions", mapaSesions);
    	
    	
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
