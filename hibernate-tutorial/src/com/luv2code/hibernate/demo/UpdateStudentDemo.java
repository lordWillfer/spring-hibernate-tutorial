package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

		// Create the session
		Session session = factory.getCurrentSession();

		try {
			int studentId = 1;

			// Now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// Retrieve Student based on the id: primary key
			System.out.println("\nGetting Student with id: " + studentId);
			Student myStudent = session.get(Student.class, studentId);

			System.out.println("Updating Student...");
			myStudent.setFirstName("Scooby");

			// Commit transaction
			session.getTransaction().commit();

			// NEW CODE
			session = factory.getCurrentSession();
			session.beginTransaction();

			// Update email for all Students
			System.out.println("Update email for all Students");
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();

			// Commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
}