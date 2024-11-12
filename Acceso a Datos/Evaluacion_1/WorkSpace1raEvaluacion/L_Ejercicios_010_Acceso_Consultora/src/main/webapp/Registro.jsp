<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REGISTRO</title>
</head>
<body>

	<form action="Acceso.jsp" method="post">

		<h1>Datos Registro Desarrollo de Software</h1>

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
				<td>Categoria profesional:</td>
				<td><input type="radio" name="categoria"> I <input
					type="radio" name="categoria"> II <input type="radio"
					name="categoria"> III</td>
			</tr>

			<tr>
				<td><input type="submit" value="Registro"></td>
			</tr>

			<tr>
				<%
				String nombre = request.getParameter("nombre");
				String contrasena = request.getParameter("contrasena");
				if (nombre == null || contrasena == null) {
				%>
				<td><h3 style="color: red">(*) El nombre y la contraseña no pueden estar vacios</h3></td>
			</tr>
			<%
			}
			%>
		</table>
	</form>

</body>
</html>