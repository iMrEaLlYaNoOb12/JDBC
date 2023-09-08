package com.vastpro.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCProg3 {
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

		// Statement st=con.createStatement();
		// String uname="shoiab";
		// String sql="insert into employee values(1,'ramu','spider',1000,'chennai',0)";
		String sql = "insert into employee values (?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setInt(1, 2);
		pstmt.setString(2, "somu");
		pstmt.setString(3, "superman");
		pstmt.setInt(4, 2000);
		pstmt.setString(5, "banglore");
		pstmt.setInt(6, 0);

		int n = pstmt.executeUpdate();

		System.out.println("Number of rows updated...:" + n);
	}
}
