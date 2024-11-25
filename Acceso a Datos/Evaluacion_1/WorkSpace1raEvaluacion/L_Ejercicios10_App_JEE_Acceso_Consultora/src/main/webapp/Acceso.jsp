<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.maraloedev.modelo.Usuario" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Acceso</title>
</head>
<body>
    <h1>Acceso al Sistema</h1>
    <form action="ServletUsuario" method="post">
        <table>
            <tr>
                <td>Nombre:</td>
                <td><input type="text" name="nombre" value="<%= ((Usuario) getServletContext().getAttribute("usuario")).getNombre() %>"></td>
            </tr>
            <tr>
                <td>Contraseña:</td>
                <td><input type="password" name="contrasena" value="<%= ((Usuario) getServletContext().getAttribute("usuario")).getContraseña() %>"></td>
            </tr>
            <tr>
                <td><input type="submit" name="Acceso" value="Acceso"></td>
            </tr>
        </table>
        <p>Sesión creada a las <%= session.getAttribute("fechaSession") %>, ID: <%= session.getAttribute("idSession") %></p>
    </form>
</body>
</html>
