/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Booking;
import model.Exam;

/**
 *
 * @author Hi! Le Minh Hieu
 */
public class ExamDAO extends ConnectMySQL {

    public void InsertExam(String conclusion, Date date, int cid) {
        String sql = "INSERT INTO `projectswp391`.`resultexamination` (conclusion, exam_date, doctor_id, customer_id) VALUES (?,?,1,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, conclusion);
            ps.setDate(2, date);
            ps.setInt(3, cid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Exam getExamBycId(int cid){
        String sql ="select * from resultexamination where customer_id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Exam(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getInt(5));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
            
    public static void main(String[] args) {
        ExamDAO dao = new ExamDAO();
        String date = "2023-02-02";
        Date date1 = Date.valueOf(date);
        dao.InsertExam("shjhashah", date1, 1);
    }
}
