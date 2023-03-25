/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 *
 * @author Hi! Le Minh Hieu
 */
public class Service {
    private int customerId;
    private int serviceId;
    private String serviceName;
    private String serviceDetail;
    private int servicePrice;
    private String serviceImage;

    public Service() {
    }

    public Service(int customerId, int serviceId, String serviceName, String serviceDetail, int servicePrice, String serviceImage) {
        this.customerId = customerId;
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceDetail = serviceDetail;
        this.servicePrice = servicePrice;
        this.serviceImage = serviceImage;
    }
public Service(int serviceId, String serviceName, String serviceDetail, int servicePrice, String serviceImage) {
        
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceDetail = serviceDetail;
        this.servicePrice = servicePrice;
        this.serviceImage = serviceImage;
    }
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDetail() {
        return serviceDetail;
    }

    public void setServiceDetail(String serviceDetail) {
        this.serviceDetail = serviceDetail;
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

    public String getServiceImage() {
        return serviceImage;
    }

    public void setServiceImage(String serviceImage) {
        this.serviceImage = serviceImage;
    }

    @Override
    public String toString() {
        return "Service{" + "customerId=" + customerId + ", serviceId=" + serviceId + ", serviceName=" + serviceName + ", serviceDetail=" + serviceDetail + ", servicePrice=" + servicePrice + ", serviceImage=" + serviceImage + '}';
    }

  

    

   
}
