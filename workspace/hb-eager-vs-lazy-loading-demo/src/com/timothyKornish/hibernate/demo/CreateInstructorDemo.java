package com.timothyKornish.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.timothyKornish.hibernate.demo.entity.Course;
import com.timothyKornish.hibernate.demo.entity.Instructor;
import com.timothyKornish.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Instructor.class)
									 .addAnnotatedClass(InstructorDetail.class)
									 .addAnnotatedClass(Course.class)
									 .buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
	
			// use the session object to save Java object
			// create the objects
			Instructor tempInstructor = new Instructor("Susan", "Patel", "Susan.Patel@coding.com");
						
			InstructorDetail tempInstructorDetail =  new InstructorDetail(
																"http;//www.SusanGaming.com/youtube",
																"Gaming");
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
						
						
			// start a transaction
			System.out.println("Beginning transaction...");
			session.beginTransaction();
						
			// save the instructor
			//
			// Note: this will also save the details object because of CascadeType.ALL
			System.out.println("Saving instructor " + tempInstructor);
			session.save(tempInstructor);
						
			// commit transaction
			session.getTransaction().commit();
			System.out.println("transaction done!");
			
		} finally {
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}
