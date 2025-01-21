
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List,entities.Departamentos"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
List<Departamentos> listDptos=null;
if (request.getAttribute("listDptos")!=null)
	listDptos=(List<Departamentos>)request.getAttribute("listDptos"); %>
<body>
	<form action="ServletControlador" method="post">
		<table align="center" border="2">
			<tr>
				<td>GESTIÓN EMPRESA- EMPLEADOS</td>
			</tr>
			<tr>
				<td>
					<p align="left">Departamento:</p> <select name="dpto">
					<%for (Departamentos d: listDptos ){%>
					<option value="<%=d.getDepNo()%>"><%=d.getDnombre()%></option>
					<%}%>
					</select>
					
					<p align="left">Nombre:</p> <input type="text" name="nombre"
					required />
					<p align="left">Apellidos:</p> <input type="text" name="apellidos"
					required />
					<p align="left">Oficio:</p> <input type="text" name="oficio"
					required />
					<p align="left">Salario:</p> <input type="text" name="salario"
					required />
				</td>
			</tr>
			<tr>
				<td><input type="submit" name="boton" value="Alta" /></td>
			</tr>
		</table>
	</form>
</body>
</body>
</html>