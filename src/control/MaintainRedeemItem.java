/*
 Author Swati
 */
package control;

import domain.Toys;
import da.RedeemItemDA;

public class MaintainRedeemItem {
    private RedeemItemDA redeemItemDA;
    
    public MaintainRedeemItem(){
        redeemItemDA = new RedeemItemDA();
    }
    
    public Toys selectRecord(String ID){
        return redeemItemDA.selectRecord(ID);
    }
    public Toys selectRecord2(String Name){
        return redeemItemDA.selectRecord2(Name);
    }
    
     public void addRedeemItem(Toys redItem){
       redeemItemDA.addItemRedeem(redItem);    
    }
    
    public void updateRedeemItem(Toys redItem){
        redeemItemDA.updateItemRedeem(redItem);    
    }
    
    public void deleteRedeemItem(Toys redItem){
        redeemItemDA.RemoveItemRedeem(redItem);    
    } 
}
