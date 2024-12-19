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
<title>MANTENIMIENTO</title>
</head>
<body>

<form action="ServletController" method="post">
		<fieldset>
			<legend>
				<h1 style="color: green">MERCHANDISHING GF</h1>
			</legend>
			<h2>Bienvenido/a a la tienda del Gregorio Fernández.</h2>
			<p>Seleccione los artículos que desee actualizar.</p>
			<table border="1">
				<tr>
					<td>Ref.</td>
					<td>Descripción</td>
					<td>Precio</td>

					<%for(Entry<String, Producto> mapaProd : mapaProductos.entrySet()){%>
				<tr>
					<td><input type="checkbox" name="productos" /><%=mapaProd.getKey() %></td>
					<td><input type="text" name="descripcion" value="<%= mapaProd.getValue().getDescripcion()%>"/></td>
					<td><input type="text" name="precio" value="<%=mapaProd.getValue().getPrecio()%>"></td>
				</tr>
				<% }%>
				<tr>
					<td colspan="3" align="center"><input type="submit"
						value="Actualizar"></td>
				</tr>
			</table>
		</fieldset>
	</form>

</body>
</html>