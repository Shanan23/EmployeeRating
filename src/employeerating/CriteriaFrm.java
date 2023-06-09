/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package employeerating;

import employeerating.dialog.CriteriaDialog;
import employeerating.model.CriteriaModel;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author macbookpro
 */
public class CriteriaFrm extends JInternalFrame {

    private String criteriaId;
    private final Frame frame;

    /**
     * Creates new form HomeFrm
     */
    public CriteriaFrm() {
        initComponents();
        generateDataToTable();
        JInternalFrame internalFrame = this; // Replace with your internal frame

        frame = (Frame) SwingUtilities.getAncestorOfClass(JFrame.class, internalFrame);
        if (frame != null) {
            // You have the frame reference
            System.out.println("Found frame: " + frame.getTitle());
        } else {
            // Frame not found
            System.out.println("Could not find frame for the internal frame.");
        }
    }

    private void generateDataToTable() {
        //data product
        String col[] = {"No", "Nama", "Bobot",
            "Deskripsi"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);

        ArrayList<CriteriaModel> criteriaModels = new DbConnection().SelectListCriteria();

        for (int i = 0; i < criteriaModels.size(); i++) {
            Object[] data = {i + 1, criteriaModels.get(i).getCriteriaName(),
                criteriaModels.get(i).getCriteriaAmount(),
                criteriaModels.get(i).getCriteriaDesc()};
            tableModel.addRow(data);
        }
        System.out.println("raw count criteria " + tableModel.getRowCount());
        tableCriteria.setModel(tableModel);
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
        tableCriteria = new javax.swing.JTable();

        setSize(new java.awt.Dimension(100, 100));

        tableCriteria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableCriteria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCriteriaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableCriteriaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableCriteriaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableCriteria);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableCriteriaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCriteriaMouseReleased
        int row = tableCriteria.getSelectedRow();
        String row_id = (tableCriteria.getModel().getValueAt(row, 0).toString());
        criteriaId = row_id;
        System.out.println("criteriaId : " + criteriaId);
        CriteriaDialog dialog = new CriteriaDialog(frame, true, criteriaId);
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                generateDataToTable();
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_tableCriteriaMouseReleased

    private void tableCriteriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCriteriaMouseClicked
        int row = tableCriteria.getSelectedRow();
        String row_id = (tableCriteria.getModel().getValueAt(row, 0).toString());
        criteriaId = row_id;
        System.out.println("criteriaId : " + criteriaId);
        CriteriaDialog dialog = new CriteriaDialog(frame, true, criteriaId);
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                generateDataToTable();
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_tableCriteriaMouseClicked

    private void tableCriteriaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCriteriaMousePressed
        int row = tableCriteria.getSelectedRow();
        String row_id = (tableCriteria.getModel().getValueAt(row, 0).toString());
        criteriaId = row_id;
        System.out.println("criteriaId : " + criteriaId);
        CriteriaDialog dialog = new CriteriaDialog(frame, true, criteriaId);
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                generateDataToTable();
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_tableCriteriaMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCriteria;
    // End of variables declaration//GEN-END:variables
}
