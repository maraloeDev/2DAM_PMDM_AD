<%@page import="com.maraloedev.modelo.Persona"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%Persona p = request.getAttribute("Persona") != null ? (Persona) request.getAttribute("Persona") : new Persona(); %>

<meta charset="UTF-8">
<title>RECOGIDA DE DATOS</title>
</head>
<body>

	<fieldset>
		<legend>
			<h1>Recogida de datos</h1>
		</legend>

		<form action="ServletPersona" method="post">
			<table>
				<tr>
					<td>DNI/NIF:</td>
					<td><input type="text" value="<%=p.getDni()!=null ? p.getDni():""%>" name="dni" size="10"></td>
				</tr>
				<tr>
					<td>Nombre:</td>
					<td><input type="text" value="<%=p.getNombre()!=null?p.getNombre():""%>" name="nombre" size="20"></td>
				</tr>
				<tr>
					<td>Apellidos:</td>
					<td><input type="text" value="<%=p.getApellidos()!=null?p.getApellidos():""%>" name="apellidos" size="40"
						maxlength="40"></td>
				</tr>
				<tr>
					<td>Dirección:</td>
					<td><input type="text" value="<%=p.getDireccion()!=null?p.getDireccion():"" %>" name="direccion" size="40"
						maxlength="40"></td>
				</tr>
				<tr>
					<td>Teléfono:</td>
					<td><input type="text" value="<%=p.getTelefono()!=null? p.getTelefono():""%>" name="telefono" size="9"></td>
				</tr>
				<tr>
					<td>Correo:</td>
					<td><input type="text" value="<%=p.getCorreo()!=null? p.getCorreo():""%>" name="correo" size="40"></td>
				</tr>
				<tr>
					<td><input type="submit" name="Enviar" value="Enviar"></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>