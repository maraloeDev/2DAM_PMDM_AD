<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.maraloedev.modelo.Usuario" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Aplicación</title>
</head>
<body>
    <h1>Bienvenido</h1>
    <% 
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) getServletContext().getAttribute("nuevoUsuario");
        Usuario usuario = (Usuario) getServletContext().getAttribute("usuario");
    %>
    <b><%= usuario.getNombre() %> has accedido correctamente.</b><br>
    <b>Número de accesos a esta página: 3</b><br>
    <table border="2">
        <tr>
            <th>Usuarios Registrados</th>
        </tr>
        <% for (Usuario u : usuarios) { %>
            <tr>
                <td><%= u.getNombre() %></td>
            </tr>
        <% } %>
    </table>
</body>
</html>
