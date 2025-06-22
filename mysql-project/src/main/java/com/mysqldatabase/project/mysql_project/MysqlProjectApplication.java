package com.mysqldatabase.project.mysql_project;
import java.sql.*;
import java.util.*;
public class MysqlProjectApplication 
{
	public PreparedStatement ps ;
	public ResultSet rs;
	public static Scanner sc=new Scanner(System.in);
	public static MysqlProjectApplication a1;
	public static void main(String[] args) 
	{   int ch;
		 a1 =new MysqlProjectApplication();   
		 do
		{
			System.out.println("\n\n1.read\n 2.write\n 3.exit");
			System.out.println("Enter Your Choice:");
			 ch =sc.nextInt();
			switch(ch)
			{
				case 1:a1.read();
				     break;
				case 2:a1.write();
				     break;
				case 3:System.out.println("thanks for using my software");	
				     break;
				default:System.out.println("invalid choice..");	  	 
			}
		}while(3!=ch);
	}

	public void read() 
	{
			try
			{
				 ps = Comman.con().prepareStatement("select * from demo");
					 rs = ps.executeQuery();
					 System.out.println("===============================STUDENT-INFO===========================================");
					while(rs.next()) 
					{
						System.out.println("id_is :  " + rs.getInt(1) + " \t name: " + rs.getString(2) + "\t gmail: "
								+ rs.getString(3));
					}
					System.out.println("=======================================================================================");
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
