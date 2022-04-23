package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectFetch 
{
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
		System.out.println("enter id to fetch record");
		int id = sc.nextInt();
		try {
			Class.forName(drive);
			conn=DriverManager.getConnection(url, un, pass);
			st=conn.createStatement();
			String sql="select * from loginpage where id="+id;  //get only one row
			r=st.executeQuery(sql);
			if(r.next())
			{
				System.out.println(r.getInt(1)+" "+r.getString(2));
			}
			else
			{
				System.out.println("invalid");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
