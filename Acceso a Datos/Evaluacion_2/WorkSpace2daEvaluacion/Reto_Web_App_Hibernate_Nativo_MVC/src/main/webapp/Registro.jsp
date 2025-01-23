<%@page import="entities.Entidades"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REGISTRO</title>
</head>
<body>
	<form action="ServletRegistro" method="post">
		<table border="2" align="center">
			<tr>
				<td colspan="2" align="center"><h1>SEDE ELECTRÓNICA GF</h1></td>
			</tr>
			<tr>
				<td><label for="dni"><b>DNI solicitante:</b></label></td>
				<td><input type="text" name="dni" maxlength="9"
					style="width: 280px" required></td>
			</tr>
			<tr>
				<td><label for="nombre"><b>NOMBRE solicitante:</b></label></td>
				<td><input type="text" name="nombre" style="width: 280px"
					required></td>
			</tr>
			<tr>
				<td><label for="apellidos"><b>APELLIDOS
							solicitante:</b></label></td>
				<td><input type="text" name="apellidos" style="width: 280px"
					required></td>
			</tr>
			<tr>
				<td><label for="tramite"><b>TRÁMITE:</b></label></td>
				<td><input type="text" name="tramite" style="width: 280px"
					required></td>
			</tr>
			<tr>
				<td><label for="entidad"><b>ENTIDAD:</b></label></td>
				<td><select name="entidad">
						<%
						// Suponemos que "entidades" es una lista de objetos Entidades enviada desde el servlet
						List<Entidades> entidades = (List<Entidades>) request.getAttribute("entidades");

						if (entidades != null && !entidades.isEmpty()) {
							for (Entidades entidad : entidades) {
						%>
						<option value="<%=entidad.getId()%>"><%=entidad.getNombre()%></option>
						<%
						}
						} else {
						%>
						<option value="">No hay entidades disponibles</option>
						<%
						}
						%>

				</select></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit"
					value="Grabar"></td>
			</tr>
		</table>
	</form>
</body>
</html>
