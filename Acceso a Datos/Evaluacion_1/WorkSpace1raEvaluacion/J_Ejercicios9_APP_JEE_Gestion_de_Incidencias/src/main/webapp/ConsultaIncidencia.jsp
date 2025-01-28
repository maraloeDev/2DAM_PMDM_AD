<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.maraloedev.modelo.Incidencia"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Consulta Incidencia</title>
</head>
<body>
    <%
        // Obtén el mapa desde el contexto de la aplicación o crea uno nuevo si no existe
        HashMap<Integer, Incidencia> mapaIncidencias = 
            getServletContext().getAttribute("mapaIncidencias") != null ? 
            (HashMap<Integer, Incidencia>) getServletContext().getAttribute("mapaIncidencias") : 
            new HashMap<Integer, Incidencia>();
    %>

    <form action="ServletIncidencia" method="post">
        <table border="2">
            <tr>
                <th>INCIDENCIA</th>
                <th>TEMA</th>
                <th>DESCRIPCION</th>
            </tr>
            
            <% 
                // Recorre el mapa de incidencias y genera las filas
                for (Entry<Integer, Incidencia> incidencia : mapaIncidencias.entrySet()) { 
            %>
            <tr>
                <td><%= incidencia.getKey() %></td>
                <td><%= incidencia.getValue().getTema() %></td>
                <td><%= incidencia.getValue().getDescripcion() %></td>
            </tr>
            <% 
                } 
            %>
        </table>
        <br>
        <input type="submit" name="Volver" value="Volver">
    </form>
</body>
</html>
