<%@page import="com.maraloedev.model.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%Usuario usuario = session.getAttribute("usuario")!=null ?(Usuario) session.getAttribute("usuario"):new Usuario();%>
<meta charset="UTF-8">
<title>Acceso</title>
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
                    <td>Elige perfil</td>
                </tr>

                <tr>
                    <td><%--  --%></td>
                </tr>

                <tr>
                    <td><input type="submit" name="Acceso" value="Acceso"></td>
                </tr>
            </table>
            
            <%if(session.getServletContext().getAttribute("datoSesion")!=null){%>
            <p>${datoSesion }</p>
            <% }%>
        </form>
</body>
</html>