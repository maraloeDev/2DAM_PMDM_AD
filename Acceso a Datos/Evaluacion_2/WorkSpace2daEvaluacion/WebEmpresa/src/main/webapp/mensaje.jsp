%@page import="pojos.Empleados,java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Avisos</title>
</head>
<body>
	<form name="formulario" method="post" action="GestionEmpleados.jsp">
		<table bgcolor="Yellow" align="center">
			<tr>
				<td><%=request.getAttribute("mensaje")%></td>
			</tr>
			
			<tr>
				<td><input type=submit name=volver value=Volver></td>
			</tr>
		</table>
	</form>
</body>
</html>