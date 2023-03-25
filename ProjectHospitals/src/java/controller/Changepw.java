/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Account;

/**
 *
 * @author Le Duong
 */
@WebServlet(name = "Changepw", urlPatterns = {"/changepw"})
public class Changepw extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Changepw.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("user");
        String oldpass = request.getParameter("oldpass");
        String pass = request.getParameter("pass");
        String repass = request.getParameter("repass");
        AccountDAO dao = new AccountDAO();
        Account a = dao.checkAccountExits(user);

        if (a == null) {
            request.setAttribute("error", "Account does not exist!");
            request.getRequestDispatcher("Changepw.jsp").forward(request, response);
        } else {
            if (!oldpass.equals(a.getAccountWord())) {
                request.setAttribute("error", "Old password is not match");
                request.getRequestDispatcher("Changepw.jsp").forward(request, response);
            } else {
                if (!pass.equals(repass)) {
                    request.setAttribute("error", "Password and confirm password does not match");
                    request.getRequestDispatcher("Changepw.jsp").forward(request, response);
                } else {
                    dao.UpDatePassWord(pass, user);
                    request.setAttribute("error", "Change Password successfully!");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }

            }

        }

    }
}
