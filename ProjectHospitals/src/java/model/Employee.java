package model;

import java.sql.Date;

public class Employee {

    private int employee_id;
    private String employee_name;
    private String employee_address;
    private Date employee_birth;
    private String employee_phone;
    private String employee_gender;
    private int employee_salary;
    private String employee_worktime;
    private int account_id;

    public Employee() {
    }

    public Employee(int employee_id, String employee_name, String employee_address, Date employee_birth, String employee_phone, String employee_gender, int employee_salary, String employee_worktime, int account_id) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_address = employee_address;
        this.employee_birth = employee_birth;
        this.employee_phone = employee_phone;
        this.employee_gender = employee_gender;
        this.employee_salary = employee_salary;
        this.employee_worktime = employee_worktime;
        this.account_id = account_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_address() {
        return employee_address;
    }

    public void setEmployee_address(String employee_address) {
        this.employee_address = employee_address;
    }

    public Date getEmployee_birth() {
        return employee_birth;
    }

    public void setEmployee_birth(Date employee_birth) {
        this.employee_birth = employee_birth;
    }

    public String getEmployee_phone() {
        return employee_phone;
    }

    public void setEmployee_phone(String employee_phone) {
        this.employee_phone = employee_phone;
    }

    public String getEmployee_gender() {
        if (employee_gender.equals("0")) {
            return "Female";
        }
        if (employee_gender.equals("1")) {
            return "Male";
        }
        return null;
    }

    public void setEmployee_gender(String employee_gender) {
        this.employee_gender = employee_gender;
    }

    public int getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(int employee_salary) {
        this.employee_salary = employee_salary;
    }

    public String getEmployee_worktime() {
        return employee_worktime;
    }

    public void setEmployee_worktime(String employee_worktime) {
        this.employee_worktime = employee_worktime;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    @Override
    public String toString() {
        return "Employee{" + "employee_id=" + employee_id + ", employee_name=" + employee_name + ", employee_address=" + employee_address + ", employee_birth=" + employee_birth + ", employee_phone=" + employee_phone + ", employee_gender=" + employee_gender + ", employee_salary=" + employee_salary + ", employee_worktime=" + employee_worktime + ", account_id=" + account_id + '}';
    }

}
