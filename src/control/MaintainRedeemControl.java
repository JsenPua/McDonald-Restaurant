/*
 Author Swati
 */
package control;
import domain.Redeem;
import da.RedeemDA;

public class MaintainRedeemControl {
    private RedeemDA redeemDA;
    
    public MaintainRedeemControl(){
        redeemDA = new RedeemDA();
    }
    
    public Redeem selectRecord(String code){
        return redeemDA.selectRecord(code);
    }
    
     public void addRedeem(Redeem red){
       redeemDA.addRedeem(red);    
    }
     
}

