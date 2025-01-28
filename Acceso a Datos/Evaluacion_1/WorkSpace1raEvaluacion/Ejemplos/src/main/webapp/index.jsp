<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="Error.jsp"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Pagina principal</title>
</head>
<body>

Numero: <%=Integer.parseInt(request.getParameter("numero")) %>

</body>
</html>