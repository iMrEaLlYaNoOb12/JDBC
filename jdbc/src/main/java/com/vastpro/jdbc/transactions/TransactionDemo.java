package com.vastpro.jdbc.transactions;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.vastpro.jdbc.conutil.ConnectionUtility;

public class TransactionDemo {
	public static void main(String[] args) throws Exception {
		Connection con = ConnectionUtility.getConnection();
		con.setAutoCommit(false);
		PreparedStatement ps = con.prepareStatement("update employee set esal=? where ename=?");
		try {
			ps.setInt(1, 1000);
			ps.setString(2, "ramu");
			ps.executeUpdate();

			ps = con.prepareStatement("update employee set esal=? where ename=?");

			ps.setInt(1, 3000);
			ps.setString(3, "somu");
			ps.executeUpdate();

			con.commit();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
		}
	}

}
