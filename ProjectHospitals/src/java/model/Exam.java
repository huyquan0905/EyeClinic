/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Hi! Le Minh Hieu
 */
public class Exam {
    private int examId;
    private String conclusion;
    private Date examDate;
    private int doctorId;
    private int customerId;

    public Exam() {
    }

    public Exam(int examId, String conclusion, Date examDate, int doctorId, int customerId) {
        this.examId = examId;
        this.conclusion = conclusion;
        this.examDate = examDate;
        this.doctorId = doctorId;
        this.customerId = customerId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Exam{" + "examId=" + examId + ", conclusion=" + conclusion + ", examDate=" + examDate + ", doctorId=" + doctorId + ", customerId=" + customerId + '}';
    }
    
}
