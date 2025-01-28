<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VOTACION</title>
</head>
<body>

<body>
    ELECCION DE DELEGADO
    <hr>
    Los delegados que se presentan a miembros del consejo escolar son:
    
    <form action="ServletVotacion" method="post">
        <table>
            <tr>
                <td><input type="checkbox" name="delegado" value="Ruth Fernandez"> RUTH FERNANDEZ</td>
            </tr>

            <tr>
                <td><input type="checkbox" name="delegado" value="Victor Vergel"> VICTOR VERGEL</td>
            </tr>
	
            <tr>
                <td><input type="submit" name="boton" value="Enviar"></td>
            </tr>
        </table>
    </form>
    <hr>
</body>
</html>