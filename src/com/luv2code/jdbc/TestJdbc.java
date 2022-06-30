package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl="jdbc:mysql://localhost:3306/hbstudenttracker?useSSL=false&serverTimezone=UTC";
		
		String user="root";
		String password="root";
		try {
			System.out.println("Connect to database: "+ jdbcUrl);
			Connection myconn=DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("connection success");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
