/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CustomerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Customer;

/**
 *
 * @author admin
 */
@WebServlet(name = "ManageCustomer", urlPatterns = {"/manage_customer"})
public class ManageCustomer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        CustomerDAO dao = new CustomerDAO();
        String index = request.getParameter("index");
        int index1 = Integer.parseInt(index);
        int countCus = dao.countCustomer();
        int endPage = countCus/10;
        if(countCus%5!=10){
            endPage++;
        }
        List<Customer> listCustomer = dao.pageCustomer(index1);
        request.setAttribute("page", endPage);
        request.setAttribute("listCustomer", listCustomer);
        request.getRequestDispatcher("ManagementCustomer.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

}
