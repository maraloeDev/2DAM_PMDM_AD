package Servlets;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ListenerContext
 *
 */
public class ListenerContext implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ListenerContext() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    
    //El sce sirve para recuperar información del contecto
    public void contextInitialized(ServletContextEvent sce)  { 
        System.out.println("Arrancando el contexto..." + sce.getServletContext().getContextPath() +
        		"Con el siguiente parametro " + sce.getServletContext().getInitParameter("datos"));
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         System.out.println("Aplicación detenida en contexto");
    }
	
}
