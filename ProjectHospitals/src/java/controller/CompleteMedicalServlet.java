/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.CustomerDAO;
import dao.ExamDAO;
import dao.PayDAO;
import dao.PreDAO;
import dao.ServiceDAO;
import dao.TestDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.xml.bind.ParseConversionEvent;
import model.Customer;
import model.Exam;
import model.Prescription;
import model.Service;
import model.Test;

/**
 *
 * @author Hi! Le Minh Hieu
 */
public class CompleteMedicalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        CustomerDAO dao = new CustomerDAO();
        TestDAO daot = new TestDAO();
        ExamDAO daox = new ExamDAO();
        PreDAO daop = new PreDAO();
        ServiceDAO daos = new ServiceDAO();
        String id = request.getParameter("cid");
        int customerId = Integer.parseInt(id);
        Customer cus = dao.getCusSer(customerId);
        List<Test> test = daot.getCusTest(customerId);
        int price1 = 0;
        for (Test test1 : test) {
            price1 += test1.getTestPrice();
        }
        Exam exam = daox.getExamBycId(customerId);
        List<Prescription> lisrPres = daop.getListPres(customerId);
        Service service = daos.getCusSer(customerId);
        int price2 = service.getServicePrice();
        int total = price1 + price2;
        Locale vn = new Locale("vi", "VN");
        NumberFormat nvn = NumberFormat.getInstance(vn);
        String str = nvn.format(total);
        request.setAttribute("listPres", lisrPres);
        request.setAttribute("test", test);
        request.setAttribute("customer", cus);
        request.setAttribute("exam", exam);
        request.setAttribute("service", service);
        request.setAttribute("total", str);
        request.setAttribute("total1", total);
        request.getRequestDispatcher("Complete.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PayDAO daog = new PayDAO();
        String total = request.getParameter("total");
        int total1 = Integer.parseInt(total);
        String cid = request.getParameter("cid");
        int cid1 = Integer.parseInt(cid);
        CustomerDAO dao = new CustomerDAO();
        dao.UpDateStatus("3", cid1);
        daog.InsertPay(total1, cid1);
        response.sendRedirect("admin");
    }

}
