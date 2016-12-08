package ui;
/*Author: huiwen*/
import control.MaintainOrderControl;
import domain.Cart;
import domain.Item;
import domain.OrderList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ItemDescFrame extends JFrame {

    private JPanel jpWest = new JPanel(new GridLayout(6, 2));
    private JPanel jpSouth = new JPanel(new BorderLayout());
    private JPanel jpFlowSouth = new JPanel();
    private JLabel jblImg = new JLabel();
    private JButton jbtAddCart = new JButton("Add To Cart");
    private String[] statusList = new String[52];
    private JTextArea jtaDesc = new JTextArea(5, 30);
    private JComboBox jcboQuantity;
    private OrderList ord;
    private MaintainOrderControl orderControl;

    public ItemDescFrame(Item i, Cart cart) {
        int listIndex = 0;
        while (listIndex != 52) {
            statusList[listIndex] = listIndex + "";
            listIndex++;
        }
        jcboQuantity = new JComboBox(statusList);
        ImageIcon imgIconOri = i.getItemImg().getImage();
        Image image = imgIconOri.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon imgIcon = new ImageIcon(image);
        jblImg.setIcon(imgIcon);
        jtaDesc.setText(i.getDescription());
        jtaDesc.setLineWrap(true);
        jtaDesc.setWrapStyleWord(true);
        jtaDesc.setAutoscrolls(true);
        jtaDesc.setEditable(false);
        jtaDesc.setFocusable(false);
        jtaDesc.setBackground(Color.LIGHT_GRAY);
        JScrollPane scrollPane = new JScrollPane(jtaDesc);
        String name = i.getItemName();
        String labelName = name;
        if (name.length() > 10) {
            labelName = "";
            int k = 0;
            for (int j = 0; j < name.length(); j++) {
                k++;
                if (k > 12 && name.charAt(j) == ' ') {
                    labelName += name.charAt(j) + "<br />";
                    k = 0;
                } else {
                    labelName += name.charAt(j);
                }
            }
        }
        jpWest.add(new JLabel("Item Code"));
        jpWest.add(new JLabel(i.getItemCode()));
        jpWest.add(new JLabel("Item Name"));
        jpWest.add(new JLabel("<html>" + labelName + "</html>"));
        jpWest.add(new JLabel("Item Price"));
        jpWest.add(new JLabel(String.format("$%.02f", i.getPrice())));
        jpWest.add(new JLabel("Item Category"));
        jpWest.add(new JLabel(i.getCategory().getCategory()));
        jpWest.add(new JLabel("Item Status"));
        jpWest.add(new JLabel(i.getStatus()));

        jpWest.add(new JLabel("Item Description: "));
        jpSouth.add(scrollPane);

        if (i.getStatus().equals("Available")) {
            jpFlowSouth.add(jcboQuantity);
            jpFlowSouth.add(jbtAddCart);
            jpSouth.add(jpFlowSouth, BorderLayout.SOUTH);
        }

        jbtAddCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(jcboQuantity.getSelectedItem().toString());
                orderControl = new MaintainOrderControl();
                String orderID = orderControl.getAfterLastCode();
                ord = new OrderList(orderID, cart.getTransID(), i, quantity);
                setVisible(false);
                cart.insertItem(ord);

            }
        });
        jpWest.setPreferredSize(new Dimension(400, 100));
        add(jblImg, BorderLayout.EAST);
        add(jpWest, BorderLayout.WEST);
        add(jpSouth, BorderLayout.SOUTH);
        setVisible(true);
        setTitle(i.getItemName() + " Description");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static void main(String[] args) {

    }

}
