package model;

import java.sql.Date;

public class Booking {

    private int booking_id;
    private Date booking_date;
    private String booking_reason;
    private String booking_description;
    private String booking_status;
    private int customerId;
    private String customerName;

    public Booking() {
    }

    public Booking(int customerId, String customerName, int booking_id, Date booking_date, String booking_reason, String booking_description, String booking_status) {
        this.customerName = customerName;
        this.booking_id = booking_id;
        this.booking_date = booking_date;
        this.booking_reason = booking_reason;
        this.booking_description = booking_description;
        this.booking_status = booking_status;
        this.customerId = customerId;
    }

    public Booking(int booking_id, Date booking_date, String booking_reason, String booking_description, String booking_status, int customerId) {
        this.booking_id = booking_id;
        this.booking_date = booking_date;
        this.booking_reason = booking_reason;
        this.booking_description = booking_description;
        this.booking_status = booking_status;
        this.customerId = customerId;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public Date getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(Date booking_date) {
        this.booking_date = booking_date;
    }

    public String getBooking_reason() {
        return booking_reason;
    }

    public void setBooking_reason(String booking_reason) {
        this.booking_reason = booking_reason;
    }

    public String getBooking_description() {
        return booking_description;
    }

    public void setBooking_description(String booking_description) {
        this.booking_description = booking_description;
    }

    public String getBooking_status() {
        if (booking_status.equals("0")) {
            return "Processing";
        }
        if (booking_status.equals("1")) {
            return "Done";
        }
        if (booking_status.equals("2")) {
            return "Reject";
        }
        if (booking_status.equals("3")) {
            return "#";
        }
        return null;
    }

    public void setBooking_status(String booking_status) {
        this.booking_status = booking_status;
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

    @Override
    public String toString() {
        return "Booking{" + "booking_id=" + booking_id + ", booking_date=" + booking_date + ", booking_reason=" + booking_reason + ", booking_status=" + booking_status + ", customerId=" + customerId + ", customerName=" + customerName + '}';
    }

}
