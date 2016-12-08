/*
 Author Soo Xingliang
 */
package da;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.time.LocalDateTime;
import domain.Transaction;
import java.util.ArrayList;
import java.sql.*;

public class TransactionDA {

    private String host = "jdbc:derby://localhost:1527/mcddb";
    private String user = "root";
    private String password = "123456";
    private String tableName = "TRANS";
    private Connection conn;
    private PreparedStatement stmt;
    private String sqlStr;
    private ResultSet rs;

    public TransactionDA() {
        createConnection();
    }

    public ResultSet selectRecord(String transID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE TRANSID = ? ORDER BY TRANSID";
        rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, transID);

            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    public Transaction getRecord(String transID) {

        Transaction transaction = null;
        try {
            ResultSet rs = selectRecord(transID);
            if (rs.next()) {
                transaction = new Transaction(transID, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getTimestamp(8), rs.getDouble(9), rs.getDouble(10), rs.getString(11));
            } else {
                System.out.println(LocalDateTime.now() + " No such Transaction ID in database.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR  in database", JOptionPane.ERROR_MESSAGE);
        }
        return transaction;
    }

    public void addRecord(Transaction t) {
        String s = "INSERT INTO " + tableName + " VALUES(?, ?, ?, ?, ?, ?, ?,?,?,?,?)";
        String transID = t.getTransID();
        String staffID = t.getStaffID();
        String orderType = t.getOrderType();
        String deliveryAddress = t.getDeliveryAddress();
        String paymentType = t.getPaymentType();
        String ccNo = t.getCcNo();
        String memberID = t.getMemberID();
        Timestamp transTime = t.getTransTime();
        double voucherValue = t.getVoucherValue();
        double total = t.getTotal();
        String status = t.getStatus();
        try {
            stmt = conn.prepareStatement(s);
            stmt.setString(1, transID);
            stmt.setString(2, staffID);
            stmt.setString(3, orderType);
            stmt.setString(4, deliveryAddress);
            stmt.setString(5, paymentType);
            stmt.setString(6, ccNo);
            stmt.setString(7, memberID);
            stmt.setTimestamp(8, transTime);
            stmt.setDouble(9, voucherValue);
            stmt.setDouble(10, total);
            stmt.setString(11, status);
            stmt.executeUpdate();
            System.out.println(LocalDateTime.now() + " " + transID + " is inserted Successful in database.\n");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR in database", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void voidRecord(String transID) {

        try {
            ResultSet rs = selectRecord(transID);
            if (rs.next()) {
                stmt = conn.prepareStatement("UPDATE " + tableName + " SET STATUS =  'VOID' WHERE TRANSID = ?");
                stmt.setString(1, transID);
                stmt.executeUpdate();
                System.out.println(LocalDateTime.now() + " " + transID + " is Void Successful in database.\n");
                JOptionPane.showMessageDialog(null, LocalDateTime.now() + transID + " is successfuly VOID in database.\n", "DATABASE UPDATE successfully", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println(LocalDateTime.now() + " No such Transaction ID in database.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR in database", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            sqlStr = "SELECT * FROM " + tableName + " ORDER BY TRANSID";
            stmt = conn.prepareStatement(sqlStr, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery();
            System.out.println(LocalDateTime.now() + " ***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getAfterLastCode() {
        String transID = "";
        int id;
        try {
            if(conn!=null){
                 rs.last();
            transID = rs.getString("TRANSID");
            id = Integer.parseInt(transID.substring(1));
            id += 1;
            transID = String.format("T%04d", id);
            }
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in getting last code: " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return transID;
    }
}
