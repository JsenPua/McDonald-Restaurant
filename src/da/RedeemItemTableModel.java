/*
 Author Swati
 */
package da;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.AbstractTableModel;

public class RedeemItemTableModel extends AbstractTableModel{
  private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private ResultSetMetaData metaData;
    private int numberOfRows;
    private boolean connectedToDatabase = false;
    private String host = "jdbc:derby://localhost:1527/mcddb";
    private String user = "root";
    private String password = "123456";
    private String query = "SELECT * FROM REDEEMITEM";

    public RedeemItemTableModel(){
             
        try {
            conn = DriverManager.getConnection(host, user, password);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            connectedToDatabase = true;
            setQuery(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        getAllRecords();
    }
    
     public Class getColumnClass(int column) throws IllegalStateException {
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        try {
            String className = metaData.getColumnClassName(column + 1);
            return Class.forName(className);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Object.class;
    }
    

    public int getColumnCount() {
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        try {
            return metaData.getColumnCount();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public String getColumnName(int column) throws IllegalStateException {
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        try {
            return metaData.getColumnName(column + 1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    @Override
    public int getRowCount() {
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        return numberOfRows;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
            throws IllegalStateException {
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        try {
            rs.absolute(rowIndex + 1);
            return rs.getObject(columnIndex + 1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public void setQuery(String query)
            throws IllegalStateException, SQLException {
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        rs = stmt.executeQuery(query);
        metaData = rs.getMetaData();

        // determine number of rows in ResultSet
        rs.last();                      // move to last row
        numberOfRows = rs.getRow();     // get row number

        // notify JTable that model has changed
        fireTableStructureChanged();
    }

    public void disconnectFromDatabase() {
        if (connectedToDatabase) {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                connectedToDatabase = false;
            }
        }
    }
    
    public void getAllRecords(){
       try{
           String query = "Select * from REDEEMITEM";
           rs = stmt.executeQuery(query);
           metaData = rs.getMetaData();
           
           rs.last();
           numberOfRows = rs.getRow();
           
           fireTableStructureChanged();
       }catch(Exception ex){
           ex.printStackTrace();
       }
    }
    
     public void getRecordsByID(String ID) {
        try{
           String query = "Select * from REDEEMITEM WHERE RDICODE = '"+ID+"'";
           rs = stmt.executeQuery(query);
           metaData = rs.getMetaData();
           rs.last();
           numberOfRows = rs.getRow();
           
           fireTableStructureChanged();
       }catch(Exception ex){
           ex.printStackTrace();
       }
            
        
    }
     
     public void retrieveByItemName (String name) {
         try{
        rs = stmt.executeQuery("select * from REDEEMITEM WHERE RDINAME = '" + name + "'");

        metaData = rs.getMetaData();
        rs.last();                      // move to last row
        numberOfRows = rs.getRow();     // get row number
        
        // notify JTable that model has changed
        fireTableStructureChanged(); 
         }catch(Exception ex){
           ex.printStackTrace();
       }
    }
     
   public void retrieveByItemPoints (int points) {
         try{
        rs = stmt.executeQuery("select * from REDEEMITEM WHERE POINT = " + points + "");

        metaData = rs.getMetaData();
        rs.last();                      // move to last row
        numberOfRows = rs.getRow();     // get row number
        
        // notify JTable that model has changed
        fireTableStructureChanged(); 
         }catch(Exception ex){
           ex.printStackTrace();
       }
    }
   
   public void retrieveByItemStock (int stock) {
         try{
        rs = stmt.executeQuery("select * from REDEEMITEM WHERE STOCKCOUNT = " + stock + "");

        metaData = rs.getMetaData();
        rs.last();                      // move to last row
        numberOfRows = rs.getRow();     // get row number
        
        // notify JTable that model has changed
        fireTableStructureChanged(); 
         }catch(Exception ex){
           ex.printStackTrace();
       }
    }

}

