/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
/*Author: huiwen*/
import control.MaintainCategoryControl;
import control.MaintainItemControl;
import domain.Cart;

import domain.Category;
import domain.Item;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class displayItemPanel extends JPanel {
    private DefaultComboBoxModel categoryList = new DefaultComboBoxModel();
    private JComboBox jcboCategory = new JComboBox(categoryList);
    private MaintainCategoryControl categoryControl;
    private ArrayList<Category> categories;
    private ArrayList<Item> items;
    private MaintainItemControl itemControl;
    private JPanel jpAbove = new JPanel();
    private JPanel jpBelow = new JPanel();
    private JButton[] jbtItems;
    private JButton[] jbtItems2;
    private JFrame itemDesc = new JFrame();
    private Cart cart;

    public displayItemPanel(Cart cart) {
        this.cart = cart;
        categoryControl = new MaintainCategoryControl();
        itemControl = new MaintainItemControl();
        jpAbove.add(new JLabel("Category"));
        jpAbove.add(jcboCategory);

        initializeCategoryList();
        jcboCategory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeButtonContent(jcboCategory.getSelectedIndex() - 1);
            }
        });
        add(jpAbove, BorderLayout.NORTH);
        add(jpBelow, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void initializeCategoryList() {
        categoryList.addElement("Select a category");
        categories = categoryControl.getCategories();
        for (int i = 0; i < categories.size(); i++) {
            categoryList.addElement(categories.get(i).getCategory());
        }
        jcboCategory.setSelectedIndex(0);
        insertButton();
    }

    public void insertButton() {

        items = itemControl.getItems();
        jpBelow.setLayout(new GridLayout((int) (Math.ceil(items.size() / 3.0)), 3));
        jbtItems = new JButton[items.size()];
        for (int i = 0; i < items.size(); i++) {
            createButton(i, jbtItems[i]);
        }
        panelLayout(items.size());
    }

    public void createButton(int i, JButton jbt) {
        String price = String.format("RM %.2f", items.get(i).getPrice());
        try {
            String itemName = items.get(i).getItemName();
            String buttonName = itemName;

            ImageIcon imgIconOri = items.get(i).getItemImg().getImage();
            Image image = imgIconOri.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
            ImageIcon imgIcon = new ImageIcon(image);
            if (itemName.length() > 10) {
                buttonName = "";
                int k = 0;
                for (int j = 0; j < itemName.length(); j++) {
                    k++;
                    if (k > 8 && itemName.charAt(j) == ' ') {
                        buttonName += itemName.charAt(j) + "<br />";
                        k = 0;
                    } else {
                        buttonName += itemName.charAt(j);
                    }
                }
            }
            jbt = new JButton("<html><center>" + buttonName + "<br/>" + price + "</html>");
            jbt.setBackground(Color.white);
            jbt.setHorizontalAlignment(SwingConstants.CENTER);
            jbt.setHorizontalTextPosition(SwingConstants.CENTER);
            jbt.setVerticalAlignment(SwingConstants.CENTER);
            jbt.setVerticalTextPosition(SwingConstants.BOTTOM);
            jbt.setIcon(imgIcon);
            jbt.setPreferredSize(new Dimension(150, 180));
            jbt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    itemDesc = new ItemDescFrame(items.get(i), cart);
                }
            });
            jpBelow.add(jbt);

        } catch (Exception ex) {
            System.out.println("Error in insertButton(): " + ex);
        }
    }

    public void changeButtonContent(int index) {
        items = itemControl.getItems();
        int buttonIndex = 0;
        for (int i = 0; i < items.size(); i++) {
            jpBelow.removeAll();
            jpBelow.revalidate();
            jpBelow.repaint();
        }

        if (index == -1) {
            for (int i = 0; i < items.size(); i++) {
                createButton(i, jbtItems[i]);
            }
            panelLayout(items.size());
        } else {
            Category category = categories.get(index);
            String categoryID = category.getCategoryID();
            jbtItems2 = new JButton[items.size()];

            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getCategory().getCategoryID().equals(categoryID)) {
                    createButton(i, jbtItems2[i]);
                    buttonIndex++;
                }
            }
            if (buttonIndex == 2) {
                jpBelow.add(new JLabel(""));
            } else if (buttonIndex == 1) {
                jpBelow.add(new JLabel(""));
                jpBelow.add(new JLabel(""));
            }
            panelLayout(buttonIndex);
        }
    }

    public void panelLayout(int size) {
        int gridRowCount = (int) Math.ceil(size / 3.0);
        int panelcount = gridRowCount;
        int heightDimension = 200;
        int w = 200;
        if (panelcount > 2) {
            heightDimension += (panelcount - 1) * w;
        }
        setPreferredSize(new Dimension(150, heightDimension));
        jpBelow.setLayout(new GridLayout(gridRowCount, 3));
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }

}
