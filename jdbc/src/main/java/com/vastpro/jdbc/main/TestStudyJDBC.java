package com.vastpro.jdbc.main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Types;

public class TestStudyJDBC {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/vastpro";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		// int boo = cs.executeUpdate();

//		cs = con.prepareCall("{call insertValues(?,?,?)}");
//		cs.setInt(1, 6);
//		cs.setString(2, "Roshan");
//		cs.setString(3, "Purple");
//
//		boo = cs.executeUpdate();
//		System.out.println(boo);
		// CallableStatement cs = con.prepareCall("{call changeColorToBlue() }");

		CallableStatement cs = con.prepareCall("{call getBag(?,?)}");
		cs.setString(1, "black");
		cs.registerOutParameter(2, Types.VARCHAR);

		ResultSet rs = cs.executeQuery();
		String bag = cs.getString(2);
		System.out.println(bag);
		// String bag1=cs.getString(2);
		
		
		
		

	}
}
