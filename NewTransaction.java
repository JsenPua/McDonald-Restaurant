/*
 Author Pua Jen Sen
 */
package ui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import domain.*;
import control.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NewTransaction extends JPanel {

    private boolean DEBUG = false;
    private JPanel rightPanel = new JPanel(new BorderLayout());
    private JPanel leftPanel = new JPanel(new BorderLayout());
    private JPanel header = new JPanel(new FlowLayout());
    private JLabel transID = new JLabel();
    private JLabel jlbHeader = new JLabel("Transaction ID : #");
    private String transIDString = "";
    private JPanel body = new JPanel(new GridLayout(10, 2));
    private JLabel jlbStaffID = new JLabel("Staff ID :");
    private JTextField jtfStaffID = new JTextField();
    private JLabel jlbOrderType = new JLabel("Order Type :");
    private Object[] orderType = new Object[]{"Eat In", "Take Away", "Delivery"};
    private JComboBox jcbOrderType = new JComboBox(orderType);
    private JLabel jlbDeliveryAddress = new JLabel("Delivery Address");
    private JTextArea jtaDeliveryAddress = new JTextArea();
    private JScrollPane jspDeliveryAddress = new JScrollPane(jtaDeliveryAddress);
    private JLabel jlbPaymentType = new JLabel("Payment Type");
    private Object[] paymentType = new Object[]{"Cash", "Credit Card"};
    private JComboBox jcbPaymentType = new JComboBox(paymentType);
    private JLabel jlbCreditCardNo = new JLabel("Credit Card No :");
    private JTextField jtfCreditCardNo = new JTextField();
    private JLabel jlbIsMember = new JLabel("Is Member ?");
    private JPanel isMember = new JPanel(new FlowLayout());
    private JRadioButton jrbIsMember = new JRadioButton("Yes");
    private JRadioButton jrbIsNotMember = new JRadioButton("No");
    private ButtonGroup gp = new ButtonGroup();
    private JLabel memberID = new JLabel("Member ID :");
    private JTextField jtfMemberID = new JTextField();
    private JButton jbtValidateMem = new JButton("Validate");
    private JLabel jlbVoucher = new JLabel("Apply Voucher");
    private JCheckBox jcbVoucher10 = new JCheckBox("RM 10");
    private ButtonGroup gp2 = new ButtonGroup();
    private JPanel botPanel = new JPanel(new FlowLayout());
    private JButton jbtProceed = new JButton("Proceed");
    private JLabel jlbEmpty = new JLabel();
    private JButton jbtAddItem = new JButton("Back to Cart");
    private JPanel title = new JPanel(new GridLayout(1, 4));
    private JLabel jlbName = new JLabel("Name");
    private JLabel jlbQty = new JLabel("Quantity");
    private JLabel jlbEach = new JLabel("Each");
    private JLabel jlbTotal = new JLabel("Total");
    private JPanel qtyPanel = new JPanel(new GridLayout(1, 2));
    private JLabel empty = new JLabel("++++");
    private JPanel totalPanel = new JPanel(new GridLayout(3, 2));
    private JTextArea test = new JTextArea();
    private JPanel flowLayoutDiscount = new JPanel(new FlowLayout());
    private JPanel flowLayoutSubTotal = new JPanel(new FlowLayout());
    private JPanel flowLayoutTax = new JPanel(new FlowLayout());
    private JPanel flowLayoutTotal = new JPanel(new FlowLayout());
    private JPanel flowLayoutBalanceDue = new JPanel(new FlowLayout());
    private JPanel flowLayoutChanges = new JPanel(new FlowLayout());
    private JLabel jlbTotalDiscount = new JLabel("Discount:");
    private JLabel jlbSubTotal = new JLabel("Sub Total :");
    private JLabel jlbGST = new JLabel("GST (6%) :");
    private JLabel jlbGrandTotal = new JLabel("Grand Total :");
    private JLabel jlbBalanceDue = new JLabel("Balance Due :");
    private JLabel jlbChange = new JLabel("Change :");
    private JLabel jlbTotalDiscountI = new JLabel("");
    private JLabel jlbSubTotalI = new JLabel("");
    private JLabel jlbGSTI = new JLabel("");
    private JLabel jlbGrandTotalI = new JLabel("");
    private JLabel jlbBalanceDueI = new JLabel("");
    private JLabel jlbChangeI = new JLabel("");
    private JPanel tablePanel = new JPanel();
    private String[] columnNames = {"No.",
        "Item Name",
        "Quantity",
        "Price Each (RM)",
        "Total (RM)"};
    private MaintainMemberControl memberControl;
    private double totalDiscount = 0;
    private double gst = 0;
    private double subTotal = 0;
    private double grandTotal = 0;
    private double balanceDue = 0;
    private double change = 0;
    private double voucherdb = 0;
    private OrderList[] cart;
    private Item item;
    private OrderList list;
    private Transaction transUpdate;
    private TransactionControl transControl;
    private MaintainOrderControl orderControl;
    Object[][] data;
    private OrderList[] updateOrder;
    private boolean isValid = false;
    private String memberDB = "";
    private String stf;

    public NewTransaction(ArrayList<OrderList> finalCart, String staff) {
        stf = staff;
        TransactionControl transControl2 = new TransactionControl();
        memberControl = new MaintainMemberControl();
        updateOrder = finalCart.toArray(new OrderList[finalCart.size()]);
        data = new Object[OrderList.getNumOfOrder()][5];
        int count = 1;
        cart = finalCart.toArray(new OrderList[finalCart.size()]);
        item = new Item();
        for (int i = 0; i < finalCart.size(); i++) {
            list = null;
            list = cart[i];
            item = list.getItem();
            data[i][0] = count + ".";
            data[i][1] = item.getItemName();
            data[i][2] = list.getQuantity() + "";
            data[i][3] = String.format("%.2f", item.getPrice()) + "";
            data[i][4] = String.format("%.2f", (item.getPrice() * list.getQuantity())) + "";
            count++;
            subTotal = subTotal + (item.getPrice() * list.getQuantity());
        }
        gst = subTotal * 0.06;
        jlbGSTI.setText(String.format("%.2f", gst) + "");
        jlbSubTotalI.setText(String.format("%.2f", subTotal) + "");
        JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(490, 390));
        table.setFillsViewportHeight(true);
        transIDString = transControl2.getAfterLastCode();
        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }
        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(223);
        table.getColumnModel().getColumn(2).setPreferredWidth(60);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);
        setLayout(new BorderLayout());
        jtaDeliveryAddress.setLineWrap(true);
        jtaDeliveryAddress.setWrapStyleWord(true);
        transID.setText(transIDString);
        jlbHeader.setSize(100, 100);
        header.add(jlbHeader);
        header.add(transID);
        rightPanel.add(header, BorderLayout.NORTH);
        body.add(jlbStaffID);
        jtfStaffID.setEditable(false);
        jtfStaffID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        jtfStaffID.setText(stf);
        body.add(jtfStaffID);
        body.add(jlbOrderType);
        body.add(jcbOrderType);
        body.add(jlbDeliveryAddress);
        body.add(jspDeliveryAddress);
        jtaDeliveryAddress.setBackground(Color.LIGHT_GRAY);
        jtaDeliveryAddress.setEditable(false);
        body.add(jlbPaymentType);
        body.add(jcbPaymentType);
        body.add(jlbCreditCardNo);
        body.add(jtfCreditCardNo);
        jtfCreditCardNo.setEditable(false);
        body.add(jlbIsMember);
        isMember.add(jrbIsMember);
        isMember.add(jrbIsNotMember);
        gp.add(jrbIsMember);
        gp.add(jrbIsNotMember);
        jrbIsNotMember.setSelected(true);
        body.add(isMember);
        body.add(memberID);
        body.add(jtfMemberID);
        jtfMemberID.setEditable(false);
        body.add(new JLabel());
        body.add(jbtValidateMem);
        body.add(jlbVoucher);
        body.add(jcbVoucher10);
        rightPanel.add(body, BorderLayout.CENTER);
        botPanel.add(jbtProceed);
        botPanel.add(jbtAddItem);
        jrbIsMember.addActionListener(new IsMemListener());
        jrbIsNotMember.addActionListener(new IsNotMemListener());
        jbtValidateMem.addActionListener(new ValidateMemListener());
        jcbOrderType.addItemListener(new OrderTypeListener());
        jcbPaymentType.addItemListener(new PaymentTypeListener());
        jbtProceed.addActionListener(new ProceedListener());
        jbtAddItem.addActionListener(new AddItemListener());
        rightPanel.add(botPanel, BorderLayout.SOUTH);
        leftPanel.add(tablePanel, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.CENTER);
        totalPanel.add(flowLayoutDiscount);
        flowLayoutDiscount.add(jlbTotalDiscount);
        flowLayoutDiscount.add(jlbTotalDiscountI);
        totalPanel.add(flowLayoutTax);
        flowLayoutTax.add(jlbGST);
        flowLayoutTax.add(jlbGSTI);
        totalPanel.add(flowLayoutSubTotal);
        flowLayoutSubTotal.add(jlbSubTotal);
        flowLayoutSubTotal.add(jlbSubTotalI);
        totalPanel.add(flowLayoutTotal);
        flowLayoutTotal.add(jlbGrandTotal);
        jlbGrandTotal.setFont(new Font("Arial", Font.BOLD, 20));
        flowLayoutTotal.add(jlbGrandTotalI);
        jlbGrandTotalI.setFont(new Font("Arial", Font.BOLD, 20));
        totalPanel.add(flowLayoutChanges);
        flowLayoutChanges.add(jlbChange);
        jlbChange.setFont(new Font("Arial", Font.BOLD, 20));
        flowLayoutChanges.add(jlbChangeI);
        jlbChangeI.setFont(new Font("Arial", Font.BOLD, 20));
        totalPanel.add(flowLayoutBalanceDue);
        flowLayoutBalanceDue.add(jlbBalanceDue);
        jlbBalanceDue.setForeground(Color.red);
        jlbBalanceDue.setFont(new Font("Arial", Font.BOLD, 20));
        flowLayoutBalanceDue.add(jlbBalanceDueI);
        jlbBalanceDueI.setFont(new Font("Arial", Font.BOLD, 20));
        jlbBalanceDueI.setForeground(Color.red);
        leftPanel.add(totalPanel, BorderLayout.SOUTH);
        add(rightPanel, BorderLayout.EAST);

    }

    public class IsMemListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (jrbIsMember.isSelected()) {
                jtfMemberID.setEditable(true);
            }
        }
    }

    public class IsNotMemListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (jrbIsNotMember.isSelected()) {
                jtfMemberID.setText("");
                jtfMemberID.setEditable(false);
            }
        }
    }

    public class OrderTypeListener implements ItemListener {

        public void itemStateChanged(ItemEvent e) {
            if (e.getItem() == orderType[2]) {
                jtaDeliveryAddress.setEditable(true);
                jtaDeliveryAddress.setBackground(Color.WHITE);
            } else {
                jtaDeliveryAddress.setText("");
                jtaDeliveryAddress.setEditable(false);
                jtaDeliveryAddress.setBackground(Color.LIGHT_GRAY);
            }
        }
    }

    public class PaymentTypeListener implements ItemListener {

        public void itemStateChanged(ItemEvent e) {
            if (e.getItem() == paymentType[1]) {
                jtfCreditCardNo.setEditable(true);
            } else {
                jtfCreditCardNo.setText("");
                jtfCreditCardNo.setEditable(false);
            }
        }
    }

    public class ValidateMemListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (isValid == false) {
                totalDiscount = 0;
                String mbrID = jtfMemberID.getText();
                Member member = memberControl.selectRecord(mbrID);
                if (member != null) {
                    if (JOptionPane.showConfirmDialog(null, "Member Name : " + member.getMemberName() + "\nContinue ?") == 0) {
                        totalDiscount = subTotal * 0.10;
                        jtfMemberID.setEditable(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No such Member.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
                }
                isValid = true;
            } else {
                JOptionPane.showMessageDialog(null, "Member ID aready validated.", "Member ID Valid", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public class ProceedListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            double amountPaid = 0;
            boolean exception = true;
            if (jrbIsNotMember.isSelected()) {
                memberDB = "M9000";
            } else {
                memberDB = jtfMemberID.getText();
            }
            if (jcbVoucher10.isSelected()) {
                totalDiscount = totalDiscount + 10;
            }
            jlbTotalDiscountI.setText(String.format("%.2f", totalDiscount) + "");
            grandTotal = subTotal - totalDiscount - gst;
            jlbGrandTotalI.setText(String.format("%.2f", grandTotal) + "");
            balanceDue = grandTotal;
            jlbBalanceDueI.setText(String.format("%.2f", balanceDue) + "");
            double balanceDue2 = 0;
            do {
                try {
                    do {
                        if (JOptionPane.showConfirmDialog(null, "Proceed to payment?", "Payment", JOptionPane.WARNING_MESSAGE) == 0) {
                            amountPaid = Double.parseDouble(JOptionPane.showInputDialog(null, "Amount Paid :", "Payment", JOptionPane.INFORMATION_MESSAGE));
                            balanceDue2 = balanceDue - amountPaid;
                            if (balanceDue2 <= 0) {
                                jlbBalanceDueI.setText("0.00");
                                change = amountPaid - balanceDue;
                                jlbChangeI.setText(String.format("%.2f", change) + "");
                                balanceDue = 0;
                            } else {
                                balanceDue = balanceDue2;
                                JOptionPane.showMessageDialog(null, "Insufficient Amount", "Payment", JOptionPane.ERROR_MESSAGE);
                            }
                            exception = false;
                        }

                    } while (balanceDue2 > 0);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Enter Only Integer!");
                    exception = true;
                }
            } while (exception == true);
            newTrans();
            MaintaiItemFrame newItemFrame = new MaintaiItemFrame(stf);
            ((Window) getRootPane().getParent()).dispose();
        }

    }

    public class AddItemListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            MaintaiItemFrame newItemFrame = new MaintaiItemFrame(stf);
            ((Window) getRootPane().getParent()).dispose();
        }
    }

    private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of data: ");
        for (int i = 0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j = 0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    public void newTrans() {
        transControl = new TransactionControl();
        transUpdate = new Transaction(list.getTransID(), jtfStaffID.getText(), jcbOrderType.getSelectedItem() + "", jtaDeliveryAddress.getText() + "0",
                jcbPaymentType.getSelectedItem().toString(), jtfCreditCardNo.getText() + "0",
                memberDB, new Timestamp(new Date().getTime()), totalDiscount, grandTotal, "PAID");
        transControl.addRecord(transUpdate);
        for (int i = 0; i < updateOrder.length; i++) {
            orderControl = new MaintainOrderControl();
            list = null;
            list = updateOrder[i];
            item = list.getItem();
            OrderList list2 = new OrderList(orderControl.getAfterLastCode(), transID.getText(), item, list.getQuantity());
            orderControl.addRecord(list2);
        }
        PrintWriter writer = null;
        try {
            //create a temporary file
            String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            writer = new PrintWriter("src\\Receipt\\" + list.getTransID() + "-" + timeLog + ".txt", "UTF-8");
            writer.printf("#" + list.getTransID() + "\n===========\n\n");
            writer.printf("%-3s %-50s %-5s %-11s %-12s \n", "No.", "Item Name", "Qty", "Price each", "Total");
            for (int i = 0; i < cart.length; i++) {
                writer.printf("%-3s %-50s %-5s %-11s %-12s \n", data[i][0] + "", data[i][1] + "", data[i][2] + "", data[i][3] + "", data[i][4]);
            }
            writer.printf("\nSub Total : RM " + String.format("%.2f", subTotal));
            writer.printf("\nDiscount : RM " + String.format("%.2f", totalDiscount));
            writer.printf("\nGst : RM " + String.format("%.2f", gst));
            writer.printf("\nGrand Total : RM " + String.format("%.2f", grandTotal));
            writer.printf("\nChange : RM " + String.format("%.2f", change));
            writer.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, "Payment Success =D");
    }
}
