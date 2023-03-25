/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Customer;
import model.Service;
import model.Test;

/**
 *
 * @author Hi! Le Minh Hieu
 */
public class CustomerDAO extends ConnectMySQL {

    public void InsertProfile(String name, String address, Date birth, String phone, String gender, String status, int account_id) {
        String sql = "INSERT INTO `projectswp391`.`customer` (customer_name, customer_address, customer_birth, customer_phone, customer_gender , customer_status, account_id) VALUES (?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setDate(3, birth);
            ps.setString(4, phone);
            ps.setString(5, gender);
            ps.setString(6, status);
            ps.setInt(7, account_id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Customer ViewProfile(int account_id) {
        String sql = "select * from customer where account_id= ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, account_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Customer> getListCustomer() {
        List<Customer> customerList = new ArrayList<Customer>();
        String sql = "select * from customer";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customerList.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public Customer getCustomerByID(int account_id) {
        String sql = "select * from customer where account_id= ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, account_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Customer> getCustomerByStatus(String status) {
        List<Customer> listCustomer = new ArrayList<>();
        String sql = "select * from customer where customer_status= ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, status);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listCustomer.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCustomer;
    }

    public Customer getCustomerByCusID(int customerId) {
        String sql = "select * from customer where customer_id= ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void InsertCusSer(int customerId, int serviceId) {
        String sql = "INSERT INTO `projectswp391`.`customer_has_service` (customer_id, service_id) VALUES (?, ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, customerId);
            ps.setInt(2, serviceId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Customer getCusSer(int customerId) {

        String sql = "select customer.customer_id, customer.customer_name, customer.customer_address, customer.customer_birth, customer.customer_phone, customer.customer_gender, customer.customer_status, service.service_name, customer.account_id\n"
                + "from customer_has_service inner join service \n"
                + "inner join customer \n"
                + "on customer_has_service.customer_id = customer.customer_id\n"
                + "and customer_has_service.service_id = service.service_id \n"
                + "where customer.customer_id = ?; ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public void UpDateStatus(String status, int cid) {
        try {
            String sql = "UPDATE customer SET customer_status = ? WHERE customer_id  = ?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, cid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteCustomer(String id) {
        String sql = "delete from customer where account_id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getListCusTest() {
        List<Customer> getList = new ArrayList<>();
        String sql = "select customer.customer_id, customer.customer_name, testcategory.test_name, testresult.test_status\n"
                + "from testresult inner join testcategory\n"
                + "inner join customer\n"
                + "on testresult.customer_id = customer.customer_id\n"
                + "and testresult.testcategory_id = testcategory.testcategory_id where customer.customer_status = 2 ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                getList.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getList;

    }

    public void UpDateProfile(String name, String address, Date birth, String phone, String gender, String status, int id) {
        try {
            String sql = "UPDATE customer SET customer_name = ?,customer_address=? ,customer_birth =?,customer_phone =?,customer_gender=?,customer_status = ?   WHERE account_id  = ?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setDate(3, birth);
            ps.setString(4, phone);
            ps.setString(5, gender);
            ps.setString(6, status);

            ps.setInt(7, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Customer> search(String keyword) {
        List<Customer> list = new ArrayList<>();
        try {
            String sql = "select *  from customer where customer_name like ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(rs.getInt(1));
                customer.setCustomerName(rs.getString(2));
                customer.setCustomerAddress(rs.getString(3));
                customer.setCustomerBirth(rs.getDate(4));
                customer.setCustomerPhone(rs.getString(5));
                customer.setCustomerGender(rs.getString(6));
                customer.setCustomerStatus(rs.getString(7));
                customer.setAccountcId(rs.getInt(8));
                list.add(customer);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Customer> searchrecord(String keyword) {
        List<Customer> list = new ArrayList<>();
        try {
            String sql = "select *  from customer where customer_name like ? and customer_status=3";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(rs.getInt(1));
                customer.setCustomerName(rs.getString(2));
                customer.setCustomerAddress(rs.getString(3));
                customer.setCustomerBirth(rs.getDate(4));
                customer.setCustomerPhone(rs.getString(5));
                customer.setCustomerGender(rs.getString(6));
                customer.setCustomerStatus(rs.getString(7));
                customer.setAccountcId(rs.getInt(8));
                list.add(customer);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Customer> getListCusBook() {
        List<Customer> getList = new ArrayList<>();
        String sql = "select customer.customer_id, customer.customer_name, customer.customer_address, customer.customer_birth, customer.customer_phone, customer.customer_gender, customer.customer_status,\n"
                + "                booking.booking_id,booking.booking_status\n"
                + "                from customer inner join booking \n"
                + "                on booking.customer_id = customer.customer_id where booking.booking_status = 1 ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                getList.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getList;
    }

    public int countCus() {
        String sql = "select count(*) from customer where customer_status = 2;";
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

    public int countCustomer() {
        String sql = "select count(*) from customer;";
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

    public List<Customer> pageCustomer(int index) {
        List<Customer> listCustomer = new ArrayList<>();
        String sql = "SELECT * FROM customer\n"
                + "LIMIT 10 OFFSET ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 10);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listCustomer.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCustomer;
    }

    public static void main(String[] args) {
        CustomerDAO dao = new CustomerDAO();
        dao.getCustomerByStatus("0");
    }
}
