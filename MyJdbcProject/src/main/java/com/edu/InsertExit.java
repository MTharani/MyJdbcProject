package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class InsertExit {

	public static void main(String[] args) 
	{
		String drive="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/entrydata";
		String un="root";
		String pass="root";
		Connection conn=null;
		Statement st=null;
		ResultSet r=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the id");
		int id = sc.nextInt();
		
		try {
			Class.forName(drive);
			conn=DriverManager.getConnection(url, un, pass);
			st=conn.createStatement();
			String sql="select * from loginpage where id="+id;  
			r=st.executeQuery(sql);
			if(!r.next())
			{
				System.out.println("enter the name;");
				String name=sc.next();
				String ins="insert into loginpage values("+id+",'"+name+"')";
				int i=st.executeUpdate(ins);
				if(i>0)
				{
					System.out.println("record insert successfully:");
				}
			}
			else
			{
				System.out.println("id is exist! please chosse another id!");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}


	}

}
