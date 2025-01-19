<%@page import="entities.Empleados,java.util.List"%>
<%@page import="org.hibernate.Hibernate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
List<Empleados> l = null;
if (request.getAttribute("listEmpl") != null) {
	l = (List<Empleados>) request.getAttribute("listEmpl");
	System.out.println(l.size());
}
%>
<body>
	<form name="formulario"  action="GestionEmpleados.jsp">
		<table border="1" align="center">
			<tr>
			<th>NOMBRE</th>
			<th>APELLIDOS</th>
			<th>OFICIO</th>
			<th>SALARIO</th>
			</tr>
			
				<%
				if (l.size() != 0) {
					for (Empleados e : l) {
						//Solucinar excepción org.hibernate.LazyInitializationException
						Hibernate.initialize(e);
				%>
				<tr>
				<td><%=e.getNombre()%></td>
				<td><%=e.getApellido()%></td>
				<td><%=e.getOficio()%></td>
				<td><%=e.getSalario()%></td>
                </tr>
				<%
				}
				}
				%>
			
			<tr>
				<td colspan="4"><input type=submit name=volver value=Volver></td>
			</tr>
		</table>
	</form>
</body>
</html>