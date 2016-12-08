package da;

import domain.Item;
import domain.OrderList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.time.LocalDateTime;

public class OrderDA {

    private String host = "jdbc:derby://localhost:1527/mcddb";
    private String user = "root";
    private String password = "123456";
    private String tableName = "ORDERLIST";
    private Connection conn;
    private PreparedStatement stmt;
    private String sqlStr;
    private ResultSet rs;

    public OrderDA() {
        createConnection();
    }

    public ResultSet selectRecord(String orderID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE ORDERID = ? ORDER BY ORDERID";
        rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, orderID);

            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in orderDA selectRecord():  " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    public OrderList getRecord(String orderID) {

        OrderList orderList = null;
        try {
            ResultSet rs = selectRecord(orderID);
            Item item = (new ItemDA()).getRecord(rs.getString(3));
            if (rs.next()) {
                orderList = new OrderList(orderID, rs.getString(2), item, rs.getInt(4));
            } else {
                System.out.println(LocalDateTime.now() + " No such OrderID in database.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in orderDA getRecord():  " + ex.getMessage(), "ERROR  in database", JOptionPane.ERROR_MESSAGE);
        }
        return orderList;
    }

    public void addRecord(OrderList o) {
        String s = "INSERT INTO " + tableName + " VALUES(?, ?, ?, ?)";
        String orderID = o.getOrderID();
        String transID = o.getTransID();
        String itemCode = o.getItem().getItemCode();
        int quantity = o.getQuantity();

        try {
            stmt = conn.prepareStatement(s);
            stmt.setString(1, orderID);
            stmt.setString(2, transID);
            stmt.setString(3, itemCode);
            stmt.setInt(4, quantity);
            stmt.executeUpdate();
            System.out.println(LocalDateTime.now() + " " + orderID + " is inserted Successful in database.\n");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in orderDA addRecord():  " + ex.getMessage(), "ERROR in database", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            sqlStr = "SELECT * FROM " + tableName + " ORDER BY ORDERID";
            stmt = conn.prepareStatement(sqlStr, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery();
            System.out.println(LocalDateTime.now() + " ***TRACE: Order Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in orderDA createConnection():  " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getAfterLastCode() {
        String orderID = "";
        int id;
        try {
            if (conn != null) {
                rs.last();
                orderID = rs.getString("ORDERID");
                id = Integer.parseInt(orderID.substring(1));
                id += 1;
                orderID = String.format("O%04d", id);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in OrderDA, getting last code: " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return orderID;
    }

    public void updateRecord(OrderList o) {
        try {
            String orderID = o.getOrderID();
            String transID = o.getTransID();
            String itemCode = o.getItem().getItemCode();
            int quantity = o.getQuantity();
            if (rs.next()) {
                stmt = conn.prepareStatement("UPDATE " + tableName + " SET transID =  ?,itemCode =  ?,quantity =  ? WHERE  orderID =  ?");
                stmt.setString(1, transID);
                stmt.setString(2, itemCode);
                stmt.setInt(3, quantity);
                stmt.setString(4, orderID);
                stmt.executeUpdate();
                System.out.println(LocalDateTime.now() + " " + orderID + " is updated Successful in database.\n");
            } else {
                System.out.println(LocalDateTime.now() + " No such orderID in database.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in orderDA " + ex.getMessage(), "ERROR in database", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteRecord(String orderID) {
        try {
            ResultSet rs = selectRecord(orderID);
            if (rs.next()) {
                stmt = conn.prepareStatement("DELETE FROM " + tableName + " WHERE orderID = ?");
                stmt.setString(1, orderID);
                stmt.executeUpdate();
                System.out.println(LocalDateTime.now() + " " + orderID + " is deleted Successful in database.\n");
            } else {
                System.out.println(LocalDateTime.now() + " No such orderID in database.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in orderDA " + ex.getMessage(), "ERROR  in database", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }

}
