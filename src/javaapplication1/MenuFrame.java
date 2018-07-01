/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author bruno
 */
public class MenuFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public MenuFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("nDpi Control Filter");
        this.setIconImage(getIconImage());
    }
    
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icono.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exit = new javax.swing.JButton();
        info = new javax.swing.JButton();
        createFilter = new javax.swing.JButton();
        nameApp = new javax.swing.JLabel();
        runWireshark = new javax.swing.JButton();
        jLabelIcon = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(getIconImages());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exit.setBackground(new java.awt.Color(255, 0, 0));
        exit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("x");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, -1, 30));

        info.setBackground(new java.awt.Color(0, 51, 204));
        info.setFont(new java.awt.Font("Lucida Handwriting", 1, 10)); // NOI18N
        info.setForeground(new java.awt.Color(255, 255, 255));
        info.setText("i");
        info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoActionPerformed(evt);
            }
        });
        getContentPane().add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 40, 30));

        createFilter.setBackground(new java.awt.Color(255, 204, 51));
        createFilter.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        createFilter.setForeground(new java.awt.Color(255, 255, 255));
        createFilter.setText("Create Filter");
        createFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createFilterActionPerformed(evt);
            }
        });
        getContentPane().add(createFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 150, -1));

        nameApp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nameApp.setForeground(new java.awt.Color(255, 255, 255));
        nameApp.setText("FilterAnalyzer");
        getContentPane().add(nameApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        runWireshark.setBackground(new java.awt.Color(0, 255, 51));
        runWireshark.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        runWireshark.setForeground(new java.awt.Color(255, 255, 255));
        runWireshark.setText("Open Wireshark");
        runWireshark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runWiresharkActionPerformed(evt);
            }
        });
        getContentPane().add(runWireshark, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 150, -1));

        jLabelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shark_1.png"))); // NOI18N
        getContentPane().add(jLabelIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, -20, 220, 230));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/índice_1.jpg"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /*End the application.*/
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    /*Report on the different sections available in the main menu.*/
    private void infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoActionPerformed
        JOptionPane.showMessageDialog(this, "To start select one of the options (Press x to exit):\n" +
"\tOpen Wireshark: Allows you to start Wireshark with the menu in order to load the created filter files, see the results and reset them.\n" +
"\tCreate Filter: Allows the creation of a filter file (udp, tcp, ip or nDpi) according to the allowed parameters.\n", "Info", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_infoActionPerformed

    /*Make the call to SelectTypeFilter, which allows you to select the type of filter to create.*/
    private void createFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createFilterActionPerformed
        SelectTypeFilter obj = new SelectTypeFilter();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_createFilterActionPerformed

    /*Initialize Wireshark together with the FilterAnalyzer.lua plugin.*/
    private void runWiresharkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runWiresharkActionPerformed
        try {
            String r = java.lang.System.getProperty("user.dir");
            String [] cmd = {"wireshark","-X","lua_script:" + r + "/FilterAnalyzer.lua"};
            Runtime.getRuntime().exec(cmd);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(this, "Invalid comand.", "Error", JOptionPane.ERROR_MESSAGE);
        }finally{
            
        }

    }//GEN-LAST:event_runWiresharkActionPerformed

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
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createFilter;
    private javax.swing.JButton exit;
    private javax.swing.JButton info;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelIcon;
    private javax.swing.JLabel nameApp;
    private javax.swing.JButton runWireshark;
    // End of variables declaration//GEN-END:variables
}
