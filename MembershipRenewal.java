/*
 Author Swati
 */
package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import control.MaintainMemberControl;
import domain.Member;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import java.text.ParseException;
import java.util.GregorianCalendar;
import javax.swing.text.DefaultCaret;

public class MembershipRenewal extends javax.swing.JFrame {

    private MaintainMemberControl memControl;
    private Member mem;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public MembershipRenewal() {
        initComponents();
        memControl = new MaintainMemberControl();
        mem = new Member();

        jbtRenew.setEnabled(false);

        jtaInformation.setBackground(Color.LIGHT_GRAY);
        jtaInformation.setLineWrap(true);
        jtaInformation.setEditable(false);
        jtfName.setEditable(false);
        jtfName.setBackground(Color.LIGHT_GRAY);
        jtfIC.setEditable(false);
        jtfIC.setBackground(Color.LIGHT_GRAY);
        jtfContact.setEditable(false);
        jtfContact.setBackground(Color.LIGHT_GRAY);
        jtaAddress.setEditable(false);
        jtaAddress.setBackground(Color.LIGHT_GRAY);
        jtfPoints.setEditable(false);
        jtfPoints.setBackground(Color.LIGHT_GRAY);
        jtfEndDate.setEditable(false);
        jtfEndDate.setBackground(Color.LIGHT_GRAY);
        jtfType.setEditable(false);
        jtfType.setBackground(Color.LIGHT_GRAY);

        setTitle("Membership Renewal");
        setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlbMemberID = new javax.swing.JLabel();
        jtfID = new javax.swing.JTextField();
        jlbEndDate = new javax.swing.JLabel();
        jtfType = new javax.swing.JTextField();
        jbtRenew = new javax.swing.JButton();
        jlbType = new javax.swing.JLabel();
        jtfEndDate = new javax.swing.JTextField();
        jtfName = new javax.swing.JTextField();
        jlbName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaInformation = new javax.swing.JTextArea();
        jlbIC = new javax.swing.JLabel();
        jlbContact = new javax.swing.JLabel();
        jlbPoints = new javax.swing.JLabel();
        jlbAddress = new javax.swing.JLabel();
        jtfPoints = new javax.swing.JTextField();
        jtfContact = new javax.swing.JTextField();
        jtfIC = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaAddress = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(221, 16, 33));

        jLabel1.setFont(new java.awt.Font("Sylfaen", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Renewal of Membership");

        jlbMemberID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbMemberID.setForeground(new java.awt.Color(255, 255, 255));
        jlbMemberID.setText("Member ID: ");

        jtfID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIDActionPerformed(evt);
            }
        });

        jlbEndDate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbEndDate.setForeground(new java.awt.Color(255, 255, 255));
        jlbEndDate.setText("Expiry Date: ");

        jbtRenew.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtRenew.setText("Renew Membership");
        jbtRenew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtRenewActionPerformed(evt);
            }
        });

        jlbType.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbType.setForeground(new java.awt.Color(255, 255, 255));
        jlbType.setText("Membership Type:");

        jlbName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbName.setForeground(new java.awt.Color(255, 255, 255));
        jlbName.setText("Member Name: ");

        jtaInformation.setBackground(new java.awt.Color(221, 16, 33));
        jtaInformation.setColumns(20);
        jtaInformation.setFont(new java.awt.Font("Monospaced", 3, 14)); // NOI18N
        jtaInformation.setForeground(new java.awt.Color(255, 255, 255));
        jtaInformation.setRows(5);
        jtaInformation.setText("Renewal for Basic\nand Premium \nMemberships!");
        jScrollPane1.setViewportView(jtaInformation);

        jlbIC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbIC.setForeground(new java.awt.Color(255, 255, 255));
        jlbIC.setText("Member IC Number:");

        jlbContact.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbContact.setForeground(new java.awt.Color(255, 255, 255));
        jlbContact.setText("Contact Number:");

        jlbPoints.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbPoints.setForeground(new java.awt.Color(255, 255, 255));
        jlbPoints.setText("Loyalty Points:");

        jlbAddress.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbAddress.setForeground(new java.awt.Color(255, 255, 255));
        jlbAddress.setText("Home Address:");

        jtaAddress.setColumns(20);
        jtaAddress.setRows(5);
        jScrollPane2.setViewportView(jtaAddress);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbMemberID)
                .addGap(18, 18, 18)
                .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlbName)
                                .addGap(38, 38, 38)
                                .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlbType)
                                    .addComponent(jlbEndDate)
                                    .addComponent(jlbAddress)
                                    .addComponent(jlbIC)
                                    .addComponent(jlbContact)
                                    .addComponent(jlbPoints))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfEndDate)
                                    .addComponent(jtfType)
                                    .addComponent(jtfPoints)
                                    .addComponent(jtfContact)
                                    .addComponent(jtfIC)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbtRenew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbMemberID)
                    .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbName)
                    .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbIC)
                            .addComponent(jtfIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbContact)
                            .addComponent(jtfContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlbAddress)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfPoints, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlbPoints))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlbEndDate)
                                    .addComponent(jtfEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlbType)
                                    .addComponent(jtfType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jbtRenew)
                                    .addComponent(jButton2))
                                .addGap(24, 24, 24))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIDActionPerformed
        String ID = jtfID.getText();
        Member member = memControl.selectRecord(ID);

        java.util.Date utilDate = new Date();

        // Convert it to java.sql.Date
        java.sql.Date date = new java.sql.Date(utilDate.getTime());

        final java.util.Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        cal.add(GregorianCalendar.MONTH, 2);

        if (jtfID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the Member ID", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            if (member != null) {
                jtfName.setText(member.getMemberName());
                jtfIC.setText(member.getIcNo());
                jtfContact.setText(member.getContactNo());
                jtaAddress.setText(member.getHomeAddress());
                jtfPoints.setText("" + member.getLoyaltyPoint());
                jtfEndDate.setText("" + member.getMemEndDate());
                jtfType.setText(member.getMbrType());
                jbtRenew.setEnabled(true);

                if (member.getMemEndDate().before(date)) {
                    jtaInformation.setText(jtfName.getText() + "'s membership \nhas expired.\nRenew membership now");
                }

            } else {
                JOptionPane.showMessageDialog(null, "This member ID does not exist", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }
        }


    }//GEN-LAST:event_jtfIDActionPerformed

    private void jbtRenewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtRenewActionPerformed
        String ID = jtfID.getText();
        Member member = memControl.selectRecord(ID);

        java.util.Date utilDate = new Date();

        // Convert it to java.sql.Date
        java.sql.Date date = new java.sql.Date(utilDate.getTime());

        final java.util.Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);

        if (member.getMemEndDate().before(date)) {
            if (jtfType.getText().equals("Basic Membership")) {
                cal.add(GregorianCalendar.MONTH, 6);
            } else if (jtfType.getText().equals("Premium Membership")) {
                cal.add(GregorianCalendar.YEAR, 1);
            }

            member = new Member(ID, jtfName.getText(), jtfIC.getText(), jtfContact.getText(), jtaAddress.getText(),
                    Integer.parseInt(jtfPoints.getText()), date, cal.getTime(), jtfType.getText());
            memControl.updateMember(member);
            JOptionPane.showMessageDialog(null, jtfName.getText() + "'s membership has been renewed");
            clearFields();
            jbtRenew.setEnabled(false);
            jtaInformation.setText("Renewal for Basic\n"
                    + "and Premium \n"
                    + "Memberships!");

        } else {
            JOptionPane.showMessageDialog(null, jtfName.getText() + "'s membership has not expired yet. Renewal is only valid until after the expiry date");
        }
        clearFields();
        jbtRenew.setEnabled(false);
    }//GEN-LAST:event_jbtRenewActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
        new MembershipMenu().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    public void clearFields() {
        jtfID.setText("");
        jtfName.setText("");
        jtfIC.setText("");
        jtfContact.setText("");
        jtaAddress.setText("");
        jtfPoints.setText("");
        jtfEndDate.setText("");
        jtfType.setText("");
    }

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
            java.util.logging.Logger.getLogger(MembershipRenewal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MembershipRenewal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MembershipRenewal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MembershipRenewal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MembershipRenewal().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtRenew;
    private javax.swing.JLabel jlbAddress;
    private javax.swing.JLabel jlbContact;
    private javax.swing.JLabel jlbEndDate;
    private javax.swing.JLabel jlbIC;
    private javax.swing.JLabel jlbMemberID;
    private javax.swing.JLabel jlbName;
    private javax.swing.JLabel jlbPoints;
    private javax.swing.JLabel jlbType;
    private javax.swing.JTextArea jtaAddress;
    private javax.swing.JTextArea jtaInformation;
    private javax.swing.JTextField jtfContact;
    private javax.swing.JTextField jtfEndDate;
    private javax.swing.JTextField jtfIC;
    private javax.swing.JTextField jtfID;
    private javax.swing.JTextField jtfName;
    private javax.swing.JTextField jtfPoints;
    private javax.swing.JTextField jtfType;
    // End of variables declaration//GEN-END:variables
}
