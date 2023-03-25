/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.UserGoogleDto;

/**
 *
 * @author Hi! Le Minh Hieu
 */
public class AccountDAO extends ConnectMySQL {

    public Account login(String user, String pass) {
        String sql = "select * from Account_Hospital where account_name = ? and account_password = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void signUp(String user, String pass) {
        String sql = "INSERT INTO `projectswp391`.`Account_Hospital` (account_name, account_password, role_admin, role_employee) VALUES (?,?,0,0);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Account checkAccountExits(String accountName) {
        String sql = "select * from Account_Hospital where account_name =?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, accountName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public void UpDatePassWord(String pass, String user) {
        try {
            String sql = "UPDATE Account_Hospital SET account_password = ? WHERE account_name  = ?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setString(2, user);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Account> getListAccount() {
        List<Account> listAccount = new ArrayList<>();
        String sql = "select * from Account_Hospital";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listAccount.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAccount;
    }

    public void InsertAccount(String name, String pass, int roleEmployee) {
        String sql = "INSERT INTO `projectswp391`.`Account_Hospital` (account_name, account_password, role_admin, role_employee) VALUES (?, ?, 0, ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pass);
            ps.setInt(3, roleEmployee);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteAccount(String id) {
        String sql = "delete from Account_Hospital where account_id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Account getAccountByID(int id) {
        String sql = "select * from Account_Hospital where account_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account getAccountByEmail(String email) {
        String sql = "select * from Account_Hospital where account_name = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Account> search(String keyword) {
        List<Account> list = new ArrayList<>();
        try {
            String sql = "select *  from account_hospital where account_name like ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setAccountId(rs.getInt(1));
                account.setAccountName(rs.getString(2));
                account.setAccountWord(rs.getString(3));
                account.setRoleAdmin(rs.getInt(4));
                account.setRoleEmployee(rs.getInt(5));
                list.add(account);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public int countAccount(){  
         String sql = "select count(*) from Account_hospital";
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
    public List<Account> pageAccount(int index){
         List<Account> listAccount = new ArrayList<>();
        String sql = "SELECT * FROM Account_hospital\n" +
"LIMIT 10 OFFSET ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, (index-1)*10);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listAccount.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAccount;
    }
    public int SelectAccount(String name) {
        String sql = "Select account_id from account_hospital where account_name = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
              return rs.getInt(1);

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
//        UserGoogleDto ug = dao.loginGoogle("hieulmhe163851@fpt.edu.vn");
//        Account a = dao.getAccountByID(6);
    int id = dao.SelectAccount("ace@g");
        System.out.println(id);

}
}