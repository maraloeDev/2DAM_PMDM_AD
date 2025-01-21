<%@page import="java.util.Map.Entry"%>
<%@page import="com.maraloedev.modelo.Votacion"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RESULTADOS</title>
</head>
<body>
<%HashMap<String, Votacion> mapaVotacion = getServletContext().getAttribute("mapaVotacion")!=null ? (HashMap<String, Votacion>)getServletContext().getAttribute("mapaVotacion") : new HashMap<String, Votacion>(); %>
	<form action="Votacion.jsp" method="post">
		<table border="2">
			<tr>
				<td>Alumno</td>
				<td>Nº Votos</td>
			</tr>
			
			<%for(Entry <String, Votacion> listaVotos : mapaVotacion.entrySet()) {%>
			

			<tr>
				<td><%= listaVotos.getKey() %></td>
				<td><%= listaVotos.getValue().getnVotos() %></td>
			</tr>
			<%}%>
		</table>

		<hr>

		<input type="submit" name="boton" value="Volver">
	</form>
</body>
</html>