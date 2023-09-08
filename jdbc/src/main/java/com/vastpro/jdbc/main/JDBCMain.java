package com.vastpro.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		String URL = "jdbc:mysql://localhost:3306/vastpro";
		String username = "root";
		String password = "root";

		Connection con = DriverManager.getConnection(URL, username, password);
		System.out.println(con);
	}

}
