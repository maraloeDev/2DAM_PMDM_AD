<%@page import="java.time.LocalDate"%>
<%@page import="org.hibernate.dialect.function.NvlCoalesceEmulation"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MENSAJE</title>
</head>
<body>

	<table align="center">
		<tr>
			<td>
				<h1>SEDE ELECTRÓNICA GF</h1>
			</td>
		</tr>
		<tr>
			<td>
				<p>
					<b>${mensajeError}</b>
				</p>
			</td>
		</tr>
		<tr align="right">
			<td>
				<form action="ServletRegistro" method="get">
					<input type="submit" value="Nuevo Registro">
				</form>
			</td>

			<td>
				<form action="Buscar.jsp" method="get">
					<input type="submit" value="Consulta Registro">
				</form>
			</td>
		</tr>
	</table>

</body>
</html>
