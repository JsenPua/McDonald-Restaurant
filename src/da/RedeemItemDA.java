/*
 Author Swati
 */
package da;
import domain.Toys;
import java.sql.*;
import javax.swing.*;

public class RedeemItemDA {

    private String host = "jdbc:derby://localhost:1527/mcddb";
    private String user = "root";
    private String password = "123456";
    private String tableName = "redeemitem";
    private Connection conn;
    private PreparedStatement stmt;

    public RedeemItemDA() {
        createConnection();
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void shutDown() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public Toys selectRecord(String RDICODE) {
        String queryStr = " SELECT * FROM " + tableName + " WHERE RDICODE = ? ";
        Toys redeemitem = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, RDICODE);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                redeemitem = new Toys(RDICODE, rs.getString("RDINAME"), rs.getInt("POINT"),rs.getInt("STOCKCOUNT"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return redeemitem;

    }
    
    public Toys selectRecord2(String NAME) {
        String queryStr = " SELECT * FROM " + tableName + " WHERE RDINAME = ? ";
        Toys redeemitem = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, NAME);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                redeemitem = new Toys(rs.getString("RDICODE"), NAME, rs.getInt("POINT"),rs.getInt("STOCKCOUNT"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return redeemitem;

    }
    
    

    public void addItemRedeem(Toys redItem) {
        String queryStr = "INSERT INTO " + tableName + " VALUES(?,  ?,  ?, ?)";
        Toys redeemitem = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, redItem.getRdiCode());
            stmt.setString(2, redItem.getRdiName());
            stmt.setInt(3, redItem.getPoints());
            stmt.setInt(4, redItem.getStockCount());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateItemRedeem(Toys redItem) {
        String queryStr = " Update " + tableName
                + " set RDINAME = ? , POINT = ? , STOCKCOUNT = ? where RDICODE= ? ";
        Toys redeemitem = null;
        try {
            stmt = conn.prepareStatement(queryStr);

            
            stmt.setString(1, redItem.getRdiName());
            stmt.setInt(2, redItem.getPoints());
            stmt.setInt(3, redItem.getStockCount());
            stmt.setString(4, redItem.getRdiCode());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void RemoveItemRedeem(Toys redItem) {
        String queryStr = "Delete from " + tableName + " where RDICODE = ?";
        Toys redeemitem = null;
        try {

            stmt = conn.prepareStatement(queryStr);

            stmt.setString(1, redItem.getRdiCode());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
   

    public static void main(String[] args) {
        RedeemItemDA da = new RedeemItemDA();
        Toys redeemitem = da.selectRecord("");
        System.out.println(redeemitem);
    }

}
