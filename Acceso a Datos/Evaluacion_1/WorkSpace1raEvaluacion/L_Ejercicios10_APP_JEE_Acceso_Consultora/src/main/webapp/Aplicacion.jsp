<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.maraloedev.model.Usuario" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aplicación</title>
</head>
<body>

<% 
ArrayList<Usuario> listaUsuarios = (ArrayList<Usuario>) getServletContext().getAttribute("listaUsuarios");
Usuario usuario = (Usuario) getServletContext().getAttribute("usuario");

// Manejo del contador de accesos
Integer contador = (Integer) session.getAttribute("contador");
if (contador == null) {
    contador = 1;
} else {
    contador++;
}
session.setAttribute("contador", contador);
%>

<h2>Bienvenido a la Aplicación</h2>

<p><%= usuario.getNombre() %>, has accedido correctamente.</p>
<p>Veces que has accedido: <%= contador %></p>

<h3>Usuarios registrados:</h3>
<table border="1">
    <tr>
        <th>Nombre</th>
    </tr>
    <% if (listaUsuarios != null) { %>
        <% for (Usuario user : listaUsuarios) { %>
            <tr>
                <td><%= user.getNombre() %></td>
            </tr>
        <% } %>
    <% } %>
</table>

</body>
</html>
