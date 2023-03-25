package controller;

import dao.AccountDAO;
import dao.BookingDAO;
import dao.CustomerDAO;
import dao.EmployeeDAO;
import dao.NewsDAO;
import dao.PayDAO;
import dao.ServiceDAO;
import dao.TestDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.Account;
import model.Booking;
import model.Customer;
import model.Employee;
import model.News;
import model.Pay;
import model.Service;
import model.TestCategory;

public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String method = request.getParameter("method");
        //chức năng search của customer
        if (method != null && method.equals("customerSearch")) {
            ServiceDAO daos = new ServiceDAO();
            NewsDAO daon = new NewsDAO();
            String keyword = request.getParameter("keyword");
            List<Service> listService = daos.search(keyword);
            List<News> listNews = daon.search(keyword);
            request.setAttribute("listService", listService);
            request.setAttribute("listNews", listNews);
            request.getRequestDispatcher("Search.jsp").forward(request, response);
        } //tìm kiếm account
        else if (method != null && method.equals("searchAccount")) {
            AccountDAO daoa = new AccountDAO();
            String keyword = request.getParameter("keyword");
            List<Account> listAccount = daoa.search(keyword);
            request.setAttribute("listAccount", listAccount);
            request.getRequestDispatcher("ManagementAccount.jsp").forward(request, response);
        } //tìm kiếm customer
        else if (method != null && method.equals("searchCustomer")) {
            CustomerDAO daoc = new CustomerDAO();
            String keyword = request.getParameter("keyword");
            List<Customer> listCustomer = daoc.search(keyword);
            request.setAttribute("listCustomer", listCustomer);
            request.getRequestDispatcher("ManagementCustomer.jsp").forward(request, response);
        } //tìm kiếm employee
        else if (method != null && method.equals("searchEmployee")) {
            EmployeeDAO daoe = new EmployeeDAO();
            String keyword = request.getParameter("keyword");
            List<Employee> listEmployee = daoe.search(keyword);
            request.setAttribute("listEmployee", listEmployee);
            request.getRequestDispatcher("ManagementEmployee.jsp").forward(request, response);
        } //tìm kiếm booking 
        else if (method != null && method.equals("searchBooking")) {
            BookingDAO daob = new BookingDAO();
            String keyword = request.getParameter("keyword");
            List<Booking> listBooking = daob.search(keyword);
            request.setAttribute("listBooking", listBooking);
            request.getRequestDispatcher("ManagementBooking.jsp").forward(request, response);
        } //tìm kiếm service
        else if (method != null && method.equals("searchService")) {
            ServiceDAO daos = new ServiceDAO();
            String keyword = request.getParameter("keyword");
            List<Service> listService = daos.search(keyword);
            request.setAttribute("sl", listService);
            request.getRequestDispatcher("ManagementService.jsp").forward(request, response);
        } //tìm kiếm test category 
        else if (method != null && method.equals("searchCategoryTest")) {
            TestDAO daot = new TestDAO();
            String keyword = request.getParameter("keyword");
            List<TestCategory> listTest = daot.search(keyword);
            request.setAttribute("listTest", listTest);
            request.getRequestDispatcher("ManagementCateTest.jsp").forward(request, response);
        }
        //tìm ki?m pay
        else if (method != null && method.equals("searchPay")) {
            PayDAO daop = new PayDAO();
            String keyword = request.getParameter("keyword");
            List<Pay> listPay = daop.search(keyword);
            request.setAttribute("listPay", listPay);
            request.getRequestDispatcher("ManagementPay.jsp").forward(request, response);
        }
        //tìm ki?m medical record
        else if (method != null && method.equals("searchMedicalRecord")) {
            CustomerDAO daoc = new CustomerDAO();
            String keyword = request.getParameter("keyword");
            List<Customer> listCustomer = daoc.searchrecord(keyword);
            request.setAttribute("listCustomer", listCustomer);
            request.getRequestDispatcher("ManagementMedicalRecord.jsp").forward(request, response);
        }

    }
}
