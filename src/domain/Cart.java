package domain;

import java.util.ArrayList;
import javax.swing.*;
/**
 *
 * @author HuiWen
 */
public class Cart {

    ArrayList<OrderList> finalCart = new ArrayList<OrderList>();

    private OrderList[] cartList;
    private int counter = 0;
    private String transID;

    public Cart(String transID) {
        this.transID = transID;
        cartList = new OrderList[30];
    }

    public void insertItem(OrderList ord) {
        try {
            if (changeOrderQuantity(ord) && !(ord.getQuantity() == 0)) {
                cartList[counter] = ord;
                counter++;
                finalCart.add(ord);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Cart cannot insert more than 30 order!");
        }
    }
    
    public ArrayList<OrderList> getFinalCart(){
        return finalCart;
    }

    public int getCounter() {
        return counter - 1;
    }

    public String getTransID() {
        return transID;
    }

    public void setTransID(String transID) {
        this.transID = transID;
    }

    public OrderList getOrderItem(int index) {
        return cartList[index];
    }

    public OrderList[] getOrderList() {
        return cartList;
    }

    public String[] getCartData() {
        String[] cartData = new String[30];
        if (counter > 0) {
            for (int i = 0; i < counter; i++) {
                if (cartList[i].getQuantity() > 0) {
                    cartData[i] = String.format("%5s %s x %d" , cartList[i].getItem().getItemCode(), cartList[i].getItem().getItemName(), cartList[i].getQuantity());
                }
            }
        }
        return cartData;
    }

    public boolean changeOrderQuantity(OrderList ord) {
        boolean addToCart = true;
        for (int i = 0; i < counter; i++) {
            if (cartList[i].getItem().getItemCode().equals(ord.getItem().getItemCode())) {
                cartList[i].setQuantity(ord.getQuantity());
                addToCart = false;
                if (ord.getQuantity() > 0) {
                    finalCart.get(i).setQuantity(ord.getQuantity());
                }else{
                    finalCart.remove(i);
                }
            }
        }
        return addToCart;
    }

}
