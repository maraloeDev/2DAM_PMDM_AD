package com.maraloedev.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.maraloedev.modelo.Usuario;

import java.io.IOException;
import java.util.ArrayList;

public class ServletUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static ArrayList<Usuario> nuevoUsuario = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String contrasena = request.getParameter("contrasena");

        if (nombre == null || nombre.isEmpty() || contrasena == null || contrasena.isEmpty()) {
            request.setAttribute("Error", "(*) El nombre de usuario y la contraseña no pueden estar vacíos.");
            request.getRequestDispatcher("Registro.jsp").forward(request, response);
            return;
        }

        Usuario usuario = new Usuario(nombre, contrasena);

        synchronized (getServletContext()) {
            if (nuevoUsuario == null) {
                nuevoUsuario = new ArrayList<>();
            }

            // Verificar si el usuario ya existe
            boolean existe = nuevoUsuario.stream().anyMatch(u -> u.getNombre().equals(usuario.getNombre()));
            if (!existe) {
                nuevoUsuario.add(usuario);
            }
            getServletContext().setAttribute("nuevoUsuario", nuevoUsuario);
        }

        getServletContext().setAttribute("usuario", usuario);

        String page = request.getParameter("Registro") != null ? "Acceso.jsp" : 
                      request.getParameter("Acceso") != null ? "Aplicacion.jsp" : "Registro.jsp";
        request.getRequestDispatcher(page).forward(request, response);
    }
}