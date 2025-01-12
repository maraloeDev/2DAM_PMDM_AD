<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sistema Preinscripción GF</title>
</head>
<body>


	<h1>SISTEMA PREINSCRIPCION GF</h1>

	<form action="ServletPreinscripcion" method="post">


		<table>
			<tr>
				<td>DNI:</td>
				<td><input type="text" name="dni" required="required"></td>
			</tr>

			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre" required="required"></td>
			</tr>

			<tr>
				<td>Apellidos:</td>
				<td><input type="text" name="apellidos" required="required"></td>
			</tr>

			<tr>
				<td>Titulo:</td>
				<td>
					<%--sacar opciones de la bd --%>
				</td>
			</tr>

			<tr>
				<td>Fecha de inscripcion:</td>
				<td><input type="date" name="fecha_de_inscripcion"required="required"></td>
			</tr>

			<tr>
				<td><input type="submit" name="" value="Grabar"></td>
			</tr>
		</table>
	</form>
</body>
</html>