/*
 Author Swati
 */
package da;
import domain.Toys;
import domain.Member;
import domain.Redeem;
import java.sql.*;
import javax.swing.*;


public class RedeemDA {
    private String host = "jdbc:derby://localhost:1527/mcddb";
    private String user = "root";
    private String password = "123456";
    private String tableName = "redeem";
    private Connection conn;
    private PreparedStatement stmt;

    public RedeemDA() {
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

    public Redeem selectRecord(String RCODE) {
        String queryStr = " SELECT * FROM " + tableName + " WHERE RCODE = ? ";
        Redeem redeem = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, RCODE);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Toys redItem = (new RedeemItemDA()).selectRecord(rs.getString(3));
                Member member = (new MemberDA().selectRecord(rs.getString(2)));
                redeem = new Redeem(RCODE,member,redItem);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return redeem;

    }
    

    public void addRedeem(Redeem red) {
        String queryStr = "INSERT INTO " + tableName + " VALUES(?,  ?,  ?)";
        Redeem redeem = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, red.getrCode());
            stmt.setObject(2, red.getMember().getMbrID());
            stmt.setObject(3, red.getRedeemItem().getRdiCode());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

   

    public static void main(String[] args) {
        RedeemDA da = new RedeemDA();
        Redeem redeem = da.selectRecord("");
        System.out.println(redeem);
    }

}
