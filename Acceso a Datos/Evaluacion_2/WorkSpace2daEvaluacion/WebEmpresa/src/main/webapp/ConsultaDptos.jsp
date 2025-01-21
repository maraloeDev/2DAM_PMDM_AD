<%@page import="entities.Departamentos,java.util.List"%>
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
List<Departamentos> l = null;
if (request.getAttribute("listDptos") != null) {
	l = (List<Departamentos>) request.getAttribute("listDptos");
	System.out.println(l.size());
}
%>
<body>
	<form name="formulario"  action="GestionDptos.jsp">
		<table border="1" align="center">
			<tr>
			<th>NUM. DPTO</th>
			<th>DESCRIPCIÓN</th>
			<th>LOCALIDAD</th>
			</tr>
			
				<%
				if (l.size() != 0) {
					for (Departamentos d : l) {
						//Solucinar excepción org.hibernate.LazyInitializationException
						Hibernate.initialize(d);
				%>
				<tr>
				<td><%=d.getDepNo()%></td>
				<td><%=d.getDnombre()%></td>
				<td><%=d.getDloc()%></td>
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