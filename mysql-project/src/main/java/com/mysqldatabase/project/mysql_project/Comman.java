package com.mysqldatabase.project.mysql_project;

import java.sql.DriverManager;
import java.sql.*;

public class Comman 
{
  public static Connection con;
       public static Connection con()
       { 
         try 
          {
           Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","admin");
           }
            catch (Exception e) 
           {
            e.printStackTrace();
           }
         return con;
       }
}
