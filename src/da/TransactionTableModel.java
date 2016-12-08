/*
 Author Soo Xingliang
 */
package da;
import java.sql.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class TransactionTableModel extends AbstractTableModel{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private ResultSetMetaData metaData;
    private int numberOfRows;
    static final String DATABASE_URL = "jdbc:derby://localhost:1527/mcddb";
    static final String USERNAME = "root";
    static final String PASSWORD = "123456";
    String queryTrans = "SELECT * FROM TRANS";
    public TransactionTableModel() throws SQLException {
        conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_READ_ONLY);
        retrieveAll(queryTrans);
    }

    public Class getColumnClass(int column) throws IllegalStateException {


        try {
            String className = metaData.getColumnClassName(column + 1);
            return Class.forName(className);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Object.class;
    }

    @Override
    public int getColumnCount() {


        try {
            return metaData.getColumnCount();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public String getColumnName(int column) throws IllegalStateException {

        try {
            return metaData.getColumnName(column + 1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    @Override
    public int getRowCount() {


        return numberOfRows;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
            throws IllegalStateException {


        try {
            rs.absolute(rowIndex + 1);
            return rs.getObject(columnIndex + 1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public void retrieveAll(String query) throws SQLException {
        rs = stmt.executeQuery(query);
        metaData = rs.getMetaData();

        // determine number of rows in ResultSet
        rs.last();                      // move to last row
        numberOfRows = rs.getRow();     // get row number
        
        // notify JTable that model has changed
        fireTableStructureChanged();    
    }
    
    public void retrieveByTransID (String transID) throws SQLException{
        rs = stmt.executeQuery("SELECT * FROM TRANS WHERE TRANSID = '" +transID+ "'");

        metaData = rs.getMetaData();
        rs.last();                      // move to last row
        numberOfRows = rs.getRow();     // get row number
        
        // notify JTable that model has changed
        fireTableStructureChanged();  
    }
public void retrieveByStaffID (String staffID) throws SQLException{
       rs = stmt.executeQuery("SELECT * FROM TRANS WHERE STAFFID = '" +staffID+ "'");

        metaData = rs.getMetaData();
        rs.last();                      // move to last row
        numberOfRows = rs.getRow();     // get row number
        
        // notify JTable that model has changed
        fireTableStructureChanged();  
    }
    
    public void retrieveByMemberID (String mbrID) throws SQLException{
         rs = stmt.executeQuery("SELECT * FROM TRANS WHERE MBRID = '" +mbrID+ "'");
        
        metaData = rs.getMetaData();
        rs.last();                      // move to last row
        numberOfRows = rs.getRow();     // get row number
        
        // notify JTable that model has changed
        fireTableStructureChanged();  
    }

    public static void main(String args[]) throws SQLException{
        JFrame frame = new JFrame();
        frame.add(new JTable(new TransactionTableModel()));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
       
        
    
    }

}
