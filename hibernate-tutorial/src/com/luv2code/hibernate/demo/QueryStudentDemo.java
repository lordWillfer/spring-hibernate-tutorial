package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

		// Create the session
		Session session = factory.getCurrentSession();

		try {
			// Start a transaction
			session.beginTransaction();

			// Query Students
			List<Student> theStudents = session.createQuery("from Student").list();

			// Display Students
			displayStudents(theStudents);

			// Query Students: lastName ='Doe'
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").list();

			// Display the Students
			System.out.println("\nStudents who have last name of Doe");
			displayStudents(theStudents);

			// Query Students: lastName='Doe' OR firsName='Daffy'
			theStudents = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Daffy'").list();

			// Display the Students
			System.out.println("\nStudents who have last name of Doe or first name Daffy");
			displayStudents(theStudents);

			// Query Students where email LIKE '%luv2code.com'
			theStudents = session.createQuery("from Student s where s.email like '%gmail.com'").list();

			// Display the Students
			System.out.println("\nStudents whose email ends with gmail.com");
			displayStudents(theStudents);

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

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}
}