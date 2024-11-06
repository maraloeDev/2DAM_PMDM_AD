<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!String cadena = "EJEMPLO016";%>
<%!int numero = 0;%>
<%!public String fecha() {
	return (new Date().toString());
}%>
<html>
<head>
<meta charset="UTF-8">
<title><%=cadena%></title>
</head>
<body>
	<h1>TABLA CONTADOR:</h1>

	<table border=2>

		<%for (int i = numero; i < numero + 10; i++) {%>
		<tr>
			<td>Número</td>
			<td><%=i%></td>
		</tr>
		<%}	numero += 10;
		%>
	</table>
	<p>
		La fecha actual es<%=fecha()%></p>
</body>
</html>