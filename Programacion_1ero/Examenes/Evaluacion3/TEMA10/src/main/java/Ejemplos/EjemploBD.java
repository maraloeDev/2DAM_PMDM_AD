package Ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EjemploBD {

    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public EjemploBD(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    private void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    private void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean insertRecord(String query, Object... params) throws SQLException {
        connect();
        try (PreparedStatement statement = jdbcConnection.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            boolean rowInserted = statement.executeUpdate() > 0;
            return rowInserted;
        } finally {
            disconnect();
        }
    }

    public boolean updateRecord(String query, Object... params) throws SQLException {
        connect();
        try (PreparedStatement statement = jdbcConnection.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            boolean rowUpdated = statement.executeUpdate() > 0;
            return rowUpdated;
        } finally {
            disconnect();
        }
    }

    public boolean deleteRecord(String query, Object... params) throws SQLException {
        connect();
        try (PreparedStatement statement = jdbcConnection.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            boolean rowDeleted = statement.executeUpdate() > 0;
            return rowDeleted;
        } finally {
            disconnect();
        }
    }

    public static void main(String[] args) {
        EjemploBD dbHelper = new EjemploBD("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

        // Insertar un registro
        String insertSQL = "INSERT INTO users (name, email) VALUES (?, ?)";
        try {
            boolean result = dbHelper.insertRecord(insertSQL, "John Doe", "john.doe@example.com");
            if (result) {
                System.out.println("Registro insertado exitosamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Actualizar un registro
        String updateSQL = "UPDATE users SET name = ? WHERE id = ?";
        try {
            boolean result = dbHelper.updateRecord(updateSQL, "Jane Doe", 1);
            if (result) {
                System.out.println("Registro actualizado exitosamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Eliminar un registro
        String deleteSQL = "DELETE FROM users WHERE id = ?";
        try {
            boolean result = dbHelper.deleteRecord(deleteSQL, 1);
            if (result) {
                System.out.println("Registro eliminado exitosamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
