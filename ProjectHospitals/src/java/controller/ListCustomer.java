/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.CustomerDAO;
import dao.TestDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Customer;
import model.Test;

/**
 *
 * @author Hi! Le Minh Hieu
 */
public class ListCustomer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        CustomerDAO dao = new CustomerDAO();
        TestDAO daot = new TestDAO();
         List<Test> listTest = daot.groupByCusTest();
         List<Test> listTest1 = new ArrayList<>();
         for (Test test : listTest) {
            int countCus = daot.getCountCustomer(test.getCustomerId());
            int countStatus = daot.getCountStatus(test.getCustomerId());
            if(countCus==countStatus){     
                listTest1.add(test);
            }
            
        }
            int countCustomer = 0;
         for (Test test : listTest1) {
            if(test.getCustomerStatus().equals("Done Test")){
                countCustomer++;
         }
        }
        
        List<Customer> listCustomer = dao.getCustomerByStatus("6");
        request.setAttribute("countCus", countCustomer);
        request.setAttribute("listCustomer", listCustomer);
        request.getRequestDispatcher("ListCustomer.jsp").forward(request, response);
    } 

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8"); 
       
    }
}
