<%@page import="com.maraloedev.entities.Votacion"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RESULTADOS</title>
</head>
<body>
	<h1 align="center">RESULTADOS DE LA VOTACI�N</h1>
	<table border="1">
		<tr>
			<td>Alumno</td>
			<td>N� de Votos</td>
		</tr>
		<%HashMap<String, Votacion> mapaVot = (HashMap<String, Votacion>) application.getAttribute("mapVotos");
		if (!mapaVot.isEmpty()){
		for (String key : mapaVot.keySet()) {%>
			<tr>
			<td><%=key%></td>
			<td><%=mapaVot.get(key).getnVotos()%></td>
			</tr>
		<%}}else{%>
		<tr >
		<td colspan="2">Se ha excedido el n�mero de usuarios</td>
		</tr>
		<%} %>
	</table>
	<form action="Votacion.jsp">
		<input type="submit" value="Volver">
	</form>
</body>
</html>