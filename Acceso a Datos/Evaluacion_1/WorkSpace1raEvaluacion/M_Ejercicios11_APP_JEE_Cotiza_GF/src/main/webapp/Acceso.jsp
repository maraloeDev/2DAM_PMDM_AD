<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ACCESO</title>
</head>
<body>

<h1>COTIZAGF S.L</h1>
        <form action="ServletCotizacion" method="post">
            <table>
                <tr>
                <td>Nombre:</td>
                <td><input type="text" name="nombre"></td>
            </tr>

            <tr>
                <td>Codigo Pin:</td>
                <td><input type="text" name="codigoPin"></td>
            </tr>

            <tr>
                <td><input type="submit" name="Acceso" value="Acceso"></td>
                <td><input type="submit" name="Cerrar" value="Cerrar"></td>
            </tr>
            </table>
            
            <%if(request.getAttribute("errorSession")!=null){%>
            <p style="color: red;">${errorSession}</p>
            <% }%>
        </form>
</body>
</html>