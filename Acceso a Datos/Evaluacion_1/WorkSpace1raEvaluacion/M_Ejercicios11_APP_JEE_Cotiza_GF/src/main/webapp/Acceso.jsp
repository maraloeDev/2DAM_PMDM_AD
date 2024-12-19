<%@page import="com.maraloedev.model.Cotizacion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%Cotizacion cotizacion = session.getAttribute("cotizacion")!=null ? (Cotizacion)session.getAttribute("cotizacion"):new Cotizacion(); %>
<meta charset="UTF-8">
<title>ACCESO</title>
</head>
<body>

<h1>COTIZAGF S.L</h1>
        <form action="ServletCotizacion" method="post">
            <table>
                <tr>
                <td>Nombre:</td>
                <td><input type="text" name="nombre" value="<%=cotizacion.getNombre()!=null ? cotizacion.getNombre() : ""%>"></td>
            </tr>

            <tr>
                <td>Codigo Pin:</td>
                <td><input type="text" name="codigoPin" value="<%=cotizacion.getCodigo_Pin()!=null ? cotizacion.getCodigo_Pin() : ""%>"></td>
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