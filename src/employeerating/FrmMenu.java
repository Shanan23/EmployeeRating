/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package employeerating;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author macbookpro
 */
public class FrmMenu extends javax.swing.JFrame {

    /**
     * Creates new form FrmMenu
     */
    public FrmMenu() {
        initComponents();
        btnHome.doClick();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        btnHome = new javax.swing.JButton();
        btnCriteria = new javax.swing.JButton();
        btnEmployee = new javax.swing.JButton();
        btnRatingFirst = new javax.swing.JButton();
        btnRatingSecond = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );

        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnCriteria.setText("Kriteria");
        btnCriteria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriteriaActionPerformed(evt);
            }
        });

        btnEmployee.setText("Karyawan");
        btnEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeActionPerformed(evt);
            }
        });

        btnRatingFirst.setText("Penilaian");
        btnRatingFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRatingFirstActionPerformed(evt);
            }
        });

        btnRatingSecond.setText("Perhitungan");
        btnRatingSecond.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRatingSecondActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCriteria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmployee)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRatingFirst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRatingSecond)
                .addContainerGap(400, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHome)
                    .addComponent(btnCriteria)
                    .addComponent(btnEmployee)
                    .addComponent(btnRatingFirst)
                    .addComponent(btnRatingSecond))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        try {
            desktopPane.removeAll();
            HomeFrm homeFrm = new HomeFrm();
            homeFrm.setMaximum(true);
            BasicInternalFrameUI ui = (BasicInternalFrameUI) homeFrm.getUI();
            ui.setNorthPane(null);
            desktopPane.add(homeFrm).setVisible(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnCriteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriteriaActionPerformed
        try {
            desktopPane.removeAll();
            CriteriaFrm criteriaFrm = new CriteriaFrm();
            criteriaFrm.setMaximum(true);
            BasicInternalFrameUI ui = (BasicInternalFrameUI) criteriaFrm.getUI();
            ui.setNorthPane(null);
            desktopPane.add(criteriaFrm).setVisible(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCriteriaActionPerformed

    private void btnEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeActionPerformed
        try {
            desktopPane.removeAll();
            EmployeeFrm employeeFrm = new EmployeeFrm();
            employeeFrm.setMaximum(true);
            BasicInternalFrameUI ui = (BasicInternalFrameUI) employeeFrm.getUI();
            ui.setNorthPane(null);
            desktopPane.add(employeeFrm).setVisible(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEmployeeActionPerformed

    private void btnRatingFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRatingFirstActionPerformed
        try {
            desktopPane.removeAll();
            RatingFrm ratingFrm = new RatingFrm();
            ratingFrm.setMaximum(true);
            BasicInternalFrameUI ui = (BasicInternalFrameUI) ratingFrm.getUI();
            ui.setNorthPane(null);
            desktopPane.add(ratingFrm).setVisible(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRatingFirstActionPerformed

    private void btnRatingSecondActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRatingSecondActionPerformed
        try {
            desktopPane.removeAll();
            CalculatedFrm calculatedFrm = new CalculatedFrm();
            calculatedFrm.setMaximum(true);
            BasicInternalFrameUI ui = (BasicInternalFrameUI) calculatedFrm.getUI();
            ui.setNorthPane(null);
            desktopPane.add(calculatedFrm).setVisible(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRatingSecondActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriteria;
    private javax.swing.JButton btnEmployee;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnRatingFirst;
    private javax.swing.JButton btnRatingSecond;
    private javax.swing.JDesktopPane desktopPane;
    // End of variables declaration//GEN-END:variables
}