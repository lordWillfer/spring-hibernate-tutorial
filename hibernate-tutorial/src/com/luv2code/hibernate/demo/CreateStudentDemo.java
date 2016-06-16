package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// Create the session
		Session session = factory.getCurrentSession();
		
		try {
			// Use the session object to save Java object
			// Create a Student object
			System.out.println("Creating new Student object...");
			Student tempStudent = new Student("Paul", "Wall", "paul@luv2code.com");
			
			// Start a transaction
			session.beginTransaction();
			
			// Save the Student object
			System.out.println("Saving the Student...");
			session.save(tempStudent);
			
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