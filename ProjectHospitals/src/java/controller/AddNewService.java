/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ServiceDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Service;

/**
 *
 * @author hp
 */
@WebServlet(name = "AddService", urlPatterns = {"/management_service"})
public class AddNewService extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServiceDAO dao = new ServiceDAO();
        List<Service> sl = dao.getListService();
        request.setAttribute("sl", sl);
        request.getRequestDispatcher("ManagementService.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServiceDAO dao = new ServiceDAO();
        String name = request.getParameter("name");
        String detail = request.getParameter("detail");
        String price = request.getParameter("price");
        String img = request.getParameter("img");
        int prices = Integer.parseInt(price);

        dao.InsertService(name, detail, prices, img);
        response.sendRedirect("management_service");
    }

}
