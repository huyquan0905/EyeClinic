/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AccountDAO;
import dao.CustomerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import model.Account;
import model.Customer;
import model.EncryptPass;

/**
 *
 * @author admin
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.getRequestDispatcher("Login.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String usename = request.getParameter("user");
        String password = request.getParameter("pass");
        AccountDAO dao = new AccountDAO();
        EncryptPass md5 = new EncryptPass();
        CustomerDAO daoc = new CustomerDAO();
        String password1 = md5.convertHashToString(password);
        Account a = dao.login(usename, password1);                     
        HttpSession session = request.getSession();
        int aid = a.getAccountId();
        if (a == null) {
            request.setAttribute("error", "Username or Password is wrong");           
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else {            
            session.setAttribute("account", a);          
            session.setMaxInactiveInterval(24*60*60);
            Customer c = daoc.getCustomerByID(aid);
            session.setAttribute("customer", c);
            response.sendRedirect("home");

        }
    }
}
