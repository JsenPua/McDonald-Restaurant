/*
 Author Phang Chun Wai
 */
package domain;


import java.io.Serializable;
import java.util.Objects;


public class Staff implements Serializable {

    private String id;
    private String ic;
    private String name;
    private String password;
    private String contactNo;
    private String address;
    private String positon;
    private double salary;
    private Icon icon;
   
    
    public Staff() {

    }
    
    public Staff(String id) {
        this.id = id;
    }

    public Staff(String id, String ic, String name, String password, String contactNo, String address, String positon,double salary,Icon icon) {
        this.id = id;
        this.ic = ic;
        this.name = name;
        this.password = password;
        this.contactNo = contactNo;
        this.address = address;
        this.positon = positon;
        this.salary = salary;
        this.icon = icon;
    }   

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPositon() {
        return positon;
    }

    public void setPositon(String positon) {
        this.positon = positon;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

   
   

}
