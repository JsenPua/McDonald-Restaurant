package da;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.time.LocalDateTime;
import domain.Category;
import java.util.ArrayList;

/**
 *
 * @author HuiWen
 */
public class CategoryDA {

    private String host = "jdbc:derby://localhost:1527/mcddb";
    private String user = "root";
    private String password = "123456";
    private String tableName = "CATEGORY";
    private Connection conn;
    private PreparedStatement stmt;
    private String sqlQueryStr = "SELECT * from " + tableName;
    private ResultSet rs;

    public CategoryDA() {
        createConnection();
    }

    public ArrayList<Category> getCategories() {

        ArrayList<Category> categories = new ArrayList<Category>();
        try {
            if (conn != null) {
                stmt = conn.prepareStatement(sqlQueryStr);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    categories.add(getCurrentRecord());
                }
            }

        } catch (SQLException ex) {
            ex.getMessage();
        }

        return categories;
    }

    public Category getCurrentRecord() {
        Category category = null;
        try {
            category = new Category(rs.getString(1), rs.getString(2));
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return category;
    }

    public Category getRecord(String categoryID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE categoryID = ?  ORDER BY categoryID";
        Category category = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, categoryID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                category = new Category(rs.getString(1), rs.getString(2));
            } else {
                System.out.println(LocalDateTime.now() + " No such categoryID in database.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR  in database", JOptionPane.ERROR_MESSAGE);
        }
        return category;
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println(LocalDateTime.now() + " ***TRACE: Category Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ResultSet selectRecord(String categoryID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE categoryID = ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, categoryID);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in CategoryDA " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    public void updateRecord(Category c){
        try {
            String categoryID = c.getCategoryID();
            String category = c.getCategory();
            ResultSet rs = selectRecord(categoryID);
            if (rs.next()) {          
                stmt = conn.prepareStatement("UPDATE " + tableName + " SET CATEGORY =  ? WHERE  categoryID =  ?");
                stmt.setString(1, category);
                stmt.setString(2, categoryID);
                stmt.executeUpdate();
                System.out.println(LocalDateTime.now() + " " + categoryID + " is updated Successful in database.\n");
            } else {
                System.out.println(LocalDateTime.now() + " No such categoryyID in database.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in CategoryDa " + ex.getMessage(), "ERROR in database", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteRecord(String categoryID) {
        try {
            ResultSet rs = selectRecord(categoryID);
            if (rs.next()) {
                stmt = conn.prepareStatement("DELETE FROM " + tableName + " WHERE categoryID = ?");
                stmt.setString(1, categoryID);
                stmt.executeUpdate();
                System.out.println(LocalDateTime.now() + " " + categoryID + " is deleted Successful in database.\n");
            } else {
                System.out.println(LocalDateTime.now() + " No such categoryID in database.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in CategoryDa " + ex.getMessage(), "ERROR  in database", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new CategoryDA();
    }
}
