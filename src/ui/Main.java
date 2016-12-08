/*
 Author Phang Chun Wai
 */
package ui;

import domain.Staff;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Main extends javax.swing.JFrame {

    private String stf;
    private PaymentFormPanel paymentFrame;
    private MaintaiItemFrame itemFrame;

    public Main(Staff staff) {

        stf = staff.getId();

        initComponents();

        if (staff.getId().charAt(0) == 'S') {
            jbtStaffing.setEnabled(false);
        } else {
            jbtStaffing.setEnabled(true);
        }

        setTitle("Main");
        setSize(690, 670);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        jLabel3.setVisible(true);
        jtfId.setText(staff.getId());
        jtfId.setVisible(true);

    }

    public Main() {

        initComponents();
        setTitle("Main");
        jLabel3.setVisible(false);

        jtfId.setVisible(false);
        setSize(690, 650);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbtOrderMenu = new javax.swing.JButton();
        jbtMemberMenu = new javax.swing.JButton();
        jbtStaffing = new javax.swing.JButton();
        jbtRedeemMenu = new javax.swing.JButton();
        jbtPaymentDet = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtfId = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 51));

        jPanel5.setBackground(new java.awt.Color(221, 16, 33));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Staff ID:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Logout");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/welcome_mcd_employees.gif"))); // NOI18N

        jbtOrderMenu.setBackground(new java.awt.Color(255, 204, 51));
        jbtOrderMenu.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jbtOrderMenu.setText("Order Menu");
        jbtOrderMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtOrderMenuActionPerformed(evt);
            }
        });

        jbtMemberMenu.setBackground(new java.awt.Color(255, 204, 51));
        jbtMemberMenu.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jbtMemberMenu.setText("Membership Menu");
        jbtMemberMenu.setAlignmentY(0.2F);
        jbtMemberMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtMemberMenuActionPerformed(evt);
            }
        });

        jbtStaffing.setBackground(new java.awt.Color(255, 204, 51));
        jbtStaffing.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jbtStaffing.setText("Staffing Menu");
        jbtStaffing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtStaffingActionPerformed(evt);
            }
        });

        jbtRedeemMenu.setBackground(new java.awt.Color(255, 204, 51));
        jbtRedeemMenu.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jbtRedeemMenu.setText("Redeem Menu");
        jbtRedeemMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtRedeemMenuActionPerformed(evt);
            }
        });

        jbtPaymentDet.setBackground(new java.awt.Color(255, 204, 51));
        jbtPaymentDet.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jbtPaymentDet.setText("Payment Details");
        jbtPaymentDet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPaymentDetActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ronald-mcdonald-psd51748.png"))); // NOI18N

        jtfId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfId.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtMemberMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(jbtRedeemMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtPaymentDet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtStaffing, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtOrderMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jtfId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jbtOrderMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtMemberMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtRedeemMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtPaymentDet, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtStaffing, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtMemberMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtMemberMenuActionPerformed
        // TODO add your handling code here:
        dispose();
        new MembershipMenu().setVisible(true);
    }//GEN-LAST:event_jbtMemberMenuActionPerformed

    private void jbtOrderMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtOrderMenuActionPerformed
        itemFrame = new MaintaiItemFrame(stf);
    }//GEN-LAST:event_jbtOrderMenuActionPerformed

    private void jbtStaffingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtStaffingActionPerformed
        try {
            // TODO add your handling code here:
            dispose();
            Staff staff = new Staff(stf);
            new MaintainStaff(staff).setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtStaffingActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        dispose();
        new Login().setVisible(true);

    }//GEN-LAST:event_jLabel1MouseClicked

    private void jbtRedeemMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtRedeemMenuActionPerformed
        // TODO add your handling code here:
        dispose();
        new RedeemFrame().setVisible(true);
    }//GEN-LAST:event_jbtRedeemMenuActionPerformed

    private void jbtPaymentDetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPaymentDetActionPerformed
        paymentFrame = new PaymentFormPanel(stf);
    }//GEN-LAST:event_jbtPaymentDetActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //  new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton jbtMemberMenu;
    private javax.swing.JButton jbtOrderMenu;
    private javax.swing.JButton jbtPaymentDet;
    private javax.swing.JButton jbtRedeemMenu;
    private javax.swing.JButton jbtStaffing;
    private javax.swing.JLabel jtfId;
    // End of variables declaration//GEN-END:variables
}
