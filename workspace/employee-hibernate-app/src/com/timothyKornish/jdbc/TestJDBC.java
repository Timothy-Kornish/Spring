package com.timothyKornish.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class TestJDBC {

	public static void main(String[] args) {
		
		String jdbcURL = "jdbc:mysql://localhost:3306/hb_employee_tracker?useSSL=false";
		String user = "hbemployee";
		String pass = "hbemployee";
		
		try {
			System.out.println("Connecting to mysql database: " + jdbcURL);
			Connection myConn = DriverManager.getConnection(jdbcURL, user, pass);
			System.out.println("Connection Successful");
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
