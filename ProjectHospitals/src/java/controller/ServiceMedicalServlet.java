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
public class ServiceMedicalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        CustomerDAO dao = new CustomerDAO();
        ServiceDAO daos = new ServiceDAO();
        List<Service> listService = daos.getListService();
        request.setAttribute("listService", listService);
        String id = request.getParameter("cid");
        int cid = Integer.parseInt(id);
        Customer cus = dao.getCustomerByCusID(cid);
        request.setAttribute("customer", cus);
        request.getRequestDispatcher("ServiceMedical.jsp").forward(request, response);
    } 

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
         CustomerDAO dao = new CustomerDAO();
         String cid = request.getParameter("cid");
         int customerId = Integer.parseInt(cid);
         String serId = request.getParameter("sid");
         if(serId.equals("Choose Service")){
             request.setAttribute("error", "You must choosen service!!!");
             response.sendRedirect("service_medical_servlet?cid="+cid);
         }else{
         int serviceId = Integer.parseInt(serId);        
         dao.InsertCusSer(customerId, serviceId);
         response.sendRedirect("list_test_cate_servlet?cid="+cid);
         }
       
         
        
    }

   

}
