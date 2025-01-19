package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Entidades;
import entities.Registros;

public class RegistrosDAO {
    public Registros insertarRegistro(String numeroRegistro,String dniSolicitante, String nombreSolicitante, String apellidosSolicitante, String tramite, String entidad) {

    	
        // Si todo está correcto, se inserta el registro en la base de datos
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            // Conexión a la base de datos
            String url = "jdbc:mysql://localhost:3306/sede";
            conn = DriverManager.getConnection(url, "root", "");
            
            // Inserto el registro en la base de datos
            String query = "INSERT INTO registros (numeroRegistro,DNI_solicitante, Nombre_solicitante, apellidos_solicitante, tramite, entidad) VALUES (?,?, ?, ?, ?, ?)";
            
            // Preparo la consulta con los datos
            stmt = conn.prepareStatement(query);
            stmt.setString(1, numeroRegistro);
            stmt.setString(2, dniSolicitante);
            stmt.setString(3, nombreSolicitante);
            stmt.setString(4, apellidosSolicitante);
            stmt.setString(5, tramite);
            stmt.setInt(6, Integer.parseInt(entidad)); // Se asume que entidad es un número válido
            // Ejecuto la consulta
            stmt.executeUpdate();
            
            // Obtengo los datos de la entidad para devolver
            String query2 = "SELECT * FROM entidades WHERE id = ?";
            
            // Preparo la consulta para obtener la entidad
            stmt = conn.prepareStatement(query2);
            stmt.setInt(6, Integer.parseInt(entidad)); // Convertimos entidad a entero
            rs = stmt.executeQuery(); // Ejecutamos la consulta
            
            // Creamos un objeto para la entidad
            Entidades ent = null;
            
            // Si hay resultados, obtenemos los datos de la entidad
            if (rs.next()) {
                ent = new Entidades();
                ent.setId(rs.getInt("id"));
                ent.setNombre(rs.getString("nombre"));
            }
            
            // Retornamos el objeto Registros
            return new Registros(numeroRegistro, ent, nombreSolicitante, apellidosSolicitante, tramite, dniSolicitante);
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            // Capturamos errores en el parseo de la entidad (si no es un número válido)
            e.printStackTrace();
        } finally {
            // Cerramos los recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return null;
    }
    }