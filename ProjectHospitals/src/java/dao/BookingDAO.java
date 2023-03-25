    package dao;

import controller.BookingServlet;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import model.Booking;
import model.Service;

public class BookingDAO extends ConnectMySQL {

    public void BookingInsert(String reason, String description, Date date, int id) {
        String sql = "INSERT INTO `projectswp391`.`Booking` (booking_reason, booking_description, booking_date, booking_status, customer_id) VALUES (?,?,?,0,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, reason);
            ps.setString(2, description);
            ps.setDate(3, date);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Booking> getBookingCus() {
        List<Booking> listBooking = new ArrayList<>();
        String sql = "select Customer.customer_id, Customer.customer_name, Booking.booking_id, Booking.booking_date, Booking.booking_reason, Booking.booking_status From Customer inner join Booking on Customer.customer_id = Booking.customer_id";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
//                listBooking.add(new Booking(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getString(5), rs.getString(6)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBooking;
    }

    public List<Booking> getListBookingId(String customerId) {
        List<Booking> listBook = new ArrayList<>();
        String sql = "SELECT * FROM BOOKING WHERE customer_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, customerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listBook.add(new Booking(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBook;
    }

    public List<Booking> getListBooking() {
        List<Booking> listBooking = new ArrayList<>();
        String sql = "select * from booking";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listBooking.add(new Booking(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBooking;
    }

    public void EditBooking(int booking_id, Date booking_date, String booking_reason, String booking_status, int customerId) {
        String sql = "INSERT INTO `projectswp391`.`Booking` (booking_id, booking_date, booking_reason, booking_status, customer_id) VALUES (?,?,?,0,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, booking_id);
            ps.setDate(2, booking_date);
            ps.setString(3, booking_reason);
            ps.setString(4, booking_status);
            ps.setInt(5, customerId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DoneBooking(int booking_id) {
        String sql = "UPDATE Booking SET booking_status = 1 WHERE booking_id  = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, booking_id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void RejectBooking(int booking_id) {
        String sql = "UPDATE Booking SET booking_status = 2 WHERE booking_id  = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, booking_id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Check(int cid) {
        String sql = "UPDATE Booking SET booking_status = 3 WHERE booking_id  = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void DeleteBooking(String id) {
        String sql = "delete from booking where booking_id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Booking> search(String keyword) {
        List<Booking> list = new ArrayList<>();
        try {
            String sql = "select Customer.customer_id, Customer.customer_name, Booking.booking_id, Booking.booking_date, Booking.booking_reason, Booking.booking_status  from booking inner join customer on booking.customer_id = customer.customer_id where customer_name like ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Booking booking = new Booking();
                booking.setCustomerId(rs.getInt(1));
                booking.setCustomerName(rs.getString(2));
                booking.setBooking_id(rs.getInt(3));
                booking.setBooking_date(rs.getDate(4));
                booking.setBooking_reason(rs.getString(5));
                booking.setBooking_status(rs.getString(6));
                list.add(booking);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    

}
