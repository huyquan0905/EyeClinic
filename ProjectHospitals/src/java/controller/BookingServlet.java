package controller;

import dao.BookingDAO;
import dao.CustomerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import model.Account;
import model.Customer;

@WebServlet(name = "BookingServlet", urlPatterns = {"/booking"})
public class BookingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        CustomerDAO dao = new CustomerDAO();
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account");
        int id = a.getAccountId();
        Customer cus = dao.ViewProfile(id);
        request.setAttribute("customer", cus);
        request.getRequestDispatcher("Booking.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String reason = request.getParameter("reason");
        String description = request.getParameter("description");
        String id = request.getParameter("bid");
        String date = request.getParameter("date");
        Date date1 = Date.valueOf(date);     
        int bid = Integer.parseInt(id);
        BookingDAO dao = new BookingDAO();
        dao.BookingInsert(reason, description, date1, bid);
        response.sendRedirect("home");
    }
}
