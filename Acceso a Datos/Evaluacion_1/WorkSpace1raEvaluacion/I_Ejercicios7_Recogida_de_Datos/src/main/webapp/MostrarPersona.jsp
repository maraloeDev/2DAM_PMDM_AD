<%@page import="clases.Persona"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MOSTRAR PERSONA</title>
</head>
<body>

<%Persona p = request.getAttribute("persona")!=null ?  (Persona) request.getAttribute("persona") : new Persona();%>
	<form action="ServletPersona" method="post">

		<table>
			<tr>
				<td>dni</td>
				<td><input type="text" name="dni"
					value="<%=p.getDni()!=null ? p.getDni() : "" %>" disabled="disabled"></td>
			</tr>
			<tr>
				<td>Nombre</td>
				<td><input type="text" name="nombre"
					value="<%=p.getNombre()!= null ? p.getNombre() : "" %>"disabled="disabled"></td>
			</tr>
			<tr>
				<td>Apellido</td>
				<td><input type="text" name="apellidos"
					value="<%=p.getApellidos()!=null ? p.getApellidos() : "" %>"disabled="disabled"></td>
			</tr>
			<tr>
				<td>Direccion</td>
				<td><input type="text" name="direccion"
					value="<%=p.getDireccion()!= null ? p.getDireccion() : "" %>"disabled="disabled"></td>
			</tr>
			<tr>
				<td>Telefono</td>
				<td><input type="text" name="telefono"
					value="<%=p.getTelefono()!=null ? p.getTelefono() : "" %>"disabled="disabled"></td>
			</tr>
			<tr>
				<td>Correo</td>
				<td><input type="text" name="correo"
					value="<%=p.getCorreo()!= null ? p.getCorreo() : "" %>"disabled="disabled"></td>
			</tr>
		</table>
		<input type="submit" name="Volver" value="Volver">
	</form>
</body>
</html>