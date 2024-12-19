<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RESULTADO</title>
</head>
<body>


<form action="ServletEstadistica" method="post">

		<%if(request.getAttribute("realizado")!=null){%>

        <h1>ESTADISTICA WEB AD</h1>

        <h2>Tu respuesta ha sido registrada <%=request.getSession().getAttribute("nombre")!=null ? request.getSession().getAttribute("nombre") : "" %> !!!!</h2>

        <h2>Los resultados de la estadistica son:</h2>

        <table border="2">

            <tr>
                <td>Opcion</td>
                <td>Num.Respuestas</td>
            </tr>

            <tr>
                <td>Me lo se todo, no necesito estudiar, con lo de clase es suficiente</td>
                <td></td>
            </tr>
            <tr>
                <td>No tengo ni idea, no lo intento</td>
               <td></td>
            </tr>
            <tr>
                <td>Estudio en el ultimo momentoEstudio en el ultimo momento</td>
                <td></td>
            </tr>
            <tr>
                <td>Estudio todo lo posible</td>
                <td></td>
            </tr>
        </table>

        <h2>Se han realizado <%=request.getServletContext().getAttribute("contador")!=null ? request.getServletContext().getAttribute("contador") : 0 %> veces</h2>
        
        <% } else {%>
        <p>${realizado }
        <% }%>

        <input type="submit" name="Volver" value="Volver">
    </form>

</body>
</html>