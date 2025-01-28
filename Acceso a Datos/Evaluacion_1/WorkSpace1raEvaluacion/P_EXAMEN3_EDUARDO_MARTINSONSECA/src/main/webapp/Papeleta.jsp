<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PAPELETA</title>
</head>
<body>

	<form action="ServletSorteo" method="post">
		<h1>SORTEO GF</h1>
		<table>
			<tr>
				<td>
					<h3>Número... <%= session.getAttribute("numero") != null ? session.getAttribute("numero") : "" %></h3>
				</td>
				<td>
					<h3><%= session.getAttribute("resultado") != null ? session.getAttribute("resultado") : "Resultado no disponible" %></h3>
				</td>
			</tr>
			<tr>
				<td>Gracias por participar.</td>
				<td>
					<input type="submit" name="volver" value="Volver">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>
