<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PARTICIPAR</title>
<%
    Integer contador = (Integer) session.getAttribute("contador");
    if (contador == null) {
        contador = 1; // Si es la primera vez que el participante accede
    }
%>
</head>
<body>

	<form action="ServletSorteo" method="post">
		<h1>SORTEO GF</h1>
		<table>
			<tr>
				<td>
					<label>Con usted han participado 
						<%= contador %> personas.
					</label>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" name="papeleta" value="Elija Papeleta">
				</td>
			</tr>
		</table>
		
		<% if (session.getAttribute("listaSessiones") != null) { %>
		<p style="color: red;"><%= "ID conectado: " + session.getAttribute("listaSessiones").toString() %></p>
		<% } %>
	</form>

</body>
</html>
