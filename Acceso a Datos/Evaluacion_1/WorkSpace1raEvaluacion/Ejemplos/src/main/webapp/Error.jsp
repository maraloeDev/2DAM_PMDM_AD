<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ERROR ERES TONTO</h1>
<% if(exception!=null){
	exception.printStackTrace(new PrintWriter(out));
} %>

</body>
</html>