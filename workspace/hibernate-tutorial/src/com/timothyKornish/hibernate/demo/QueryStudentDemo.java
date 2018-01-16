package com.timothyKornish.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.timothyKornish.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Student.class)
									 .buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
	
			// start a transaction
			System.out.println("Beginning transaction...");
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students
			displayStudents(theStudents);
			
			// quesry students: lastName = 'Doe'
			theStudents = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
			
			// display the students
			System.out.println("\n\nStudents with last name of Doe");
			displayStudents(theStudents);
			
			// quesry students: email ends with coding.com
			theStudents = session.createQuery("from Student s where s.email LIKE '%coding.com'").getResultList();
						
			// display the students
			System.out.println("\n\nStudents with email ending in coding.com");
			displayStudents(theStudents);
			
			// quesry students: email ends with coding.com
			theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
									
			// display the students
			System.out.println("\n\nStudents with email ending in gmail.com");
			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("transaction done!");
			
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

}
