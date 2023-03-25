package controller;

import dao.EmployeeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;
import model.Employee;

public class EditEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EmployeeDAO dao = new EmployeeDAO();
        List<Employee> listEmployee = dao.getListEmployee();
        request.setAttribute("listEmployee", listEmployee);
        request.getRequestDispatcher("ManagementEmployee.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EmployeeDAO dao = new EmployeeDAO();
        String eid = request.getParameter("eid");
        int id = Integer.parseInt(eid);
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String birth = request.getParameter("birth");
        Date birth1 = Date.valueOf(birth);
        String gender = request.getParameter("gender");
        String salary = request.getParameter("salary");
        int salary1 = Integer.parseInt(salary);
        String workTime = request.getParameter("wtime");
        dao.EditEmployee(name, address, birth1, phone, gender, salary1, workTime, id);
        response.sendRedirect("management_employee_servlet");

    }
}
