<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ServletEmpleado" method="post">
		<table align="center" border="2">
			<tr>
				<td>GESTIÓN DEPARTAMENTOS</td>
			</tr>
			<tr>
				<td>
					<p align="left">Num. Dpto:</p> <input type="text" name="ndpto" required>
				</td>
			</tr>
			<tr>
				<td><input type="submit" name="boton" value="Baja" /></td>
			</tr>
		</table>
	</form>
</body>
</html>