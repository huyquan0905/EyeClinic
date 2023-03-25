/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.CustomerDAO;
import dao.ServiceDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Customer;
import model.Service;

/**
 *
 * @author Hi! Le Minh Hieu
 */
public class ManageMedicalRecord extends HttpServlet {
   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       CustomerDAO dao = new CustomerDAO();
       ServiceDAO daos = new ServiceDAO();

        List<Customer> listCustomer = dao.getCustomerByStatus("3");


        request.setAttribute("listCustomer", listCustomer);
        request.getRequestDispatcher("ManagementMedicalRecord.jsp").forward(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String id = request.getParameter("cid");
        response.sendRedirect("view_record_servlet?cid="+id);
    }

}
