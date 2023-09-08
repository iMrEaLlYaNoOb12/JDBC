package com.vastpro.jdbc.main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class JDBCCallableStatement {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/vastpro";
		String username = "root";
		String password = "root";

		Connection con = DriverManager.getConnection(url, username, password);

		String sql = "{call myproc1()}";

		CallableStatement cs = con.prepareCall(sql);
		cs.executeUpdate();

		cs = con.prepareCall("{call updateFlaf(?,?)}");
		cs.setString(1, "Prashanth");
		cs.setInt(2, 1);

		int i = cs.executeUpdate();
		System.out.println("no of rows updated...:" + i);

		cs = con.prepareCall("{call countEmployees(?)}");
		cs.registerOutParameter(1, Types.INTEGER);

		cs.execute();

		int no = cs.getInt(1);

		System.out.println("No Of Rows...:" + no);

		cs = con.prepareCall("{call getFlagValue(?,?)}");

		cs.setString(1, "Guru");
		cs.registerOutParameter(2, Types.INTEGER);

		cs.execute();

		int flagvalue = cs.getInt(2);
		System.out.println("flag value of Guru is...:" + flagvalue);

	}
}
