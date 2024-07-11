
package javaapplication5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class conn {
    Statement s;
   public conn() {
       try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemng","root","Ksengupta18$");
         s = con.createStatement();
       }
       catch (Exception e)
       {
          e.printStackTrace();
       }
   }
}
