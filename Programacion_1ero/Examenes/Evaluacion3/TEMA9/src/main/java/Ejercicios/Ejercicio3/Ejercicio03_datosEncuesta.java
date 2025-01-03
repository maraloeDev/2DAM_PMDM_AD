package Ejercicios.Ejercicio3;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ejercicio03_datosEncuesta extends javax.swing.JFrame {

    static int si;
    static int no;
    static int nSnC;

    static int sumaSi = 0;
    static int sumaNo = 0;
    static int sumaNsNc = 0;

    //Lectura CSV
    static BufferedReader br;
    static CsvToBean csvTB;

    //Escritura CSV
    static BufferedWriter bw;
    static CSVWriter csvW;

    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

    //Archivo
    File archivoEncuesta = new File(".\\src\\main\\java\\Ejercicios\\Ejercicio3\\encuesta.csv");

    //Ventana nueva
    JFrame ventanaDatos;
    JPanel panelDatos;
    JTextArea datosEscritura;

    Ejercicio03_opcionesEncuesta datosEncuesta = new Ejercicio03_opcionesEncuesta();

    public Ejercicio03_datosEncuesta() {
        initComponents();
        setFrame();
    }

    private void setFrame() {
        setTitle("Encuesta");
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void votar() {
        try {
            if (!archivoEncuesta.exists()) {
                try {
                    archivoEncuesta.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(Ejercicio03_datosEncuesta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (btnSi.isSelected()) {
                si++;
                sumaSi += si;
            } else if (btnNo.isSelected()) {
                no++;
                sumaNo += no;
            } else if (btnNsNc.isSelected()) {
                nSnC++;
                sumaNsNc += nSnC;
            } else {
                JOptionPane.showMessageDialog(null, "No has seleccionado nada");
                return;
            }

            JOptionPane.showMessageDialog(null, "Votacion almacenada correctamente");

            datosEncuesta = new Ejercicio03_opcionesEncuesta(si, no, nSnC);

            bw = new BufferedWriter(new FileWriter(archivoEncuesta));
            csvW = new CSVWriter(bw);

            csvW.writeNext(datosEncuesta.toArray(), false);

            bw.write(datosEncuesta.toString());

            csvW.close();

        } catch (IOException ex) {
            Logger.getLogger(Ejercicio03_datosEncuesta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void mostrarResultado() {

        if (!archivoEncuesta.exists()) {

            JOptionPane.showMessageDialog(null, "No existe ningun archivo encuesta.csv");

        } else {
            ventanaDatos = new JFrame(sdf.format(new Date()));
            panelDatos = new JPanel();
            datosEscritura = new JTextArea();

            ventanaDatos.setVisible(true);
            ventanaDatos.add(panelDatos);
            ventanaDatos.setResizable(false);
            ventanaDatos.setLocationRelativeTo(null);
            ventanaDatos.setSize(new Dimension(500, 500));

            datosEscritura.setPreferredSize(new Dimension(400, 300));
            datosEscritura.setEditable(false);

            panelDatos.setSize(new Dimension(500, 500));
            panelDatos.add(datosEscritura);

            lecturaCSV();

        }
    }

    void lecturaCSV() {

        try {
            br = new BufferedReader(new FileReader(archivoEncuesta));
            csvTB = new CsvToBeanBuilder<Ejercicio03_opcionesEncuesta>(br)
                    .withType(Ejercicio03_opcionesEncuesta.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            for (var datos : csvTB.parse()) {

                Ejercicio03_opcionesEncuesta aux = (Ejercicio03_opcionesEncuesta) datos;
                datosEscritura.setText("Total votos: " + aux.calcularTotal() + "\n"
                        + "\n Si: " + aux.porcentajeSi() + "%\n"
                        + "\n No: " + aux.porcentajeNo() + "%\n"
                        + "\n NS/NC: " + aux.porcentajeNsNc() + "%\n");

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio03_datosEncuesta.class
                    .getName()).log(Level.SEVERE, null, ex);
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

        conjuntoBotones = new javax.swing.ButtonGroup();
        tituloEncuesta = new javax.swing.JLabel();
        btnSi = new javax.swing.JRadioButton();
        btnNo = new javax.swing.JRadioButton();
        btnNsNc = new javax.swing.JRadioButton();
        brnVotar = new javax.swing.JButton();
        btnMostrarResultados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tituloEncuesta.setText("Te gustaria realizar practicas en con la modalidad FP DUAL");

        conjuntoBotones.add(btnSi);
        btnSi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSi.setSelected(true);
        btnSi.setText("Si");

        conjuntoBotones.add(btnNo);
        btnNo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNo.setText("No");

        conjuntoBotones.add(btnNsNc);
        btnNsNc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNsNc.setText("NS/NC");

        brnVotar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        brnVotar.setForeground(new java.awt.Color(255, 0, 51));
        brnVotar.setText("Votar");
        brnVotar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                brnVotarMouseClicked(evt);
            }
        });

        btnMostrarResultados.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMostrarResultados.setForeground(new java.awt.Color(255, 0, 0));
        btnMostrarResultados.setText("Mostrar Resultados");
        btnMostrarResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMostrarResultadosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(tituloEncuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNsNc)
                    .addComponent(btnNo)
                    .addComponent(btnSi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(brnVotar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMostrarResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(tituloEncuesta)
                .addGap(27, 27, 27)
                .addComponent(btnSi)
                .addGap(18, 18, 18)
                .addComponent(btnNo)
                .addGap(18, 18, 18)
                .addComponent(btnNsNc)
                .addGap(18, 18, 18)
                .addComponent(brnVotar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMostrarResultados)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void brnVotarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_brnVotarMouseClicked
        votar();
        conjuntoBotones.clearSelection();
    }//GEN-LAST:event_brnVotarMouseClicked

    private void btnMostrarResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarResultadosMouseClicked
        mostrarResultado();
    }//GEN-LAST:event_btnMostrarResultadosMouseClicked

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
            java.util.logging.Logger.getLogger(Ejercicio03_datosEncuesta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ejercicio03_datosEncuesta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ejercicio03_datosEncuesta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ejercicio03_datosEncuesta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Ejercicio03_datosEncuesta().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnVotar;
    private javax.swing.JButton btnMostrarResultados;
    private javax.swing.JRadioButton btnNo;
    private javax.swing.JRadioButton btnNsNc;
    private javax.swing.JRadioButton btnSi;
    private javax.swing.ButtonGroup conjuntoBotones;
    private javax.swing.JLabel tituloEncuesta;
    // End of variables declaration//GEN-END:variables
}
