<%@page import="clases.Persona"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RECOGIDA PERSONA</title>
</head>
<body>
	<%Persona p = request.getAttribute("persona")!=null ?  (Persona) request.getAttribute("persona") : new Persona();%>
	<form action="ServletPersona" method="post">

		<table>
			<tr>
				<td>dni</td>
				<td><input type="text" name="dni"
					value="<%=p.getDni()!=null ? p.getDni() : "" %>"></td>
			</tr>
			<tr>
				<td>Nombre</td>
				<td><input type="text" name="nombre"
					value="<%=p.getNombre()!= null ? p.getNombre() : "" %>"></td>
			</tr>
			<tr>
				<td>Apellido</td>
				<td><input type="text" name="apellidos"
					value="<%=p.getApellidos()!=null ? p.getApellidos() : "" %>"></td>
			</tr>
			<tr>
				<td>Direccion</td>
				<td><input type="text" name="direccion"
					value="<%=p.getDireccion()!= null ? p.getDireccion() : "" %>"></td>
			</tr>
			<tr>
				<td>Telefono</td>
				<td><input type="text" name="telefono"
					value="<%=p.getTelefono()!=null ? p.getTelefono() : "" %>"></td>
			</tr>
			<tr>
				<td>Correo</td>
				<td><input type="text" name="correo"
					value="<%=p.getCorreo()!= null ? p.getCorreo() : "" %>"></td>
			</tr>
			
			<tr>
				<td><input type="submit" name="Enviar" value="Enviar"></td>
				<td><input type="submit" name="Volver" value="Volver"></td>
			</tr>
		</table>
	</form>
</body>
</html>