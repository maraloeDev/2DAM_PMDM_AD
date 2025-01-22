<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ESTADISTICA</title>
</head>
<body>

    <form action="ServletEstadistica" method="post">

        <h1>ESTADISTICA WEB AD</h1>

        <table>
            <tr>
                <td>Nombre:</td>
                <td><input type="text" name="nombre"></td>
            </tr>
        </table>

        <h2>Cuando se acerca la fecha del examen, eres de los que...</h2>
        <br>
        <br>
        <input type="radio" name="respuesta"> Me lo se todo, no necesito estudiar, con lo de clase es suficiente
        <br>
        <input type="radio" name="respuesta"> No tengo ni idea, no lo intento
        <br>
        <input type="radio" name="respuesta"> Estudio en el ultimo momento
        <br>
        <input type="radio" name="respuesta"> Estudio todo lo posible
        <br>
        <br>
        <input type="submit" name="Enviar" value="Enviar">
        
        <%if(request.getAttribute("errorSession")==null){%>
        
        <p style="color: red;">${errorSession}</p>
        <% }%>
    </form>

</body>
</html>