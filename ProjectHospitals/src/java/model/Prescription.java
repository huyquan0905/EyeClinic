/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Hi! Le Minh Hieu
 */
public class Prescription {
    private int presId;
    private String presName;
    private int presQuantity;

    private int doctorId;
    private int customerId;
    private String presNote;

    public Prescription() {
    }

    public Prescription(int presId, String presName, int presQuantity, int doctorId, int customerId, String presNote) {
        this.presId = presId;
        this.presName = presName;
        this.presQuantity = presQuantity;
        this.doctorId = doctorId;
        this.customerId = customerId;
        this.presNote = presNote;
    }

    public int getPresId() {
        return presId;
    }

    public void setPresId(int presId) {
        this.presId = presId;
    }

    public String getPresName() {
        return presName;
    }

    public void setPresName(String presName) {
        this.presName = presName;
    }

    public int getPresQuantity() {
        return presQuantity;
    }

    public void setPresQuantity(int presQuantity) {
        this.presQuantity = presQuantity;
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

    public String getPresNote() {
        return presNote;
    }

    public void setPresNote(String presNote) {
        this.presNote = presNote;
    }

    @Override
    public String toString() {
        return "Prescription{" + "presId=" + presId + ", presName=" + presName + ", presQuantity=" + presQuantity + ", doctorId=" + doctorId + ", customerId=" + customerId + ", presNote=" + presNote + '}';
    }

    
}
