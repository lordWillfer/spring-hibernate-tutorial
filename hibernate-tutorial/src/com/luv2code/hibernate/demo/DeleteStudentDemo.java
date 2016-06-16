package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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

			// Delete the Student
			//System.out.println("Deleting Student: " + myStudent);
			//session.delete(myStudent);
			
			// Delete Student id=2
			System.out.println("Deleting Student id=2");
			session.createQuery("delete from Student where id=2").executeUpdate();
			
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