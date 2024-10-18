package EjerciciosSergio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Ejercicio06_Golf extends javax.swing.JFrame {

    //Datos
    static int id;
    static String nombre;
    static int nGolpes;
    static int nHoyos;

    static File memoryStick = new File(".\\src\\main\\java\\EjerciciosSergio\\guardaPartidas.txt");
    static File archivoPrincipal = new File(".\\src\\main\\java\\EjerciciosSergio\\archivoPrincipal.bin");
    static ArrayList<Ejercicio06_datosGolf> listaDatos = new ArrayList<>();
    static DefaultListModel<String> modeloLista = new DefaultListModel<>();
    static Ejercicio06_datosGolf datosJugador;

    //Escritura Binaria
    static FileOutputStream fos;
    static BufferedOutputStream bos;
    static DataOutputStream dos;

    //LecturaBinaria
    static FileInputStream fis;
    static BufferedInputStream bis;
    static DataInputStream dis;

    //EscrituraPlana
    FileWriter fw;
    BufferedWriter bw;

    public Ejercicio06_Golf() {
        initComponents();
        setFrame();
    }

    private void setFrame() {
        setTitle("Golf");
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void agregarPuntuaciones() {

        id = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce un id: "));
        nombre = JOptionPane.showInputDialog(null, "Introduce en nombre del jugador");
        nGolpes = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce en numero de golpes"));
        nHoyos = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce en numero de hoyos jugados"));

        int confirmacion = JOptionPane.showConfirmDialog(null, "Estas seguro de que quieres guardar todo");

        if (confirmacion == JOptionPane.YES_OPTION) {
            datosJugador = new Ejercicio06_datosGolf(id, nombre, nGolpes, nHoyos);
            listaDatos.add(datosJugador);
            JOptionPane.showMessageDialog(null, "Datos almacenados correctamente");

            try {

                if (!archivoPrincipal.exists()) {
                    archivoPrincipal.createNewFile();
                }
                fos = new FileOutputStream(archivoPrincipal);
                bos = new BufferedOutputStream(fos);
                dos = new DataOutputStream(fos);

                for (Ejercicio06_datosGolf datos : listaDatos) {

                    dos.writeInt(datos.getId());
                    dos.writeUTF(datos.getNombreJugador());
                    dos.writeInt(datos.getnGolpes());
                    dos.writeInt(datos.getnHoyos());

                }
                dos.close();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Ejercicio06_Golf.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Ejercicio06_Golf.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Datos no almacenados");
        }
    }

    private void ordenacionPuntos() {
        Collections.sort(listaDatos, (Ejercicio06_datosGolf datos1, Ejercicio06_datosGolf datos2) -> Integer.compare(datos1.getnGolpes(), datos2.getnGolpes()));
    }

    private void calcularResultado() {

        id = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce un id"));

        boolean encontrado = false;
        int suma = 0;
        for (Ejercicio06_datosGolf calcular : listaDatos) {
            if (calcular.getId() != id) {

            } else {
                if ((calcular.getId() == id) && calcular.getnHoyos() >= 3) {
                    encontrado = true;
                    suma += nGolpes;
                    JOptionPane.showMessageDialog(null, "El numero de golpes en total han sido de " + suma);
                }
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Id no encontrado");
        }
        ordenacionPuntos();

    }

    private void verPartidas() {

        listaPartidas.setModel(modeloLista);
        modeloLista.clear();

        if (listaDatos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        } else {
            try {

                List<Ejercicio06_datosGolf> tenp = new ArrayList<>();
                fis = new FileInputStream(archivoPrincipal);
                bis = new BufferedInputStream(fis);
                dis = new DataInputStream(fis);

                modeloLista.addElement("ID  NOMBRE  NGOLPES  NHOYOS");
                while (dis.available() > 0) {

                    tenp.add(new Ejercicio06_datosGolf(dis.readInt(), dis.readUTF(), dis.readInt(), dis.readInt()));

                }
                Collections.sort(tenp, (Ejercicio06_datosGolf datos1, Ejercicio06_datosGolf datos2) -> Integer.compare(datos1.getnGolpes(), datos2.getnGolpes()));

                for (Ejercicio06_datosGolf ordena : tenp) {
                    modeloLista.addElement(ordena.getId() + "   " + ordena.getNombreJugador() + "   " + ordena.getnGolpes() + "  " + ordena.getnHoyos());
                }

                dis.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Ejercicio06_Golf.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Ejercicio06_Golf.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void exportarPartida() {

        ArrayList<Ejercicio06_datosGolf> exportaciones = new ArrayList<>();
        try {

            try {

                if (!memoryStick.exists()) {

                    memoryStick.createNewFile();
                }
            } catch (IOException ex) {
                Logger.getLogger(Ejercicio06_Golf.class.getName()).log(Level.SEVERE, null, ex);
            }

            id = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce un id: "));
            for (Ejercicio06_datosGolf partidaExistente : listaDatos) {

                if (partidaExistente.getId() == id) {
                    fw = new FileWriter(memoryStick);
                    bw = new BufferedWriter(fw);

                    exportaciones.add(new Ejercicio06_datosGolf(id, nombre, nGolpes, nHoyos));

                    for (Ejercicio06_datosGolf export : exportaciones) {
                        bw.write(String.valueOf(export));
                    }

                    JOptionPane.showMessageDialog(null, "Partida exportada correctamente");
                }
                bw.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(Ejercicio06_Golf.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        listaPartidas = new javax.swing.JList<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        menuExportar = new javax.swing.JMenuItem();
        menuPartidas = new javax.swing.JMenu();
        menuAgregarPuntuacion = new javax.swing.JMenuItem();
        menuCarcularResultado = new javax.swing.JMenuItem();
        menuVerPartidasGuardadas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listaPartidas.setEnabled(false);
        jScrollPane1.setViewportView(listaPartidas);

        menuArchivo.setText("Archivo");

        menuExportar.setText("Exportar partida");
        menuExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExportarActionPerformed(evt);
            }
        });
        menuArchivo.add(menuExportar);

        jMenuBar1.add(menuArchivo);

        menuPartidas.setText("Partidas");

        menuAgregarPuntuacion.setText("Agregar una nueva puntuacion");
        menuAgregarPuntuacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAgregarPuntuacionActionPerformed(evt);
            }
        });
        menuPartidas.add(menuAgregarPuntuacion);

        menuCarcularResultado.setText("Calcular resultado de una partida");
        menuCarcularResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCarcularResultadoActionPerformed(evt);
            }
        });
        menuPartidas.add(menuCarcularResultado);

        menuVerPartidasGuardadas.setText("Ver partidas guardadas");
        menuVerPartidasGuardadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVerPartidasGuardadasActionPerformed(evt);
            }
        });
        menuPartidas.add(menuVerPartidasGuardadas);

        jMenuBar1.add(menuPartidas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuAgregarPuntuacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAgregarPuntuacionActionPerformed
        agregarPuntuaciones();
    }//GEN-LAST:event_menuAgregarPuntuacionActionPerformed

    private void menuCarcularResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCarcularResultadoActionPerformed
        calcularResultado();
    }//GEN-LAST:event_menuCarcularResultadoActionPerformed

    private void menuVerPartidasGuardadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVerPartidasGuardadasActionPerformed
        verPartidas();
    }//GEN-LAST:event_menuVerPartidasGuardadasActionPerformed

    private void menuExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExportarActionPerformed
        exportarPartida();
    }//GEN-LAST:event_menuExportarActionPerformed

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
            java.util.logging.Logger.getLogger(Ejercicio06_Golf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ejercicio06_Golf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ejercicio06_Golf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ejercicio06_Golf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Ejercicio06_Golf().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaPartidas;
    private javax.swing.JMenuItem menuAgregarPuntuacion;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenuItem menuCarcularResultado;
    private javax.swing.JMenuItem menuExportar;
    private javax.swing.JMenu menuPartidas;
    private javax.swing.JMenuItem menuVerPartidasGuardadas;
    // End of variables declaration//GEN-END:variables
}
