/*
 Author Soo Xingliang
 */
package ui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import domain.*;

public class PaymentFormPanel extends JFrame {

    private JPanel mainPanel = new JPanel(new BorderLayout());
    private JPanel topGridLayout = new JPanel(new GridLayout(1, 4));
    private JPanel centerGridLayout = new JPanel();
    private NewTransaction newTransPanel;
    private RetrieveVoidTransaction newVoidPanel = new RetrieveVoidTransaction();
    private HistoryTransaction newHistoryPanel = new HistoryTransaction();
    private JButton jbtPayment = new JButton("Payment");
    private JButton jbtRetrieveVoid = new JButton("Retrieve");
    private JButton jbtHistory = new JButton("History");
    private String stf;

    public PaymentFormPanel() {
        jbtPayment.setFont(new Font("Arial", Font.BOLD, 30));
        jbtRetrieveVoid.setFont(new Font("Arial", Font.BOLD, 30));
        jbtHistory.setFont(new Font("Arial", Font.BOLD, 30));
        setLayout(new BorderLayout());
        topGridLayout.add(jbtPayment);
        topGridLayout.add(jbtRetrieveVoid);
        topGridLayout.add(jbtHistory);
        mainPanel.add(topGridLayout, BorderLayout.NORTH);
        mainPanel.add(centerGridLayout, BorderLayout.CENTER);
        centerGridLayout.setLayout(new BorderLayout());
        centerGridLayout.add(newHistoryPanel);
        mainPanel.add(new JLabel("  "), BorderLayout.WEST);
        mainPanel.add(new JLabel("  "), BorderLayout.EAST);
        add(mainPanel);
        jbtPayment.addActionListener(new DisableListener());
        jbtPayment.setBackground(Color.gray);
        jbtRetrieveVoid.addActionListener(new ButtonListener());
        jbtHistory.addActionListener(new ButtonListener());
        setSize(800, 605);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public PaymentFormPanel(String staff) {
        stf = staff;
        jbtPayment.setFont(new Font("Arial", Font.BOLD, 30));
        jbtRetrieveVoid.setFont(new Font("Arial", Font.BOLD, 30));
        jbtHistory.setFont(new Font("Arial", Font.BOLD, 30));
        setLayout(new BorderLayout());
        topGridLayout.add(jbtPayment);
        topGridLayout.add(jbtRetrieveVoid);
        topGridLayout.add(jbtHistory);
        mainPanel.add(topGridLayout, BorderLayout.NORTH);
        mainPanel.add(centerGridLayout, BorderLayout.CENTER);
        centerGridLayout.setLayout(new BorderLayout());
        centerGridLayout.add(newHistoryPanel);
        mainPanel.add(new JLabel("  "), BorderLayout.WEST);
        mainPanel.add(new JLabel("  "), BorderLayout.EAST);
        add(mainPanel);
        jbtPayment.addActionListener(new DisableListener());
        jbtPayment.setBackground(Color.gray);
        jbtRetrieveVoid.addActionListener(new ButtonListener());
        jbtHistory.addActionListener(new ButtonListener());
        setSize(800, 605);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public PaymentFormPanel(ArrayList<OrderList> finalCart, String staff) {
        stf = staff;
        newTransPanel = new NewTransaction(finalCart, stf);
        jbtPayment.setFont(new Font("Arial", Font.BOLD, 30));
        jbtRetrieveVoid.setFont(new Font("Arial", Font.BOLD, 30));
        jbtHistory.setFont(new Font("Arial", Font.BOLD, 30));
        setLayout(new BorderLayout());
        topGridLayout.add(jbtPayment);
        topGridLayout.add(jbtRetrieveVoid);
        topGridLayout.add(jbtHistory);
        mainPanel.add(topGridLayout, BorderLayout.NORTH);
        mainPanel.add(centerGridLayout, BorderLayout.CENTER);
        centerGridLayout.setLayout(new BorderLayout());
        centerGridLayout.add(newTransPanel);
        mainPanel.add(new JLabel("  "), BorderLayout.WEST);
        mainPanel.add(new JLabel("  "), BorderLayout.EAST);
        add(mainPanel);
        jbtPayment.addActionListener(new ButtonListener());
        jbtRetrieveVoid.addActionListener(new ButtonListener());
        jbtHistory.addActionListener(new ButtonListener());
        setSize(800, 615);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //Refresh all container for pMidInner
            centerGridLayout.removeAll();
            centerGridLayout.repaint();

            //Displaying inner panel GUI
            if (e.getSource() == jbtPayment) {
                centerGridLayout.setLayout(new BorderLayout());
                centerGridLayout.add(newTransPanel);
                mainPanel.add(centerGridLayout, BorderLayout.CENTER);
                add(mainPanel);
                setTitle("Payment");
                setSize(800, 616);
            } else if (e.getSource() == jbtRetrieveVoid) {
                centerGridLayout.setLayout(new BorderLayout());
                centerGridLayout.add(newVoidPanel);
                mainPanel.add(centerGridLayout, BorderLayout.CENTER);
                add(mainPanel);
                setTitle("Retrieve and Void");
                setSize(801, 615);
            } else if (e.getSource() == jbtHistory) {
                centerGridLayout.setLayout(new BorderLayout());
                centerGridLayout.add(newHistoryPanel);
                mainPanel.add(centerGridLayout, BorderLayout.CENTER);
                add(mainPanel);
                setTitle("Transaction History");
                setSize(800, 615);
            }

        }
    }

    private class DisableListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Please place order before proceed to payment.", "No Order Placed", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        PaymentFormPanel frame = new PaymentFormPanel();
    }

    public boolean opened() {
        return true;
    }

    public void ClosePanel() {
        this.dispose();
    }
}
