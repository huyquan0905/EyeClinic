/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.BookingDAO;
import dao.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Hi! Le Minh Hieu
 */
public class CheckPatient extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CustomerDAO daoc = new CustomerDAO();
        String bid = request.getParameter("bid");
        int bid1 = Integer.parseInt(bid);
        if (bid != null) {
            BookingDAO daob = new BookingDAO();
            daob.Check(bid1);
        }
        String cid = request.getParameter("cid");
        int cid1 = Integer.parseInt(cid);

        daoc.UpDateStatus("6", cid1);

        response.sendRedirect("register_patient_servlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
