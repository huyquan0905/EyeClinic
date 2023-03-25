/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.PayDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import model.Pay;

/**
 *
 * @author Hi! Le Minh Hieu
 */
public class ApprovePayServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PayDAO dao = new PayDAO();
        List<Pay> listPay = dao.getPay();
        request.setAttribute("listPay", listPay);
        request.getRequestDispatcher("ApprovePaying.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("pid");
        PayDAO dao = new PayDAO();
        int id1 = Integer.parseInt(id);
        dao.UpdatePay(id1);
        response.sendRedirect("approve_pay_servlet");

    }

}
