<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
</head>
<body>

<h2>DATOS REGISTRO DESARROLLO DE SOFTWARE</h2>

        <form action="ServletUsuario" method="post">

            <table>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre"></td>
                </tr>

                <tr>
                    <td>Contraseña</td>
                    <td><input type="password" name="contrasena"></td>
                </tr>

                <tr>
                    <td>Categoria Profesional</td>
                    <td><input type="radio" name="categoria" value="1" checked> I
                        <input type="radio" name="categoria" value="2"> II
                        <input type="radio" name="categoria" value="3"> III
                    </td>
                </tr>

                <tr>
                    <td><input type="submit" name="boton" value="Registro"></td>
                </tr>
            </table>
        </form>

	<%if(request.getAttribute("errorDatos")==null){%>
	<h3 style="color: red;">${errorDatos}</h3>

	<%}%>
</body>
</html>