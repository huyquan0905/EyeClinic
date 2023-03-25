/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.CustomerDAO;
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
import model.Test;
import model.TestCategory;

/**
 *
 * @author Hi! Le Minh Hieu
 */
public class ListTestCateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        TestDAO daotc = new TestDAO();
        List<TestCategory> listCate = daotc.getListCategoryTest();

        CustomerDAO dao = new CustomerDAO();
        String id = request.getParameter("cid");
        int customerId = Integer.parseInt(id);
        Customer cus = dao.getCusSer(customerId);
        List<Test> listTest = daotc.getListCustomerTest(customerId);
        request.setAttribute("listTest", listTest);
        request.setAttribute("customer", cus);
        request.setAttribute("listCate", listCate);
        request.getRequestDispatcher("TestCategoryMedical.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        TestDAO daot = new TestDAO();
        String check = request.getParameter("1");

        if ("add".equals(check)) {
            String cid = request.getParameter("cid");
            String tid = request.getParameter("tid");
            int cid1 = Integer.parseInt(cid);
            int tid1 = Integer.parseInt(tid);
            if(!tid.equals("Choose Test")){
                daot.InsertCusTest(cid1, tid1);
            }
            
            response.sendRedirect("list_test_cate_servlet?cid=" + cid);
        } else if ("next".equals(check)) {

            CustomerDAO dao = new CustomerDAO();
            String cid = request.getParameter("cid");
            
            String testID = request.getParameter("testID");
            if(testID!=null){
            int cid1 = Integer.parseInt(cid);
            dao.UpDateStatus("1", cid1);
            response.sendRedirect("listcustomer");
                
            }else{
                 response.sendRedirect("list_test_cate_servlet?cid="+cid);
            }
           

        }

    }

}
