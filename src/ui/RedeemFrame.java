/*
 Author Swati
 */
package ui;

import domain.Member;
import control.MaintainMemberControl;
import control.MaintainRedeemItem;
import domain.Toys;
import domain.Redeem;
import control.MaintainRedeemControl;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Random;

public class RedeemFrame extends javax.swing.JFrame {

    private MaintainMemberControl memControl;
    private Member mem;
    private MaintainRedeemItem maintainRedItem;
    private Toys redItem;
    private MaintainRedeemControl maintainRedControl;
    private Redeem red;
    private static final String CHAR_LIST = "1234567890";
    private static final int RANDOM_STRING_LENGTH = 4;

    public RedeemFrame() {
        memControl = new MaintainMemberControl();
        maintainRedItem = new MaintainRedeemItem();
        initComponents();
        jtfCode.setEnabled(false);
        jtfMemPoint.setEnabled(false);
        jtfPoints.setEnabled(false);
        jtfStock.setEnabled(false);
        mem = new Member();
        jbtRedeem.setEnabled(false);

        redItem = new Toys();
        maintainRedControl = new MaintainRedeemControl();
        red = new Redeem();

        setLocationRelativeTo(null);
        setTitle("Redeem Toys");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jbtFrankie = new javax.swing.JButton();
        jbtDrac = new javax.swing.JButton();
        jbtMavis = new javax.swing.JButton();
        jbtDennis = new javax.swing.JButton();
        jbtMurray = new javax.swing.JButton();
        jbtWayne = new javax.swing.JButton();
        jlbID = new javax.swing.JLabel();
        jtfID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jbtRedeem = new javax.swing.JButton();
        jbtAdd = new javax.swing.JButton();
        jbtRemove = new javax.swing.JButton();
        jbtClear = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jtfCode = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jtfPoints = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jtfMemPoint = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jtfStock = new javax.swing.JTextField();
        jbtView = new javax.swing.JButton();
        jbtHomepage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 51));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setText("REDEEM TOYS");

        jbtFrankie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1.png"))); // NOI18N
        jbtFrankie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtFrankieActionPerformed(evt);
            }
        });

        jbtDrac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/3.png"))); // NOI18N
        jbtDrac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDracActionPerformed(evt);
            }
        });

        jbtMavis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/4.png"))); // NOI18N
        jbtMavis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtMavisActionPerformed(evt);
            }
        });

        jbtDennis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/2.png"))); // NOI18N
        jbtDennis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDennisActionPerformed(evt);
            }
        });

        jbtMurray.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/5.png"))); // NOI18N
        jbtMurray.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtMurrayActionPerformed(evt);
            }
        });

        jbtWayne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/6.jpg"))); // NOI18N
        jbtWayne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtWayneActionPerformed(evt);
            }
        });

        jlbID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbID.setText("Member ID: ");

        jtfID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIDActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Name of Item:");

        jtfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNameActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Name: Frankenstein");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Points: 10");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Name: Dennis");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Points: 20");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Name: Drac");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Points: 30");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Name: Mavis");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Points: 30");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Name: Murray");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Points: 15");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Name: Wayne ");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Points: 15");

        jbtRedeem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtRedeem.setText("Redeem Toy");
        jbtRedeem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtRedeemActionPerformed(evt);
            }
        });

        jbtAdd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtAdd.setText("Add New Redeem Item");
        jbtAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAddActionPerformed(evt);
            }
        });

        jbtRemove.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtRemove.setText("Remove or Update Redeem Item");
        jbtRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtRemoveActionPerformed(evt);
            }
        });

        jbtClear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtClear.setText("Clear Fields");
        jbtClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtClearActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Item Code:");

        jtfCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodeActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Points Needed:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Member Points:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Item Stock :");

        jbtView.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtView.setText("View Redeem Items");
        jbtView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtViewActionPerformed(evt);
            }
        });

        jbtHomepage.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtHomepage.setText("Back To Homepage");
        jbtHomepage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtHomepageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jbtMavis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jbtFrankie, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jbtMurray, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jbtDennis))
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jbtWayne, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jbtDrac, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16))
                                .addGap(127, 127, 127))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jbtAdd)
                                .addGap(18, 18, 18)
                                .addComponent(jbtRemove)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtRedeem)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jbtView)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbtClear))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel18)
                                        .addComponent(jlbID))
                                    .addGap(38, 38, 38)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfMemPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel4))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(40, 40, 40)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtfCode)
                                        .addComponent(jtfPoints)
                                        .addComponent(jtfStock)))
                                .addComponent(jbtHomepage))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jbtHomepage))
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbtDrac, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jbtFrankie, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtDennis, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbID)
                            .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jtfMemPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jtfPoints, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addGap(41, 41, 41)
                        .addComponent(jbtRedeem))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jtfStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtMavis, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtMurray, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtWayne, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel16)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtClear)
                            .addComponent(jbtRemove)
                            .addComponent(jbtView)
                            .addComponent(jbtAdd))
                        .addGap(71, 71, 71))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtFrankieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtFrankieActionPerformed

        int option = JOptionPane.showConfirmDialog(null, "Select Frankenstein?", "Frankenstein", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {

            jtfName.setText("Frankenstein");

        }
    }//GEN-LAST:event_jbtFrankieActionPerformed

    private void jbtClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtClearActionPerformed
        clearFields();
    }//GEN-LAST:event_jbtClearActionPerformed

    private void jbtRedeemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtRedeemActionPerformed
        String ID = generateRandomString();
        int choice1;

        Redeem redeem = maintainRedControl.selectRecord(ID);
        Toys toys = maintainRedItem.selectRecord2(jtfName.getText());
        Member member = memControl.selectRecord(jtfID.getText());
        try {
            if (jtfID.getText().isEmpty() || jtfName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "The Member ID or Item Name is not provided");
            } else if (member == null || toys == null ) {
                JOptionPane.showMessageDialog(null, "The member ID or the name of item provided is not valid or available");

            } else {
                int point = Integer.parseInt(jtfPoints.getText());
                int stock = Integer.parseInt(jtfStock.getText());
                if (member.getLoyaltyPoint() > point && toys.getStockCount() > 0) {
                    redeem = new Redeem(ID, member, toys);
                    maintainRedControl.addRedeem(redeem);
                    point = member.getLoyaltyPoint() - point;
                    stock = toys.getStockCount() - 1;
                    member = new Member(member.getMbrID(), member.getMemberName(), member.getIcNo(), member.getContactNo(), member.getHomeAddress(), point, member.getMemStartDate(), member.getMemEndDate(), member.getMbrType());
                    memControl.updateMember(member);
                    toys = new Toys(toys.getRdiCode(), toys.getRdiName(), toys.getPoints(), stock);
                    maintainRedItem.updateRedeemItem(toys);
                    JOptionPane.showMessageDialog(null, "Redeemed successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
                    jtfMemPoint.setText("" + member.getLoyaltyPoint());
                    jtfStock.setText("" + stock);
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient points or insufficient stock", "Information", JOptionPane.INFORMATION_MESSAGE);
                }

            }

        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jbtRedeemActionPerformed

    private void jtfIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIDActionPerformed

        Member member = memControl.selectRecord(jtfID.getText());
        Toys toys = maintainRedItem.selectRecord2(jtfName.getText());
        if (member == null) {
            JOptionPane.showMessageDialog(null, "This Member ID does not exist");
            jbtRedeem.setEnabled(false);
        } else {
            jtfMemPoint.setText("" + member.getLoyaltyPoint());
            jbtRedeem.setEnabled(true);
        }

    }//GEN-LAST:event_jtfIDActionPerformed

    private void jtfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNameActionPerformed
        Toys toys = maintainRedItem.selectRecord2(jtfName.getText());
        if (toys == null) {
            JOptionPane.showMessageDialog(null, "This Toy does not exist");
            jbtRedeem.setEnabled(false);
        } else {
            String point = "" + toys.getPoints();
            String stock = "" + toys.getStockCount();
            jtfCode.setText(toys.getRdiCode());
            jtfPoints.setText(point);
            jtfStock.setText(stock);
            jbtRedeem.setEnabled(true);

        }

    }//GEN-LAST:event_jtfNameActionPerformed

    private void jbtAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAddActionPerformed
        dispose();
        new RedeemItemFrame().setVisible(true);
    }//GEN-LAST:event_jbtAddActionPerformed

    private void jbtRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtRemoveActionPerformed
        dispose();
        new UpdateOrDeleteRedeem().setVisible(true);
    }//GEN-LAST:event_jbtRemoveActionPerformed

    private void jbtDennisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDennisActionPerformed
        int option = JOptionPane.showConfirmDialog(null, "Select Dennis?", "Dennis", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {

            jtfName.setText("Dennis");

        }
    }//GEN-LAST:event_jbtDennisActionPerformed

    private void jbtDracActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDracActionPerformed
        int option = JOptionPane.showConfirmDialog(null, "Select Drac?", "Drac", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {

            jtfName.setText("Drac");

        }
    }//GEN-LAST:event_jbtDracActionPerformed

    private void jbtMavisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtMavisActionPerformed
        int option = JOptionPane.showConfirmDialog(null, "Select Mavis?", "Mavis", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {

            jtfName.setText("Mavis");

        }
    }//GEN-LAST:event_jbtMavisActionPerformed

    private void jbtMurrayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtMurrayActionPerformed
        int option = JOptionPane.showConfirmDialog(null, "Select Murray?", "Murray", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {

            jtfName.setText("Murray");

        }
    }//GEN-LAST:event_jbtMurrayActionPerformed

    private void jbtWayneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtWayneActionPerformed
        int option = JOptionPane.showConfirmDialog(null, "Select Wayne?", "Wayne", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {

            jtfName.setText("Wayne");

        }
    }//GEN-LAST:event_jbtWayneActionPerformed

    private void jbtViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtViewActionPerformed
        dispose();
        new RedeemItemTable().setVisible(true);
    }//GEN-LAST:event_jbtViewActionPerformed

    private void jtfCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCodeActionPerformed

    private void jbtHomepageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtHomepageActionPerformed
        dispose();
        new Main().setVisible(true);
    }//GEN-LAST:event_jbtHomepageActionPerformed

    public void clearFields() {
        jtfID.setText("");
        jtfName.setText("");
        jtfStock.setText("");
        jtfMemPoint.setText("");
        jtfCode.setText("");
        jtfPoints.setText("");

    }

    public String generateRandomString() {
        String code = "R";

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
            java.util.logging.Logger.getLogger(RedeemFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RedeemFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RedeemFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RedeemFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RedeemFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtAdd;
    private javax.swing.JButton jbtClear;
    private javax.swing.JButton jbtDennis;
    private javax.swing.JButton jbtDrac;
    private javax.swing.JButton jbtFrankie;
    private javax.swing.JButton jbtHomepage;
    private javax.swing.JButton jbtMavis;
    private javax.swing.JButton jbtMurray;
    private javax.swing.JButton jbtRedeem;
    private javax.swing.JButton jbtRemove;
    private javax.swing.JButton jbtView;
    private javax.swing.JButton jbtWayne;
    private javax.swing.JLabel jlbID;
    private javax.swing.JTextField jtfCode;
    private javax.swing.JTextField jtfID;
    private javax.swing.JTextField jtfMemPoint;
    private javax.swing.JTextField jtfName;
    private javax.swing.JTextField jtfPoints;
    private javax.swing.JTextField jtfStock;
    // End of variables declaration//GEN-END:variables
}
