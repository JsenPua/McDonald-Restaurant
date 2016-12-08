/*
 Author Soo Xingliang
 */
package control;

import da.*;
import domain.*;
import java.util.ArrayList;
import java.sql.*;

public class TransactionControl {

    private TransactionDA transactionDA;

    public TransactionControl() {
        transactionDA = new TransactionDA();
    }

    public Transaction selectRecord(String transID) {
        return transactionDA.getRecord(transID);
    }

    public void addRecord(Transaction t) {
        transactionDA.addRecord(t);
    }

    public void voidRecord(String transID) {
        transactionDA.voidRecord(transID);
    }

    public String getAfterLastCode() {
        return transactionDA.getAfterLastCode();
    }
}
