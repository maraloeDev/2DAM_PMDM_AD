
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
	<form action="ServletControlador2" method="post">
		<table align="center" border="2">
			<tr>
				<td>GESTIÓN EMPRESA- DEPARTAMENTOS</td>
			</tr>
			<tr>
				<td>
					<p align="left">Num. Dpto:</p> <input type="text" name="ndpto"
					required />
					<p align="left">Descripción:</p> <input type="text" name="dnombre"
					required />
					<p align="left">Localidad:</p> <input type="text" name="dloc"
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