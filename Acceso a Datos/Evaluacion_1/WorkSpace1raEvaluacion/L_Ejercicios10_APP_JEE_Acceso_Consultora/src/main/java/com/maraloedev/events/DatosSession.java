package com.maraloedev.events;

import java.util.Date;
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

	/**
	 * Default constructor.
	 */
	public DatosSession() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {
		se.getSession().getServletContext().setAttribute("datoSesion", "A las " + new Date().toString()
				+ " se creó esta sesión con el identificador: " + se.getSession().getId());

	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
	}

}
