/*
 Author Swati
 */
package da;

import domain.Member;
import java.sql.*;
import javax.swing.*;

public class MemberDA {

    private String host = "jdbc:derby://localhost:1527/mcddb";
    private String user = "root";
    private String password = "123456";
    private String tableName = "membership";
    private Connection conn;
    private PreparedStatement stmt;

    public MemberDA() {
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

    public Member selectRecord(String mbrID) {
        String queryStr = " SELECT * FROM " + tableName + " WHERE MBRID = ? ";
        Member member = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, mbrID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                member = new Member(mbrID, rs.getString("memberName"), rs.getString("icNo"),
                        rs.getString("contactNo"), rs.getString("homeAddress"),
                        rs.getInt("loyaltyPoint"), rs.getDate("memStartDate"), rs.getDate("memEndDate"), rs.getString("mbrType"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return member;

    }

    public void addMember(Member mem) {
        String queryStr = "INSERT INTO " + tableName + " VALUES(?,  ?,  ?, ?, ?, ?,  ?, ?, ?)";
        Member member = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, mem.getMbrID());
            stmt.setString(2, mem.getMemberName());
            stmt.setString(3, mem.getIcNo());
            stmt.setString(4, mem.getContactNo());
            stmt.setString(5, mem.getHomeAddress());
            stmt.setInt(6, mem.getLoyaltyPoint());
            stmt.setDate(7, new java.sql.Date(mem.getMemStartDate().getTime()));
            stmt.setDate(8, new java.sql.Date(mem.getMemEndDate().getTime()));
            stmt.setString(9, mem.getMbrType());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateMember(Member mem) {
        String queryStr = " Update " + tableName
                + " set MemberName = ? , ICNo = ? , ContactNo = ? , HomeAddress = ? , LoyaltyPoint = ? , MemStartDate = ? , MemEndDate = ? , mbrType = ? where MBRID = ? ";
        Member member = null;
        try {
            stmt = conn.prepareStatement(queryStr);

            stmt.setString(1, mem.getMemberName());
            stmt.setString(2, mem.getIcNo());
            stmt.setString(3, mem.getContactNo());
            stmt.setString(4, mem.getHomeAddress());
            stmt.setInt(5, mem.getLoyaltyPoint());
            stmt.setDate(6, new java.sql.Date(mem.getMemStartDate().getTime()));
            stmt.setDate(7, new java.sql.Date(mem.getMemEndDate().getTime()));
            stmt.setString(8, mem.getMbrType());
            stmt.setString(9, mem.getMbrID());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void removeMember(Member mem) {
        String queryStr = "Delete from " + tableName + " where MBRID = ?";
        Member member = null;
        try {

            stmt = conn.prepareStatement(queryStr);

            stmt.setString(1, mem.getMbrID());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
   

    public static void main(String[] args) {
        MemberDA da = new MemberDA();
        Member member = da.selectRecord("");
        System.out.println(member);
    }

}
