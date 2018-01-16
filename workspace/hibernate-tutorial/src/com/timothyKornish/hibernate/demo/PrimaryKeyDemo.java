package com.timothyKornish.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.timothyKornish.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Student.class)
				 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save Java object
			// create 3 student objects
			System.out.println("Creating 3 student objects...");
			Student tempStudent1 = new Student("John", "Doe", "John.Doe@coding.com");
			Student tempStudent2 = new Student("Jamal", "Jamalason", "Jamal.Jamalason@Jamaica.com");
			Student tempStudent3 = new Student("Bonita", "Pinata","PINATAS@Espana.com");
			
			// start a transaction
			System.out.println("Beginning transaction...");
			session.beginTransaction();

			// save the student object
			System.out.println("saving student in transaction...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("transaction done!");
			
		} finally {
			factory.close();
		}
	}

}
