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


public class Toys implements Serializable{
    private String rdiCode;
    private String rdiName;
    private int points;
    private int stockCount;
    
    public Toys(){
        
    }
    
    public Toys(String rdiCode){
         this.rdiCode = rdiCode;
    }
    
    

    public Toys(String rdiCode, String rdiName, int points , int stockCount) {
        this.rdiCode = rdiCode;
        this.rdiName = rdiName;
        this.points = points;
        this.stockCount =stockCount;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public String getRdiCode() {
        return rdiCode;
    }

    public void setRdiCode(String rdiCode) {
        this.rdiCode = rdiCode;
    }

    public String getRdiName() {
        return rdiName;
    }

    public void setRdiName(String rdiName) {
        this.rdiName = rdiName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.rdiCode);
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
        final Toys other = (Toys) obj;
        if (!Objects.equals(this.rdiCode, other.rdiCode)) {
            return false;
        }
        return true;
    }
    
    
}
