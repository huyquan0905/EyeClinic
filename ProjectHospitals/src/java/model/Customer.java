/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Hi! Le Minh Hieu
 */
public class Customer {
    
    private int customerId;
    private String customerName;
    private String customerAddress;
    private Date customerBirth;
    private String customerPhone;
    private String customerGender;
    private String customerStatus;
    private String serviceName;
    private int accountcId;
    private String testName;
    private String testStatus;
    private int bookingId;
    private String bookingStatus;
    public Customer() {
    }

    public Customer(int customerId, String customerName, String customerAddress, Date customerBirth, String customerPhone, String customerGender, String customerStatus, String serviceName, int accountcId) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerBirth = customerBirth;
        this.customerPhone = customerPhone;
        this.customerGender = customerGender;
        this.customerStatus = customerStatus;
        this.serviceName = serviceName;
        this.accountcId = accountcId;
    }
     public Customer(int customerId, String customerName, String customerAddress, Date customerBirth, String customerPhone, String customerGender, String customerStatus,int bookingId, String bookingStatus) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerBirth = customerBirth;
        this.customerPhone = customerPhone;
        this.customerGender = customerGender;
        this.customerStatus = customerStatus;
        this.bookingId = bookingId;
        this.bookingStatus = bookingStatus;
    }


    public Customer(int customerId, String customerName, String customerAddress, Date customerBirth, String customerPhone, String customerGender, String customerStatus, int accountcId) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerBirth = customerBirth;
        this.customerPhone = customerPhone;
        this.customerGender = customerGender;
        this.customerStatus = customerStatus;
        this.accountcId = accountcId;
    }

    public Customer(int customerId, String customerName, String testName, String testStatus) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.testName = testName;
        this.testStatus = testStatus;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
    
    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Date getCustomerBirth() {
        return customerBirth;
    }

    public void setCustomerBirth(Date customerBirth) {
        this.customerBirth = customerBirth;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerGender() {
        if (customerGender.equals("0")) {
            return "Female";
        }
        if (customerGender.equals("1")) {
            return "Male";
        }
        return null;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerStatus() {
        if(customerStatus.equals("6")) {
            return "Processing";
        }
        else if (customerStatus.equals("1")) {
            return "Test Processing";
        }
        else if (customerStatus.equals("2")){
            return "Done Test";
        }else if (customerStatus.equals("3")){
            return "Done All";
        }
        
        return "Processing";
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getAccountcId() {
        return accountcId;
    }

    public void setAccountcId(int accountcId) {
        this.accountcId = accountcId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestStatus() {
        if (testStatus.equals("0")) {
            return "Processing";
        }
        else if (testStatus.equals("1")) {
            return "Test Processing";
        }
        else if (testStatus.equals("2")){
            return "Done Test";
        }else if (testStatus.equals("3")){
            return "Done All";
        }
        return null;
    }

    public void setTestStatus(String testStatus) {
        this.testStatus = testStatus;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
    
    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", customerName=" + customerName + ", customerAddress=" + customerAddress + ", customerBirth=" + customerBirth + ", customerPhone=" + customerPhone + ", customerGender=" + customerGender + ", customerStatus=" + customerStatus + ", serviceName=" + serviceName + ", accountcId=" + accountcId + ", testName=" + testName + ", testStatus=" + testStatus + '}';
    }

}
