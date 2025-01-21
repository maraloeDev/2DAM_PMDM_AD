<%@page import="com.maraloedev.model.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>COMPRA</title>
</head>
<body>

<%
ArrayList<Producto> listaProductos = new ArrayList<Producto>();
if(session!=null) {
	// Obtener la lista de productos desde la sesión (previniendo posibles errores de null)
    listaProductos = session.getAttribute("listaProductos") != null 
        ? (ArrayList<Producto>) session.getAttribute("listaProductos") 
        : new ArrayList<Producto>();
}
    // Obtener la lista de productos desde la sesión (previniendo posibles errores de null)
    //ArrayList<Producto> listaProductos = session.getAttribute("listaProductos") != null 
     //   ? (ArrayList<Producto>) session.getAttribute("listaProductos") 
     //   : new ArrayList<Producto>();
%>

<form action="ServletController" method="post">
    <fieldset>
        <legend>
            <h1 style="color: green">MERCHANDISHING GF</h1>
            <input type="submit" value="Login">
        </legend>
        <h2>Bienvenido/a a la tienda del Gregorio Fernández.</h2>
        <p>Su compra todavía no ha finalizado</p>

        <table border="1">
            <thead>
                <tr>
                    <th>Ref.</th>
                    <th>Descripción</th>
                    <th>Precio</th>
                </tr>
            </thead>
            <tbody>

                <%for (Producto listaProds : listaProductos) {%>
                <tr>
                    <td><%= listaProds.getReferencia() %></td>
                    <td><%= listaProds.getDescripcion() %></td>
                    <td><%= listaProds.getPrecio() %></td>
                </tr>
                <% } %>
        
            </tbody>
        </table>
    </fieldset>
</form>

</body>
</html>
