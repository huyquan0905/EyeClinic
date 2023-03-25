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

/**
 *
 * @author asus
 */
public class EditCategoryTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String name = request.getParameter("name");
         String price = request.getParameter("price");
         int price1 = Integer.parseInt(price);
         String image = request.getParameter("img");
         String tid = request.getParameter("tid");
          int tid1 = Integer.parseInt(tid);
         TestDAO tdao = new TestDAO();
         tdao.EditCategoryTest(name, image, price1,tid1);
         response.sendRedirect("manage_category_test");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
