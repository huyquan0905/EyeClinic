/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.CustomerDAO;
import dao.EmployeeDAO;
import dao.PayDAO;
import dao.ServiceDAO;
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
public class AdminServlet extends HttpServlet {
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        CustomerDAO daoc = new CustomerDAO();
        int countCus = daoc.countCustomer();
        EmployeeDAO daoe = new EmployeeDAO();
        int countEmp = daoe.countEmployee();
        ServiceDAO daos = new ServiceDAO();
        int countSer = daos.countService();
         PayDAO dao = new PayDAO();
        List<Pay> listPay = dao.getPay();
        int totalRevenue = 0;
        for (Pay pay : listPay) {
            if(pay.getPayStatus().equals("Paid")){
                totalRevenue+=pay.getPayTotal();
            }
            
        }
         Locale vn = new Locale("vi", "VN");
         NumberFormat nvn = NumberFormat.getInstance(vn);
         String str = nvn.format(totalRevenue);
        request.setAttribute("totalRevenue", str);
        request.setAttribute("countCus", countCus);
        request.setAttribute("countEmp", countEmp);
        request.setAttribute("countSer", countSer);
        request.getRequestDispatcher("AdminDashboard.jsp").forward(request, response);
    } 


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
    }

   

}
