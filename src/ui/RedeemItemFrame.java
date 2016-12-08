/*
 Author Swati
 */
package ui;

import java.util.Random;
import control.MaintainRedeemItem;
import domain.Toys;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RedeemItemFrame extends javax.swing.JFrame {
    private static final String CHAR_LIST = "1234567890";
    private static final int RANDOM_STRING_LENGTH = 3;
    private MaintainRedeemItem reditemControl;
    private Toys redItem;
    public RedeemItemFrame() {
        initComponents();
        reditemControl = new MaintainRedeemItem();
        redItem = new Toys();
        setTitle("Add New Toys");
        setLocationRelativeTo(null);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlbName = new javax.swing.JLabel();
        jlbPoints = new javax.swing.JLabel();
        jtfRdiName = new javax.swing.JTextField();
        jtfPointsNeed = new javax.swing.JTextField();
        jbtAdd = new javax.swing.JButton();
        jbtClear = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtfStock = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 51));

        jLabel1.setFont(new java.awt.Font("Sylfaen", 3, 18)); // NOI18N
        jLabel1.setText("REDEEMABLE ITEMS");

        jlbName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbName.setText("Redeem Item Name: ");

        jlbPoints.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbPoints.setText("Points Needed: ");

        jtfRdiName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfRdiNameActionPerformed(evt);
            }
        });

        jtfPointsNeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPointsNeedActionPerformed(evt);
            }
        });
        jtfPointsNeed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfPointsNeedKeyTyped(evt);
            }
        });

        jbtAdd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtAdd.setText("Add New Redeemable Item");
        jbtAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAddActionPerformed(evt);
            }
        });

        jbtClear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtClear.setText("Clear Fields");
        jbtClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtClearActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Stock Count: ");

        jtfStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfStockKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jbtAdd)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlbName)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlbPoints, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGap(83, 83, 83)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtfRdiName, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                .addComponent(jtfPointsNeed)
                                .addComponent(jtfStock))))
                    .addComponent(jbtClear)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbName)
                    .addComponent(jtfRdiName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbPoints)
                    .addComponent(jtfPointsNeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(jbtAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtClear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(26, 26, 26))
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

    private void jbtAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAddActionPerformed
        String ID = generateRandomString();
        int point = 0;
        int choice1;

        Toys redeemItem = reditemControl.selectRecord(ID);
        
        if (jtfRdiName.getText().equals("") || jtfPointsNeed.getText().isEmpty()) 
            JOptionPane.showMessageDialog(null, "Please make sure to fill in all the necessary fields");

        else {
                if (!(jtfRdiName.getText().length() < 31 && jtfPointsNeed.getText().length() < 4)) {

                    JOptionPane.showMessageDialog(null, "Please make sure to fill in all the necessary fields");
                } else {

                    choice1 = JOptionPane.showConfirmDialog(null, "Do you confirm registration? Click on 'Yes' to confirm and 'No' to go back",
                            "Confirmation", JOptionPane.YES_NO_OPTION);

                    if (choice1 == JOptionPane.YES_OPTION) {
                        redeemItem = new Toys(ID, jtfRdiName.getText(), Integer.parseInt(jtfPointsNeed.getText()),Integer.parseInt(jtfStock.getText()));

                        reditemControl.addRedeemItem(redeemItem);
                        JOptionPane.showMessageDialog(null, jtfRdiName.getText() + " successfully added");
                        JOptionPane.showMessageDialog(null, "Here is the ID for "
                                + jtfRdiName.getText() + ": " + ID);

                        clearFields();
                    }
                }
            }
        
    }//GEN-LAST:event_jbtAddActionPerformed

    private void jtfRdiNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfRdiNameActionPerformed
       
    }//GEN-LAST:event_jtfRdiNameActionPerformed

    private void jbtClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtClearActionPerformed
        clearFields();
    }//GEN-LAST:event_jbtClearActionPerformed

    private void jtfPointsNeedKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPointsNeedKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();  // ignore event
        }
    }//GEN-LAST:event_jtfPointsNeedKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        new RedeemFrame().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtfPointsNeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPointsNeedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPointsNeedActionPerformed

    private void jtfStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfStockKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();  // ignore event
        }
    }//GEN-LAST:event_jtfStockKeyTyped
    
    public String generateRandomString() {
        String code = "RI";

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
    
    public void clearFields(){
        jtfRdiName.setText("");
        jtfPointsNeed.setText("");
        jtfStock.setText("");

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
            java.util.logging.Logger.getLogger(RedeemItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RedeemItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RedeemItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RedeemItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RedeemItemFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtAdd;
    private javax.swing.JButton jbtClear;
    private javax.swing.JLabel jlbName;
    private javax.swing.JLabel jlbPoints;
    private javax.swing.JTextField jtfPointsNeed;
    private javax.swing.JTextField jtfRdiName;
    private javax.swing.JTextField jtfStock;
    // End of variables declaration//GEN-END:variables
}
