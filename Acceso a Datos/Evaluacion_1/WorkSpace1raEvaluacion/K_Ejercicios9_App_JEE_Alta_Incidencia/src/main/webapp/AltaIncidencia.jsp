<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ALTA INCIDENCIA</title>
</head>
<body>

	<h1>ALTA INCIDECIA</h1>

	<form action="ServletIncidencia" method="post">

		<table>
			<tr>
				<td>Tema:</td>
				<td><input type="text" name="tema"></td>
			</tr>
			<tr>
				<td>Descripcion:</td>
				<td><input type="text" name="descripcion"></td>
			</tr>
		</table>
		
		<%if(request.getAttribute("Error")!=null){%>
			<p style="color: red">${Error}</p>
		<% }%>
		<input type="submit" value="Confirmar">
	</form>

</body>
</html>