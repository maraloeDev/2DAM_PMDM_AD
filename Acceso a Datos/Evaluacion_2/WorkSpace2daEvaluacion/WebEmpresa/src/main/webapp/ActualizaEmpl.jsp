<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ServletControlador" method="post">
		<table align="center" border="2">
			<tr >
				<td colspan="3">GESTIÓN EMPRESA- EMPLEADOS</td>
			</tr>
			<tr >
				<td colspan="3">
					<p align="left">Nombre:</p> <input type="text" name="nombre" required />
					<p align="left">Apellidos:</p> <input type="text" name="apellidos" required />
	                <p align="left">Oficio:</p> <input type="text" name="oficio"  />
	                <p align="left">Salario:</p> <input type="text" name="salario"  />
			</tr>
			<tr>
				<td><input type="submit" name="boton" value="Actualizar" /></td>
			</tr>
		</table>
	</form>
</body>
</html>