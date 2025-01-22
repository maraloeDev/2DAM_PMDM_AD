package Servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejemplo011
 */
public class Ejemplo011 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int val =0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejemplo011() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
    String paramValue = request.getParameter("param");
    if (paramValue != null) {
        val = Integer.parseInt(paramValue);
        System.out.println("Thread: " + Thread.currentThread().getName() + " usa el valor: " + val);

        try {
            // Simulamos una operación que tarda 10 segundos
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            System.out.println(ex.toString());
        }

        System.out.println("Thread: " + Thread.currentThread().getName() + " usa el valor: " + val);
    } else {
        System.out.println("El parámetro 'param' no está presente en la solicitud.");
    }
    
    //METODOS
    prueba(request, response);
    pruebaConLock(request, response);
}

	public synchronized void prueba (HttpServletRequest request, HttpServletResponse response)
 
            throws ServletException, IOException {
		
		//Cambiando la variable local del doGet
		
	    String paramValue = request.getParameter("param");
	    if (paramValue != null) {
	        val = Integer.parseInt(paramValue);
	        System.out.println("Thread: " + Thread.currentThread().getName() + " usa el valor: " + val);

	        try {
	            // Simulamos una operación que tarda 10 segundos
	            Thread.sleep(10000);
	        } catch (InterruptedException ex) {
	            System.out.println(ex.toString());
	        }

	        System.out.println("Thread: " + Thread.currentThread().getName() + " usa el valor: " + val);
	    } else {
	        // Handle the case where the "param" parameter is not present
	        System.out.println("El parámetro 'param' no está presente en la solicitud.");
	    }
	}

	private final Object lock = new Object(); //Un lock bloquea lo problemas de concurrencia, se usa solo 
	// en sessiones y contexto
	public void pruebaConLock(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    try {
	        synchronized (lock) {
	            val = Integer.valueOf(request.getParameter("param"));
	            System.out.println("Thread: " + Thread.currentThread().getName() + " usa el valor: " + val);
	            Thread.sleep(10000); // Simula una operación que tarda 10 segundos
	        }
	    } catch (InterruptedException ex) {
	        ex.printStackTrace();
	    }
	    System.out.println("Thread: " + Thread.currentThread().getName() + " usa el valor: " + val);
	}	
}