package com.maraloedev.events;

import java.util.HashMap;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class DatosSession
 *
 */
@WebListener("/Accesso.jsp")
public class DatosSession implements HttpSessionListener {
	private HashMap<String, String> mapaSession = new HashMap<String, String>();

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
         if(mapaSession == null) {
        	 mapaSession = new HashMap<String, String>();
         }
         
         mapaSession.put("admin", "admin");
         
         se.getSession().setAttribute("mapaSession", mapaSession);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
