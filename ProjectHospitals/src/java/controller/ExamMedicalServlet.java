/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.CustomerDAO;
import dao.ExamDAO;
import dao.TestDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import model.Customer;
import model.Test;

/**
 *
 * @author Hi! Le Minh Hieu
 */
public class ExamMedicalServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         CustomerDAO dao = new CustomerDAO();
         TestDAO daot = new TestDAO();
        String id = request.getParameter("cid");
        int customerId = Integer.parseInt(id);
         Customer cus = dao.getCusSer(customerId);
         List<Test> test = daot.getCusTest(customerId);
         request.setAttribute("test", test);
         request.setAttribute("customer", cus);
        request.getRequestDispatcher("ExaminationMedical.jsp").forward(request, response);
    } 

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ExamDAO daox = new ExamDAO();
        String conclusion = request.getParameter("conclusion");
        java.util.Date currentDate = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = formatter.format(currentDate);
        Date date2 = Date.valueOf(date1);
        String cid = request.getParameter("cid");
        int cid1 = Integer.parseInt(cid);
        daox.InsertExam(conclusion, date2, cid1);
        response.sendRedirect("prescription_medical_servlet?cid="+cid);
    }

}
