package domain;
import domain.Item;
/**
 *
 * @author HuiWen
 */
public class OrderList {

    private String orderID, transID;
    private int quantity;
    private Item item;
    private static int numOfOrder;
    
    public OrderList() {

    }

    public OrderList(String orderID, String transID, Item item, int quantity) {
        this.orderID = orderID;
        this.transID = transID;
        this.item = item;
        this.quantity = quantity;
        numOfOrder++;
    }
    
    public static int getNumOfOrder(){
        return numOfOrder;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setTransID(String transID) {
        this.transID = transID;
    }

    public String getTransID() {
        return transID;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

}
