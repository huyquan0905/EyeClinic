/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Customer;
import model.Service;
import model.Test;

/**
 *
 * @author Hi! Le Minh Hieu
 */
public class ServiceDAO extends ConnectMySQL {

    public Service getServiceBysID(String sid) {

        String sql = "select * from service where service_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, sid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Service(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    public Service getCusSer(int customerId){
        
    String sql ="select customer.customer_id,service.service_id, service.service_name,service.service_detail,service.service_price,service.service_image\n" +
"from customer_has_service inner join service \n" +
"inner join customer \n" +
"on customer_has_service.customer_id = customer.customer_id\n" +
"and customer_has_service.service_id = service.service_id \n" +
"where customer.customer_id = ?; ";   
        try {
             PreparedStatement ps = connection.prepareStatement(sql);
              ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
              return new Service(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        return null;
       
     }

    public List<Service> getListService() {
        List<Service> listService = new ArrayList<>();
        String sql = "select * from service";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listService.add(new Service(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listService;
    }

    public void DeleteService(String sid) {
        String sql = "  DELETE FROM service WHERE service_id =?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, sid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void InsertService(String name, String detail, int price, String img) {

        String sql = "INSERT INTO `projectswp391`.`service` (service_name, service_detail, service_price, service_image) values(?, ?, ?, ?);";
        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, detail);
            ps.setDouble(3, price);
            ps.setString(4, img);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void EditService( String name, String detail, int price, String img,int id) {
        String sql = "  UPDATE service  set service_name= ?   ,service_detail = ? \n"
                + "  ,service_price = ?   ,service_image = ?\n"
                + "  where service_id = ?;";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1, name);
            ps.setString(2, detail);
            ps.setInt(3, price);
            ps.setString(4, img);
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Service> search(String keyword) {
        List<Service> list = new ArrayList<>();
        try {
            String sql = "select *  from service where service_name like ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Service service = new Service();
                service.setServiceId(rs.getInt(1));
                service.setServiceName(rs.getString(2));
                service.setServiceDetail(rs.getString(3));
                service.setServicePrice(rs.getInt(4));
                service.setServiceImage(rs.getString(5));
                list.add(service);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
     public int countService(){  
         String sql = "select count(*) from Service";
         try {
            

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
              return rs.getInt(1);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
        
    }

    public static void main(String[] args) {
        ServiceDAO dao = new ServiceDAO();
        List<Service> service = dao.getListService();
                for (Service service1 : service) {
                    System.out.println(service1);
        }
       
     
      
    }
}
