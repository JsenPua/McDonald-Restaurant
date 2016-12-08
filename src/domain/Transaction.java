/*
 Author Soo Xingliang
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.sql.*;

public class Transaction implements Serializable {

    private String transID;
    private String staffID;
    private String orderType;
    private String deliveryAddress;

    private String paymentType;
    private String ccNo;
    private String memberID;
    private Timestamp transTime;
    private double voucherValue;
    private double total;
    private String status;

    public Transaction() {
    }

    public Transaction(String transID, String staffID, String orderType, String deliveryAddress, String paymentType, String ccNo, String memberID, Timestamp transTime, double voucherValue, double total, String status) {
        this.transID = transID;
        this.staffID = staffID;
        this.orderType = orderType;
        this.deliveryAddress = deliveryAddress;
        this.paymentType = paymentType;
        this.ccNo = ccNo;
        this.memberID = memberID;
        this.transTime = transTime;
        this.voucherValue = voucherValue;
        this.total = total;
        this.status = status;
    }

    public String getTransID() {
        return transID;
    }

    public void setTransID(String transID) {
        this.transID = transID;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getCcNo() {
        return ccNo;
    }

    public void setCcNo(String ccNo) {
        this.ccNo = ccNo;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public Timestamp getTransTime() {
        return transTime;
    }

    public void setTransTime(Timestamp transTime) {
        this.transTime = transTime;
    }

    public double getVoucherValue() {
        return voucherValue;
    }

    public void setVoucherValue(double voucherValue) {
        this.voucherValue = voucherValue;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
