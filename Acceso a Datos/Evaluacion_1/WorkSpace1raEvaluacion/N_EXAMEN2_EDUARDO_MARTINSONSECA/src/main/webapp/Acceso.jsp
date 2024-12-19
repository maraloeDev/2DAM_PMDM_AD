<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ACCESO</title>
</head>
<body>

	<form action="ServletController" method="post">

		<fieldset>
			<legend>
				<h1 style="color: green">MERCHANDISHING GF</h1>
			</legend>
			<table>
				<tr>
					<td><label>Nombre:</label></td>
					<td><input type="text" name="nombre"></td>

				</tr>
				<tr>
					<td><label>Password:</label></td>
					<td><input type="password" name="contrasena"></td>
				</tr>
				<tr>
					<td><label>Perfil:</label></td>
					<td><select>
							<option>Administrador</option>
					</select></td>
				</tr>
				<tr>
					<td><input type="submit" name="Acceso" value="Acceso"></td>
					<td><input type="submit" name="Salir" value="Salir"></td>
				</tr>
			</table>
		</fieldset>
	</form>
	<%if(request.getAttribute("errorSesion")==null){%>
	<p style="color: red;">${errorSesion }</p>
	<% }%>
</body>
</html>