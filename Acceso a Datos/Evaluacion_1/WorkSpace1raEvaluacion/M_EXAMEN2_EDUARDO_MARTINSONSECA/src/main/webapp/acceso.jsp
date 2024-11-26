<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
					<td><input type="text"></td>

				</tr>
				<tr>
					<td><label>Password:</label></td>
					<td><input type="password"></td>
				</tr>
				<tr>
					<td><label>Perfil:</label></td>
					<td><select>
							<option>Administrador</option>
					</select></td>
				</tr>
				<tr>
					<td><input type="submit" value="Acceso"></td>
					<td><input type="submit" value="Salir"></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>