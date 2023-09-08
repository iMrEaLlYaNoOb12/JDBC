package com.vastpro.main;

import java.util.List;

import com.vastpro.dao.StudentDAO;
import com.vastpro.dao.StudentDAOImpl;
import com.vastpro.jdbc.conutil.ConnectionUtility1;
import com.vastpro.model.Student;

public class StudentDAOMain {
	public static void main(String[] args) throws Exception {
		StudentDAO impl = new StudentDAOImpl(ConnectionUtility1.getConnection());

		Student student = impl.findByID(3);
		System.out.println("find by ID : " + student + "\n");

		impl = new StudentDAOImpl(ConnectionUtility1.getConnection());
		student = impl.findBySname("Prashanth");
		System.out.println("find by name : " + student + "\n");

		impl = new StudentDAOImpl(ConnectionUtility1.getConnection());
		List<Student> students = impl.findAll();
		for (Student student2 : students) {
			System.out.println(student2);
		}

	}
}
