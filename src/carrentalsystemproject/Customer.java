
package carrentalsystemproject;

import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public final class Customer extends javax.swing.JFrame {

    
    public Customer() {
        initComponents();
        autoID();
        table_update();
    }
    
   Connection con;
   PreparedStatement pst;
   ResultSet rs;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtcustid = new javax.swing.JTextField();
        txtcustname = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaddress = new javax.swing.JTextArea();
        txtmobile = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        CustomerRegistrationTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Customer Registration"));

        jLabel1.setText("Customer ID:");

        jLabel2.setText("Name:");

        jLabel3.setText("Address:");

        jLabel4.setText("Mobile:");

        txtcustid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcustidActionPerformed(evt);
            }
        });

        txtcustname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcustnameActionPerformed(evt);
            }
        });

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtaddress.setColumns(20);
        txtaddress.setRows(5);
        jScrollPane2.setViewportView(txtaddress);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(77, 77, 77)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(77, 77, 77)
                        .addComponent(jButton4))
                    .addComponent(txtcustname)
                    .addComponent(txtcustid)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                    .addComponent(txtmobile))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtcustid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtcustname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(21, 21, 21))
        );

        CustomerRegistrationTable.setAutoCreateRowSorter(true);
        CustomerRegistrationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CustomerID", "Name", "Address", "Mobile"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        CustomerRegistrationTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomerRegistrationTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(CustomerRegistrationTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public void table_update()
    {
        try {
            con = DBConncetion.connectOnlineDB();
            pst = con.prepareStatement("Select * from Group16_CustomerRegistrationTable");
            rs = pst.executeQuery();
            
            DefaultTableModel df = (DefaultTableModel)CustomerRegistrationTable.getModel();
            df.setRowCount(0);
            
            while(rs.next()) {
                Vector v2 = new Vector();
                v2.add(rs.getString("CustomerID"));
                v2.add(rs.getString("Name"));
                v2.add(rs.getString("Address"));
                v2.add(rs.getString("Mobile"));
                df.addRow(v2);
            }
            
            rs.close();
            pst.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
    public void autoID()
    {
        try {
            con = DBConncetion.connectOnlineDB();
            Statement s = con.createStatement();
            
            ResultSet rs = s.executeQuery("select Max(CustomerID) from Group16_CustomerRegistrationTable");
            rs.next();
            rs.getString("Max(CustomerID)");
            
            if(rs.getString("Max(CustomerID)")==null)
            {
                txtcustid.setText("A001");
            }
            else
            {
                long ID = Long.parseLong(rs.getString("Max(CustomerID)").substring(2,rs.getString("Max(CustomerID)").length()));
                ID++;
                txtcustid.setText("A0"+ String.format("%03d", ID));
            }
            
            rs.close();
            s.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
        
    
    
    private void txtcustnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcustnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcustnameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String CustomerID= txtcustid.getText();
        String Name= txtcustname.getText();
        String Address= txtaddress.getText();
        String Mobile = txtmobile.getText();
        
        try { 
            con = DBConncetion.connectOnlineDB();
            pst= con.prepareStatement("insert into Group16_CustomerRegistrationTable(CustomerID, Name, Address, Mobile) values(?,?,?,?)");
            pst.setString(1, CustomerID);
            pst.setString(2, Name);
            pst.setString(3, Address);
            pst.setString(4, Mobile);
            pst.executeUpdate();
            
            pst.close();
            con.close();
            
            JOptionPane.showMessageDialog(this, " Customer Added Successfully!");
            
            txtcustname.setText("");
            txtaddress.setText("");
            txtmobile.setText("");
            txtcustname.requestFocus();
            autoID();
            table_update();
            
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtcustidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcustidActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtcustidActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void CustomerRegistrationTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerRegistrationTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel)CustomerRegistrationTable.getModel();
        int selectIndex = CustomerRegistrationTable.getSelectedRow();
        txtcustid.setText(d1.getValueAt(selectIndex, 0).toString());
        txtcustname.setText(d1.getValueAt(selectIndex, 1).toString());
        txtaddress.setText(d1.getValueAt(selectIndex, 2).toString());
        txtmobile.setText(d1.getValueAt(selectIndex, 3).toString());
    }//GEN-LAST:event_CustomerRegistrationTableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel)CustomerRegistrationTable.getModel();
        int selectIndex = CustomerRegistrationTable.getSelectedRow();
        try {
            String ID = d1.getValueAt(selectIndex, 0).toString();
            String Name = txtcustname.getText();
            String Address = txtaddress.getText();
            String Mobile = txtmobile.getText();
            
            con = DBConncetion.connectOnlineDB();
            
            pst = con.prepareStatement("Update Group16_CustomerRegistrationTable set Name=?,Address=?,Mobile=? where CustomerID=?");
            pst.setString(1, Name);
            pst.setString(2, Address);
            pst.setString(3, Mobile);
            pst.setString(4, ID);
            pst.executeUpdate();
            
            pst.close();
            con.close();
            
            JOptionPane.showMessageDialog(this, "Information Updated");
            table_update();
                    
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel)CustomerRegistrationTable.getModel();
        int selectIndex = CustomerRegistrationTable.getSelectedRow();
        
        String ID = d1.getValueAt(selectIndex, 0).toString();
        
        int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete?", "Warning", JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION)
        {
            try {
                con = DBConncetion.connectOnlineDB();
                pst = con.prepareStatement("Delete from Group16_CustomerRegistrationTable where CustomerID=?");
                pst.setString(1, ID);
                pst.executeUpdate();
                
                pst.close();
                con.close();
                
                JOptionPane.showMessageDialog(this, "Record Deleted");
                table_update();
                
            } catch (SQLException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    
    
    
    
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
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Customer().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CustomerRegistrationTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtaddress;
    private javax.swing.JTextField txtcustid;
    private javax.swing.JTextField txtcustname;
    private javax.swing.JTextField txtmobile;
    // End of variables declaration//GEN-END:variables

    
    // autoId() removed — use autoID() instead
}
