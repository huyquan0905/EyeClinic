/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AccountDAO;
import dao.CustomerDAO;
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

/**
 *
 * @author admin
 */
@WebServlet(name = "DeleteAccount", urlPatterns = {"/delete_account"})
public class DeleteAccount extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        AccountDAO dao = new AccountDAO();
        CustomerDAO daoc = new CustomerDAO();
        String aid = request.getParameter("aid");
        int id = Integer.parseInt(aid);
        List<Account> listAccount = dao.getListAccount();
        Account account = dao.getAccountByID(id);

        daoc.DeleteCustomer(aid);
        dao.DeleteAccount(aid);
        request.setAttribute("listAccount", listAccount);
        response.sendRedirect("manage_account?index=1");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

}
