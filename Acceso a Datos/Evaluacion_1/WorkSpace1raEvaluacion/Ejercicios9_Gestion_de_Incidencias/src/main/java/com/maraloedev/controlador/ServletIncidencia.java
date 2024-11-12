package com.maraloedev.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.maraloedev.modelo.Incidencia;

public class ServletIncidencia extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletIncidencia() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random rndm = new Random();
        Integer numeroIncidencia = rndm.nextInt(1,20);
        String tema = request.getParameter("tema");
        String descripcion = request.getParameter("descripcion");

        List<Incidencia> incidenciasGuardadas = (List<Incidencia>) getServletContext().getAttribute("incidenciasGuardadas");

        if (incidenciasGuardadas == null) {
            incidenciasGuardadas = new ArrayList<>();
        }

        boolean numeroUnicoEncontrado = false;
        do {
        	numeroIncidencia = rndm.nextInt(1,20);

            boolean existe = false;
            for (Incidencia inc : incidenciasGuardadas) {
                if (inc.getIncidencia() == numeroIncidencia) {
                    existe = true;
                    break;
                }
            }
            
            if (!existe) {
                numeroUnicoEncontrado = true;
            }
        } while (!numeroUnicoEncontrado);

        Incidencia nuevaIncidencia = new Incidencia(numeroIncidencia, tema, descripcion);
        incidenciasGuardadas.add(nuevaIncidencia);


        getServletContext().setAttribute("incidenciasGuardadas", incidenciasGuardadas);

        
        response.getWriter().append("<html>\r\n"
                + "    <head>\r\n"
                + "        <title>ALTA INCIDENCIA</title>\r\n"
                + "    </head>\r\n"
                + "    <body>\r\n"
                + "        <h1>ALTA INCIDENCIA</h1>\r\n"
                + "        <form action=\"ConsultarIncidencia.jsp\" method=\"post\">\r\n"
                + "          <p style=\"text-align: center;\">Su incidencia ha sido dada de alta en nuestro sistema con el código:</p> \r\n"
                + "          <h2 style=\"text-align: center;\">" + numeroIncidencia + "</h2>\r\n"
                + "          <input type=\"submit\" value=\"Consultar\">\r\n"
                + "        </form>\r\n"
                + "    </body>\r\n"
                + "</html>");
    }
}
