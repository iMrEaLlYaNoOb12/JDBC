package com.vastpro.jdbc.main;

import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.vastpro.jdbc.conutil.ConnectionUtility;

public class TestConUtility {
	public static void main(String[] args) throws Exception {
		ExecutorService es = Executors.newFixedThreadPool(2);

		es.execute(() -> {
			try {
				Connection con = ConnectionUtility.getConnection();
				System.out.println("Thread1...:" + con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		es.execute(() -> {
			try {
				Connection con = ConnectionUtility.getConnection();
				System.out.println("Thread2...:" + con);
				Connection connn = ConnectionUtility.getConnection();
				System.out.println("Thread2...:" + connn);
				ConnectionUtility.closeConnection();
				Connection connn2 = ConnectionUtility.getConnection();
				System.out.println("Thread2...:" + connn2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		es.shutdown();
	}
}
