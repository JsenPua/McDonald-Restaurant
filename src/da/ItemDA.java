package da;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.time.LocalDateTime;
import domain.Item;
import domain.Category;
import domain.ItemImg;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author HuiWen
 */
public class ItemDA {

    private String host = "jdbc:derby://localhost:1527/mcddb";
    private String user = "root";
    private String password = "123456";
    private String tableName = "ITEM";
    private Connection conn;
    private PreparedStatement stmt;
    private String sqlStr;
    private ResultSet rs;

    public ItemDA() {
        createConnection();
    }

    public ArrayList<Item> getItems() {

        ArrayList<Item> items = new ArrayList<Item>();
        sqlStr = "SELECT * from " + tableName + " ORDER BY ITEMCODE";
        try {
            if (conn != null) {
                stmt = conn.prepareStatement(sqlStr);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    items.add(getCurrentRecord());
                }
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return items;
    }

    public Item getCurrentRecord() {
        Item item = null;
        try {
            Category category = (new CategoryDA()).getRecord(rs.getString(4));
            Blob blob = rs.getBlob(6);
            ItemImg itemPhoto = new ItemImg(new ImageIcon(blob.getBytes(1, (int) blob.length())));
            item = new Item(rs.getString(1), rs.getString(2), rs.getDouble(3), category, rs.getString(5), itemPhoto, rs.getString(7));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in ItemDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return item;
    }

    public ResultSet selectRecord(String itemCode) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE itemCode = ? ORDER BY ITEMCODE";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, itemCode);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in ItemDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    public void addRecord(Item i) throws IOException {
        String s = "INSERT INTO " + tableName + " VALUES(?, ?, ?, ?, ?, ?, ?)";
        String itemCode = i.getItemCode();
        String itemName = i.getItemName();
        Double price = i.getPrice();
        String categoryID = i.getCategory().getCategoryID();
        String description = i.getDescription();
        URL url = i.getItemImg().getUrl();
        InputStream inputImage = url.openStream();
        String status = i.getStatus();
        try {
            stmt = conn.prepareStatement(s);
            stmt.setString(1, itemCode);
            stmt.setString(2, itemName);
            stmt.setDouble(3, price);
            stmt.setString(4, categoryID);
            stmt.setString(5, description);
            stmt.setBinaryStream(6, inputImage, (int) (inputImage.available()));
            stmt.setString(7, status);
            stmt.executeUpdate();
            System.out.println(LocalDateTime.now() + " " + itemCode + " is inserted Successful in database.\n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in ItemDa " + ex.getMessage(), "ERROR in database", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Item getRecord(String itemCode) {

        Item item = null;
        try {
            ResultSet rs = selectRecord(itemCode);
            if (rs.next()) {
                Blob blob = rs.getBlob(6);
                ItemImg itemPhoto = new ItemImg(new ImageIcon(blob.getBytes(1, (int) blob.length())));
                Category category = (new CategoryDA()).getRecord(rs.getString(4));
                item = new Item(itemCode, rs.getString(2), rs.getDouble(3), category, rs.getString(5), itemPhoto, rs.getString(7));
            } else {
                System.out.println(LocalDateTime.now() + " No such item code in database.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in ItemDa " + ex.getMessage(), "ERROR  in database", JOptionPane.ERROR_MESSAGE);
        }
        return item;
    }

    public String displayRecord(char command) {
        String itemcode = "";
        try {
            if (command == 'L') {
                if (rs.isFirst() || rs.isBeforeFirst()) {
                    JOptionPane.showMessageDialog(null, "This is the first record! Last record will be displayed.");
                    rs.last();
                } else {
                    rs.previous();
                }
            } else if (command == 'R') {
                if (rs.isLast()) {
                    JOptionPane.showMessageDialog(null, "This is the last record! First record will be displayed.");
                    rs.first();
                } else {
                    rs.next();
                }
            }
            itemcode = rs.getString("itemCode");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in ItemDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return itemcode;
    }

    public void updateRecord(Item i) throws IOException {
        try {
            String itemCode = i.getItemCode();
            String itemName = i.getItemName();
            Double price = i.getPrice();
            String categoryID = i.getCategory().getCategoryID();
            String description = i.getDescription();
            InputStream inputImage = null;
            String status = i.getStatus();
            boolean hasImage = false;
            Blob blob = null;
            ResultSet rs = selectRecord(itemCode);

            if (rs.next()) {
                try {
                    URL url = i.getItemImg().getUrl();
                    inputImage = url.openStream();
                    hasImage = true;
                } catch (NullPointerException ex) {
                    blob = rs.getBlob(6);
                }
                stmt = conn.prepareStatement("UPDATE " + tableName + " SET ITEMNAME =  ?, PRICE =  ?,CATEGORYID =  ?, DESCRIPTION =  ?,IMAGE =  ?, STATUS =  ? WHERE  ITEMCODE =  ?");
                stmt.setString(1, itemName);
                stmt.setDouble(2, price);
                stmt.setString(3, categoryID);
                stmt.setString(4, description);
                if (hasImage) {
                    stmt.setBinaryStream(5, inputImage, (int) (inputImage.available()));
                } else {
                    stmt.setBlob(5, blob);

                }
                stmt.setString(6, status);
                stmt.setString(7, itemCode);
                stmt.executeUpdate();
                System.out.println(LocalDateTime.now() + " " + itemCode + " is updated Successful in database.\n");
            } else {
                System.out.println(LocalDateTime.now() + " No such item code in database.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in ItemDa " + ex.getMessage(), "ERROR in database", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteRecord(Item i) {
        try {
            String itemCode = i.getItemCode();
            ResultSet rs = selectRecord(itemCode);
            if (rs.next()) {
                stmt = conn.prepareStatement("DELETE FROM " + tableName + " WHERE itemCode = ?");
                stmt.setString(1, itemCode);
                stmt.executeUpdate();
                System.out.println(LocalDateTime.now() + " " + itemCode + " is deleted Successful in database.\n");
            } else {
                System.out.println(LocalDateTime.now() + " No such item code in database.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in ItemDa " + ex.getMessage(), "ERROR  in database", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            sqlStr = "SELECT * FROM " + tableName + " ORDER BY ITEMCODE";
            stmt = conn.prepareStatement(sqlStr, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery();
            System.out.println(LocalDateTime.now() + " ***TRACE: Item Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in ItemDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {

    }
}
