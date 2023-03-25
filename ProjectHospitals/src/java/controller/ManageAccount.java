/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AccountDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.Account;

/**
 *
 * @author Hi! Le Minh Hieu
 */
@WebServlet(name = "ManageAccount", urlPatterns = {"/manage_account"})
public class ManageAccount extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        AccountDAO dao = new AccountDAO();
        String index = request.getParameter("index");
        int index1 = Integer.parseInt(index);
        int count = dao.countAccount();
        int endPage = count/10;
        if(count%5!=10){
            endPage++;
        }
        request.setAttribute("page", endPage);
        List<Account> listAccount = dao.pageAccount(index1);
        request.setAttribute("listAccount", listAccount);
        request.getRequestDispatcher("ManagementAccount.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        AccountDAO dao = new AccountDAO();
        String username = request.getParameter("usename");
        String pass = request.getParameter("password");
        String role = request.getParameter("role");
        int roles = Integer.parseInt(role);
        String index = request.getParameter("index");
        dao.InsertAccount(username, pass, roles);
        response.sendRedirect("manage_account?index=1");

    }

}
