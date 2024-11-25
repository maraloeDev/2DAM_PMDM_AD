<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.maraloedev.modelo.Incidencia"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CONSULTAR INCIDENCIA</title>
</head>
<body>

	<%HashMap<Integer, Incidencia> mapaIncidencias = getServletContext().getAttribute("mapaIncidencias")!=null ? (HashMap<Integer,Incidencia>) getServletContext().getAttribute("mapaIncidencias") : new HashMap<Integer,Incidencia>(); %>


	<form action="ServletIncidencia" method="post">
		<table border="2">
			<tr>
				<td>INCIDENCIA</td>
				<td>TEMA</td>
				<td>DESCRIPCION</td>
			</tr>


			<%
			for(Entry<Integer,Incidencia> totalIncidencias : mapaIncidencias.entrySet()) {%>
			<tr>
				<td><%=totalIncidencias.getKey() %></td>
				<td><%=totalIncidencias.getValue().getTema() %></td>
				<td><%=totalIncidencias.getValue().getDescripcion() %></td>
			</tr>
			<%}%>

		</table>
		<input type="submit" name="Volver" value="Volver">
	</form>
</body>
</html>