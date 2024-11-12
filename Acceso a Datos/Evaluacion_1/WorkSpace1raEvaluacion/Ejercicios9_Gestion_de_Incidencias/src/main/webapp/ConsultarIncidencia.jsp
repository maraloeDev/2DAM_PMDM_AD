<%@page import="com.maraloedev.modelo.Incidencia"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle de Incidencia</title>
</head>
<body>
    <h1>Detalles de la Incidencia</h1>

    <%
        
        List<Incidencia> incidenciasGuardadas = (List<Incidencia>) getServletContext().getAttribute("incidenciasGuardadas");

        
        Incidencia ultimaIncidencia = null;
        if (incidenciasGuardadas != null && !incidenciasGuardadas.isEmpty()) {
            // Obtener la última incidencia agregada
            ultimaIncidencia = incidenciasGuardadas.get(incidenciasGuardadas.size() - 1);
        }
    %>

    <form action="AltaIncidencia.jsp" method="post">
        <table border="2">
            <tr>
                <td><b>INCIDENCIA</b></td>
                <td><b>TEMA</b></td>
                <td><b>DESCRIPCIÓN</b></td>
            </tr>
            <tr>
                <td><%= (ultimaIncidencia != null && ultimaIncidencia.getIncidencia() != null) ? ultimaIncidencia.getIncidencia() : "" %></td>
                <td><%= (ultimaIncidencia != null && ultimaIncidencia.getTema() != null) ? ultimaIncidencia.getTema() : "" %></td>
                <td><%= (ultimaIncidencia != null && ultimaIncidencia.getDescripcion() != null) ? ultimaIncidencia.getDescripcion() : "" %></td>
            </tr>
        </table>
        <input type="submit" value="Volver">
    </form>
</body>
</html>
