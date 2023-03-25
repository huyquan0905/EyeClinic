package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Employee;

public class EmployeeDAO extends ConnectMySQL {

    public List<Employee> getListEmployee() {
        List<Employee> employeeList = new ArrayList<Employee>();
        String sql = "select * from employee";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                employeeList.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getInt(9)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public void EditEmployee(String name, String address, Date birth, String phone, String gender, int salary, String worktime, int eid) {
        String sql = "  UPDATE employee  set employee_name= ?   ,employee_address = ? \n"
                + "  ,employee_birth = ?   ,employee_phone = ?, employee_gender = ?, employee_salary = ?, employee_worktime = ?\n"
                + "  where employee_id = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setDate(3, birth);
            ps.setString(4, phone);
            ps.setString(5, gender);
            ps.setInt(6, salary);
            ps.setString(7, worktime);
            ps.setInt(8, eid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        String sql = "delete from employee where employee_id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Employee> search(String keyword) {
        List<Employee> list = new ArrayList<>();
        try {
            String sql = "select *  from employee where employee_name like ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployee_id(rs.getInt(1));
                employee.setEmployee_name(rs.getString(2));
                employee.setEmployee_address(rs.getString(3));
                employee.setEmployee_birth(rs.getDate(4));
                employee.setEmployee_phone(rs.getString(5));
                employee.setEmployee_gender(rs.getString(6));
                employee.setEmployee_salary(rs.getInt(7));
                employee.setEmployee_worktime(rs.getString(8));
                employee.setAccount_id(rs.getInt(9));
                list.add(employee);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public int countEmployee(){  
         String sql = "select count(*) from Employee";
         try {
            

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
              return rs.getInt(1);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
        
    }
    
}
