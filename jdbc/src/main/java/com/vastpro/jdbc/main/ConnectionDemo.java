package com.vastpro.jdbc.main;

import java.sql.Connection;
//import java.sql.Connection;
import java.sql.DatabaseMetaData;

import com.vastpro.jdbc.conutil.ConnectionUtility;

public class ConnectionDemo {
	public static void main(String[] args) throws Exception {
		Connection con = ConnectionUtility.getConnection();

		DatabaseMetaData dm = con.getMetaData();

		System.out.println(dm.getDatabaseProductName());
		System.out.println(dm.getDatabaseMajorVersion());
		System.out.println(dm.getDriverName());
		System.out.println(dm.getDefaultTransactionIsolation());
		System.out.println("None..:" + Connection.TRANSACTION_NONE);
		System.out.println("Read Committed..:" + Connection.TRANSACTION_READ_COMMITTED);
		System.out.println("Read uncommitted..:" + Connection.TRANSACTION_READ_UNCOMMITTED);
		System.out.println("Repeat Read..:" + Connection.TRANSACTION_REPEATABLE_READ);
		System.out.println("Serializable..:" + Connection.TRANSACTION_SERIALIZABLE);

		con.setTransactionIsolation(8);
		dm = con.getMetaData();
		System.out.println(dm.getDefaultTransactionIsolation());
		System.out.println(con.getTransactionIsolation());

	}
}