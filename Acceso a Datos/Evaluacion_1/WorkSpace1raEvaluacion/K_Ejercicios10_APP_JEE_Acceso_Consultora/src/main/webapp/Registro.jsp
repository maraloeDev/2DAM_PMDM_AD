<%@page import="com.maraloedev.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%Usuario usuario = session.getAttribute("usuario")!=null ?(Usuario) session.getAttribute("usuario"):new Usuario();%>
<meta charset="UTF-8">
<title>Registro</title>
</head>
<body>

<h2>DATOS REGISTRO DESARROLLO DE SOFTWARE</h2>

        <form action="ServletUsuario" method="post">

            <table>
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nombre" value="<%=usuario.getNombre()!=null?usuario.getNombre():""%>"></td>
                </tr>

                <tr>
                    <td>Contraseña:</td>
                    <td><input type="password" name="contrasena" value="<%=usuario.getContrasena()!=null?usuario.getContrasena():""%>"></td>
                </tr>

                <tr>
                    <td>Categoria Profesional</td>
                    <td><input type="radio" name="categoria" value="C1" checked>I
                        <input type="radio" name="categoria" value="C2">II
                        <input type="radio" name="categoria" value="C3">III
                    </td>
                </tr>

                <tr>
                    <td><input type="submit" name="Registro" value="Registro"></td>
                </tr>
            </table>
            
            <%if(request.getAttribute("errorDatos")!=null) {%>
            <h4 style="color: red;">${errorDatos }</h4>
            <% }%>
        </form>
</body>
</html>