/*
 Author Swati
 */
package ui;

import da.MemberTableModel;
import domain.Member;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;
import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class MemberTable extends JFrame {

    private static String url = "jdbc:derby://localhost:1527/collegedb";
    private static String username = "nbuser";
    private static String password = "1234";
    private static String query = "SELECT * FROM MEMBERSHIP";
    private JComboBox jcbCriteria;


    JTextField jtf1 = new JTextField();
    JButton jbtBack = new JButton("Back to Membership Main Menu");
    JLabel jlbSearchBy = new JLabel("Search By:");
    JLabel jlbEnterSearch = new JLabel("Enter your Search:");

    private MemberTableModel tableModel;
    private JTable resultTable;
    private TableRowSorter<TableModel> sorter;

    public MemberTable() {
        jcbCriteria = new JComboBox(new Object[]{"Member ID", "Member Name"});
        tableModel = new MemberTableModel();
        resultTable = new JTable(tableModel);
        jlbSearchBy.setForeground(Color.WHITE);
        jlbEnterSearch.setForeground(Color.WHITE);

        JPanel panelNorth = new JPanel(new GridLayout(2,2,0,10));
        panelNorth.setBackground(Color.RED);
        panelNorth.add(jlbSearchBy);
        panelNorth.add(jcbCriteria);
        panelNorth.add(jlbEnterSearch);
        panelNorth.add(jtf1);
        
        JPanel panelSouth = new JPanel();
        panelSouth.setBackground(Color.red);
        panelSouth.add(jbtBack);

        jtf1.addActionListener(new EnterButtonListener());
        jbtBack.addActionListener(new BackListener());
        add(panelNorth, BorderLayout.NORTH);
        add(new JScrollPane(resultTable), BorderLayout.CENTER);
        add(panelSouth, BorderLayout.SOUTH);
        sorter = new TableRowSorter<TableModel>(tableModel);
        resultTable.setRowSorter(sorter);

        addWindowListener(new WindowCloseListener());

        setTitle("Membership Table");
        setSize(1200, 530);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private class WindowCloseListener extends WindowAdapter {

        @Override
        public void windowClosed(WindowEvent event) {
            tableModel.disconnectFromDatabase();
            System.exit(0);
        }
    }

    private class EnterButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (jcbCriteria.getSelectedItem().toString().equals("Member ID")) {
                tableModel.getRecordsByID(jtf1.getText());
                jtf1.setText("");
            } else {
                tableModel.retrieveByMemName(jtf1.getText());
                jtf1.setText("");
            }

        }
    }
    
    private class BackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new MembershipMenu();
            setVisible(false);
            
        }
    }

    public static void main(String[] args) {
      MemberTable fra = new MemberTable();
      fra.setTitle("Membership Table");
      fra.setSize(1200, 530);
      fra.setLocationRelativeTo(null);
      fra.setVisible(true);
      fra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
