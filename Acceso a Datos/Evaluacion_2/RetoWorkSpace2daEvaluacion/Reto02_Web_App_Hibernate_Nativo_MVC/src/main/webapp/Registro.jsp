<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>REGISTRO</title>
</head>
<body>
    <form action="ServletRegistro" method="post">
        <table border="2" align="center">
            <tr>
                <td colspan="2" align="center"><h1>SEDE ELECTRÓNICA GF</h1></td>
            </tr>
            <tr>
                <td><label for="dni"><b>DNI solicitante:</b></label></td>
                <td>
                    <input type="text" name="dni" maxlength="9" style="width: 280px" required>
                </td>
            </tr>
            <tr>
                <td><label for="nombre"><b>NOMBRE solicitante:</b></label></td>
                <td>
                    <input type="text" name="nombre" style="width: 280px" required>
                </td>
            </tr>
            <tr>
                <td><label for="apellidos"><b>APELLIDOS solicitante:</b></label></td>
                <td>
                    <input type="text" name="apellidos" style="width: 280px" required>
                </td>
            </tr>
            <tr>
                <td><label for="tramite"><b>TRÁMITE:</b></label></td>
                <td>
                    <input type="text" name="tramite" style="width: 280px" required>
                </td>
            </tr>
            <tr>
                <td><label for="entidad"><b>ENTIDAD:</b></label></td>
                <td>
                    <select name="entidad" >
                        <%
                        Connection conn = null;
                        Statement stmt = null;
                        ResultSet rs = null;

                        try {
                            // Establecer conexión a la base de datos
                            String url = "jdbc:mysql://localhost:3306/sede";
                            String user = "root";
                            String password = "";
                            conn = DriverManager.getConnection(url, user, password);
                            stmt = conn.createStatement();
                            String query = "SELECT * FROM entidades";
                            rs = stmt.executeQuery(query);

                            // Llenar el select con las opciones obtenidas de la base de datos
                            while (rs.next()) {
                                String id = rs.getString("id");
                                String nombre = rs.getString("nombre");
                        %>
                                <option value="<%= id %>"><%= nombre %></option>
                        <%
                            }
                        } catch (Exception e) {
                            // Mostrar el error en caso de que ocurra un problema
                            out.println("<div class='error'>Error de conexión: " + e.getMessage() + "</div>");
                        } finally {
                            // Cerrar recursos
                            if (rs != null) try { rs.close(); } catch (Exception ignore) {}
                            if (stmt != null) try { stmt.close(); } catch (Exception ignore) {}
                            if (conn != null) try { conn.close(); } catch (Exception ignore) {}
                        }
                        %>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <input type="submit" value="Grabar">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
