<%@page import="com.maraloedev.modelo.Persona"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RECOGIDA PERSONA</title>
</head>
<body>
<%--Recupero del contexto el atributo persona, que contiene el objeto persona --%>
	<%Persona persona = getServletContext().getAttribute("persona")!=null?(Persona) getServletContext().getAttribute("persona"): new Persona(); %>
	<form action="ServletPersona" method="post">

		<fieldset>
			<legend>RECOGIDA PERSONA</legend>

			<table>
				<tr>
					<td>dni</td>
					<td><input type="text" name="dni" value="<%=persona.getDni()!=null?persona.getDni():""%>" required="required"></td>
				</tr>

				<tr>
					<td>nombre</td>
					<td><input type="text" name="nombre" value="<%=persona.getNombre()!=null?persona.getNombre():""%>" required="required"></td>

				</tr>

				<tr>
					<td>apellidos</td>
					<td><input type="text" name="apellidos" value="<%=persona.getApellidos()!=null?persona.getApellidos():"" %>" required="required"></td>

				</tr>

				<tr>
					<td>direccion</td>
					<td><input type="text" name="direccion" value="<%=persona.getDireccion()!=null?persona.getDireccion():""%>" required="required"></td>
				</tr>

				<tr>
					<td>telefono</td>
					<td><input type="text" name="telefono" value="<%=persona.getTelefono()!=null?persona.getTelefono():""%>" required="required"></td>
				</tr>

				<tr>
					<td>correo</td>
					<td><input type="text" name="correo" value="<%=persona.getCorreo()!=null?persona.getCorreo():""%>" required="required"></td>
				</tr>
			</table>
			<input type="submit" name="boton" value="Enviar">

		</fieldset>
	</form>
</body>
</html>