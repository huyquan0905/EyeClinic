/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.TestDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.TestCategory;


public class ManageCategoryTest extends HttpServlet {

   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            TestDAO tdao = new TestDAO();
            List<TestCategory>  listTest = tdao.getListCategoryTest();
            request.setAttribute("listTest",listTest);
            
            
            request.getRequestDispatcher("ManagementCateTest.jsp").forward(request, response);
            
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String name = request.getParameter("name");
         String price = request.getParameter("price");
         int price1 = Integer.parseInt(price);
         String image = request.getParameter("img");
         TestDAO tdao = new TestDAO();
         tdao.InsertTestCategory(name, image, price1);
         response.sendRedirect("manage_category_test");
         
      
    }

  
 

}
