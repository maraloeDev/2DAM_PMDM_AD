<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.maraloedev.model.Cotizacion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%Cotizacion cotizacion = session.getAttribute("cotizacion")!=null ? (Cotizacion)session.getAttribute("cotizacion"):new Cotizacion(); %>
<%HashMap<Integer,String> valorNuevo = getServletContext().getAttribute("valorNuevo")!=null ? (HashMap<Integer,String>) getServletContext().getAttribute("valorNuevo"):new HashMap<Integer,String>(); %>
<meta charset="UTF-8">
<title>CONSULTA COTIZACION</title>
</head>
<body>

<h1>COTIZAGF S.L</h1>

		<%if(request.getSession().getAttribute("fechaSession")!=null && request.getSession().getAttribute("nombre")!=null){%>
		<h4>La sesion esta activa por el usuario : <%=cotizacion.getNombre()!=null ? cotizacion.getNombre() : "" %></h4>
		<h4>Fecha de nueva cotizacion : ${fechaSession }</h4>
		<% }%>
		
        <form action="ServletCotizacion" method="post">
            <table border="2">
    
                <tr>
                    <td>Ciclo</td>
                    <td>Valor Anterior</td>
                    <td>Valor Actual</td>
                    <td>Condicion</td>
                </tr>
    
                <tr>
                    <td>TURISMO</td>
                    <td>19.5</td>
                    <%for(Entry<Integer,String> elValor :valorNuevo.entrySet()) {%>
                    <td><%=elValor.getValue() %></td>
                    
                    <%
                    break;
                    }%>
                    
                    <td></td>
                </tr>
    
                <tr>
                    <td>FARMACIA</td>
                    <td>35.5</td>
                    <td></td>
                    <td></td>
                </tr>
    
                <tr>
                    <td>DAM</td>
                    <td>48.5</td>
                    <td></td>
                    <td></td>
                </tr>
    
                <tr>
                    <td>ATENCION</td>
                    <td>30.5</td>
                    <td></td>
                    <td></td>
                </tr>0
    
                <tr>
                    <td>VENTAS</td>
                    <td>20.5</td>
                    <td></td>
                    <td></td>
                </tr>
    
                <tr>
                    <td>ISOCIAL</td>
                    <td>37.5</td>
                    <td></td>
                    <td></td>
                </tr>
    
                <tr>
                    <td>ADIF</td>
                    <td>30.0</td>
                    <td></td>
                    <td></td>
                </tr>
    
                <tr>
                    <td>LA</td>
                    <td>58.0</td>
                    <td></td>
                    <td></td>
                </tr>
                
                <tr>
                    <td>SMR</td>
                    <td>47.5</td>
                    <td></td>
                    <td></td>
                </tr>
    
                <tr>
                    <td>ADMIN</td>
                    <td>45.0</td>
                    <td></td>
                    <td></td>
                </tr>
    
                <tr>
                    <td>LABCLIN</td>
                    <td>52.0</td>
                    <td></td>
                    <td></td>
                </tr>
    
                <tr>
                    <td>EDINF</td>
                    <td>23.0</td>
                    <td></td>
                    <td></td>
                </tr>
            </table>
            <br>
            <input type="submit" name="Volver" value="Volver">
        </form>
</body>
</html>