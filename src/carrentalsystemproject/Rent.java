
package carrentalsystemproject;

import java.awt.event.KeyEvent;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.toedter.calendar.JDateChooser;
public class Rent extends javax.swing.JFrame {

    public Rent() {
        initComponents();
        // Disable fields first, before LoadCarID() runs.
        // LoadCarID() triggers combocarIDActionPerformed which will re-enable
        // them if the selected car is available. If setEnabled(false) came
        // after LoadCarID(), it would override those enables — leaving fields
        // permanently locked no matter which car was selected.
        txtdate.setDateFormatString("yyyy/MM/dd");
        txtdue.setDateFormatString("yyyy/MM/dd");
        txtcust_id.setEnabled(false);
        txtcustname.setEnabled(false);
        txtfee.setEnabled(false);
        txtdate.setEnabled(false);
        txtdue.setEnabled(false);
        LoadCarID();
    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    PreparedStatement pst1;
    PreparedStatement pst2;
    PreparedStatement pst3;
    PreparedStatement pst4;

    public void LoadCarID() {
        // Use local variables to avoid shared state being overwritten
        // when combocarIDActionPerformed fires during addItem() calls
        Connection localCon = null;
        PreparedStatement localPst = null;
        ResultSet localRs = null;
        try {
            localCon = DBConncetion.connectOnlineDB();
            if (localCon == null) {
                return;
            }
            localPst = localCon.prepareStatement("Select * from Group16_CarRegistrationTable");
            localRs = localPst.executeQuery();
            combocarID.removeAllItems();

            while (localRs.next()) {
                combocarID.addItem(localRs.getString("CarRegNo"));
            }

            localRs.close();
            localPst.close();
            localCon.close();

        } catch (SQLException ex) {
            Logger.getLogger(Rent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Rents = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtcust_id = new javax.swing.JTextField();
        txtcustname = new javax.swing.JTextField();
        txtfee = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        combocarID = new javax.swing.JComboBox<>();
        txtdate = new com.toedter.calendar.JDateChooser();
        txtdue = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtavl = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Rents.setBorder(javax.swing.BorderFactory.createTitledBorder("Rents"));

        jLabel1.setText("Car ID:");

        jLabel2.setText("Customer ID:");

        jLabel3.setText("Customer Name:");

        jLabel4.setText("Fee:");

        jLabel5.setText("DATE OUT:");

        txtcust_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcust_idKeyPressed(evt);
            }
        });

        jLabel6.setText("DATE DUE IN:");

        combocarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocarIDActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout RentsLayout = new javax.swing.GroupLayout(Rents);
        Rents.setLayout(RentsLayout);
        RentsLayout.setHorizontalGroup(
                RentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(RentsLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(RentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                .addGap(66, 66, 66)
                                .addGroup(RentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtcust_id)
                                        .addComponent(txtcustname)
                                        .addComponent(txtfee)
                                        .addComponent(txtdue, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtdate, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(RentsLayout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addGap(56, 56, 56)
                                                .addComponent(jButton2)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(RentsLayout.createSequentialGroup()
                                                .addComponent(combocarID, javax.swing.GroupLayout.PREFERRED_SIZE, 153,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37,
                                                        Short.MAX_VALUE)
                                                .addComponent(txtavl, javax.swing.GroupLayout.PREFERRED_SIZE, 111,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(64, 64, 64)));
        RentsLayout.setVerticalGroup(
                RentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(RentsLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(RentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(RentsLayout.createSequentialGroup()
                                                .addGroup(RentsLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(combocarID,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtavl, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(33, 33, 33)
                                                .addGroup(RentsLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(txtcust_id,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(33, 33, 33)
                                                .addGroup(RentsLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(txtcustname,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(33, 33, 33)
                                                .addGroup(RentsLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtfee, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4))
                                                .addGap(36, 36, 36)
                                                .addComponent(jLabel5))
                                        .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(RentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addComponent(txtdue, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54,
                                        Short.MAX_VALUE)
                                .addGroup(RentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addGap(40, 40, 40)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(Rents, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(24, 24, 24)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(Rents, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(27, Short.MAX_VALUE)));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.hide();
    }// GEN-LAST:event_jButton2ActionPerformed

    private void combocarIDActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_combocarIDActionPerformed
        // TODO add your handling code here:
        Object selectedItem = combocarID.getSelectedItem();
        if (selectedItem == null) {
            return;
        }
        String CarID = selectedItem.toString();
        try {
            con = DBConncetion.connectOnlineDB();
            if (con == null) {
                return;
            }
            pst1 = con.prepareStatement("Select * from Group16_CarRegistrationTable where CarRegNo=?");
            pst1.setString(1, CarID);
            rs = pst1.executeQuery();

            if (rs.next() == false) {
                JOptionPane.showMessageDialog(this, "CarID NOT FOUND");
            } else {
                String aval = rs.getString("Available");
                // Null-safe: avoid NullPointerException if DB field is null
                String avalTrimmed = (aval != null) ? aval.trim() : "";
                txtavl.setText(avalTrimmed);

                if ("Yes".equals(avalTrimmed)) {
                    txtcust_id.setEnabled(true);
                    txtcustname.setEnabled(true);
                    txtfee.setEnabled(true);
                    txtdate.setEnabled(true);
                    txtdue.setEnabled(true);
                }
            }

            rs.close();
            pst1.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Rent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// GEN-LAST:event_combocarIDActionPerformed

    private void txtcust_idKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtcust_idKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String cust_id = txtcust_id.getText();

            try {
                con = DBConncetion.connectOnlineDB();
                if (con == null) {
                    return;
                }

                pst2 = con.prepareStatement("Select * from Group16_CustomerRegistrationTable where CustomerID=?");
                pst2.setString(1, cust_id);
                rs = pst2.executeQuery();

                if (rs.next() == false) {
                    JOptionPane.showMessageDialog(this, "CustomerID NOT FOUND");
                } else {
                    String custname = rs.getString("Name");
                    txtcustname.setText(custname.trim());
                }

                rs.close();
                pst2.close();
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(Rent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }// GEN-LAST:event_txtcust_idKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String CarID = combocarID.getSelectedItem().toString();
        String CustomerID = txtcust_id.getText();
        String Fee = txtfee.getText();
        SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
        String DateOut = Date_Format.format(txtdate.getDate());

        SimpleDateFormat Date_Format1 = new SimpleDateFormat("yyyy-MM-dd");
        String DateDueIn = Date_Format1.format(txtdue.getDate());

        try {
            con = DBConncetion.connectOnlineDB();
            if (con == null) {
                return;
            }

            pst3 = con.prepareStatement(
                    "insert into Group16_Rents(CarID, CustomerID, Fee, DateOut, DateDueIn) values(?,?,?,?,?)");
            pst3.setString(1, CarID);
            pst3.setString(2, CustomerID);
            pst3.setString(3, Fee);
            pst3.setString(4, DateOut);
            pst3.setString(5, DateDueIn);
            pst3.executeUpdate();

            pst4 = con.prepareStatement("Update Group16_CarRegistrationTable set Available='No' where CarRegNo=?");
            pst4.setString(1, CarID);
            pst4.executeUpdate();

            pst4.close();
            pst3.close();
            con.close();

            JOptionPane.showMessageDialog(this, "Success");

        } catch (SQLException ex) {
            Logger.getLogger(Rent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
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
            java.util.logging.Logger.getLogger(Rent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Rents;
    private javax.swing.JComboBox<String> combocarID;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtavl;
    private javax.swing.JTextField txtcust_id;
    private javax.swing.JTextField txtcustname;
    private com.toedter.calendar.JDateChooser txtdate;
    private com.toedter.calendar.JDateChooser txtdue;
    private javax.swing.JTextField txtfee;
    // End of variables declaration//GEN-END:variables
}
