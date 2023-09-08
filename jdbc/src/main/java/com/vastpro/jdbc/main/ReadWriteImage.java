package com.vastpro.jdbc.main;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;

public class ReadWriteImage {
	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/vastpro";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
//		PreparedStatement ps=con.prepareStatement("insert into myimages (image) values(?)");
//		ps.setBytes(1, readImageToBytes("omiet.png"));
//		ps.execute();

		// To Read
		PreparedStatement ps = con.prepareStatement("select * from myimages");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1));
			byte b[] = rs.getBytes(2);
			ByteArrayInputStream inputStream = new ByteArrayInputStream(b);

			BufferedImage image = ImageIO.read(inputStream);
			// Display or save the BufferedImage as needed
			// For example, saving the image to a file:
			ImageIO.write(image, "png", new File("output.png"));
		}
	}

	public static byte[] readImageToBytes(String path) throws Exception {
		FileInputStream fis = new FileInputStream(path);
		byte b[] = new byte[fis.available()];
		fis.read(b);
		return b;
	}
}
