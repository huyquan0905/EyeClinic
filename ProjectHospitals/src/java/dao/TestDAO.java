/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaGrammar;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import model.Customer;
import model.Service;
import model.Test;
import model.TestCategory;

/**
 *
 * @author Hi! Le Minh Hieu
 */
public class TestDAO extends ConnectMySQL {

    public void InsertCusTest(int customerId, int customerCateId) {
        String sql = "INSERT INTO `projectswp391`.`testresult` (test_status, customer_id, testcategory_id) VALUES (0, ?, ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, customerId);
            ps.setInt(2, customerCateId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Test> getCusTest(int customerId) {
        List<Test> listTest = new ArrayList<>();
        String sql = "select testcategory.test_name, testcategory.test_price, testresult.result_test, testresult.date_test\n"
                + "from testresult inner join testcategory\n"
                + "on testresult.testcategory_id = testcategory.testcategory_id\n"
                + "where testresult.customer_id = ?; ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listTest.add(new Test(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getDate(4))) ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTest;

    }

    public List<Test> getListCusTest() {
        List<Test> testList = new ArrayList<>();
        String sql = "select customer.customer_id, customer.customer_name, testcategory.test_name, testcategory.test_price, testresult.test_id, testresult.result_test, testresult.date_test, testresult.test_status\n"
                + "from testresult inner join testcategory\n"
                + "inner join customer \n"
                + "on testresult.customer_id = customer.customer_id\n"
                + "and testresult.testcategory_id = testcategory.testcategory_id where testresult.test_status = 0 order by customer.customer_id ; ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
      
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                testList.add(new Test(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getDate(7), rs.getString(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testList;

    }

    public List<TestCategory> getListCategoryTest() {
        List<TestCategory> testList = new ArrayList<>();
        String sql = "select * from testcategory";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                testList.add(new TestCategory(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testList;

    }

    public Test getTest(int tid) {
        String sql = "select customer.customer_id, customer.customer_name, testcategory.test_name, testcategory.test_price, testresult.test_id, testresult.result_test, testresult.date_test, testresult.test_status\n"
                + "from testresult inner join testcategory\n"
                + "inner join customer \n"
                + "on testresult.customer_id = customer.customer_id\n"
                + "and testresult.testcategory_id = testcategory.testcategory_id \n"
                + "where testresult.test_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, tid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Test(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getDate(7), rs.getString(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public void InsertTestCategory(String name, String image, int price) {
        String sql = "INSERT INTO `projectswp391`.`testcategory` (test_name, test_image,test_price ) VALUES (?, ?, ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setInt(3, price);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void DeleteCategoryTest(String tid) {
        String sql = "  DELETE FROM testcategory WHERE testcategory_id =?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, tid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void EditCategoryTest(String name, String img, int price, int tid) {
        String sql = "  UPDATE testcategory  set test_name= ?   ,test_image = ? \n"
                + "  ,test_price = ? \n"
                + "  where testcategory_id = ?;";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, img);
            ps.setInt(3, price);

            ps.setInt(4, tid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpDateTestCus(String result, Date date, int tid) {
        try {
            String sql = "UPDATE testresult SET result_test = ?, date_test = ?, test_status=1 WHERE test_id  = ?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, result);
            ps.setDate(2, date);
            ps.setInt(3, tid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Test> getListCustomerTest(int cid) {
        List<Test> testList = new ArrayList<>();
        String sql = "select customer.customer_id, customer.customer_name,testcategory.test_name, testcategory.test_price, testresult.test_id, testresult.result_test, testresult.date_test, testresult.test_status\n"
                + "from testresult inner join testcategory\n"
                + "inner join customer \n"
                + "on testresult.customer_id = customer.customer_id\n"
                + "and testresult.testcategory_id = testcategory.testcategory_id where testresult.customer_id=?; ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                testList.add(new Test(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getDate(7), rs.getString(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testList;

    }
    public List<Test> groupByCusTest(){
        List<Test> list = new ArrayList<>();
        String sql = "select  testresult.test_status , testresult.customer_id, customer.customer_name, customer.customer_status from testresult inner join customer \n" +
"on testresult.customer_id = customer.customer_id  \n" +
"group by testresult.test_status , testresult.customer_id";
         try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Test(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
   
    public int getCountCustomer(int id){
        int count = 0;
        String sql = "select count(customer_id) from testresult where customer_id = ?";
          try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){               
                return count = rs.getInt(1);
            }
            rs.close();
             ps.close();
        } catch (Exception e) {
             e.printStackTrace();
        }
        return count;
      
        
    }
    public int getCountStatus(int id){
        int count = 0;
        String sql = "select count(test_status) from testresult where customer_id = ? and test_status =1";
          try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){               
                return count = rs.getInt(1);
            }
            rs.close();
             ps.close();
        } catch (Exception e) {
             e.printStackTrace();
        }
        return count;
    }
    
    public List<TestCategory> search(String keyword) {
        List<TestCategory> list = new ArrayList<>();
        try {
            String sql = "select *  from testcategory where test_name like ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TestCategory testCategory = new TestCategory();
                testCategory.setTestCategoryid(rs.getInt(1));
                testCategory.setTestName(rs.getString(2));
                testCategory.setImage(rs.getString(3));
                testCategory.setTestPrice(rs.getInt(4));
                list.add(testCategory);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
      public int countTest(){  
         String sql = "select count(*) from testresult";
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
    public List<Test> pageTest(int index){
         List<Test> testList = new ArrayList<>();
        String sql = "SELECT * FROM Test\n" +
"LIMIT 10 OFFSET ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, (index-1)*10);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                testList.add(new Test(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getDate(7), rs.getString(8)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return testList;
    }


    public static void main(String[] args) {
        TestDAO dao = new TestDAO();
  
       
    }

}
