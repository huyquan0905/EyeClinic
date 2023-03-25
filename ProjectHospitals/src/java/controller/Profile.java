package controller;

import dao.BookingDAO;
import dao.CustomerDAO;
import dao.ExamDAO;
import dao.PreDAO;
import dao.ServiceDAO;
import dao.TestDAO;

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
import model.Booking;
import model.Customer;
import model.Exam;
import model.Prescription;
import model.Service;
import model.Test;

/**
 *
 * @author Hi! Le Minh Hieu
 */
@WebServlet(name = "Profile", urlPatterns = {"/profile"})
public class Profile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        CustomerDAO dao = new CustomerDAO();
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account");
        int id = a.getAccountId();
        Customer cus = dao.ViewProfile(id);
        TestDAO daot = new TestDAO();
        ServiceDAO daos = new ServiceDAO();
        ExamDAO daoe = new ExamDAO();
        PreDAO daop = new PreDAO();
        if (cus != null) {
            Customer cus1 = dao.ViewProfile(id);
            
            int cid = cus1.getCustomerId();
            String customerId = Integer.toString(cid);
            Customer cuss = dao.getCusSer(cid);
            BookingDAO bdao = new BookingDAO();
            List<Booking> listBook = bdao.getListBookingId(customerId);
            List<Test> test = daot.getCusTest(cid);
            Service service = daos.getCusSer(cid);
            Exam exam = daoe.getExamBycId(cid);
            List<Prescription> lisrPres = daop.getListPres(cid);
            request.setAttribute("customer", cus1);
            request.setAttribute("customers", cuss);
            request.setAttribute("listBook", listBook);
            request.setAttribute("listPres", lisrPres);
            request.setAttribute("test", test);
            request.setAttribute("exam", exam);
            request.setAttribute("service", service);
        }
        request.getRequestDispatcher("Profile.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String customerName = request.getParameter("namecustomer");
        String customerAddress = request.getParameter("addresscustomer");
        String customerPhone = request.getParameter("phonecustomer");
        String customerBirth = request.getParameter("birthcustomer");
        Date date = Date.valueOf(customerBirth);
        String customerGender = request.getParameter("customergender");

        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account");
        CustomerDAO dao = new CustomerDAO();
        int aid = a.getAccountId();
        dao.InsertProfile(customerName, customerAddress, date, customerPhone, customerGender, "0", aid);
        Customer c = dao.getCustomerByID(aid);
        session.setAttribute("customer", c);
        response.sendRedirect("profile");

    }

}
