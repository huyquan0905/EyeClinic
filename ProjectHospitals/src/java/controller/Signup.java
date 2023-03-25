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
import model.Account;
import model.EncryptPass;

/**
 *
 * @author admin
 */
@WebServlet(name="Signup", urlPatterns={"/signup"})
public class Signup extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.getRequestDispatcher("Signup.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
         String user = request.getParameter("user");
         String pass = request.getParameter("pass");
         String repass = request.getParameter("repass");
         AccountDAO dao = new AccountDAO();
         if(!pass.equals(repass)){
             request.setAttribute("error", "Password and confirm password does not match");
             request.getRequestDispatcher("Signup.jsp").forward(request, response);
         }else{
             Account a = dao.checkAccountExits(user);
             if(a==null){
                 request.setAttribute("error", "SignUp Suscessfully !!!");
                 EncryptPass md5 = new EncryptPass();
                  String pass1 = md5.convertHashToString(pass);
                 dao.signUp(user, pass1);
                 request.getRequestDispatcher("Login.jsp").forward(request, response);
             }else{
                  request.setAttribute("error", "Username already exists !!!");
                  request.getRequestDispatcher("Signup.jsp").forward(request, response);
             }
         }
    }
}