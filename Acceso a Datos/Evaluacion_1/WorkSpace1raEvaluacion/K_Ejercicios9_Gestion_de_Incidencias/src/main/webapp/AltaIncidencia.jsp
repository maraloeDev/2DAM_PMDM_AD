<%@page import="java.util.Random"%>
<%@page import="com.maraloedev.modelo.Incidencia"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%!Random rndm = new Random(); 
	Integer numeroIncidencia=rndm.nextInt(1, 20);
%>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ALTA INCIDENCIA</h1>
	<form action="ServletIncidencia" method="post">

		<table>
			<tr>
				<td>Tema:</td>
				<td><input type="text" name="tema"></td>
			</tr>
			<tr>
				<td>Descripcion:</td>
				<td><input type="text" name="descripcion" size="45"></td>
			</tr>
			<tr>
				<td colspan="2">
					<%
                        String tema = request.getParameter("tema");
                        String descripcion = request.getParameter("descripcion");
                        boolean isTemaOrDescripcionEmpty = (tema == null || tema.isEmpty()) || (descripcion == null || descripcion.isEmpty());

                        // Si falta algún campo, mostrar el mensaje de error y deshabilitar el botón
                        if (isTemaOrDescripcionEmpty) { 
                    %>
					<p style="color: red;">(* El tema y la descripcion son
						obligatorios)</p> <input type="submit" value="Confirmar"> <% 
                        }
                        %>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
