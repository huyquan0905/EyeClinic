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
import model.Prescription;

/**
 *
 * @author Hi! Le Minh Hieu
 */
public class PreDAO extends ConnectMySQL {
    public void InsertPres(String name, int quantity, int cid, String note) {
        String sql = "INSERT INTO `projectswp391`.`prescription` (medicine_name, quantity, doctor_id, customer_id, note) VALUES (?,?,1,?,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, quantity);
            ps.setInt(3, cid);
            ps.setString(4, note);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Prescription getPresBycId(int cid){
        String sql ="select * from prescription where customer_id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Prescription(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Prescription> getListPres(int cid) {
        List<Prescription> presList = new ArrayList<Prescription>();
        String sql = "select * from prescription where customer_id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                presList.add(new Prescription(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return presList;
    }
    public static void main(String[] args) {
        PreDAO dao = new PreDAO();
       dao.InsertPres("sajjsda", 10, 2, "jdsjjsa");
    }
    
}

