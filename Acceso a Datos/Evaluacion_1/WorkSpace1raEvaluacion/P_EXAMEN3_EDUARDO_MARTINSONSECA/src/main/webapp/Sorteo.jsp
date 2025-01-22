<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SORTEO</title>
</head>
<body>

	<form action="ServletSorteo" method="post">
		<h1>SORTEO GF</h1>

		<% if (request.getSession().getAttribute("participante") != null) { %>
		<h3>Lo sentimos, no puede participar de nuevo</h3>
		<% } else { %>
		<table>
			<tr>
				<td><label>Participante:</label></td>
				<td><input type="text" name="participante"></td>
			</tr>
			<tr>
				<td><input type="submit" name="incribir" value="Inscripción"></td>
			</tr>
		</table>

		<% if (request.getAttribute("errorSession") != null) { %>
		<p style="color: red;"><%= request.getAttribute("errorSession") %></p>
		<% } %>
		<% } %>
		
		<% if(session.getAttribute("idDesconectado") != null) { %>
		<p style="color: red;"><%= session.getAttribute("idDesconectado") %></p>
		<% } %>
	</form>
</body>
</html>
