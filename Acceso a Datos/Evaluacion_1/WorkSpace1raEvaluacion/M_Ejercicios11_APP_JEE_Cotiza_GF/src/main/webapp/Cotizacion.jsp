<%@page import="java.util.Date"%>
<%@page import="com.maraloedev.model.Cotizacion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
<head>
<%Cotizacion cotizacion = session.getAttribute("cotizacion")!=null ? (Cotizacion)session.getAttribute("cotizacion"):new Cotizacion(); %>
<meta charset="UTF-8">
<title>COTIZACION</title>
</head>
<body>

<h1>COTIZAGF S.L</h1>

		<%if(request.getSession().getAttribute("fechaSession")!=null && request.getSession().getAttribute("nombre")!=null){%>
		<h4>La sesion esta activa por el usuario : <%=cotizacion.getNombre() %></h4>
		<h4>Fecha de nueva cotizacion : ${fechaSession }</h4>
		<% }%>
		
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
                <td><input type="text" name="valorNuevoTURISMO" size="2"></td>
            </tr>

            <tr>
                <td>FARMACIA</td>
                <td>35.5</td>
                <td><input type="text" name="valorNuevoFARMACIA" size="2"></td>
            </tr>

            <tr>
                <td>DAM</td>
                <td>48.5</td>
                <td><input type="text" name="valorNuevoDAM" size="2"></td>
            </tr>

            <tr>
                <td>ATENCION</td>
                <td>30.5</td>
                <td><input type="text" name="valorNuevoATENCION" size="2"></td>
            </tr>

            <tr>
                <td>VENTAS</td>
                <td>20.5</td>
                <td><input type="text" name="valorNuevoVENTAS" size="2"></td>
            </tr>

            <tr>
                <td>ISOCIAL</td>
                <td>37.5</td>
                <td><input type="text" name="valorNuevoISOCIAL" size="2"></td>
            </tr>

            <tr>
                <td>ADIF</td>
                <td>30.0</td>
                <td><input type="text" name="valorNuevoADIF" size="2"></td>
            </tr>

            <tr>
                <td>LA</td>
                <td>58.0</td>
                <td><input type="text" name="valorNuevoLA" size="2"></td>
            </tr>
            
            <tr>
                <td>SMR</td>
                <td>47.5</td>
                <td><input type="text" name="valorNuevoSMR" size="2"></td>
            </tr>

            <tr>
                <td>ADMIN</td>
                <td>45.0</td>
                <td><input type="text" name="valorNuevoADMIN" size="2"></td>
            </tr>

            <tr>
                <td>LABCLIN</td>
                <td>52.0</td>
                <td><input type="text" name="valorNuevoLABCLIN" size="2"></td>
            </tr>

            <tr>
                <td>EDINF</td>
                <td>23.0</td>
                <td><input type="text" name="valorNuevoEDINF" size="2"></td>
            </tr>
        </table>
        <br>
        <input type="submit" name="Enviar" value="Enviar">
    </form>
</body>
</html>