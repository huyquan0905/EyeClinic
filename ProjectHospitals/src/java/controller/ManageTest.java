/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.TestDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import model.Account;
import model.Customer;
import model.Test;

/**
 *
 * @author admin
 */
@WebServlet(name="ManageTest", urlPatterns={"/manage_test"})
public class ManageTest extends HttpServlet {
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");   
         TestDAO dao = new TestDAO();
         String index = request.getParameter("index");
        int index1 = Integer.parseInt(index);
        int count = dao.countTest();
        int endPage = count/10;
        if(count%10!=0){
            endPage++;
        }
         request.setAttribute("page", endPage);
         List<Test> listTest = dao.getListCusTest();
         request.setAttribute("listTest", listTest);
         request.getRequestDispatcher("ManagementTest.jsp").forward(request, response);
           
           
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
         
    }


}