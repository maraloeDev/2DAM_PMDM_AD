package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ln.RegistrosLN;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entities.Entidades;
import entities.Registros;

/**
 * Servlet implementation class ServletRegistro
 */
@WebServlet("/ServletRegistro")
public class ServletRegistro extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection conn = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistro() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Si se está realizando una consulta de registro (buscando por numeroRegistro)
        String numeroRegistro = request.getParameter("numeroRegistro");
        if (numeroRegistro != null && !numeroRegistro.isEmpty()) {
            buscarRegistroPorNumero(request, response, numeroRegistro);
        } else {
            // Si no hay número de registro, mostrar las entidades para el formulario de registro
            mostrarFormularioRegistro(request, response);
        }
    }

    private void buscarRegistroPorNumero(HttpServletRequest request, HttpServletResponse response, String numeroRegistro)
            throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Establecer conexión con la base de datos
            String url = "jdbc:mysql://localhost:3306/sede";
            String user = "root";
            String password = "";
            conn = DriverManager.getConnection(url, user, password);

            // Consulta SQL para obtener el registro con el numeroRegistro proporcionado
            String query = "SELECT r.dni, r.nombre, r.apellidos, r.tramite, e.nombre AS entidad " +
                    "FROM registros r JOIN entidades e ON r.entidad_id = e.id WHERE r.numero_registro = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, numeroRegistro);
            rs = stmt.executeQuery();

            // Si el registro es encontrado
            if (rs.next()) {
                // Pasar los datos del registro al JSP
                request.setAttribute("dni", rs.getString("dni"));
                request.setAttribute("nombre", rs.getString("nombre"));
                request.setAttribute("apellidos", rs.getString("apellidos"));
                request.setAttribute("tramite", rs.getString("tramite"));
                request.setAttribute("entidad", rs.getString("entidad"));
                
                // Redirigir a la página de consulta (consultar.jsp)
                request.getRequestDispatcher("/Consultar.jsp").forward(request, response);
            } else {
                // Si no se encuentra el registro, mostrar mensaje de error
                request.setAttribute("mensajeError", "El número de registro no existe.");
                request.getRequestDispatcher("/Consultar.jsp").forward(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("mensajeError", "Error al consultar la base de datos: " + e.getMessage());
            request.getRequestDispatcher("/Consultar.jsp").forward(request, response);
        } finally {
            // Cerrar los recursos
            closeResources(rs, stmt, conn);
        }
    }

    private void mostrarFormularioRegistro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Conexión a la base de datos
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<String> entidades = new ArrayList<>();

        try {
            // Establecer conexión a la base de datos
            String url = "jdbc:mysql://localhost:3306/sede";
            conn = DriverManager.getConnection(url, "root", "");
            stmt = conn.createStatement();
            String query = "SELECT * FROM entidades";
            rs = stmt.executeQuery(query);

            // Añadir las entidades a la lista
            while (rs.next()) {
                String id = rs.getString("id");
                String nombre = rs.getString("nombre");
                entidades.add(id + "-" + nombre);
            }

            // Pasar las entidades al JSP
            request.setAttribute("entidades", entidades);
            request.getRequestDispatcher("/Registro.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Error al conectar a la base de datos");
            request.getRequestDispatcher("/Registro.jsp").forward(request, response);
        } finally {
            // Cerrar los recursos
            closeResources(rs, stmt, conn);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recoger los datos del formulario
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String tramite = request.getParameter("tramite");
        String entidadSeleccionada = request.getParameter("entidad");
        String numeroRegistro = "REG_" + nombre.substring(0, 2) + apellidos.substring(0, 2) + dni.substring(0, 2)
                + dni.substring(8);

        // Realizar el registro a través de la lógica de negocios (RegistrosLN)
        RegistrosLN registrosLN = new RegistrosLN();
        Registros resultado = registrosLN.insertarRegistro(numeroRegistro, dni, nombre, apellidos, tramite, entidadSeleccionada);

        // Redirigir dependiendo del resultado
        String mensaje;
        if (resultado != null) {
            // Generar el número de registro
            mensaje = "La grabación se ha realizado correctamente. Guarde el siguiente número de registro: "
                    + numeroRegistro + "<br>" + "Fecha de registro: " + LocalDate.now();
        } else {
            mensaje = "No se ha registrado el trámite. Error al realizar la grabación.";
        }

        // Pasar el mensaje al JSP de resultado
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("Mensaje.jsp").forward(request, response);
    }

    // Método para cerrar los recursos de la base de datos
    private void closeResources(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (stmt != null)
                stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
