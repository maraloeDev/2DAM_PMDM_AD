<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alta Incidencia</title>
</head>
<body>

	<h1>ALTA INCIDENCIA</h1>
	<form action="ServletIncidencia" method="post">

		<table>
			<tr>
				<td>Tema :</td>
				<td><input type="text" name="tema"></td>
			</tr>

			<tr>
				<td>Descripción</td>
				<td><input type="text" name="descripcion" size="40"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Confirmar" name="confirmar"></td>
			</tr>
		</table>
		<%if(getServletContext().getAttribute("ErrorCamposIncidencia")!=null){ %>
		<p style="color: red;">${ErrorCamposIncidencia }</p>
			
<%}%>
	</form>
</body>
</html>