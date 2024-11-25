<%@page import="java.util.Map"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="como.maraloedev.modelo.Votacion"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>RESULTADOS</title>
</head>
<body>
    <h1>Resultados de la Votación</h1>
    <table border="1">
        <tr>
            <th>Alumno</th>
            <th>Número de Votos</th>
        </tr>
        <%
            Map<String, Votacion> mapaVotos = getServletContext().getAttribute("mapaVotos")!=null ? (HashMap<String,Votacion>) getServletContext().getAttribute("mapaVotos") : new HashMap();
                for (Entry <String, Votacion> candidato : mapaVotos.entrySet()) {
        %>
            <tr>
                <td><%=candidato.getKey()%></td>
                <td><%=candidato.getValue().getnVotos()%></td>
            </tr>
        <%
                }
            
        %>
    </table>
    <br>
    <form action="Votacion.jsp" method="post">
        <input type="submit" name="Volver" value="Volver">
    </form>
</body>
</html>