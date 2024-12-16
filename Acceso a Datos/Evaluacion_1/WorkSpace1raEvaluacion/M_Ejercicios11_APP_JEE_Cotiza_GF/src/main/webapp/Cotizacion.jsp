<%@page import="com.maraloedev.model.Cotizacion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>COTIZACION</title>
</head>
<body>

<h1>COTIZAGF S.L</h1>

        <form action="ServletCotizacion" method="post">
        
        <table border="2">

            <tr>
                <td>Ciclo</td>
                <td>Valor Actual</td>
                <td>Valor Nuevo</td>
            </tr>

            <tr>
                <td>TURISMO</td>
                <td>19.5</td>
                <td><input type="text" name="valorNuevo"></td>
            </tr>

            <tr>
                <td>FARMACIA</td>
                <td>19.5</td>
                <td><input type="text" name="valorNuevo"></td>
            </tr>

            <tr>
                <td>DAM</td>
                <td>19.5</td>
                <td><input type="text" name="valorNuevo"></td>
            </tr>

            <tr>
                <td>ATENCION</td>
                <td>19.5</td>
                <td><input type="text" name="valorNuevo"></td>
            </tr>

            <tr>
                <td>VENTAS</td>
                <td>19.5</td>
                <td><input type="text" name="valorNuevo"></td>
            </tr>

            <tr>
                <td>ISOCIAL</td>
                <td>19.5</td>
                <td><input type="text" name="valorNuevo"></td>
            </tr>

            <tr>
                <td>ADIF</td>
                <td>19.5</td>
                <td><input type="text" name="valorNuevo"></td>
            </tr>

            <tr>
                <td>LA</td>
                <td>19.5</td>
                <td><input type="text" name="valorNuevo"></td>
            </tr>

            <tr>
                <td>ADMIN</td>
                <td>19.5</td>
                <td><input type="text" name="valorNuevo"></td>
            </tr>

            <tr>
                <td>LABCLIN</td>
                <td>19.5</td>
                <td><input type="text" name="valorNuevo"></td>
            </tr>

            <tr>
                <td>EDINF</td>
                <td>19.5</td>
                <td><input type="text" name="valorNuevo"></td>
            </tr>
        </table>
        <br>
        <input type="submit" value="Enviar">
    </form>

</body>
</html>