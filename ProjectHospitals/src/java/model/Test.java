/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Hi! Le Minh Hieu
 */
public class Test {
    private int customerId;
    private String customerName;
    private int testId;
    private String resultTest;
    private Date testDate;
    private String testStatus;
    private String testName;
    private int testPrice;
    private String customerStatus;
    public Test() {
    }
    
     public Test(String testStatus,int customerId, String customerName, String customerStatus) {
         this.testStatus = testStatus;
         this.customerId = customerId;
         this.customerName = customerName;
         this.customerStatus = customerStatus;
    }

    public Test(int customerId, int testId, String resultTest, Date testDate, String testStatus) {
        this.customerId = customerId;
        this.testId = testId;
        this.resultTest = resultTest;
        this.testDate = testDate;
        this.testStatus = testStatus;
    }
    public Test(String testName, int testPrice, String resultTest, Date testDate) {
        this.testName = testName;
        this.testPrice = testPrice;
        this.resultTest = resultTest;
        this.testDate = testDate;
    }
    public Test(int customerId, String customerName, String testName,int testPrice,int testId, String resultTest, Date testDate, String testStatus) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.testId = testId;
        this.testName = testName;
        this.testPrice = testPrice;
        this.resultTest = resultTest;
        this.testDate = testDate;
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

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getResultTest() {
        return resultTest;
    }

    public void setResultTest(String resultTest) {
        this.resultTest = resultTest;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public String getTestStatus() {
       if (testStatus.equals("0")) {
            return "Processing";
        }
        else if (testStatus.equals("1")) {
            return "Test Done";
        }
      
        return null;
    }

    public void setTestStatus(String testStatus) {
        this.testStatus = testStatus;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getTestPrice() {
        return testPrice;
    }
     public String getTestPrice1() {
        Locale vn = new Locale("vi","VN");
        NumberFormat nvn = NumberFormat.getInstance(vn);
        String str = nvn.format(testPrice);
        
        return str;
    }

    public void setTestPrice(int testPrice) {
        this.testPrice = testPrice;
    }

    public String getCustomerStatus() {
        if (customerStatus.equals("0")) {
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
        return null;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }
    

    @Override
    public String toString() {
        return "Test{" + "customerId=" + customerId + ", customerName=" + customerName + ", testId=" + testId + ", resultTest=" + resultTest + ", testDate=" + testDate + ", testStatus=" + testStatus + ", testName=" + testName + ", testPrice=" + testPrice + '}';
    }

    
   

    
}
