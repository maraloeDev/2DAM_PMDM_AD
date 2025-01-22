package com.maraloedev.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ServletSorteo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	// Obtener la sesión actual
        HttpSession session = request.getSession();
        
        // inscribir al participante
        String action = request.getParameter("incribir");
        String participante = request.getParameter("participante");

        // SORTEO.JSP
        if (action != null && action.equals("Inscripción")) {
            if (participante == null || participante.isEmpty()) {
                // Error si no se introdujo el nombre
                request.setAttribute("errorSession", "Debe introducir un nombre para participar.");
                request.getRequestDispatcher("Sorteo.jsp").forward(request, response);
            } else if (session.getAttribute("participante") != null) {
                // Ya está registrado, no puede participar de nuevo
                request.getRequestDispatcher("Sorteo.jsp").forward(request, response);
            } else {
                // Inscribir al participante y guardar en sesión
                session.setAttribute("participante", participante);

                // Compruebo si la lista de sesiones existe, si no la creo
                ArrayList<String> listaSessiones = (ArrayList<String>) session.getAttribute("listaSessiones");
                if (listaSessiones == null) {
                    listaSessiones = new ArrayList<>();
                }

                // Agregar la sesión actual a la lista
                listaSessiones.add(session.getId());

                // Almacenar la lista de sesiones actualizada en la sesión
                session.setAttribute("listaSessiones", listaSessiones);

                // Incrementar el contador de participantes
                Integer contador = (Integer) session.getAttribute("contador");
                if (contador == null) {
                    contador = 1; // Si no existe, inicializamos el contador en 1
                } else {
                    contador++; // Incrementamos el contador
                }
                session.setAttribute("contador", contador);

                // Redirigir a la página de participación
                response.sendRedirect("Participar.jsp");
            }
        }

        // Genero un número aleatorio y compruebo si es par o impar
        String papeleta = request.getParameter("papeleta");
        if (papeleta != null && papeleta.equals("Elija Papeleta")) {
            Random random = new Random();
            int numero = random.nextInt(100) + 1;
            String resultado = (numero % 2 == 0) ? "PREMIADO!!!" : "NO PREMIADO";

            session.setAttribute("numero", numero);
            session.setAttribute("resultado", resultado);
            response.sendRedirect("Papeleta.jsp");
        }

        // Vuelvo a la página de Sorteo
        String volver = request.getParameter("volver");
        if (volver != null && volver.equals("Volver")) {
            // Incrementar el contador incluso al volver
            Integer contador = (Integer) session.getAttribute("contador");
            if (contador == null) {
                contador = 1; // Si es la primera vez, comenzamos con 1
            } else {
                contador++; // Incrementamos el contador
            }
            session.setAttribute("contador", contador); // Actualizamos el contador

            // Eliminar la sesión de la lista y cerrar sesión
            ArrayList<String> listaSessiones = (ArrayList<String>) session.getAttribute("listaSessiones");
            if (listaSessiones != null) {
                synchronized (this) {
                    listaSessiones.remove(session.getId());
                }
                session.setAttribute("listaSessiones", listaSessiones);
            }

            // AQUI PONES IDCONECTADO EN LA SESION = nommbreid
            request.getSession().setAttribute("idDesconectado", "ID DESCONECTADO");

            // No invalidamos la sesión aquí. Lo hacemos después de la redirección.
            response.sendRedirect("Sorteo.jsp");
        }
    }
}