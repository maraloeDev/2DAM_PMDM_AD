package com.mycompany.ejerciciopin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Ejercicio01_EjercicioPIN extends javax.swing.JFrame implements ActionListener, MouseListener {

    private int pulsaciones;
    private JPasswordField passwd;
    private JButton botonOjo;
    private JButton boton;
    private JButton[] botones;
    private char echoChar = '\u2022';

    public Ejercicio01_EjercicioPIN() {
        initComponents();      
        this.setTitle("Ejercicio PIN");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        crearControles();      
    }

    public void crearControles() {
        botones = new JButton[10];
        for (int num = 0; num < 10; num++) { // coloco el número num
            int pos; // almacena la posición aleatoria
            boolean ocupado = true; // controla si la posición está ocupada
            while (ocupado) { //mientras la posición esté ocupada
                pos = new Random().nextInt(0,10);
                if (botones[pos] == null) { //si tiene el valor inicial
                    ocupado = false;
                    boton = new JButton(String.valueOf(num));
                    boton.setActionCommand(String.valueOf(num));
                    boton.addActionListener(this);
                    botones[pos] = boton;
                }
            }
        }

        //metemos los botones en el panel
        for (int i = 0; i < botones.length; i++) {
            this.jPanel1.add(botones[i]);
        }

        //metemos la caja de contraseña
        passwd = new JPasswordField();
        passwd.setEchoChar(echoChar);      
        passwd.setEditable(false);
        this.jPanel2.add(passwd);
        
        //y el botón con imagen
        botonOjo=new JButton();
        ImageIcon imagen=new ImageIcon("./resources/ojo.jpg");
        botonOjo.setIcon(imagen);        
        botonOjo.setBackground(Color.WHITE);
        this.botonOjo.setBorder(BorderFactory.createEmptyBorder());
        botonOjo.addMouseListener(this);
        this.jPanel2.add(botonOjo);
        pack();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(0, 1));

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(jPanel1);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ejercicio01_EjercicioPIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ejercicio01_EjercicioPIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ejercicio01_EjercicioPIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ejercicio01_EjercicioPIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Ejercicio01_EjercicioPIN().setVisible(true);
            
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        pulsaciones++;
        if (pulsaciones <= 4) {
            this.passwd.setText(String.valueOf(this.passwd.getPassword()) + ((JButton) e.getSource()).getActionCommand());
        }
        if (pulsaciones == 4) {           
            for (int i = 0; i < botones.length; i++) {
                botones[i].setEnabled(false);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        this.passwd.setEchoChar((char)0);
        botonOjo.setBorder(BorderFactory.createLineBorder(Color.blue));
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        passwd.setEchoChar(echoChar);      
        botonOjo.setBorder(BorderFactory.createEmptyBorder());
    }

    @Override
    public void mouseEntered(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
