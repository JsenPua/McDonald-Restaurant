/*
 Author Phang Chun Wai
 */
package da;

import domain.Staff;
import domain.Icon;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.*;

public class StaffDA {

    private final String host = "jdbc:derby://localhost:1527/mcddb";
    private final String user = "root";
    private final String password = "123456";
    private final String tableName = "STAFF";
    private Connection conn;
    private PreparedStatement stmt;

    public StaffDA() {
        createConnection();
    }

    public ResultSet selectRecord(String id) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE STAFFID = ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in StaffDa " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    public Staff getRecord(String ID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE STAFFID = ?";
        Staff staff = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Blob blob = rs.getBlob(9);
                Icon imageIcon = new Icon(new ImageIcon(blob.getBytes(1, (int) blob.length())));
                double salary = Double.parseDouble(rs.getString("SALARY"));
                staff = new Staff(ID, rs.getString("STAFFIC"), rs.getString("STAFFNAME"), rs.getString("PASSWORD"),
                        rs.getString("CONTACTNO"), rs.getString("ADDRESS"), rs.getString("POSITION"), salary, imageIcon);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return staff;
    }

    public void addRecord(Staff s) {
        String queryStr = "INSERT INTO " + tableName + " VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
       
        try {
            
            ResultSet rs = selectRecord(s.getId());
            if(!rs.next()){
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, s.getId());
            stmt.setString(2, s.getIc());
            stmt.setString(3, s.getName());
            stmt.setString(4, s.getPassword());
            stmt.setString(5, s.getContactNo());
            stmt.setString(6, s.getAddress());
            stmt.setString(7, s.getPositon());
            stmt.setString(8, "" + s.getSalary());
            URL url = s.getIcon().getUrl();
            InputStream inputImage = url.openStream();
            stmt.setBinaryStream(9, inputImage, (int) (inputImage.available()));

            stmt.executeUpdate();
            }
            
        } catch (SQLException ex) {
            ex.getMessage();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    public void updateRecord(Staff s) throws SQLException, IOException {
        String queryStr = "Update " + tableName + " set STAFFIC = ? , STAFFNAME = ? , PASSWORD = ? , CONTACTNO = ? , ADDRESS = ? , POSITION = ? , SALARY = ? , ICON = ? WHERE STAFFID = ?";
        
        try {
            InputStream inputImage = null;
            boolean hasImage = false;
            Blob blob = null;
            ResultSet rs = selectRecord(s.getId());

            if (rs.next()) {
                try {
                    URL url = s.getIcon().getUrl();
                    inputImage = url.openStream();
                    hasImage = true;
                } catch (NullPointerException ex) {
                    blob = rs.getBlob(9);
                }

                stmt = conn.prepareStatement(queryStr);

                stmt.setString(1, s.getIc());
                stmt.setString(2, s.getName());
                stmt.setString(3, s.getPassword());
                stmt.setString(4, s.getContactNo());
                stmt.setString(5, s.getAddress());
                stmt.setString(6, s.getPositon());
                stmt.setString(7, "" + s.getSalary());
                if (hasImage) {
                    stmt.setBinaryStream(8, inputImage, (int) (inputImage.available()));
                } else {
                    stmt.setBlob(8, blob);

                }

                stmt.setString(9, s.getId());

                stmt.executeUpdate();

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in StaffDa " + ex.getMessage(), "ERROR in database", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void deleteRecord(Staff s) {
        String queryStr = "DELETE FROM " + tableName + " WHERE STAFFID = ?";
       
        try {
            ResultSet rs = selectRecord(s.getId());
            if(rs.next()){
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, s.getId());
            stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
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

    public static void main(String[] args) {
        StaffDA staffDA = new StaffDA();
        Staff staff = staffDA.getRecord("S001");
        System.out.println(staff);
    }
}
