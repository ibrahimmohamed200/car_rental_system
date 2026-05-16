
package carrentalsystemproject;

import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Returncar extends javax.swing.JFrame {

    
    public Returncar() {
        initComponents();
        
    }

    Connection con;
    PreparedStatement pst;
    PreparedStatement pst1;
    PreparedStatement pst2;
    ResultSet rs;
    
    @SuppressWarnings("unchecked")
    
    public void table_update()
    {
        try {
            con = DBConncetion.connectOnlineDB();
            pst = con.prepareStatement("Select * from Group16_ReturnCar");
            rs = pst.executeQuery();
            
            DefaultTableModel df = (DefaultTableModel)ReturnCar.getModel();
            df.setRowCount(0);
            
            while(rs.next()) {
                Vector v2 = new Vector();
                v2.add(rs.getString("CarID"));
                v2.add(rs.getString("CustomerID"));
                v2.add(rs.getString("ReturnDate"));
                v2.add(rs.getString("DaysElapsed"));
                v2.add(rs.getString("Fine"));
                df.addRow(v2);
            }
            
            rs.close();
            pst.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Returncar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtcarid = new javax.swing.JTextField();
        txtcustid = new javax.swing.JTextField();
        txtdate = new javax.swing.JTextField();
        txtelp = new javax.swing.JTextField();
        txtfine = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ReturnCar = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Return Car");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Rent Info"));

        jLabel2.setText("Car ID:");

        jLabel3.setText("Customer ID:");

        jLabel4.setText("Return Date:");

        jLabel5.setText("Days Elapsed:");

        jLabel6.setText("Fine:");

        txtcarid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcaridActionPerformed(evt);
            }
        });
        txtcarid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcaridKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtfine, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(txtelp)
                    .addComponent(txtdate)
                    .addComponent(txtcustid)
                    .addComponent(txtcarid))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtcarid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtcustid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtfine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        ReturnCar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CarID", "CustomerID", "ReturnDate", "DaysElapsed", "Fine"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ReturnCar);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(299, 299, 299)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jButton1)
                        .addGap(61, 61, 61)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtcaridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcaridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcaridActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String CarID = txtcarid.getText();
        String CustomerID = txtcustid.getText();
        String ReturnDate = txtdate.getText();
        String DaysElapsed = txtelp.getText();
        String Fine = txtfine.getText();
        
        try {
            con = DBConncetion.connectOnlineDB();
            
            pst = con.prepareStatement("Insert into Group16_ReturnCar(CarID, CustomerID, ReturnDate, DaysElapsed, Fine) values(?,?,?,?,?)");
            pst.setString(1, CarID);
            pst.setString(2, CustomerID);
            pst.setString(3,ReturnDate);
            pst.setString(4, DaysElapsed);
            pst.setString(5, Fine);
            pst.executeUpdate();
            
            pst1 = con.prepareStatement("Update Group16_CarRegistrationTable set Available='Yes' where CarRegNo=?");
            pst1.setString(1, CarID);
            pst1.executeUpdate();
            
            pst2 = con.prepareStatement("Delete from Group16_Rents where CarID=?");
            pst2.setString(1, CarID);
            pst2.executeUpdate();
            
            pst2.close();
            pst1.close();
            pst.close();
            con.close();
            
            JOptionPane.showMessageDialog(this, "Car Returned Successfully!");
            table_update();
            
        } catch (SQLException ex) {
            Logger.getLogger(Returncar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtcaridKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcaridKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            try {
                con = DBConncetion.connectOnlineDB();
                
                String CarID = txtcarid.getText();
                
                pst = con.prepareStatement("Select CarID, CustomerID, DateDueIn, DATEDIFF(NOW(), DateDueIn) as DaysElapsed from Group16_Rents where CarID=?");
                pst.setString(1, CarID);
                
                rs = pst.executeQuery();
                
                if(rs.next()==false)
                {
                    JOptionPane.showMessageDialog(this, "Car ID Not Found");
                }
                else
                {
                    String CustomerID = rs.getString("CustomerID");
                    txtcustid.setText(CustomerID.trim());
                    
                    String ReturnDate = rs.getString("DateDueIn");
                    txtdate.setText(ReturnDate.trim());
                    
                    String DaysElapsed = rs.getString("DaysElapsed");
                    
                    int Elapsed = Integer.parseInt(DaysElapsed);
                    
                    if(Elapsed>0)
                    {
                        txtelp.setText(DaysElapsed);
                        
                        int Fine = Elapsed * 200;
                        
                        txtfine.setText(String.valueOf(Fine));
                    }
                    else
                    {
                        txtelp.setText("0");
                        txtfine.setText("0");
                    }
                }
                
                rs.close();
                pst.close();
                con.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(Returncar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtcaridKeyPressed

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
            java.util.logging.Logger.getLogger(Returncar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Returncar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Returncar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Returncar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Returncar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ReturnCar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtcarid;
    private javax.swing.JTextField txtcustid;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtelp;
    private javax.swing.JTextField txtfine;
    // End of variables declaration//GEN-END:variables
}
