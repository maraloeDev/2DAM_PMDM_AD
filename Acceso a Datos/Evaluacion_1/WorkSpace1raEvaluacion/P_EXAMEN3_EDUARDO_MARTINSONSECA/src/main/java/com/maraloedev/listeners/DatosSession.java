package com.maraloedev.listeners;

import java.util.ArrayList;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import jakarta.servlet.ServletContext;

/**
 * Application Lifecycle Listener implementation class DatosSession
 *
 */
@WebListener
public class DatosSession implements HttpSessionListener {

    /**
     * Default constructor.
     */
    public DatosSession() {
        // Constructor vacío
    }

    /**
     * Manejo cuando se crea una sesión.
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();

        // Recupero la lista de sesiones del contexto de la aplicación
        ArrayList<String> listaSessiones = (ArrayList<String>) context.getAttribute("listaSessiones");
        if (listaSessiones == null) {
            // Si no existe la lista, la creo
            listaSessiones = new ArrayList<String>();
        }

        // Agregar el ID de la nueva sesión a la lista
        listaSessiones.add(se.getSession().getId());

        // Actualizar la lista en el contexto de la aplicación
        context.setAttribute("listaSessiones", listaSessiones);

       
    }

    /**
     * Manejo cuando se destruye una sesión.
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();

        // Recupero la lista de sesiones del contexto de la aplicación
        ArrayList<String> listaSessiones = (ArrayList<String>) context.getAttribute("listaSessiones");
        if (listaSessiones != null) {
            // Eliminar el ID de la sesión destruida
            listaSessiones.remove(se.getSession().getId());

            // Actualizar la lista en el contexto de la aplicación
            context.setAttribute("listaSessiones", listaSessiones);
        }
    }
}
