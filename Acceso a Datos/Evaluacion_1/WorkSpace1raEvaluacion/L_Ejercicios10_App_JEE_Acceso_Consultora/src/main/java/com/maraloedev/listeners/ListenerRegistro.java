package com.maraloedev.listeners;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.Date;

@WebListener
public class ListenerRegistro implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setAttribute("fechaSession", new Date(se.getSession().getCreationTime()));
        se.getSession().setAttribute("idSession", se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Manejar lógica cuando una sesión se destruye
    }
}
