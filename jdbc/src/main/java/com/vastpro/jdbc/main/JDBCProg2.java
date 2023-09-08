package com.vastpro.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCProg2 {
	public static void main(String[] args) throws Exception {
		// Step 1 - Load or register the driver
		// Step 2 - Establish the connection

		// step1-loading the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// step 2 - Establish the connection
		String url = "jdbc:mysql://localhost:3306/vastpro";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);

		String sql ; // "create table employee(eid int(5),ename varchar(50),epass varchar(8),esal int(10),ecity varchar(40),flag int(1))";

		Statement stmt = con.createStatement();

		boolean b; //stmt.execute(sql);

		sql = "select * from employee";
		b = stmt.execute(sql);

		System.out.println(b ? "success-table created" : "failure");
	}
}
