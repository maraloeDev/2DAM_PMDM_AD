package com.maraloedev.listeners;

import java.util.ArrayList;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import jakarta.websocket.Session;

/**
 * Application Lifecycle Listener implementation class listenerSesion
 *
 */
@WebListener("*")
public class listenerSesion implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public listenerSesion() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         HttpSession session = se.getSession();         
         session.setAttribute("fechaCreacionSession", session.getCreationTime());
         session.setAttribute("idSession", session.getId());
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
