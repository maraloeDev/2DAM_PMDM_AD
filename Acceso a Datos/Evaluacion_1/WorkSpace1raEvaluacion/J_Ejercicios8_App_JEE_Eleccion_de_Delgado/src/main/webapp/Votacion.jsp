<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VOTACION</title>
</head>
<body>

<form action="ServletVotacion" method="post">
        <table>
            <tr>
                <td><input type="checkbox" name="delegados" value="Ruth Fernandez">RUTH FERNANDEZ</td>
            </tr>

            <tr>
                <td><input type="checkbox" name="delegados" value="Victor Vergel">VICTOR VERGEL</td>
            </tr>
            
            <tr>
                <td><input type="submit" name = "Enviar" value="Enviar"></td>
            </tr>
        </table>
    </form>
</body>
</html>