package domain;

import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author HuiWen
 */
public class Category implements Serializable {

    private String categoryID;
    private String category;

    public Category() {
    }

    public Category(String categoryID) {
        this.categoryID = categoryID;
    }

    public Category(String categoryID, String category) {
        this.categoryID = categoryID;
        this.category = category;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void SetCategoryID() {
        this.categoryID = categoryID;
    }

    public String getCategory() {
        return category;
    }

    public void SetCategory() {
        this.category = category;
    }

    @Override
    public String toString() {
        return  String.format("%s %s",categoryID, category);
    }
}
