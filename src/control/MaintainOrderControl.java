/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import da.OrderDA;
import domain.OrderList;

public class MaintainOrderControl {

    private OrderDA orderDA;

    public MaintainOrderControl() {
        orderDA = new OrderDA();
    }

    public OrderList selectRecord(String orderID) {
        return orderDA.getRecord(orderID);
    }
    
    public void addRecord(OrderList o) {
        orderDA.addRecord(o);
    }

    public String getAfterLastCode() {
        return orderDA.getAfterLastCode();
    }

    public void updateRecord(OrderList o) {
        orderDA.updateRecord(o);
    }

    public void deleteRecord(String orderid) {
        orderDA.deleteRecord(orderid);
    }
}
