/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountDAO;
import dao.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;
import model.Account;
import model.Customer;
import model.EncryptPass;

/**
 *
 * @author Hi! Le Minh Hieu
 */
public class RegisterPatientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CustomerDAO daoc = new CustomerDAO();

        List<Customer> listCusBook = daoc.getListCusBook();
        List<Customer> listCusRe = daoc.getCustomerByStatus("5");
        request.setAttribute("listCusBook", listCusBook);
        request.setAttribute("listCusRe", listCusRe);

        request.getRequestDispatcher("RegisterPatient.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String birth = request.getParameter("birth");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        Date birth1 = Date.valueOf(birth);
        AccountDAO daoa = new AccountDAO();
        EncryptPass md5 = new EncryptPass();
        String pass1 = md5.convertHashToString(passWord);
        
        Account a = daoa.checkAccountExits(userName);
        if (a == null) {
            daoa.InsertAccount(userName, pass1, 0);
            int id = daoa.SelectAccount(userName);           
            CustomerDAO daoc = new CustomerDAO();
            daoc.InsertProfile(name, address, birth1, phone, gender, "5", id);
            response.sendRedirect("register_patient_servlet");
        } else {
            request.setAttribute("error", "Username already exists !!!");
            response.sendRedirect("register_patient_servlet");
        }

    }

}
