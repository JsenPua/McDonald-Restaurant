/*
 Author Swati
 */
package ui;

import domain.Member;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import control.MaintainMemberControl;
import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Random;

public class MemberRegister extends javax.swing.JFrame {

    private MaintainMemberControl memControl;
    private Member mem;
    private static final String CHAR_LIST = "1234567890";
    private static final int RANDOM_STRING_LENGTH = 4;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private String type;

    public MemberRegister() {
        initComponents();
        memControl = new MaintainMemberControl();
        mem = new Member();

        jtaAddress.setLineWrap(true);
        setTitle("Member Registration Menu");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jlbName = new javax.swing.JLabel();
        jlbIC = new javax.swing.JLabel();
        jlbContact = new javax.swing.JLabel();
        jlbAddress = new javax.swing.JLabel();
        jtfName = new javax.swing.JTextField();
        jtfIC = new javax.swing.JTextField();
        jtfContact = new javax.swing.JTextField();
        jbtRegister = new javax.swing.JButton();
        jbtClear = new javax.swing.JButton();
        jbtBack = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaAddress = new javax.swing.JTextArea();
        jckBasic = new javax.swing.JCheckBox();
        jckPremium = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(221, 16, 33));

        jlbName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbName.setForeground(new java.awt.Color(255, 255, 255));
        jlbName.setText("Member Name:");

        jlbIC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbIC.setForeground(new java.awt.Color(255, 255, 255));
        jlbIC.setText("Member's IC:");

        jlbContact.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbContact.setForeground(new java.awt.Color(255, 255, 255));
        jlbContact.setText("Contact Number:");

        jlbAddress.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbAddress.setForeground(new java.awt.Color(255, 255, 255));
        jlbAddress.setText("Address:");

        jtfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNameActionPerformed(evt);
            }
        });
        jtfName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNameKeyTyped(evt);
            }
        });

        jtfIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfICActionPerformed(evt);
            }
        });
        jtfIC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfICKeyTyped(evt);
            }
        });

        jtfContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfContactActionPerformed(evt);
            }
        });
        jtfContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfContactKeyTyped(evt);
            }
        });

        jbtRegister.setText("Register");
        jbtRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtRegisterActionPerformed(evt);
            }
        });

        jbtClear.setText("Clear");
        jbtClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtClearActionPerformed(evt);
            }
        });

        jbtBack.setText("Back");
        jbtBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBackActionPerformed(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBar(null);

        jtaAddress.setColumns(20);
        jtaAddress.setRows(5);
        jScrollPane2.setViewportView(jtaAddress);

        jckBasic.setBackground(new java.awt.Color(221, 16, 33));
        jckBasic.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jckBasic.setForeground(new java.awt.Color(255, 255, 255));
        jckBasic.setText("Basic Membership");
        jckBasic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jckBasicActionPerformed(evt);
            }
        });

        jckPremium.setBackground(new java.awt.Color(221, 16, 33));
        jckPremium.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jckPremium.setForeground(new java.awt.Color(255, 255, 255));
        jckPremium.setText("Premium Membership");
        jckPremium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jckPremiumActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Membership Type: ");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 153));
        jLabel3.setText("eg: 960211146453");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 153));
        jLabel4.setText("eg:0122673452");

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MEMBERSHIP REGISTRATION");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 153));
        jLabel5.setText("**6 months membership**");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 153));
        jLabel6.setText("**1 year membership**");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jbtBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtClear)
                        .addGap(18, 18, 18)
                        .addComponent(jbtRegister))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jlbName)
                            .addComponent(jlbContact)
                            .addComponent(jlbAddress)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jlbIC))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfName)
                                    .addComponent(jtfIC)
                                    .addComponent(jtfContact)
                                    .addComponent(jScrollPane2)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jckBasic)
                                    .addComponent(jLabel5))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jckPremium))))))
                .addGap(48, 48, 48))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbName)
                    .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbIC)
                    .addComponent(jtfIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbContact)
                    .addComponent(jtfContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(7, 7, 7)
                        .addComponent(jlbAddress)))
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jckBasic)
                    .addComponent(jckPremium)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(80, 80, 80)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtRegister)
                    .addComponent(jbtClear)
                    .addComponent(jbtBack))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNameActionPerformed

    }//GEN-LAST:event_jtfNameActionPerformed

    private void jbtRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtRegisterActionPerformed
        //Register Button
        String ID = generateRandomString();
        int point = 0;
        int choice1;

        java.util.Date utilDate = new Date();

        // Convert it to java.sql.Date
        java.sql.Date date = new java.sql.Date(utilDate.getTime());

        final java.util.Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);

        Member member = memControl.selectRecord(ID);

        if (jtfName.getText().equals("") || jtfIC.getText().equals("")
                || jtfContact.getText().equals("") || jtaAddress.getText().equals("")
                || jckBasic.isSelected() == false && jckPremium.isSelected() == false) 
            JOptionPane.showMessageDialog(null, "Please make sure to fill in all the necessary fields");

        else {
                if (!(jtfName.getText().length() < 31 && jtfIC.getText().length() < 15
                        && jtfContact.getText().length() < 13 && jtaAddress.getText().length() < 101)) {

                    JOptionPane.showMessageDialog(null, "Please make sure to fill in all the necessary fields");
                } else {

                    choice1 = JOptionPane.showConfirmDialog(null, "Do you confirm registration? Click on 'Yes' to confirm and 'No' to go back",
                            "Confirmation", JOptionPane.YES_NO_OPTION);

                    if (jckBasic.isSelected()) {
                        type = jckBasic.getText();
                        cal.add(GregorianCalendar.MONTH, 6);
                    } else {
                        type = jckPremium.getText();
                        cal.add(GregorianCalendar.YEAR, 1);
                    }

                    if (choice1 == JOptionPane.YES_OPTION) {
                        member = new Member(ID, jtfName.getText(), jtfIC.getText(), jtfContact.getText(), jtaAddress.getText(),
                                point, date, cal.getTime(), type);

                        memControl.addMember(member);
                        JOptionPane.showMessageDialog(null, jtfName.getText() + " successfully added");
                        JOptionPane.showMessageDialog(null, "\tSUCCESSFULLY REGISTERED AS MEMBER OF MCDONALD'S\n\nHere is "
                                + jtfName.getText() + "'s Member ID: " + ID);

                        clearFields();
                    }
                }
            }

    }//GEN-LAST:event_jbtRegisterActionPerformed

    

    public String generateRandomString() {
        String code = "M";

        StringBuffer randStr = new StringBuffer();
        for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return code + randStr.toString();

    }

    private int getRandomNumber() {

        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }

    private void jbtClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtClearActionPerformed
        //Clear Button
        clearFields();
    }//GEN-LAST:event_jbtClearActionPerformed

    private void jbtBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBackActionPerformed
        new MembershipMenu().setVisible(true);
        dispose();
    }//GEN-LAST:event_jbtBackActionPerformed

    private void jckBasicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jckBasicActionPerformed
        jckPremium.setSelected(false);
    }//GEN-LAST:event_jckBasicActionPerformed

    private void jckPremiumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jckPremiumActionPerformed
        jckBasic.setSelected(false);
    }//GEN-LAST:event_jckPremiumActionPerformed

    private void jtfNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNameKeyTyped
        int i = evt.getKeyChar();
        if (!((i < '0') || (i > '9')) && (i != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();  // ignore event
        }
    }//GEN-LAST:event_jtfNameKeyTyped

    private void jtfICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfICActionPerformed

    }//GEN-LAST:event_jtfICActionPerformed

    private void jtfICKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfICKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();  // ignore event
        }
    }//GEN-LAST:event_jtfICKeyTyped

    private void jtfContactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfContactKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();  // ignore event
        }
    }//GEN-LAST:event_jtfContactKeyTyped

    private void jtfContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfContactActionPerformed

    public void clearFields() {
        jtfName.setText("");
        jtfIC.setText("");
        jtfContact.setText("");
        jtaAddress.setText("");
        jckBasic.setSelected(false);
        jckPremium.setSelected(false);
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
            java.util.logging.Logger.getLogger(MemberRegister.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemberRegister.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemberRegister.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemberRegister.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemberRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtBack;
    private javax.swing.JButton jbtClear;
    private javax.swing.JButton jbtRegister;
    private javax.swing.JCheckBox jckBasic;
    private javax.swing.JCheckBox jckPremium;
    private javax.swing.JLabel jlbAddress;
    private javax.swing.JLabel jlbContact;
    private javax.swing.JLabel jlbIC;
    private javax.swing.JLabel jlbName;
    private javax.swing.JTextArea jtaAddress;
    private javax.swing.JTextField jtfContact;
    private javax.swing.JTextField jtfIC;
    private javax.swing.JTextField jtfName;
    // End of variables declaration//GEN-END:variables

}
