/*
 Author Soo Xingliang
 */
package ui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import da.*;
import domain.*;
import control.*;
import java.sql.*;

public class RetrieveVoidTransaction extends JPanel {

    private JLabel jlbTransID = new JLabel("Transaction ID :");
    private JTextField jtfTransID = new JTextField();
    private JLabel jlbStatus = new JLabel("Status :");
    private JTextField jtfStatus = new JTextField();
    private JLabel jlbStaffID = new JLabel("Staff ID :");
    private JTextField jtfStaffID = new JTextField();
    private JLabel jlbStaffName = new JLabel("Staff Name :");
    private JTextField jtfStaffName = new JTextField();
    private JLabel jlbOrderType = new JLabel("Order Type :");
    private JTextField jtfOrderType = new JTextField();
    private JLabel jlbDeliveryAdd = new JLabel("Delivery Address :");
    private JTextArea jtaDeliveryAdd = new JTextArea();
    private JLabel jlbPaymentType = new JLabel("Payment Type :");
    private JTextField jtfPaymentType = new JTextField();
    private JLabel jlbCCNo = new JLabel("Credit Card No :");
    private JTextField jtfCCNo = new JTextField();
    private JLabel jlbMemberID = new JLabel("Member ID :");
    private JTextField jtfMemberID = new JTextField();
    private JLabel jlbMemberName = new JLabel("Member Name ");
    private JTextField jtfMemberName = new JTextField();
    private JLabel jlbTransDate = new JLabel("Date of Transaction :");
    private JTextField jtfTransDate = new JTextField();
    private JLabel jlbVoucher = new JLabel("Voucher Value :");
    private JTextField jtfVoucher = new JTextField();
    private JLabel jlbTotalPayment = new JLabel("TotalPayment :");
    private JTextField jtfTotalPayment = new JTextField();
    private JPanel rightPanel = new JPanel(new BorderLayout());
    private JPanel leftPanel = new JPanel(new GridLayout(7, 1));
    private JButton jbtRetrieve = new JButton("Retrieve");
    private JButton jbtVoid = new JButton("Void");
    private JPanel retrieveP = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel leftp1 = new JPanel(new GridLayout(2, 2));
    private JPanel leftp2 = new JPanel(new GridLayout(2, 2));
    private JPanel leftp3 = new JPanel(new GridLayout(1, 2));
    private JPanel leftp4 = new JPanel(new GridLayout(2, 2));
    private JPanel leftp5 = new JPanel(new GridLayout(2, 2));
    private JPanel leftp6 = new JPanel(new GridLayout(2, 2));
    private JPanel leftp7 = new JPanel(new GridLayout(2, 2));
    private JPanel confirmationPanel = new JPanel(new GridLayout(14, 2));
    private JLabel jlbConfirm = new JLabel("Confirmation Panel");
    private JLabel jlbStaffIDn = new JLabel("Staff ID :");
    private JTextField jtfStaffn = new JTextField();
    private JLabel jlbPW = new JLabel("Password :");
    private JPasswordField jpfStaffP = new JPasswordField();
    private JPanel voidP = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private MaintainStaffControl staffControl;
    private TransactionControl transControl;
    private MaintainMemberControl memberControl;

    public RetrieveVoidTransaction() {
        staffControl = new MaintainStaffControl();
        transControl = new TransactionControl();
        memberControl = new MaintainMemberControl();
        setLayout(new BorderLayout());
        jtaDeliveryAdd.setLineWrap(true);
        jtaDeliveryAdd.setWrapStyleWord(true);
        jlbTransID.setFont(new Font("Arial", Font.BOLD, 25));
        jtfTransID.setFont(new Font("Arial", Font.BOLD, 25));
        leftp1.add(jlbTransID);
        leftp1.add(jtfTransID);
        jlbStatus.setFont(new Font("Arial", Font.BOLD, 25));
        jtfStatus.setFont(new Font("Arial", Font.BOLD, 25));
        leftp1.add(jlbStatus);
        leftp1.add(jtfStatus);
        jtfStatus.setEditable(false);
        leftPanel.add(leftp1);
        leftp2.add(jlbStaffID);
        leftp2.add(jtfStaffID);
        jtfStaffID.setEditable(false);
        leftp2.add(jlbStaffName);
        leftp2.add(jtfStaffName);
        jtfStaffName.setEditable(false);
        leftPanel.add(leftp2);
        leftp3.add(jlbDeliveryAdd);
        leftp3.add(jtaDeliveryAdd);
        jtaDeliveryAdd.setEditable(false);
        leftPanel.add(leftp3);
        leftp4.add(jlbPaymentType);
        leftp4.add(jtfPaymentType);
        jtfPaymentType.setEditable(false);
        leftp4.add(jlbCCNo);
        leftp4.add(jtfCCNo);
        jtfCCNo.setEditable(false);
        leftPanel.add(leftp4);
        leftp5.add(jlbMemberID);
        leftp5.add(jtfMemberID);
        jtfMemberID.setEditable(false);
        leftp5.add(jlbMemberName);
        leftp5.add(jtfMemberName);
        jtfMemberName.setEditable(false);
        leftPanel.add(leftp5);
        leftp6.add(jlbTransDate);
        leftp6.add(jtfTransDate);
        jtfTransDate.setEditable(false);
        leftp6.add(jlbVoucher);
        leftp6.add(jtfVoucher);
        jtfVoucher.setEditable(false);
        leftPanel.add(leftp6);
        leftp7.add(jlbTotalPayment);
        leftp7.add(jtfTotalPayment);
        jtfTotalPayment.setEditable(false);
        leftp7.add(new JLabel());
        retrieveP.add(jbtRetrieve);
        leftp7.add(retrieveP);
        leftPanel.add(leftp7);
        rightPanel.add(jlbConfirm, BorderLayout.NORTH);
        confirmationPanel.add(new JLabel(""));
        confirmationPanel.add(new JLabel(""));
        confirmationPanel.add(new JLabel("Confirmation Panel"));
        confirmationPanel.add(new JLabel(""));
        confirmationPanel.add(jlbStaffIDn);
        confirmationPanel.add(jtfStaffn);
        jtfStaffn.setEditable(false);
        confirmationPanel.add(jlbPW);
        confirmationPanel.add(jpfStaffP);
        jpfStaffP.setEditable(false);
        confirmationPanel.add(new JLabel(""));
        confirmationPanel.add(new JLabel(""));
        confirmationPanel.add(new JLabel(""));
        voidP.add(jbtVoid);
        confirmationPanel.add(voidP);
        confirmationPanel.add(new JLabel(""));
        confirmationPanel.add(new JLabel(""));
        confirmationPanel.add(new JLabel(""));
        confirmationPanel.add(new JLabel(""));
        confirmationPanel.add(new JLabel(""));
        confirmationPanel.add(new JLabel(""));
        confirmationPanel.add(new JLabel(""));
        confirmationPanel.add(new JLabel(""));
        confirmationPanel.add(new JLabel(""));
        confirmationPanel.add(new JLabel(""));
        confirmationPanel.add(new JLabel(""));
        rightPanel.add(new JLabel("    "), BorderLayout.NORTH);
        rightPanel.add(confirmationPanel, BorderLayout.CENTER);
        rightPanel.add(new JLabel("    "), BorderLayout.SOUTH);
        rightPanel.add(new JLabel("    "), BorderLayout.WEST);
        rightPanel.add(new JLabel("    "), BorderLayout.EAST);
        add(leftPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);
        jbtRetrieve.addActionListener(new RetrieveListener());
        jbtVoid.addActionListener(new VoidListener());

    }

    private class RetrieveListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String id = jtfTransID.getText();
            Transaction trans = transControl.selectRecord(id);
            if (trans != null) {
                JOptionPane.showMessageDialog(null, trans.getStaffID());
                Staff staff = staffControl.selectRecord(trans.getStaffID());
                Member member = memberControl.selectRecord(trans.getMemberID());
                jtfStatus.setText(trans.getStatus()+"ED");
                jtfStaffID.setText(trans.getStaffID());
                jtfStaffName.setText(staff.getName());
                jtfOrderType.setText(trans.getOrderType());
                jtaDeliveryAdd.setText(trans.getDeliveryAddress());
                jtfPaymentType.setText(trans.getPaymentType());
                jtfCCNo.setText(trans.getCcNo());
                jtfMemberID.setText(trans.getMemberID());
                jtfMemberName.setText(member.getMemberName());
                jtfTransDate.setText("" + trans.getTransTime());
                jtfVoucher.setText("RM " + trans.getVoucherValue());
                jtfTotalPayment.setText("RM " + trans.getTotal());
                jtfStaffn.setEditable(true);
                jpfStaffP.setEditable(true);
                if(trans.getStatus().equals("VOID")){
                    jtfStatus.setFont(new Font("Arial", Font.BOLD, 25));
                    jtfStatus.setForeground(Color.red);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No such Transaction ID.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
                jtfStaffn.setEditable(false);
                jpfStaffP.setEditable(false);
            }
        }
    }

    private class VoidListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String id = jtfTransID.getText();
            Transaction trans = transControl.selectRecord(id);
            String staffID = jtfStaffn.getText();
            Staff staff = staffControl.selectRecord(staffID);
            if (trans != null) {
                if (staff != null) {
                    String staffPassword = jpfStaffP.getText();
                    if (staffPassword.equals(staff.getPassword())) {
                        transControl.voidRecord(id);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Staff ID or Password.", "Authorisation Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No such Staff ID", "Authorisation Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No such Transaction ID.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
