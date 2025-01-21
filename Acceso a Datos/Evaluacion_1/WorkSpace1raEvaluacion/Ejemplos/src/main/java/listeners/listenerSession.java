package listeners;

import java.util.Date;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class listenerSession
 *
 */
public class listenerSession implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public listenerSession() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    
    /**
     * Este metodo sera invocado cada vez que se cree una sesion en la app
     */
    public void sessionCreated(HttpSessionEvent se)  { 

    	HttpSession session = se.getSession();
    	System.out.println("La hora actual de la session es " + new Date(System.currentTimeMillis()) + " se creo la session con id " + session.getId());
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    
    /**
     * Este metodo sera invocado cada que se destrya una sesion en la app
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	HttpSession session = se.getSession();
    	System.out.println("La hora actual de la session es " + new Date(System.currentTimeMillis()) + " se destruyo la session con id " + session.getId());
    }
	
}
