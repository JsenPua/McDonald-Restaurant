/*
 Author Swati
 */
package ui;
import da.RedeemItemTableModel;
import domain.Toys;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;
import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class RedeemItemTable extends JFrame{
    private static String url = "jdbc:derby://localhost:1527/collegedb";
    private static String username = "nbuser";
    private static String password = "1234";
    private static String query = "SELECT * FROM REDEEMITEM";
    private JComboBox jcbCriteria;


    JTextField jtf1 = new JTextField();
    JButton jbtBack = new JButton("Back to Redeem Menu");
    JLabel jlbSearchBy = new JLabel("Search By:");
    JLabel jlbEnterSearch = new JLabel("Enter your Search:");
    
    private RedeemItemTableModel tableModel;
    private JTable resultTable;
    private TableRowSorter<TableModel> sorter;

    public RedeemItemTable() {
        jcbCriteria = new JComboBox(new Object[]{"Redeem Item Code", "Redeem Item Name", "Redeem Item Points", "Redeem Item Stock"});
        tableModel = new RedeemItemTableModel();
        resultTable = new JTable(tableModel);

        JPanel panelNorth = new JPanel(new GridLayout(2,2,0,10));
        panelNorth.setBackground(Color.orange);
        panelNorth.add(jlbSearchBy);
        panelNorth.add(jcbCriteria);
        panelNorth.add(jlbEnterSearch);
        panelNorth.add(jtf1);
        
        JPanel panelSouth = new JPanel();
        panelSouth.setBackground(Color.orange);
        panelSouth.add(jbtBack);

        jtf1.addActionListener(new EnterButtonListener());
        jbtBack.addActionListener(new BackListener());
        add(panelNorth, BorderLayout.NORTH);
        add(new JScrollPane(resultTable), BorderLayout.CENTER);
        add(panelSouth, BorderLayout.SOUTH);
        sorter = new TableRowSorter<TableModel>(tableModel);
        resultTable.setRowSorter(sorter);

        addWindowListener(new WindowCloseListener());

        setTitle("Redeem Item Table");
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
            if (jcbCriteria.getSelectedItem().toString().equals("Redeem Item Code")) {
                tableModel.getRecordsByID(jtf1.getText());
                jtf1.setText("");
            } else if(jcbCriteria.getSelectedItem().toString().equals("Redeem Item Name")) {
                tableModel.retrieveByItemName(jtf1.getText());
                jtf1.setText("");
            }else if(jcbCriteria.getSelectedItem().toString().equals("Redeem Item Points")){
                tableModel.retrieveByItemPoints(Integer.parseInt(jtf1.getText()));
                jtf1.setText("");
            }else{
                tableModel.retrieveByItemStock(Integer.parseInt(jtf1.getText()));
                jtf1.setText("");
            }

        }
    }
    
    private class BackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new RedeemFrame().setVisible(true);
            setVisible(false);
            
        }
    }

    public static void main(String[] args) {
      RedeemItemTable fra = new RedeemItemTable();
      fra.setTitle("Redeem Item Table");
      fra.setSize(1200, 530);
      fra.setLocationRelativeTo(null);
      fra.setVisible(true);
      fra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
