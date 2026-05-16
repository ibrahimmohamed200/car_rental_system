
package carrentalsystemproject;

import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public final class CarRegistration extends javax.swing.JFrame {

    
    public CarRegistration() {
        initComponents();
        autoID();
        table_update();
    }
    
   Connection con;
   PreparedStatement pst;
   ResultSet rs;
    
    @SuppressWarnings("unchecked")
    
    public void table_update()
    {
        try {
            con = DBConncetion.connectOnlineDB();
            if (con == null) return;
            
            pst = con.prepareStatement("Select * from Group16_CarRegistrationTable");
            rs = pst.executeQuery();
            
            DefaultTableModel df = (DefaultTableModel)CarRegistrationTable.getModel();
            df.setRowCount(0);
            
            while(rs.next()) {
                Vector v2 = new Vector();
                v2.add(rs.getString("CarRegNo"));
                v2.add(rs.getString("Brand"));
                v2.add(rs.getString("Model"));
                v2.add(rs.getString("Available"));
                df.addRow(v2);
            }
            
            rs.close();
            pst.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CarRegistration.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error loading table data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(CarRegistration.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Unexpected error in table load: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
            
    public void autoID()
    {
        try {
            con = DBConncetion.connectOnlineDB();
            if (con == null) return;
            Statement s = con.createStatement();
            
            ResultSet rs = s.executeQuery("select Max(CarRegNo) from Group16_CarRegistrationTable");
            rs.next();
            
            if(rs.getString("Max(CarRegNo)")==null)
            {
                txtregno.setText("C001");
            }
            else
            {
                String maxIdStr = rs.getString("Max(CarRegNo)");
                if (maxIdStr.length() > 2) {
                    long ID = Long.parseLong(maxIdStr.substring(2));
                    ID++;
                    txtregno.setText("C0"+ String.format("%03d", ID));
                } else {
                    txtregno.setText("C001");
                }
            }
            
            rs.close();
            s.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CarRegistration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CarRegistration.class.getName()).log(Level.SEVERE, null, ex);
            txtregno.setText("C001"); // Default fallback
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        CarRegistrationTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        txtregno = new javax.swing.JTextField();
        txtbrand = new javax.swing.JTextField();
        txtmodel = new javax.swing.JTextField();
        comavl = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CarRegistrationTable.setAutoCreateRowSorter(true);
        CarRegistrationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CarRegNo", "Brand", "Model", "Available"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        CarRegistrationTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CarRegistrationTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(CarRegistrationTable);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Car Registration"));

        jLabel5.setText("Car Registration No.");

        jLabel6.setText("Brand:");

        jLabel7.setText("Model:");

        jLabel8.setText("Available:");

        jButton5.setText("Add");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Edit");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Delete");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Cancel");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        txtbrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbrandActionPerformed(evt);
            }
        });

        comavl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        comavl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comavlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5)
                            .addComponent(jButton7))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6)
                            .addComponent(jButton8)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtregno)
                        .addComponent(txtbrand)
                        .addComponent(txtmodel)
                        .addComponent(comavl, 0, 197, Short.MAX_VALUE)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtregno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtbrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtmodel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(comavl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void CarRegistrationTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CarRegistrationTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel)CarRegistrationTable.getModel();
        int selectIndex = CarRegistrationTable.getSelectedRow();
        txtregno.setText(d1.getValueAt(selectIndex, 0).toString());
        txtbrand.setText(d1.getValueAt(selectIndex, 1).toString());
        txtmodel.setText(d1.getValueAt(selectIndex, 2).toString());
        comavl.setSelectedItem(d1.getValueAt(selectIndex, 3).toString());
    }//GEN-LAST:event_CarRegistrationTableMouseClicked

    private void txtbrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbrandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbrandActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel)CarRegistrationTable.getModel();
        int selectIndex = CarRegistrationTable.getSelectedRow();
        if (selectIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please select a record to edit.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            String ID = d1.getValueAt(selectIndex, 0).toString();
            String Brand = txtbrand.getText();
            String Model = txtmodel.getText();
            String Available = "";
            
            if (comavl.getSelectedItem() != null) {
                Available = comavl.getSelectedItem().toString();
            } else {
                JOptionPane.showMessageDialog(this, "Please select if the car is Available or not.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            con = DBConncetion.connectOnlineDB();
            if (con == null) return;
            
            pst = con.prepareStatement("Update Group16_CarRegistrationTable set Brand=?,Model=?,Available=? where CarRegNo=?");
            pst.setString(1, Brand);
            pst.setString(2, Model);
            pst.setString(3, Available);
            pst.setString(4, ID);
            pst.executeUpdate();
            
            pst.close();
            con.close();
            
            JOptionPane.showMessageDialog(this, "Record Updated");
            table_update();
                    
        } catch (SQLException ex) {
            Logger.getLogger(CarRegistration.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            String RegistrationNumber= txtregno.getText();
            String Brand= txtbrand.getText();
            String Model= txtmodel.getText();
            String Available = "";
            
            if (comavl.getSelectedItem() != null) {
                Available = comavl.getSelectedItem().toString();
            } else {
                JOptionPane.showMessageDialog(this, "Please select if the car is Available or not.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (RegistrationNumber.isEmpty() || Brand.isEmpty() || Model.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            con = DBConncetion.connectOnlineDB();
            if (con == null) {
                JOptionPane.showMessageDialog(this, "Database connection failed.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            pst= con.prepareStatement("insert into Group16_CarRegistrationTable(CarRegNo, Brand, Model, Available) values(?,?,?,?)");
            pst.setString(1, RegistrationNumber);
            pst.setString(2, Brand);
            pst.setString(3, Model);
            pst.setString(4, Available);
            pst.executeUpdate();
            
            pst.close();
            con.close();
            
            JOptionPane.showMessageDialog(this, " Car Added ");
            
            txtbrand.setText("");
            txtmodel.setText("");
            comavl.setSelectedIndex(-1);
            txtbrand.requestFocus();
            autoID();
            table_update();
            
        } catch (SQLException ex) {
            Logger.getLogger(CarRegistration.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(CarRegistration.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Unexpected error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void comavlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comavlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comavlActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel)CarRegistrationTable.getModel();
        int selectIndex = CarRegistrationTable.getSelectedRow();
        if (selectIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please select a record to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String ID = d1.getValueAt(selectIndex, 0).toString();
        
        int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete?", "Warning", JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION)
        {
            try {
                con = DBConncetion.connectOnlineDB();
                if (con == null) return;
                
                pst = con.prepareStatement("Delete from Group16_CarRegistrationTable where CarRegNo=?");
                pst.setString(1, ID);
                pst.executeUpdate();
                
                pst.close();
                con.close();
                
                JOptionPane.showMessageDialog(this, "Record Deleted");
                table_update();
                
            } catch (SQLException ex) {
                Logger.getLogger(CarRegistration.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } 
        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    
    
    
    
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
            java.util.logging.Logger.getLogger(CarRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CarRegistration().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CarRegistrationTable;
    private javax.swing.JComboBox<String> comavl;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtbrand;
    private javax.swing.JTextField txtmodel;
    private javax.swing.JTextField txtregno;
    // End of variables declaration//GEN-END:variables

    
    
}
