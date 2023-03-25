package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectMySQL {
   public Connection connection;
   public ConnectMySQL(){
       String url = "jdbc:mysql://localhost:3306/projectswp391";
       String user = "root";
       String password = "huyquan09052002";
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(ConnectMySQL.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(ConnectMySQL.class.getName()).log(Level.SEVERE, null, ex);
       }
    
       
   }
    public static void main(String[] args) throws SQLException {
        try {
           System.out.println(new ConnectMySQL().connection);
        } catch (Exception e) {
       }
    }
}