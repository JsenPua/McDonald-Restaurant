/*
 Author Swati
 */
package control;
import domain.Member;
import da.MemberDA;

public class MaintainMemberControl {
    private MemberDA memDA;
    
    public MaintainMemberControl(){
        memDA = new MemberDA();
    }
    
    public Member selectRecord(String mbrID){
        return memDA.selectRecord(mbrID);
    }
    
     public void addMember(Member mem){
        memDA.addMember(mem);    
    }
    
    public void updateMember(Member mem){
        memDA.updateMember(mem);    
    }
    
    public void removeMember(Member mem){
        memDA.removeMember(mem);    
    }
    
}
