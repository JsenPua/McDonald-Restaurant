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

public class UpdateOrDeleteRedeem extends javax.swing.JFrame {
    private MaintainRedeemItem reditemControl;
    private Toys redItem;
    
    public UpdateOrDeleteRedeem() {
        initComponents();
        reditemControl = new MaintainRedeemItem();
        redItem = new Toys();
        
        jtfItemName.setEnabled(false);
        jtfItemPoints.setEnabled(false);
        jtfItemStock.setEnabled(false);
        setTitle("Update or Delete Toys");
        setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfRdiCode = new javax.swing.JTextField();
        jbtEnter = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfItemName = new javax.swing.JTextField();
        jtfItemPoints = new javax.swing.JTextField();
        jbtUpdate = new javax.swing.JButton();
        jbtRemove = new javax.swing.JButton();
        jbtClear = new javax.swing.JButton();
        jbtBack = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jtfItemStock = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 51));

        jLabel1.setFont(new java.awt.Font("Sylfaen", 3, 18)); // NOI18N
        jLabel1.setText("Update or Delete Redeemable Item");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Redeem Item Code: ");

        jbtEnter.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtEnter.setText("Retrieve Redeem Item");
        jbtEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtEnterActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Redeem Item Name:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Redeem Item Points: ");

        jtfItemPoints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfItemPointsActionPerformed(evt);
            }
        });
        jtfItemPoints.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfItemPointsKeyTyped(evt);
            }
        });

        jbtUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtUpdate.setText("Update Redeem Item");
        jbtUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtUpdateActionPerformed(evt);
            }
        });

        jbtRemove.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtRemove.setText("Remove Redeem Item");
        jbtRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtRemoveActionPerformed(evt);
            }
        });

        jbtClear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtClear.setText("Clear Fields");

        jbtBack.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtBack.setText("Back");
        jbtBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBackActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Reddem Item Stock:");

        jtfItemStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfItemStockKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jtfRdiCode, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtEnter)
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbtUpdate))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbtRemove))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbtClear))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbtBack))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfItemName, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(jtfItemPoints)
                            .addComponent(jtfItemStock)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfRdiCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtEnter))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfItemPoints, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfItemStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addComponent(jbtUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtRemove)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtClear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtBack)
                .addContainerGap(67, Short.MAX_VALUE))
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

    private void jbtEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtEnterActionPerformed
        String ID = jtfRdiCode.getText();
        Toys redeemItem = reditemControl.selectRecord(ID);

        if (redeemItem != null) {
            jtfItemName.setText(redeemItem.getRdiName());
            jtfItemPoints.setText("" + redeemItem.getPoints());
            jtfItemStock.setText("" + redeemItem.getStockCount());
            
            jtfItemName.setEnabled(true);
            jtfItemPoints.setEnabled(true);
            jtfItemStock.setEnabled(true);

        } else {
            JOptionPane.showMessageDialog(null, "This redeem item ID does not exist", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            clearFields();
        }
    }//GEN-LAST:event_jbtEnterActionPerformed

    private void jbtUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtUpdateActionPerformed
         String ID = jtfRdiCode.getText();
         Toys redeemItem = reditemControl.selectRecord(ID);
         
        if (redeemItem != null) {
            
            redeemItem = new Toys(ID, jtfItemName.getText(), Integer.parseInt(jtfItemPoints.getText()),Integer.parseInt(jtfItemStock.getText()));
            reditemControl.updateRedeemItem(redeemItem);
            JOptionPane.showMessageDialog(null, jtfItemName.getText() + " updated");
            clearFields();
            jtfItemName.setEnabled(false);
            jtfItemPoints.setEnabled(false);
            jtfItemStock.setEnabled(false);

        } else {
            JOptionPane.showMessageDialog(null, "This redeem item does not exist or has been removed from database", "ERROR", JOptionPane.ERROR_MESSAGE);
            clearFields();
        }
    }//GEN-LAST:event_jbtUpdateActionPerformed

    private void jbtRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtRemoveActionPerformed
       String ID = jtfRdiCode.getText();
         Toys redeemItem = reditemControl.selectRecord(ID);

        if (redeemItem != null) {
            
            redeemItem = new Toys(ID, jtfItemName.getText(), Integer.parseInt(jtfItemPoints.getText()),Integer.parseInt(jtfItemStock.getText()));
             int option = JOptionPane.showConfirmDialog(null, "Confirm delete item ?", "Delete", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {  
            reditemControl.deleteRedeemItem(redeemItem);
            JOptionPane.showMessageDialog(null, jtfItemName.getText() + " removed");
            clearFields();
            jtfItemName.setEnabled(false);
            jtfItemPoints.setEnabled(false);
            jtfItemStock.setEnabled(false);
                }

        } else {
            JOptionPane.showMessageDialog(null, "This redeem item does not exist or has been removed from database", "ERROR", JOptionPane.ERROR_MESSAGE);
            clearFields();
        }
    }//GEN-LAST:event_jbtRemoveActionPerformed

    private void jtfItemPointsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfItemPointsActionPerformed
          
    }//GEN-LAST:event_jtfItemPointsActionPerformed

    private void jtfItemPointsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfItemPointsKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();  // ignore event
        }
    }//GEN-LAST:event_jtfItemPointsKeyTyped

    private void jbtBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBackActionPerformed
        dispose();
        new RedeemFrame().setVisible(true);
    }//GEN-LAST:event_jbtBackActionPerformed

    private void jtfItemStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfItemStockKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();  // ignore event
        }
    }//GEN-LAST:event_jtfItemStockKeyTyped

    public void clearFields(){
        jtfRdiCode.setText("");
        jtfItemName.setText("");
        jtfItemPoints.setText("");
        jtfItemStock.setText("");
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
            java.util.logging.Logger.getLogger(UpdateOrDeleteRedeem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateOrDeleteRedeem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateOrDeleteRedeem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateOrDeleteRedeem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateOrDeleteRedeem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtBack;
    private javax.swing.JButton jbtClear;
    private javax.swing.JButton jbtEnter;
    private javax.swing.JButton jbtRemove;
    private javax.swing.JButton jbtUpdate;
    private javax.swing.JTextField jtfItemName;
    private javax.swing.JTextField jtfItemPoints;
    private javax.swing.JTextField jtfItemStock;
    private javax.swing.JTextField jtfRdiCode;
    // End of variables declaration//GEN-END:variables
}
