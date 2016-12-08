package domain;

import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author HuiWen
 */
public class Item implements Serializable {

    private String itemCode;
    private String itemName;
    private double price;
    private String description;
    private ItemImg itemImg;
    private String status;
    private Category category;
    private static int totalItem;

    public Item() {
    }

    public Item(String itemCode) {
        this.itemCode = itemCode;
    }

    public Item(String itemCode, String itemName, Double price, Category category, String description, ItemImg itemImg, String status) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
        this.category = category;
        this.description = description;
        this.itemImg = itemImg;
        this.status = status;
        totalItem++;
    }
    
     public static int getTotalItem() {
        return totalItem;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setItemImg(ItemImg itemImg) {
        this.itemImg = itemImg;
    }

    public ItemImg getItemImg() {
        return itemImg;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.itemCode);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.itemCode, other.itemCode)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s %s %f %s %s %s %s", itemCode, itemName, price, category.getCategory(), description, itemImg.getUrl(), status);
    }

}
