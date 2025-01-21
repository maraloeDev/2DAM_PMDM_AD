<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Buscar Registro</title>
</head>
<body>



<form action="ServletRegistro" method="get">
    <table border="2" align="center">
        <tr>
            <td colspan="2" align="center"><h1>SEDE ELECTRÓNICA GF</h1></td>
        </tr>
        <tr>
            <td><label for="numeroRegistro"><b>Numero Registro:</b></label></td>
            <td><input type="text" name="numeroRegistro" maxlength="9" style="width: 280px" required></td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="submit" value="Buscar">
            </td>
        </tr>
    </table>
</form>
