/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import model.Account;
import model.Customer;

/**
 *
 * @author asus
 */
public class EditProfileServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        dao.UpDateProfile(customerName, customerAddress, date, customerPhone, customerGender, "0", aid);
          Customer c = dao.getCustomerByID(aid);
        session.setAttribute("customer", c);
        response.sendRedirect("profile");

        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
