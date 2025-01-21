<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ServletControlador2" method="post">
		<table align="center" border="2">
			<tr >
				<td colspan="3">GESTIÓN EMPRESA- DEPARTAMENTOS</td>
			</tr>
			<tr >
				<td colspan="3">
					<p align="left">Num. Dpto:</p> <input type="text" name="ndpto" required />
					<p align="left">Descripción:</p> <input type="text" name="dnombre" />
	                <p align="left">Localidad:</p> <input type="text" name="dloc"  />
					
			</tr>
			<tr>
				<td><input type="submit" name="boton" value="Actualizar" /></td>
			</tr>
		</table>
	</form>
</body>
</html>