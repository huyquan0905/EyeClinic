/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.CustomerDAO;
import dao.ExamDAO;
import dao.PreDAO;
import dao.TestDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Customer;
import model.Exam;
import model.Prescription;
import model.Test;

/**
 *
 * @author Hi! Le Minh Hieu
 */
public class PrescriptionMedicalServlet extends HttpServlet {
   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
         CustomerDAO dao = new CustomerDAO();
         TestDAO daot = new TestDAO();
         ExamDAO daox = new ExamDAO();
          PreDAO daop = new PreDAO();
         String id = request.getParameter("cid");
         int customerId = Integer.parseInt(id);
         Customer cus = dao.getCusSer(customerId);
         List<Test> test = daot.getCusTest(customerId);
         Exam exam = daox.getExamBycId(customerId);
          List<Prescription> lisrPres = daop.getListPres(customerId);
         request.setAttribute("listPres", lisrPres);
         request.setAttribute("test", test);
         request.setAttribute("customer", cus);
         request.setAttribute("exam", exam);
         request.getRequestDispatcher("PrescriptionMedical.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8"); 
         String check = request.getParameter("1");
         
         if("add".equals(check)){
             String cid = request.getParameter("cid");
             String name = request.getParameter("presname");
         String quantity = request.getParameter("presquantity");
         int quantity1 = Integer.parseInt(quantity);
         String note = request.getParameter("presnote");
         
         int cid1 = Integer.parseInt(cid);
         PreDAO daop = new PreDAO();
         daop.InsertPres(name, quantity1, cid1, note);
         response.sendRedirect("prescription_medical_servlet?cid="+cid);
         }
         else if("next".equals(check)){
             String cid = request.getParameter("cid");
             response.sendRedirect("complete_medical_servlet?cid="+cid);
         }
         
        
    }

   
}
