package com.maraloedev.listeners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.util.HashMap;

public class ListenerCategorias implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        HashMap<String, String> mapaCategorias = new HashMap<>();
        mapaCategorias.put("C1A", "Programador Senior");
        mapaCategorias.put("C1B", "Programador Junior");
        mapaCategorias.put("C2A", "Analista");
        mapaCategorias.put("C2B", "Analista-Programador");
        mapaCategorias.put("C3", "Jefe de Proyecto");

        sce.getServletContext().setAttribute("mapaCategorias", mapaCategorias);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Limpiar recursos si es necesario
    }
}
