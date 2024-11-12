
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VOTACI�N DE DELEGADO</title>
</head>
<body>
	<h1 align="center">ELECCI�N DE DELEGADO</h1>
	<hr/>
	<p>Los delegados que presentan a miembros del Consejo Escolar son: </p>
	<form action="ServletVotacion" method="post">
		<input type="checkbox" name="alumno" value="Ruth Fernandez"/><label>Ruth Fern�ndez</label><br>
		<input type="checkbox" name="alumno" value="Victor Vergel"/><label>V�ctor Vergel</label><br>
		<input type="submit" value="Enviar"/><br>
	</form>
	<hr/>
</body>
</html>