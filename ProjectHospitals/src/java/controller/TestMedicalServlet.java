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
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import model.Customer;
import model.Test;

/**
 *
 * @author Hi! Le Minh Hieu
 */
public class TestMedicalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        CustomerDAO dao = new CustomerDAO();
        TestDAO daot = new TestDAO();
        String id = request.getParameter("cid");
        int customerId = Integer.parseInt(id);
        Customer cus = dao.getCusSer(customerId);
        String tid = request.getParameter("tid");
        int tid1 = Integer.parseInt(tid);
        Test test = daot.getTest(tid1);
        request.setAttribute("listTest", test);
        request.setAttribute("customer", cus);
        request.getRequestDispatcher("TestMedical.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String result = request.getParameter("testresult");
       
        String tid = request.getParameter("tid");
        String cid = request.getParameter("cid");
        int tid1 = Integer.parseInt(tid);
        int cid1 = Integer.parseInt(cid);
        TestDAO daot = new TestDAO();
        CustomerDAO daoc = new CustomerDAO();
        java.util.Date currentDate = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = formatter.format(currentDate);
        Date date2 = Date.valueOf(date1);
        daot.UpDateTestCus(result, date2, tid1);
        daoc.UpDateStatus("2", cid1);
        response.sendRedirect("test_customer_servlet?index=1");

    }

}
