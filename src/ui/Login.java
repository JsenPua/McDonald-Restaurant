/*
 Author Phang Chun Wai
 */
package ui;

import control.MaintainStaffControl;
import domain.Staff;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Login extends JFrame {

    private MaintainStaffControl stfControl;
    private JTextField jtfId = new JTextField();
    private JPasswordField jpfPassword = new JPasswordField();
    private JLabel jtlHeading = new JLabel("STAFF LOGIN");
    private JLabel jtlHelp = new JLabel("<html><u>Help</u><html>");
    private JPanel panelSN = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    private JPanel panelC = new JPanel(new GridLayout(2, 2, 10, 10));
    private JPanel panelS = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    private JPanel panelN = new JPanel(new GridLayout(1, 3));

    private JButton jtbLogin = new JButton("Sign in");
    int count = 0;
    public Login() {
       
        stfControl = new MaintainStaffControl();
        jtfId.setForeground(Color.WHITE);
        jtfId.setBackground(Color.RED);
        jpfPassword.setBorder(null);
        jtfId.setBorder(null);
        jpfPassword.setForeground(Color.WHITE);
        jpfPassword.setBackground(Color.RED);
        panelS.setBackground(Color.orange);
        panelN.setBackground(Color.orange);
        panelSN.setBackground(Color.orange);

        panelC.setBackground(Color.orange);

        panelSN.add(jtlHelp);

        jpfPassword.setEchoChar('*');

        jtlHelp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jtlHelp.setFont(new Font("Times New Roman", Font.TYPE1_FONT, 10));

        jtbLogin.setBackground(Color.red);
        jtbLogin.setForeground(Color.WHITE);

        jtlHeading.setFont(new Font("Times New Roman", Font.ITALIC, 20));

        panelN.add(new JLabel(""));
        panelN.add(jtlHeading);
        panelN.add(panelSN);
        panelC.add(new JLabel("User ID"));
        panelC.add(jtfId);
        panelC.add(new JLabel("Password"));
        panelC.add(jpfPassword);
        panelS.add(jtbLogin);

        add(panelN, BorderLayout.NORTH);
        add(panelC, BorderLayout.CENTER);
        add(panelS, BorderLayout.SOUTH);

        jtlHelp.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Enter your staff ID \nEg User ID :1234\nEnter your current password\nEg Password :****", "Help", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        jtbLogin.addActionListener(new SignInListener());
        
        setTitle("LOGIN");
        setSize(400, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
                setResizable(false);

        
    }

    private class SignInListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String id = jtfId.getText();
            Staff stf = stfControl.selectRecord(id);

            if (stf != null && jpfPassword.getText().equals(stf.getPassword())) {
                JOptionPane.showMessageDialog(null, "WELCOME TO McDonald's!!");
                dispose();

                Staff staff = new Staff(jtfId.getText());
                
                 Main frame = new Main(staff);
                
                 
                count =0;
               

            } else {
                JOptionPane.showMessageDialog(null, "Invalid user ID or password", "STAFF NOT FOUND", JOptionPane.ERROR_MESSAGE);
                jpfPassword.setText("");
                warning();
            }
        }
    }

    public void warning() {
        
        count++;
        if (count == 3) {
            JOptionPane.showMessageDialog(null, "You're not an authorised user", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Login login = new Login();
        login.setTitle("LOGIN");
        login.setSize(400, 200);
        login.setVisible(true);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setLocationRelativeTo(null);
        login.setResizable(false);

    }

}

