package com.timothyKornish.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.timothyKornish.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Student.class)
									 .buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save Java object
			// create student object
			System.out.println("Creating a new student object...");
			Student tempStudent = new Student("Daffy", "Duck", "Daffy.Duck@coding.com");
			
			// start a transaction
			System.out.println("Beginning transaction...");
			session.beginTransaction();
			
			// save the student object
			System.out.println("saving student in transaction...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("transaction done!");
			
			// my new code
			
			// find out the student's id: primary key
			System.out.println("Saved student. generated ID: " + tempStudent.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("Get complete: " + myStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("transaction done!");
			
		} finally {
			factory.close();
		}
	}

}
