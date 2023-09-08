package com.vastpro.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadWriteText {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/vastpro";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		String str = "jack and jill went up the hill";
		byte b[] = str.getBytes();
		//writeBlob(b, con);
		//writeClob(str, con);
		readBlob(con);
	}

	public static void writeBlob(byte b[], Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("insert into myfiles (file1) values (?)");
		ps.setBytes(1, b);
		ps.execute();
	}

	public static void writeClob(String str, Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("insert into myfiles (file2) values (?)");
		ps.setString(1, str);
		ps.execute();
	}

	public static void readBlob(Connection con) throws Exception {
		PreparedStatement ps = con.prepareStatement("select * from myfiles");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1));
			byte b[] = rs.getBytes(2);
			if (b != null) {
				String str = new String(b);
				System.out.println(str);
			}
			System.out.println(rs.getString(3));
		}
	}
}
