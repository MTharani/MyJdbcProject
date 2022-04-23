package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectRecord {

	public static void main(String[] args) 
	{
		String drive="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/entrydata";
		String un="root";
		String pass="root";
		Connection conn=null;
		Statement st=null;
		ResultSet r=null;
		try {
			Class.forName(drive);
			conn=DriverManager.getConnection(url, un, pass);
			st=conn.createStatement();
			String sql="select * from loginpage";
			r=st.executeQuery(sql);
			System.out.println("id\tname");
			while(r.next())
			{
				int id=r.getInt("id");
				String name=r.getString("name");
				System.out.println(id+"\t"+name);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
