package control;

import da.ItemDA;
import domain.Category;
import domain.Item;
import java.io.IOException;
import java.util.ArrayList;

public class MaintainItemControl {

    private ItemDA itemDA;

    public MaintainItemControl() {
        itemDA = new ItemDA();
    }

    public Item selectRecord(String itemCode) {
        return itemDA.getRecord(itemCode);
    }

    public void addRecord(Item i) throws IOException {
        itemDA.addRecord(i);
    }

    public void updateRecord(Item i) throws IOException {
        itemDA.updateRecord(i);
    }

    public void deleteRecord(Item i) {
        itemDA.deleteRecord(i);
    }

    public Item displayRecord(char c) {
        return selectRecord(itemDA.displayRecord(c));
    }

    public ArrayList<Item> getItems() {
        return itemDA.getItems();
    }
   
}
