/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author Admin
 */
@WebServlet(name = "EditService", urlPatterns = {"/edit_service"})
public class EditService extends HttpServlet {

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
       
        String sid =  request.getParameter("id");
        int id = Integer.parseInt(sid);
        String name = request.getParameter("name");
        String detail = request.getParameter("detail");
        String price = request.getParameter("price");
        String img = request.getParameter("img");
        int prices = Integer.parseInt(price);
        dao.EditService(name, detail, prices, img, id);
        response.sendRedirect("management_service");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
