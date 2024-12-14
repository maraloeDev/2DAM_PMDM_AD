<%@page import="java.util.Date"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Acceso</title>
</head>

<%HashMap <Long, String> mapaSessions = getServletContext().getAttribute("mapaSessions")!=null ? (HashMap<Long, String>) getServletContext().getAttribute("mapaSessions") : new HashMap<Long, String>();%>
<%HashMap<String, String> mapaCategorias = getServletContext().getAttribute("mapaCategorias")!=null ? (HashMap<String, String>) getServletContext().getAttribute("mapaCategorias") : new HashMap<String, String>();%>
<body>
<body>
	<h2>DATOS REGISTRO DESARROLLO DE SOFTWARE</h2>

	<form action="ServletUsuario" method="post">

		<table>
			<tr>
				<td>Nombre</td>
				<td><input type="text" name="nombre"></td>
			</tr>

			<tr>
				<td>Contraseña</td>
				<td><input type="password" name="contrasena"></td>
			</tr>

			<tr>
    <td>Elige perfil</td>
    <td>
        <select></select>
    </td>
</tr>
<tr>
				<td><input type="submit" name="boton" value="Acceso"></td>
			</tr>
		</table>
		
		<%for(Entry<Long, String> mapaSession : mapaSessions.entrySet()) {%>
		
		<p>A las <%=new Date().toString()%> se creó esta session con el identificador <%=mapaSession.getKey()%></p> 			
		<%}%>
	</form>
</body>
</html>