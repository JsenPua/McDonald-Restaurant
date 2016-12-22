package ui;

import control.MaintainItemControl;
import control.MaintainCategoryControl;
import domain.Item;
import domain.Category;
import da.CategoryDA;
import domain.ItemImg;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.swing.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MaintainAddItemFrame extends JFrame {

    private MaintainItemControl itemControl;
    private MaintainCategoryControl categoryControl;
    private ArrayList<Category> categories;
    private JTextField jtfItemCode = new JTextField();
    private JTextField jtfItemName = new JTextField();
    private JTextField jtfPrice = new JTextField();
    private DefaultComboBoxModel categoryList = new DefaultComboBoxModel();
    private JComboBox jcboCategory = new JComboBox(categoryList);
    private String categoryID;
    private JTextArea jtaDescription = new JTextArea(5, 400);
    private JTextField jtfImageurl = new JTextField();
    private JButton jbtBrowse = new JButton("Choose Image");
    private JButton jbtView = new JButton("View Image");
    private JLabel jlbPhoto = new JLabel();
    private ItemImg imgPhoto;
    private ImageIcon imgIcon;
    private Box boxImge;
    private JPanel jbtPanel = new JPanel(new GridLayout(2, 1));
    private JFileChooser jfcPhoto = new JFileChooser();
    File workingDirectory = new File(System.getProperty("user.dir"));
    private String[] statusList = {"Available", "Item Expired", "Item Out Of Stock"};
    private JComboBox jcboStatus = new JComboBox(statusList);
    private JButton jbtAdd = new JButton("Add New Item");
    private JButton jbtRetrieve = new JButton("Retrieve Item");
    private JButton jbtUpdate = new JButton("Update Item");
    private JButton jbtDelete = new JButton("Delete Item");
    private JButton jbtLeft = new JButton("<");
    private JButton jbtRight = new JButton(">");
    private JButton jbtReset = new JButton("Reset");
    private JFrame imgFrame = new JFrame();

    public MaintainAddItemFrame() {
        itemControl = new MaintainItemControl();
        categoryControl = new MaintainCategoryControl();
        JPanel jpCenter = new JPanel(new GridLayout(7, 2));

        jpCenter.add(new JLabel("Item Code"));
        jpCenter.add(jtfItemCode);
        jtfItemCode.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                codeOnUpdate();
            }

            public void insertUpdate(DocumentEvent documentEvent) {
                codeOnUpdate();
            }

            public void removeUpdate(DocumentEvent documentEvent) {

            }
        });

        jpCenter.add(new JLabel("Item Name"));
        jpCenter.add(jtfItemName);
        jpCenter.add(new JLabel("Price"));
        jpCenter.add(jtfPrice);

        jtfPrice.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                priceOnUpdate();
            }

            public void insertUpdate(DocumentEvent documentEvent) {
                priceOnUpdate();
            }

            public void removeUpdate(DocumentEvent documentEvent) {

            }
        });
        jpCenter.add(new JLabel("Category"));
        initializeCategoryList();
        jpCenter.add(jcboCategory);

        jpCenter.add(new JLabel("Description"));
        jtaDescription.setLineWrap(true);
        jtaDescription.setWrapStyleWord(true);
        jtaDescription.setAutoscrolls(true);
        JScrollPane scrollPane = new JScrollPane(jtaDescription);
        jpCenter.add(scrollPane);

        jpCenter.add(new JLabel("Image"));
        boxImge = Box.createHorizontalBox();
        boxImge.add(jtfImageurl);
        jbtPanel.add(jbtBrowse);
        jbtPanel.add(jbtView);
        boxImge.add(jbtPanel);
        jbtView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (imgIcon != null) {
                    Image image = imgIcon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
                    ImageIcon img2 = new ImageIcon(image);
                    imgFrame = new ImageFrame(img2);
                } else {
                    JOptionPane.showMessageDialog(null, "Error display: Image is null.", "Display Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        jfcPhoto.setCurrentDirectory(workingDirectory);
        jpCenter.add(boxImge);
        jtfImageurl.setEditable(false);
        jpCenter.add(new JLabel("Status"));
        jpCenter.add(jcboStatus);

        JPanel jpSouth = new JPanel();
        jpSouth.add(jbtAdd);
        jpSouth.add(jbtRetrieve);
        jpSouth.add(jbtUpdate);
        jpSouth.add(jbtDelete);
        jpSouth.add(jbtLeft);
        jpSouth.add(jbtRight);
        jpSouth.add(jbtReset);

        add(jpCenter);
        add(jpSouth, BorderLayout.SOUTH);

        jbtReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });

        jbtAdd.addActionListener(new AddListener());
        jbtRetrieve.addActionListener(new RetrieveListener());
        jbtUpdate.addActionListener(new UpdateListener());
        jbtDelete.addActionListener(new DeleteListener());
        jbtBrowse.addActionListener(new BrowseListener());
        jcboCategory.addActionListener(new SelectCategoryListener());
        ButtonListener listener = new ButtonListener();
        jbtLeft.addActionListener(listener);
        jbtRight.addActionListener(listener);

        setTitle("Manage Item System");
        setSize(750, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void clear() {
        jtfItemCode.setText("");
        jtfItemName.setText("");
        jtfPrice.setText("");
        jcboCategory.setSelectedIndex(0);
        jtaDescription.setText("");
        imgIcon = null;
        jtfImageurl.setText("");
        jcboStatus.setSelectedIndex(0);
    }

    public DefaultComboBoxModel getCategoryList() {
        return categoryList;
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jbtLeft) {
                retrieveItem(itemControl.displayRecord('L'));
            } else if (e.getSource() == jbtRight) {
                retrieveItem(itemControl.displayRecord('R'));
            }
        }
    }

    private class AddListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String itemCode = jtfItemCode.getText().toUpperCase();
            String itemName = jtfItemName.getText();
            double price = Double.parseDouble(jtfPrice.getText());
            Category category = (new CategoryDA()).getRecord(categoryID);
            String description = jtaDescription.getText();
            String selectedFile = "";
            String status = statusList[jcboStatus.getSelectedIndex()];
            boolean canContinue = false;
            try {
                selectedFile = jfcPhoto.getSelectedFile().getAbsolutePath();
                canContinue = true;
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Error Insert: Image is null.", "Insert Error", JOptionPane.ERROR_MESSAGE);
            }
            if (canContinue) {
                try {
                    ImageIcon imageIcon = new ImageIcon(selectedFile);
                    URL url = new URL("file:///" + selectedFile);
                    imgPhoto = new ItemImg(imageIcon, url);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error insert" + ex.getMessage());
                }
                Item item = itemControl.selectRecord(itemCode);
                if (item != null) {
                    JOptionPane.showMessageDialog(null, "Item Existed", "SAME RECORD IS FOUND", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        item = new Item(itemCode, itemName, price, category, description, imgPhoto, status);
                        itemControl.addRecord(item);
                    } catch (IOException ex) {
                        Logger.getLogger(MaintainAddItemFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(null, "Insert Error: " + exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    item = itemControl.selectRecord(itemCode);
                    if (item != null) {
                        JOptionPane.showMessageDialog(null, itemCode + " is inserted Successful.\n", "Insert Successful", JOptionPane.INFORMATION_MESSAGE);
                        clear();
                        String itemcode = itemCode;
                        int itemNum;
                        itemNum = Integer.parseInt(itemcode.substring(1));
                        itemNum += 1;
                        itemcode = "I" + itemNum;
                        jtfItemCode.setText(itemcode);
                    }
                }

            }
        }
    }

    private class RetrieveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String itemCode = jtfItemCode.getText().toUpperCase();
            retrieveItem(itemControl.selectRecord(itemCode));
        }
    }

    public void retrieveItem(Item item) {
        if (item != null) {
            jtfItemCode.setText(item.getItemCode());
            jtfItemName.setText(item.getItemName());
            jtfPrice.setText("" + item.getPrice());
            jcboCategory.setSelectedItem(item.getCategory().getCategory());
            jtaDescription.setText(item.getDescription());
            jtfImageurl.setText("Press image button to see image");
            this.imgIcon = item.getItemImg().getImage();
            jcboStatus.setSelectedItem(item.getStatus());
        } else {
            JOptionPane.showMessageDialog(null, "No such item code.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);

        }
    }

    private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String itemCode = jtfItemCode.getText().toUpperCase();
            String itemName = jtfItemName.getText();
            double price = Double.parseDouble(jtfPrice.getText());
            Category category = (new CategoryDA()).getRecord(categoryID);
            String description = jtaDescription.getText();
            String selectedFile;
            String status = statusList[jcboStatus.getSelectedIndex()];
            Item item = itemControl.selectRecord(itemCode);
            try {
                selectedFile = jfcPhoto.getSelectedFile().getAbsolutePath();
                ImageIcon imageIcon = new ImageIcon(selectedFile);
                URL url = new URL("file:///" + selectedFile);
                imgPhoto = new ItemImg(imageIcon, url);
            } catch (NullPointerException ex) {
                ImageIcon imageIcon = item.getItemImg().getImage();
                imgPhoto = new ItemImg(imageIcon);
            } catch (Exception exc) {
                JOptionPane.showMessageDialog(null, "Error in image: " + exc.getMessage());
            }

            if (item != null) {
                try {
                    item.setItemName(itemName);
                    item.setPrice(price);
                    item.setCategory(category);
                    item.setDescription(description);
                    item.setItemImg(imgPhoto);
                    item.setStatus(status);
                    itemControl.updateRecord(item);
                    JOptionPane.showMessageDialog(null, itemCode + " is updated Successful.\n", "Insert Successful", JOptionPane.INFORMATION_MESSAGE);

                } catch (IOException ex) {
                    Logger.getLogger(MaintainAddItemFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No such item code.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    private class DeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String itemCode = jtfItemCode.getText().toUpperCase();
            Item item = itemControl.selectRecord(itemCode);
            if (item != null) {
                int opt = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
                if (opt == JOptionPane.YES_OPTION) {
                    itemControl.deleteRecord(item);
                    item.setItemCode(null);
                    item.setItemName(null);
                    item.setPrice(0);
                    item.setCategory(null);
                    item.setDescription(null);
                    item.setItemImg(null);
                    item.setStatus(null);
                    retrieveItem(itemControl.displayRecord('L'));
                    JOptionPane.showMessageDialog(null, itemCode + " is deleted Successful.\n", "Deleted Successful", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No such item code.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public class BrowseListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int result = jfcPhoto.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = jfcPhoto.getSelectedFile();
                String fileName = file.getAbsolutePath();
                imgIcon = new ImageIcon(fileName);
                Image img2 = imgIcon.getImage().getScaledInstance(120, 80, Image.SCALE_SMOOTH);
                imgIcon.setImage(img2);
                jlbPhoto.setIcon(imgIcon);
                jtfImageurl.setText(fileName);
                repaint();
            }
        }
    }

    private void initializeCategoryList() {
        categories = categoryControl.getCategories();
        categoryList.addElement("Select a category");
        for (int i = 0; i < categories.size(); ++i) {
            categoryList.addElement(categories.get(i).getCategory());

        }
    }

    private class SelectCategoryListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Category category = categories.get((jcboCategory.getSelectedIndex() - 1));
                categoryID = category.getCategoryID();
            } catch (ArrayIndexOutOfBoundsException ex) {
                JOptionPane.showMessageDialog(null, "Enter all field to add, edit, retrieve and delete item.");
            }
        }
    }

    public void codeOnUpdate() {
        if (jtfItemCode.getText().length() > 5) {
            JOptionPane.showMessageDialog(null, "ItemCode cannot longer than 5 character", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!(jtfItemCode.getText().charAt(0) == 'i' || jtfItemCode.getText().charAt(0) == 'I')) {
            JOptionPane.showMessageDialog(null, "ItemCode must start with I", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void priceOnUpdate() {
        try {
            double valPrice = Double.parseDouble(jtfPrice.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Please enter the price!", "Insert Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {

        new MaintainAddItemFrame();
    }

}
