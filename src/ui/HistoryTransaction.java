/*
 Author Soo Xingliang
 */
package ui;

import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import da.*;
import domain.*;
import control.*;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class HistoryTransaction extends JPanel{
    
    private TransactionTableModel tableModel;
    private JTextField queryField;
    private TableRowSorter<TableModel> sorter;
    private JButton submitButton = new JButton("Search");
    private JTable resultTable; 
    private JComboBox jcbo;

    public HistoryTransaction() {
        try {
            jcbo = new JComboBox(new Object[]{"Transaction ID", "Staff ID", "Member ID"});

            setLayout(new BorderLayout());
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            
            tableModel = new TransactionTableModel();
           
            queryField = new JTextField("");
            
            resultTable = new JTable(tableModel);
                       
            JScrollPane scrollPane = new JScrollPane(queryField,
                    ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

            // create Box to manage placement of queryArea and submitButton in GUI
            
            Box boxNorth = Box.createHorizontalBox();
            boxNorth.add(new JLabel("Search Criteria:  "));
            boxNorth.add(jcbo);
            boxNorth.setBorder(BorderFactory.createEmptyBorder(2, 10, 5, 10));
            
            
            Box boxCenter = Box.createHorizontalBox();
            boxCenter.add(scrollPane);
            boxCenter.add(submitButton);
            boxCenter.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            
            
            add(boxNorth, BorderLayout.NORTH);
            add(boxCenter, BorderLayout.CENTER);
            add(new JScrollPane(resultTable), BorderLayout.SOUTH);
            

            submitButton.addActionListener(new SubmitButtonListener());

            sorter = new TableRowSorter<TableModel>(tableModel);
            resultTable.setRowSorter(sorter);
      
            setVisible(true);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            //tableModel.disconnectFromDatabase();
            System.exit(1);
        }
    }

    private class SubmitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                
                if(jcbo.getSelectedItem().toString().equals("Transaction ID")){
                        tableModel.retrieveByTransID(queryField.getText());
                        queryField.setText("");
                }else if(jcbo.getSelectedItem().toString().equals("Staff ID")){
                        tableModel.retrieveByStaffID(queryField.getText());
                        queryField.setText("");
                }
                else{
                        tableModel.retrieveByMemberID(queryField.getText());
                        queryField.setText("");                
                }
                
                
                //tableModel.retrieveByMemID(queryArea.getText());
                System.out.println("***TRACE: in SubmitButtonListener");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);

                
            }
        }
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame ();
        frame.add(new HistoryTransaction());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }
}
