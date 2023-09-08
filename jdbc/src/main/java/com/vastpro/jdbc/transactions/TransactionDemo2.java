package com.vastpro.jdbc.transactions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Savepoint;

import com.vastpro.jdbc.conutil.ConnectionUtility1;

public class TransactionDemo2 {
	public static void main(String[] args) throws Exception {
		Connection con = ConnectionUtility1.getConnection();

		Savepoint sp = null;
		try {
			PreparedStatement psup = con.prepareStatement("update employee set flag=1");
			psup.executeUpdate();

			sp = con.setSavepoint("first");

			PreparedStatement ps = con.prepareStatement("update employee set esal=? where ename=?");
			ps.setInt(1, 1000);
			ps.setString(2, "ramu");
			ps.executeUpdate();

			ps = con.prepareStatement("update employee set esal=? where ename=?");

			ps.setInt(1, 3000);
			ps.setString(3, "somu");
			ps.executeUpdate();

			ConnectionUtility1.closeConnection(null, null);
		} catch (Exception e) {
			ConnectionUtility1.closeConnection(e, sp);
			e.printStackTrace();
		}
	}

}
