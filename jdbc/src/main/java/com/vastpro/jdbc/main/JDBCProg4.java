package com.vastpro.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCProg4 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// Step 1 - Load or register the driver
		// Step 2 - Establish the connection

		// step1-loading the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// step 2 - Establish the connection
		String url = "jdbc:mysql://localhost:3306/vastpro";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);

		Statement stmt = con.createStatement();

		String sql = "select * from employee";

		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			System.out.println(rs.getInt("eid"));
			System.out.println(rs.getString(2));
		}

	}

}
