package Problema1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    static Scanner scanner = new Scanner(System.in);

    //ConexionBD
    static Connection con;
    static String url;
    static String user;
    static String password;
    static PreparedStatement ps;
    static Statement st;
    static ResultSet rs;

    //EscrituraTxt
    static BufferedWriter bw;
    static File archivo = new File(".\\src\\main\\java\\Problema1\\incidencias.txt");
    static String cIF_cliente;
    static String nombre_cliente;
    static Cliente c = new Cliente();
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm");

    public static void main(String[] args) {
        conexionBD();
        menu();
    }

    private static void conexionBD() {

        try {
            url = "jdbc:mysql://localhost:3306/junio2023";
            user = "root";
            password = "";

            con = DriverManager.getConnection(url, user, password);

            System.out.println("Base de Datos conectada");
        } catch (SQLException ex) {
            System.err.println("Base de Datos NO conectada, comprueba credenciales");
            System.exit(0);
        }

    }

    private static void menu() {

        String opcion = "";

        do {
            try {
                System.out.println("Introduce una opcion: \n A  B o x (Salir del programa)");
                opcion = scanner.nextLine();

                switch (opcion.toLowerCase()) {
                    case "a":

                        altaClientes();
                        break;
                    case "b":

                        bajaClientes();
                        break;

                    case "x":
                        con.close();
                        System.out.println("Base de datos desconectada");
                        System.exit(0);
                    default:
                        System.out.println("Opcion incorrecta, vuelve a intentarlo");
                }
            } catch (SQLException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }

        } while (!opcion.equalsIgnoreCase("x"));
    }

    private static void altaClientes() {

        try {
            System.out.println("Introduce un CIF");
            cIF_cliente = scanner.nextLine();

            System.out.println("Introduce un nombre");
            nombre_cliente = scanner.nextLine();

            String consulta = "SELECT * FROM clientes WHERE CIF_cliente = ?";

            ps = con.prepareStatement(consulta);

            ps.setString(1, cIF_cliente);
            rs = ps.executeQuery();
            boolean existe = rs.next(); //El rs.next() devueve el siguiente resultado    //Si hay 1 resultado la primera nos dara true y la segunda false
            ps.close();

            try {

                if (existe) {

                    if (!archivo.exists()) {
                        try {
                            archivo.createNewFile();
                        } catch (IOException ex) {
                            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    try {
                        bw = new BufferedWriter(new FileWriter(archivo, true));

                        bw.write(sdf.format(new java.util.Date()) + "-" + "A" + "-" + cIF_cliente);
                        bw.newLine();

                        bw.close();

                    } catch (IOException ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {

                    String consultaInsert = "INSERT INTO clientes (CIF_cliente, nombre_cliente) VALUES(?, ?)";

                    ps = con.prepareStatement(consultaInsert);
                    ps.setString(1, cIF_cliente);
                    ps.setString(2, nombre_cliente);
                    ps.executeUpdate();

                    System.out.println("Fila insertada");
                    ps.close();

                }

            } catch (SQLException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void bajaClientes() {

        System.out.println("Introduce un cliente");
        String nombreCliente = scanner.nextLine();

        String consultaExistente = "SELECT * FROM clientes WHERE nombre_cliente = ?";
        String consultaEliminar = "DELETE FROM clientes WHERE nombre_cliente = ?";
        boolean clienteExiste = false;

        try (PreparedStatement psExistente = con.prepareStatement(consultaExistente)) {
            psExistente.setString(1, nombreCliente);

            try (ResultSet rs = psExistente.executeQuery()) {
                if (rs.next()) {
                    clienteExiste = true;
                }
            }

            if (clienteExiste) { //Si existe se elimina
                try (PreparedStatement psEliminar = con.prepareStatement(consultaEliminar)) {
                    psEliminar.setString(1, nombreCliente);
                    psEliminar.executeUpdate();

                    System.out.println("Cliente eliminado");
                }
                
            } else { // Si no existe se elimina

                try {
                    bw = new BufferedWriter(new FileWriter(archivo, true));

                    bw.write(sdf.format(new java.util.Date()) + "-" + "B" + "-" + nombreCliente);
                    bw.newLine();

                    bw.close();

                } catch (IOException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
