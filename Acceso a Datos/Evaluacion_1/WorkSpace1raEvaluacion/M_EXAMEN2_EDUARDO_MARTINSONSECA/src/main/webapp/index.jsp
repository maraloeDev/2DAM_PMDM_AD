<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="ServletController" method="post">
		<fieldset>
			<legend>
				<h1 style="color: green">MERCHANDISHING GF</h1>
				<input type="submit" value="Login">
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
				<tr>
					<td><input type="checkbox" /></td>
					<td></td>
					<td></td>
				</tr>

				<tr>
					<td colspan="3" align="center"><input type="submit"
						value="Ver Cesta"></td>
				</tr>
			</table>

		</fieldset>
	</form>
</body>
</html>