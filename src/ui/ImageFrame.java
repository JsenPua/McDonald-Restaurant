package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*Author: huiwen*/
public class ImageFrame extends JFrame {

    public ImageFrame(ImageIcon img) {
        JLabel label1;
        if(img!=null){
            label1 = new JLabel();
            label1.setIcon(img);

        }else {
            label1 = new JLabel("No image to display");
        }
        add(label1);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Image");
        setSize(480, 480);
        setVisible(true);
        setLocationRelativeTo(null);
    }

}
