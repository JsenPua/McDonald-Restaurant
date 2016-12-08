/*
 Author Swati
 */
package domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

public class Member implements Serializable {

    private String mbrID;
    private String memberName;
    private String icNo;
    private String contactNo;
    private String homeAddress;
    //private Date birthDate;
    private int loyaltyPoint;
    private Date memStartDate;
    private Date memEndDate;
    private String mbrType;
    private static int memberCount = 0;

    public Member() {

    }
    
    public Member(String mbrID) {
             this.mbrID = mbrID;
    }

    public Member(String mbrID, int loyaltyPoint) {
        this.mbrID = mbrID;
        this.loyaltyPoint = loyaltyPoint;
    }

    public Member(String mbrID, String memberName, String icNo, String contactNo,
            String homeAddress, int loyaltyPoint, Date memStartDate, Date memEndDate, String mbrType) {
        this.mbrID = mbrID;
        this.memberName = memberName;
        this.icNo = icNo;
        this.contactNo = contactNo;
        this.homeAddress = homeAddress;
        this.loyaltyPoint = loyaltyPoint;
        this.memStartDate = memStartDate;
        this.memEndDate = memEndDate;
        this.mbrType = mbrType;
        memberCount++;
    }

    public static int getMemberCount() {
        return memberCount;
    }

    public String getMbrID() {
        return mbrID;
    }

    public String getMbrType() {
        return mbrType;
    }

    public void setMbrType(String mbrType) {
        this.mbrType = mbrType;
    }

    public void setMbrID(String mbrID) {
        this.mbrID = mbrID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getIcNo() {
        return icNo;
    }

    public void setIcNo(String icNo) {
        this.icNo = icNo;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public int getLoyaltyPoint() {
        return loyaltyPoint;
    }

    public void setLoyaltyPoint(int loyaltyPoint) {
        this.loyaltyPoint = loyaltyPoint;
    }

    public Date getMemStartDate() {
        return memStartDate;
    }

    public void setMemStartDate(Date memStartDate) {
        this.memStartDate = memStartDate;
    }

    public Date getMemEndDate() {
        return memEndDate;
    }

    public void setMemEndDate(Date memEndDate) {
        this.memEndDate = memEndDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.mbrID);
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
        final Member other = (Member) obj;
        if (!Objects.equals(this.mbrID, other.mbrID)) {
            return false;
        }
        return true;
    }

}
