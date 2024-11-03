package listeners;

import java.io.*;
import java.util.HashMap;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener("Ejercicio01")
public class ListenerEjercicio01 implements ServletContextListener {
    private static final String FILE_NAME = "tareas.ser";

    public ListenerEjercicio01() {
    	
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
    	
        HashMap<String, String> tareas = new HashMap<>();
        String filePath = sce.getServletContext().getRealPath("") + "tarea";

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            tareas = (HashMap<String, String>) ois.readObject();
            sce.getServletContext().setAttribute("notificaciones", tareas);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de tareas no encontrado. Se creara uno nuevo al finalizar.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    	
        HashMap<String, String> tareas = (HashMap<String, String>) sce.getServletContext().getAttribute("notificaciones");
        String filePath = sce.getServletContext().getRealPath("") + File.separator + FILE_NAME;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(tareas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
