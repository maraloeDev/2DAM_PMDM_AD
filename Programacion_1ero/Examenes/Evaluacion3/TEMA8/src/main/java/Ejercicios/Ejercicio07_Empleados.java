package Ejercicios;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Ejercicio07_Empleados extends javax.swing.JFrame {

    //Archivo
    static File archivo = new File(".\\src\\main\\java\\Ejercicios\\ficheroEmpleados.csv");
    //LecturaCSV
    static BufferedReader br;
    static CsvToBean<Ejercicio07_datosEmpleados> csvTB;

    //Escritura CSV
    static BufferedWriter bw;
    static CSVWriter csvW;

    //Modelo Lista
    DefaultListModel<String> modeloLista = new DefaultListModel<>();

    //Almacenamiento Empleados
    static ArrayList<Ejercicio07_datosEmpleados> listaEmpleados;
    static Ejercicio07_datosEmpleados losEmpleados = new Ejercicio07_datosEmpleados();
    static boolean encontrado = false;

    public Ejercicio07_Empleados() {
        initComponents();
        setFrame();
    }

    private void setFrame() {
        setTitle("Ejercicio CSV");
        setLocationRelativeTo(null);
        setResizable(false);
    }

    void lecturaCSV() {
        listaEmpleados = new ArrayList<>();
        modeloLista = new DefaultListModel<>();
        modeloLista.clear();
        try {
            //Establezco el modelo a la lista
            mostrarEmpleados.setModel(modeloLista);

            br = new BufferedReader(new FileReader(archivo));
            csvTB = new CsvToBeanBuilder<Ejercicio07_datosEmpleados>(br)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withType(Ejercicio07_datosEmpleados.class)
                    .build();
            //Establezco la "Cabecera"
            modeloLista.addElement(Arrays.toString(losEmpleados.toArray()));

            //Recorro el csv, y añado los empleados a la lista, y añado el tS
            for (Ejercicio07_datosEmpleados cargaDatos : csvTB.parse()) {
                modeloLista.addElement(cargaDatos.toString());
                listaEmpleados.add(cargaDatos);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio07_Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        ordenarDatos();
    }

    void cargarDatos() {
        lecturaCSV();
    }

    void ordenarDatos() {
        modeloLista.clear();

        if (btnId.isSelected()) {
            modeloLista.addElement(Arrays.toString(losEmpleados.toArray()));
            for (Ejercicio07_datosEmpleados ordenadoId : listaEmpleados) {
                modeloLista.addElement(String.valueOf(ordenadoId));
            }

        } else if (btnApellidos.isSelected()) {

            modeloLista.addElement(String.valueOf(Arrays.toString(losEmpleados.toArrayApellidos())));
            for (Ejercicio07_datosEmpleados ordenadoApellidos : listaEmpleados) {
                modeloLista.addElement(String.valueOf(ordenadoApellidos.toStringApellidos()));
            }

        } else if (btnDepartamento.isSelected()) {

            modeloLista.addElement(String.valueOf(Arrays.toString(losEmpleados.toArrayDepartamento())));
            for (Ejercicio07_datosEmpleados ordenadoDepartamento : listaEmpleados) {
                modeloLista.addElement(String.valueOf(ordenadoDepartamento.toStringDepartamentos()));
            }
        }
    }

    void buscarEmpleado() {

        int idaBuscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce un id a buscar"));

        for (Ejercicio07_datosEmpleados elEmpleado : listaEmpleados) {
            if (idaBuscar == elEmpleado.getId()) {
                JOptionPane.showMessageDialog(null, "Empleado encontrado\n "
                        + "ID : " + elEmpleado.getId()
                        + "\n Apellidos " + elEmpleado.getApellidos()
                        + "\nNombre de departamento " + elEmpleado.getNombreDepartamento());
                encontrado = true;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Empleado no encontrado");
        }

    }

    void agregarDatos() {

        try {
            bw = new BufferedWriter(new FileWriter(archivo, true));
            csvW = new CSVWriter(bw);

            int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce un id:"));
            String apellido = JOptionPane.showInputDialog(null, "Introduce un apellido:");
            String nombreDepartamento = JOptionPane.showInputDialog(null, "Introduce un nombre de departamento:");

            losEmpleados = new Ejercicio07_datosEmpleados(id, apellido, nombreDepartamento);

            bw.write(String.valueOf(losEmpleados.toString()));

            csvW.close();

        } catch (IOException ex) {
            Logger.getLogger(Ejercicio07_Empleados.class.getName()).log(Level.SEVERE, null, ex);
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

        conjjuntoBotones = new javax.swing.ButtonGroup();
        cargarDatos = new javax.swing.JButton();
        buscarEmpleados = new javax.swing.JButton();
        agregarMasDatos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mostrarEmpleados = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        btnId = new javax.swing.JRadioButton();
        btnApellidos = new javax.swing.JRadioButton();
        btnDepartamento = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cargarDatos.setText("Cargar datos");
        cargarDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cargarDatosMouseClicked(evt);
            }
        });

        buscarEmpleados.setText("Buscar empleado");
        buscarEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarEmpleadosMouseClicked(evt);
            }
        });

        agregarMasDatos.setText("Agregar + datos");
        agregarMasDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarMasDatosMouseClicked(evt);
            }
        });

        jScrollPane1.setViewportView(mostrarEmpleados);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordenar por"));

        conjjuntoBotones.add(btnId);
        btnId.setSelected(true);
        btnId.setText("id");

        conjjuntoBotones.add(btnApellidos);
        btnApellidos.setText("apellidos");

        conjjuntoBotones.add(btnDepartamento);
        btnDepartamento.setText("departamento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(btnId)
                .addGap(33, 33, 33)
                .addComponent(btnApellidos)
                .addGap(50, 50, 50)
                .addComponent(btnDepartamento)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnId)
                    .addComponent(btnApellidos)
                    .addComponent(btnDepartamento))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buscarEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cargarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(agregarMasDatos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cargarDatos)
                        .addGap(18, 18, 18)
                        .addComponent(buscarEmpleados)
                        .addGap(18, 18, 18)
                        .addComponent(agregarMasDatos)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarDatosMouseClicked
        cargarDatos();
    }//GEN-LAST:event_cargarDatosMouseClicked

    private void buscarEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarEmpleadosMouseClicked
        buscarEmpleado();
    }//GEN-LAST:event_buscarEmpleadosMouseClicked

    private void agregarMasDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarMasDatosMouseClicked
        agregarDatos();
    }//GEN-LAST:event_agregarMasDatosMouseClicked

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
            java.util.logging.Logger.getLogger(Ejercicio07_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ejercicio07_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ejercicio07_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ejercicio07_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Ejercicio07_Empleados().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarMasDatos;
    private javax.swing.JRadioButton btnApellidos;
    private javax.swing.JRadioButton btnDepartamento;
    private javax.swing.JRadioButton btnId;
    private javax.swing.JButton buscarEmpleados;
    private javax.swing.JButton cargarDatos;
    private javax.swing.ButtonGroup conjjuntoBotones;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> mostrarEmpleados;
    // End of variables declaration//GEN-END:variables
}
