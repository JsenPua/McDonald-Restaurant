package control;

import da.CategoryDA;
import domain.Category;
import java.util.ArrayList;

public class MaintainCategoryControl {

    private CategoryDA categoryDA;

    public MaintainCategoryControl() {
        categoryDA = new CategoryDA();
    }
    
    public Category selectRecord(String categoryID) {
        return categoryDA.getCurrentRecord();
    }
    
    public ArrayList<Category> getCategories() {
        return categoryDA.getCategories();
    }
    
    public void updateRecord(Category c) {
        categoryDA.updateRecord(c);
    }

    public void deleteRecord(String categoryid) {
        categoryDA.deleteRecord(categoryid);
    }
}
