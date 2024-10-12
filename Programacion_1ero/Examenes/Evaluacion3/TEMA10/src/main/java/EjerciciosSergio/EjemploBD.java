package EjerciciosSergio;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EjemploBD extends javax.swing.JFrame {

    //Conexion BD
    static Connection con;
    static String url = "jdbc:mysql://localhost:3306/fincas";
    static String user = "root";
    static String password = "";

    static Statement st;
    static ResultSet rs;
    static PreparedStatement ps;
    static finca finca;
    static ArrayList<finca> listaFincas = new ArrayList<>();

    //Archivo
    static File archivo = new File(".\\src\\main\\java\\EjerciciosSergio\\exportaciones.csv");

    //Escritura CSV
    BufferedWriter bw;
    CSVWriter csvW = null;

    //LecturaCSV
    BufferedReader br;
    CsvToBean<finca> csvTB;

    public EjemploBD() {
        initComponents();
        setFrame();
    }

    private void setFrame() {
        setTitle("Fincas");
        setResizable(false);
        setLocationRelativeTo(null);
        lasFincas.setEditable(false);

        addWindowListener(new WindowAdapter() {
            @Override
            //Cuando se abre la ventana, se "Intenta conectar a la base de datos"
            public void windowOpened(WindowEvent e) {
                try {
                    con = DriverManager.getConnection(url, user, password);
                    JOptionPane.showMessageDialog(null, "Base de Datos conectada");
                } catch (SQLException ex) {
                    dispose();
                    JOptionPane.showMessageDialog(null, "Base de Datos NO conectada");
                }

            }

            //Cuando se cierra la ventana, se cierra la conexion
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EjemploBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
    }

    void insertarFincas() {

        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce un id: "));
            String direccion = JOptionPane.showInputDialog(null, "Introduce una direccion: ");
            double area = Double.parseDouble(JOptionPane.showInputDialog(null, "Introduce un area: "));
            int propietario = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce id del propietario"));

            String consulta = "INSERT INTO finca (id, direccion, area, propietarioID) VALUES (?,?,?,?)";

            PreparedStatement ps = con.prepareCall(consulta);
            ps.setInt(1, id);
            ps.setString(2, direccion);
            ps.setDouble(3, area);
            ps.setInt(4, propietario);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Finca agregada correctamente");

        } catch (SQLException ex) {
            Logger.getLogger(EjemploBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void recorreFincas() {

        StringBuilder textoFincas = new StringBuilder();

        listaFincas.clear();

        try {
            String consulta = "SELECT id, direccion, area, propietarioId FROM finca";
            st = con.createStatement();
            rs = st.executeQuery(consulta);

            while (rs.next()) {
                int id = rs.getInt(1);
                String direccion = rs.getString(2);
                double area = rs.getDouble(3);
                int propietarioId = rs.getInt(4);

                finca = new finca(id, direccion, area, propietarioId);
                listaFincas.add(finca);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            Logger.getLogger(EjemploBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (finca finca : listaFincas) {
            textoFincas.append(finca.toString()).append("\n");

        }

        lasFincas.setText(textoFincas.toString());

    }

    void actualizarFincas() {

        try {
            recorreFincas();

            int idActualizar = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el id de la finca a actualizar"));

            int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce un id: "));
            String direccion = JOptionPane.showInputDialog(null, "Introduce una direccion: ");
            double area = Double.parseDouble(JOptionPane.showInputDialog(null, "Introduce un area: "));
            int propietario = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce id del propietario"));

            String consulta = "UPDATE finca SET direccion = ?, area = ?, propietarioId = ? WHERE id = ?";

            ps = con.prepareCall(consulta);

            ps.setString(1, direccion);
            ps.setDouble(2, area);
            ps.setInt(3, propietario);
            ps.setInt(4, id);

            JOptionPane.showMessageDialog(null, "Filas actualizadas: " + ps.executeUpdate());

        } catch (SQLException ex) {
            Logger.getLogger(EjemploBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void eliminarFinca() {

        try {
            recorreFincas();
            String idEliminar = JOptionPane.showInputDialog(null, "Introduce el id de la finca a eliminar");

            if ((!"0".equals(idEliminar)) || (idEliminar != "10000")) {
                JOptionPane.showMessageDialog(null, "ID incorrecto");

            } else {

                String consulta = "DELETE FROM finca WHERE ID = ?";

                ps = con.prepareStatement(consulta);
                ps.setInt(1, Integer.parseInt(idEliminar));

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Finca eliminada");
                ps.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(EjemploBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void verFincas() {
        recorreFincas();
    }

    void exportarFinca() {
        escrituraCSV();
        lecturaCSV();
    }

    void lecturaCSV() {
        StringBuilder strB = new StringBuilder();
        try {
            if (!archivo.exists()) {
                try {
                    archivo.createNewFile();
                    JOptionPane.showMessageDialog(null, "Archivo creado correctamente");
                } catch (IOException ex) {
                    Logger.getLogger(EjemploBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            br = new BufferedReader(new FileReader(archivo));
            csvTB = new CsvToBeanBuilder<finca>(br)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withType(finca.class)
                    .build();
            for (finca lecturaFinca : csvTB.parse()) {

                strB.append(Arrays.toString(lecturaFinca.toArray()));
                strB.append("\n");
                strB.append(lecturaFinca.toString());

                lasFincas.setText(strB.toString());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EjemploBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void escrituraCSV() {

        try {

            listaFincas.clear();

            try {
                String consulta = "SELECT id, direccion, area, propietarioId FROM finca";
                st = con.createStatement();
                rs = st.executeQuery(consulta);

                while (rs.next()) {
                    int id = rs.getInt(1);
                    String direccion = rs.getString(2);
                    double area = rs.getDouble(3);
                    int propietarioId = rs.getInt(4);

                    finca = new finca(id, direccion, area, propietarioId);
                    listaFincas.add(finca);
                }
                rs.close();
                st.close();

            } catch (SQLException ex) {
                Logger.getLogger(EjemploBD.class.getName()).log(Level.SEVERE, null, ex);
            }

            bw = new BufferedWriter(new FileWriter(archivo));
            csvW = new CSVWriter(bw);

            csvW.writeNext(finca.toArray(), false);

            for (finca laFincaRecorre : listaFincas) {
                bw.write(laFincaRecorre.toString());
                bw.newLine();
            }

            csvW.close();

        } catch (IOException ex) {
            Logger.getLogger(EjemploBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        insetarFincas = new javax.swing.JButton();
        actualizarFincas = new javax.swing.JButton();
        eliminarFincas = new javax.swing.JButton();
        verFincas = new javax.swing.JButton();
        exportarCSV = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lasFincas = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        insetarFincas.setText("Insertar Finca");
        insetarFincas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insetarFincasMouseClicked(evt);
            }
        });

        actualizarFincas.setText("Actualizar Finca");
        actualizarFincas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actualizarFincasMouseClicked(evt);
            }
        });

        eliminarFincas.setText("Eliminar Finca");
        eliminarFincas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarFincasMouseClicked(evt);
            }
        });

        verFincas.setText("Ver Fincas");
        verFincas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verFincasMouseClicked(evt);
            }
        });

        exportarCSV.setText("Exportar Finca");
        exportarCSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exportarCSVMouseClicked(evt);
            }
        });

        lasFincas.setColumns(20);
        lasFincas.setRows(5);
        lasFincas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jScrollPane1.setViewportView(lasFincas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eliminarFincas, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verFincas, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actualizarFincas)
                    .addComponent(insetarFincas, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exportarCSV))
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(insetarFincas)
                .addGap(31, 31, 31)
                .addComponent(actualizarFincas)
                .addGap(28, 28, 28)
                .addComponent(eliminarFincas)
                .addGap(36, 36, 36)
                .addComponent(verFincas)
                .addGap(31, 31, 31)
                .addComponent(exportarCSV)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insetarFincasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insetarFincasMouseClicked
        insertarFincas();
    }//GEN-LAST:event_insetarFincasMouseClicked

    private void actualizarFincasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarFincasMouseClicked
        actualizarFincas();
    }//GEN-LAST:event_actualizarFincasMouseClicked

    private void eliminarFincasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarFincasMouseClicked
        eliminarFinca();
    }//GEN-LAST:event_eliminarFincasMouseClicked

    private void verFincasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verFincasMouseClicked
        verFincas();
    }//GEN-LAST:event_verFincasMouseClicked

    private void exportarCSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportarCSVMouseClicked
        exportarFinca();
    }//GEN-LAST:event_exportarCSVMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EjemploBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EjemploBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EjemploBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EjemploBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new EjemploBD().setVisible(true);
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarFincas;
    private javax.swing.JButton eliminarFincas;
    private javax.swing.JButton exportarCSV;
    private javax.swing.JButton insetarFincas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea lasFincas;
    private javax.swing.JButton verFincas;
    // End of variables declaration//GEN-END:variables
}
