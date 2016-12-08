/*
 Author Phang Chun Wai
 */
package ui;

import da.StaffTableModel;
import domain.Staff;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;
import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class StaffTable extends JFrame {

    private static String url = "jdbc:derby://localhost:1527/collegedb";
    private static String username = "nbuser";
    private static String password = "1234";
    private static String query = "SELECT * FROM STAFF";
    private JComboBox jcbSearch;
    private String stf;


    JTextField jtfSearch = new JTextField();
    

    private StaffTableModel tableModel;
    private JTable resultTable;
    private TableRowSorter<TableModel> sorter;
    private JScrollPane jcp = new JScrollPane();
    private JButton jbtRefresh = new JButton("Refresh");
    
    private JButton jbtBack = new JButton("<<Back");

    public StaffTable(Staff staff) {
        jcbSearch = new JComboBox(new Object[]{"Staff ID", "Staff Name", "Staff Position"});
        tableModel = new StaffTableModel();
        resultTable = new JTable(tableModel);
        jcbSearch.setBackground(Color.orange);
        jtfSearch.setBackground(Color.orange);
        
        stf = staff.getId();
        JPanel panelNorth = new JPanel(new GridLayout(2,2,0,10));
        panelNorth.add(new JLabel("Search by: "));
        panelNorth.add(jcbSearch);
        panelNorth.add(new JLabel("Enter your Search: "));
        panelNorth.add(jtfSearch);
        
        
        JPanel panelSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        resultTable.setBackground(Color.orange);
         jcp = new JScrollPane(resultTable);
         
         
        jtfSearch.addActionListener(new EnterButtonListener());
        
        panelSouth.setBackground(Color.red);
        panelNorth.setBackground(Color.red);
       
        
        add(panelNorth, BorderLayout.NORTH);
        add(jcp, BorderLayout.CENTER);
        panelSouth.add(jbtRefresh);
         panelSouth.add(jbtBack);
        
        add(panelSouth,BorderLayout.SOUTH);
        
        
        
        sorter = new TableRowSorter<TableModel>(tableModel);
        resultTable.setRowSorter(sorter);

        addWindowListener(new WindowCloseListener());
        jbtRefresh.addActionListener(new ResfreshButtonListener());
        jbtBack.addActionListener(new BackButtonListener());

        setTitle("Staff Table");
        setSize(1200, 530);
        setLocationRelativeTo(null);
        setVisible(true);
        setFocusableWindowState(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBackground(Color.RED);
        
    }

    private class WindowCloseListener extends WindowAdapter {

        @Override
        public void windowClosed(WindowEvent event) {
            tableModel.disconnectFromDatabase();
            System.exit(0);
        }
    }
    private class ResfreshButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
          tableModel.getAllRecords();
            }
        }
    
    private class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            try {
                setVisible(false);
                Staff staff = new Staff(stf);
                new MaintainStaff(staff).setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(StaffTable.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    
      
    

    private class EnterButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            switch (jcbSearch.getSelectedItem().toString()) {
                case "Staff ID":
                    tableModel.getRecordsByID(jtfSearch.getText());
                    jtfSearch.setText("");
                    break;
                case "Staff Name":
                    tableModel.getRecordsByName(jtfSearch.getText());
                    jtfSearch.setText("");
                    break;
                case "Staff Position":
                    tableModel.getRecordsByPosition(jtfSearch.getText());
                    jtfSearch.setText("");
                    break;
                default:
                    break;
            }
                

        }
    }
    

    public static void main(String[] args) {
//      StaffTable fra = new StaffTable();
//      fra.setTitle("Staff Table");
//      fra.setSize(1200, 530);
//      fra.setLocationRelativeTo(null);
//      fra.setVisible(true);
//      fra.setFocusableWindowState(true);
//      fra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}