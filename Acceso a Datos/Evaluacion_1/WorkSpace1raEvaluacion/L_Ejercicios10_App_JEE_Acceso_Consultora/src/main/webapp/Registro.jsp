<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registro</title>
</head>
<body>
    <h1>Datos Registro Desarrollo de Software</h1>
    <form action="ServletUsuario" method="post">
        <table>
            <tr>
                <td>Nombre:</td>
                <td><input type="text" name="nombre"></td>
            </tr>
            <tr>
                <td>Contraseña:</td>
                <td><input type="password" name="contrasena"></td>
            </tr>
            <tr>
                <td>Categoría Profesional:</td>
                <td>
                    <input type="radio" name="categorias" value="I"> I
                    <input type="radio" name="categorias" value="II"> II
                    <input type="radio" name="categorias" value="III"> III
                </td>
            </tr>
            <tr>
                <td><input type="submit" name="Registro" value="Registro"></td>
            </tr>
        </table>
        <% if (request.getAttribute("Error") != null) { %>
            <h4 style="color: red;"><%= request.getAttribute("Error") %></h4>
        <% } %>
    </form>
</body>
</html>
