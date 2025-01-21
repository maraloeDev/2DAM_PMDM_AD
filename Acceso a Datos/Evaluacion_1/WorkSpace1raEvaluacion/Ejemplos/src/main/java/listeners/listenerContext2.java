package listeners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class listenerContext2
 *
 */
public class listenerContext2 implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public listenerContext2() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    
    /**
     * Este metodo es invocado cuando la app web es arrancada,
     * Sera ejecutado antes de que cualquier servlet sea inicializado
     *  
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         
    	System.out.println("Aplicacion arrancado en el contexto... " + sce.getServletContext().getContextPath()
    			+ "con el siguiente parametro de configuracion " + sce.getServletContext().getInitParameter("bbdd"));
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    
    /**
     * Este metodo es invocado cuando la app va a ser detenida, 
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         
    	System.out.println("Aplicación del contexto " + sce.getServletContext().getContextPath() + " deteniendose...");
    }
	
}
