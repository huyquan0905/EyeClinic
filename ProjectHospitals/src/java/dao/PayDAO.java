/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Pay;
import model.Service;
import model.Test;

/**
 *
 * @author Hi! Le Minh Hieu
 */
public class PayDAO extends ConnectMySQL {

    public void InsertPay(int total, int customer_id) {

        String sql = "INSERT INTO `projectswp391`.`pay` (paytotal, customer_id, pay_status) values(?, ?, 0);";
        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, total);
            ps.setInt(2, customer_id);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Pay> getPay() {
        List<Pay> listPay = new ArrayList<>();
        String sql = "select c.customer_id, c.customer_name, s.service_price, sum(t.test_price) as test_price, p.paytotal, p.pay_status from customer c \n"
                + "inner join service s inner join customer_has_service cs on s.service_id = cs.service_id and cs.customer_id = c.customer_id\n"
                + "inner join testcategory t inner join testresult ts on t.testcategory_id = ts.testcategory_id and ts.customer_id = c.customer_id\n"
                + "inner join pay p on p.customer_id = c.customer_id\n"
                + "group by c.customer_id, c.customer_name, s.service_price, p.paytotal, p.pay_status";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listPay.add(new Pay(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPay;

    }

    public void UpdatePay(int customer_id) {

        String sql = "UPDATE pay set pay_status = 1 where customer_id = ?;";
        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, customer_id);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Pay> search(String keyword) {
        List<Pay> list = new ArrayList<>();
        try {
            String sql = "select c.customer_id, c.customer_name, s.service_price, sum(t.test_price) as test_price, p.paytotal, p.pay_status from customer c \n"
                + "inner join service s inner join customer_has_service cs on s.service_id = cs.service_id and cs.customer_id = c.customer_id\n"
                + "inner join testcategory t inner join testresult ts on t.testcategory_id = ts.testcategory_id and ts.customer_id = c.customer_id\n"
                + "inner join pay p on p.customer_id = c.customer_id where c.customer_name like ?\n"
                + "group by c.customer_id, c.customer_name, s.service_price, p.paytotal, p.pay_status";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pay pay = new Pay();
                pay.setCustomerId(rs.getInt(1));
                pay.setCustomerName(rs.getString(2));
                pay.setServicePrice(rs.getInt(3));
                pay.setPayTotal(rs.getInt(4));
                pay.setPayStatus(rs.getString(5));

                list.add(pay);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
