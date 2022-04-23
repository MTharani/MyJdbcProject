package com.edu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
public class Dbconnect {

	public static void main(String[] args)
	{

		//Make a connection with Database
		int id;
		String name;

		Scanner sc=new Scanner(System.in);

		System.out.println("Enter name");
		name=sc.next();

		System.out.println("Enter id");
		id=sc.nextInt();
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/entrydata";//database name
		String un="root";
		String pa="root";
		sc.close();
		try {
			//load the driver
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,un,pa);
			Statement st=conn.createStatement();

			String ins="insert into loginpage values("+id+",'"+name+"')";
			int i=st.executeUpdate(ins);
			if(i>0) {
				System.out.println("Record inserted");
			}else {
				System.out.println("Not inserted");
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

	}


}


