<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consultar Registro</title>

</head>
<body>

	<%-- Muestro el mensaje de error si no se encuentra el registro --%>
	<%
    String mensajeError = (String) request.getAttribute("mensajeError");
    if (mensajeError != null) {
        out.println("<p style='color: red;'>" + mensajeError + "</p>");
    }
%>

	<%-- MRecupero los atributos escritos por el usuario en Registro,JSP --%>
	<%
    String dni = (String) request.getAttribute("dni");
    String nombre = (String) request.getAttribute("nombre");
    String apellidos = (String) request.getAttribute("apellidos");
    String tramite = (String) request.getAttribute("tramite");
    String entidad = (String) request.getAttribute("entidad");
    String numeroRegistro = (String) request.getAttribute("numeroRegistro");
%>

    <%-- Muestro los datos del registro deshabilitando los campos --%>
	<table border="2" align="center">
		<tr>
			<td colspan="2" align="center"><h1>SEDE ELECTRÓNICA GF</h1></td>
		</tr>
		<tr>
			<td><label for="dni"><b>DNI solicitante:</b></label></td>
			<td><input type="text" name="dni" value="<%= dni %>"
				maxlength="9" style="width: 280px" disabled></td>
		</tr>
		<tr>
			<td><label for="nombre"><b>NOMBRE solicitante:</b></label></td>
			<td><input type="text" name="nombre" value="<%= nombre %>"
				style="width: 280px" disabled></td>
		</tr>
		<tr>
			<td><label for="apellidos"><b>APELLIDOS solicitante:</b></label></td>
			<td><input type="text" name="apellidos" value="<%= apellidos %>"
				style="width: 280px" disabled></td>
		</tr>
		<tr>
			<td><label for="tramite"><b>TRÁMITE:</b></label></td>
			<td><input type="text" name="tramite" value="<%= tramite %>"
				style="width: 280px" disabled></td>
		</tr>
		<tr>
			<td><label for="entidad"><b>ENTIDAD:</b></label></td>
			<td><input type="text" name="entidad" value="<%= entidad %>"
				style="width: 280px" disabled></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<form action="Buscar.jsp" method="get" style="display: inline;">
					<input type="submit" value="Nueva búsqueda">
				</form>
				<form action="ServletRegistro" method="get" style="display: inline;">
					<input type="submit" value="Nuevo registro">
				</form>
			</td>
		</tr>
	</table>

</body>
</html>
