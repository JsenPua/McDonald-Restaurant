/*
 Author Swati
 */
package domain;
import java.io.Serializable;
import java.util.Objects;

public class Redeem implements Serializable{
    private String rCode;
    private Toys redeemItem;
    private Member member;


    public Redeem() {
        
    }

    public Redeem(String rCode, Member member,Toys redeemItem) {
        this.rCode = rCode;
        this.redeemItem = redeemItem;
        this.member = member;
     
    }

    public String getrCode() {
        return rCode;
    }

    public void setrCode(String rCode) {
        this.rCode = rCode;
    }

    public Toys getRedeemItem() {
        return redeemItem;
    }

    public void setRedeemItem(Toys redeemItem) {
        this.redeemItem = redeemItem;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.rCode);
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
        final Redeem other = (Redeem) obj;
        if (!Objects.equals(this.rCode, other.rCode)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
