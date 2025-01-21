<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.maraloedev.model.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
<head>
<%
HashMap<String, String> listaUsuarios = session.getAttribute("listaUsuarios") != null
		? (HashMap) session.getAttribute("listaUsuarios")
		: new HashMap<String, String>();
%>
<%
Usuario usuario = session.getAttribute("usuario") != null ? (Usuario) session.getAttribute("usuario") : new Usuario();
%>

<meta charset="UTF-8">
<title>Aplicacion</title>
</head>
<body>

	<h2>DATOS REGISTRO DESARROLLO DE SOFTWARE</h2>

	<form action="ServletUsuario" method="post">

		<%=usuario.getNombre()%>
		has accedido correctamente Numero de veces que has accedido: 1 veces
		<table border="2">
			<tr>
				<td>Usuarios registrados</td>
			</tr>
			<%for (Entry<String, String> usuarios : listaUsuarios.entrySet()) {%>
			<tr>
				<td><%=usuarios.getKey()%></td>
			</tr>
			<%
			}
			%>
			<tr>
				<td><input type="submit" name="AccesoApp" value="Acceso"></td>
			</tr>
		</table>
	</form>
</body>
</html>