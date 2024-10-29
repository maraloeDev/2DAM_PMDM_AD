package Servlets;

import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class ListenerSession
 *
 */
public class ListenerSession implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public ListenerSession() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
        		 System.out.println("A las " + new Date(System.currentTimeMillis()).toString() + 
        				 "se creo la session con el ID " + se.getSession());
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("A las " + new Date(System.currentTimeMillis()).toString() + 
				 "se destruyo la session con el ID " + se.getSession());
    }
	
}
