/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Hi! Le Minh Hieu
 */
public class Pay {
    private int payId;
    private int payTotal;
    private int customerId;
    private String payStatus;
    private String customerName;
    private int servicePrice;
    private int testPrice;
    public Pay() {
    }

    public Pay(int customerId,String customerName, int servicePrice, int testPrice, int payTotal, String payStatus) {
        this.payTotal = payTotal;
        this.payStatus = payStatus;
        this.customerName = customerName;
        this.servicePrice = servicePrice;
        this.testPrice = testPrice;
        this.customerId = customerId;
    }

    public Pay(int payId, int payTotal, int customerId, String payStatus, String customerName, int servicePrice, int testPrice) {
        this.payId = payId;
        this.payTotal = payTotal;
        this.customerId = customerId;
        this.payStatus = payStatus;
        this.customerName = customerName;
        this.servicePrice = servicePrice;
        this.testPrice = testPrice;
    }

    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }

    public int getPayTotal() {
        return payTotal;
    }
     public String getPayTotal1() {
        Locale vn = new Locale("vi","VN");
        NumberFormat nvn = NumberFormat.getInstance(vn);
        String str = nvn.format(payTotal);  
        return str;
    }
    public void setPayTotal(int payTotal) {
        this.payTotal = payTotal;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getPayStatus() {
        if(payStatus.equals("0")){
            return "Unpaid";
        }
        return "Paid";
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getServicePrice() {
        return servicePrice;
    }
    public String getServicePrice1(){
    Locale vn = new Locale("vi","VN");
        NumberFormat nvn = NumberFormat.getInstance(vn);
        String str = nvn.format(servicePrice);
        
        return str;
}

    public void setServicePrice(int servicePrice) {
        this.servicePrice = servicePrice;
    }

    public int getTestPrice() {
        return testPrice;
    }
      
    public void setTestPrice(int testPrice) {
        this.testPrice = testPrice;
    }

    @Override
    public String toString() {
        return "Pay{" + "payId=" + payId + ", payTotal=" + payTotal + ", customerId=" + customerId + ", payStatus=" + payStatus + ", customerName=" + customerName + ", servicePrice=" + servicePrice + ", testPrice=" + testPrice + '}';
    }

}