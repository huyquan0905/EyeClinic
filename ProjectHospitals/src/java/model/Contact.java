package model;

import java.sql.Date;

public class Contact {

    private int contact_id;
    private String contact_mess;
    private String contact_reply;
    private String contact_priority;
    private Date contact_date;
    private String contact_status;
    private int customer_id;

    public Contact() {
    }

    public Contact(int contact_id, String contact_mess, String contact_reply, String contact_priority, Date contact_date, String contact_status, int customer_id) {
        this.contact_id = contact_id;
        this.contact_mess = contact_mess;
        this.contact_reply = contact_reply;
        this.contact_priority = contact_priority;
        this.contact_date = contact_date;
        this.contact_status = contact_status;
        this.customer_id = customer_id;
    }

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public String getContact_mess() {
        return contact_mess;
    }

    public void setContact_mess(String contact_mess) {
        this.contact_mess = contact_mess;
    }

    public String getContact_reply() {
        return contact_reply;
    }

    public void setContact_reply(String contact_reply) {
        this.contact_reply = contact_reply;
    }

    public String getContact_priority() {
        return contact_priority;
    }

    public void setContact_priority(String contact_priority) {
        this.contact_priority = contact_priority;
    }

    public Date getContact_date() {
        return contact_date;
    }

    public void setContact_date(Date contact_date) {
        this.contact_date = contact_date;
    }

    public String getContact_status() {
        return contact_status;
    }

    public void setContact_status(String contact_status) {
        this.contact_status = contact_status;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    @Override
    public String toString() {
        return "Contact{" + "contact_id=" + contact_id + ", contact_mess=" + contact_mess + ", contact_reply=" + contact_reply + ", contact_priority=" + contact_priority + ", contact_date=" + contact_date + ", contact_status=" + contact_status + ", customer_id=" + customer_id + '}';
    }

}
