/*
 Author Phang Chun Wai
 */
package control;

import da.StaffDA;
import domain.Staff;
import java.io.IOException;
import java.sql.SQLException;

public class MaintainStaffControl {

    private StaffDA staffDA;

    public MaintainStaffControl() {
        staffDA = new StaffDA();
    }
   

    public Staff selectRecord(String id) {
       return staffDA.getRecord(id);
    }

    public void addRecord(Staff s){
        staffDA.addRecord(s);

    }

    public void deleteRecord(Staff s) {
        staffDA.deleteRecord(s);
    }

    public void updateRecord(Staff s) throws SQLException, IOException  {
        staffDA.updateRecord(s);
    }    
}
