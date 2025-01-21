<%@page import="java.util.Map.Entry"%>
<%@page import="com.maraloedev.model.Producto"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%HashMap<String, Producto> mapaProductos = getServletContext().getAttribute("mapaProductos")!=null ? (HashMap<String,Producto>) getServletContext().getAttribute("mapaProductos") :new HashMap<String,Producto>();%>
<meta charset="UTF-8">
<title>INDEX</title>
</head>
<body>

	<form action="ServletController" method="post">
		<fieldset>
			<legend>
				<h1 style="color: green">MERCHANDISHING GF</h1>
				<input type="submit" name="Login" value="Login">
			</legend>
			<h2>Bienvenido/a a la tienda del Gregorio Fernández.</h2>
			<h3>En el día de hoy se han realizado: compra/s.</h3>
			<p>Seleccione los artículos que desee comprar.Recuerde que solo
				se permite una única unidad por artículo para cada miembro de la
				comunidad.</p>
			<table border="1">
				<tr>
					<td>Ref.</td>
					<td>Descripción</td>
					<td>Precio</td>

					<%for(Entry<String, Producto> mapaProd : mapaProductos.entrySet()){%>
				
				<tr>
					<td><input type="checkbox" name="productos" value="<%=mapaProd.getKey() %>" /><%=mapaProd.getKey() %></td>
					<td><%=mapaProd.getValue().getDescripcion() %></td>
					<td><%=mapaProd.getValue().getPrecio() %></td>
				</tr>
				<% }%>
				<tr>
					<td colspan="3" align="center"><input type="submit"
						value="Ver Cesta"></td>
				</tr>
			</table>
			<%if(request.getAttribute("errorCesta")==null){%>
			
			<p>${errorCesta }</p>
			<% }%>
		</fieldset>
	</form>
</body>
</html>