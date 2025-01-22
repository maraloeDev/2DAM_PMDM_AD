<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<% Integer accesos = (Integer) session.getAttribute("accesos");

if(accesos == null){
	accesos =0;
}
accesos = accesos.intValue() +1;
session.setAttribute("accesos", accesos);
if(request.getParameter("invalidaSession")!=null){
	session.invalidate();
	accesos = accesos - 1;
}%>
<html>
<head>
<meta charset="UTF-8">
<title>EJEMPLO017</title>
</head>
<body>

<form>
<input type=submit name = "invalidaSession" value="Invalida sesion"> <br>
<input type="submit" name = "recargarSession" value="Recargar sesion">
</form>
<br>
Contador: 
<%=accesos.intValue() %>

</body>
</html>