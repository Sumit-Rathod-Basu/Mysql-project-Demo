package com.mysqldatabase.project.mysql_project;
import java.sql.*;
import java.util.*;
public class MysqlProjectApplication 
{
	public PreparedStatement ps ;
	public ResultSet rs;
	public Scanner sc=new Scanner(System.in);
	public static MysqlProjectApplication a1;
	public static void main(String[] args) 
	{
			 a1 =new MysqlProjectApplication();
				//a1.read();
				a1.write();
	}

	public void read() 
	{
			try
			{
				 ps = Comman.con().prepareStatement("select * from demo");
					 rs = ps.executeQuery();
					while(rs.next()) 
					{
						System.out.println("id_is :\t" + rs.getInt(1) + " \t name: \t" + rs.getString(2) + "\t gmail: \t"
								+ rs.getString(3));
					}
			} catch (Exception e) 
			{
				e.printStackTrace();
			}

	}
	public void write() 
	{
		
		  try 
		  {
					ps = Comman.con().prepareStatement("insert into demo values(?,?,?)");
					System.out.println("enter\tid:");
					
					int no=sc.nextInt();
					ps.setInt(1, no);
					System.out.println("enter your name :");
					String str=sc.next();
					ps.setString(2,str);
					System.out.println("enter your gmail is:");
					str=sc.next();
					ps.setString(3, str);
					System.out.println("your data are inserted.....");
					System.out.println("Show your data yes/no ");
					str=sc.next();
					ps.executeUpdate();
					if(str.equals("yes"))
					{
							a1.read();
					}
		  }
		  catch( SQLException e)
		  {
				System.out.println("Error:"+e);
		  }

	}

}
