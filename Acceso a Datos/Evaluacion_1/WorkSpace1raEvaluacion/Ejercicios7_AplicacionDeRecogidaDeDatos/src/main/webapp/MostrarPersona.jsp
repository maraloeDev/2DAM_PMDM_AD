<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fieldset>
		<legend>
			<h1>DATOS DE LA PERSONA <%=request.getParameter("nombre") %></h1>
		</legend>
<form action="RecogidaPersona.jsp">
 dni <input type="text" name="dni" value="<%=request.getParameter("dni")%>" disabled="disabled"/><br>
            nombre <input type="text" name="nombre" value="<%=request.getParameter("nombre")%>" disabled="disabled"/><br>
            direccion <input type="text" name="direccion" value="<%=request.getParameter("direccion")%>"disabled="disabled"/><br>
            correo <input type="text" name="correo" value="<%=request.getParameter("correo")%>"disabled="disabled"/><br>
            <br>
            <input type="submit" value="Volver"/>
        </form>
        </fieldset>
</body>
</html>