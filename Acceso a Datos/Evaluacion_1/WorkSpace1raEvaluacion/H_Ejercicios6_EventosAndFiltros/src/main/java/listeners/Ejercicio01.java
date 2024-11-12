package listeners;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class Ejercicio01
 *
 */
@WebListener("Ejercicio01")
public class Ejercicio01 implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public Ejercicio01() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce) {
    	sce.getServletContext();
		ObjectInputStream ois = null;
		HashMap<String, String> tareas = new HashMap<String, String>();
		try {
			// En la primera lectura si no existe el fichero que lo cree
			File f = new File(sce.getServletContext().getRealPath("") + "tareas.dat");
			if (!f.exists()) {
				f.createNewFile();
			}
			ois = new ObjectInputStream(new FileInputStream(f));
			System.out.println("Al arranque:" + sce.getServletContext().getRealPath("") + "tareas.dat");
			tareas = (HashMap<String, String>) ois.readObject();
			// }
			sce.getServletContext().setAttribute("task", tareas);
		} catch (EOFException e) {
			
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce) {
		
		ObjectOutputStream oos = null;

		try {
			oos = new ObjectOutputStream(new FileOutputStream(sce.getServletContext().getRealPath("") + "tareas.dat"));
			System.out.println("Lista tareas " + sce.getServletContext().getRealPath("") + "tareas.dat");
			oos.writeObject(sce.getServletContext().getAttribute("task"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

}