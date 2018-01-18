package com.timothyKornish.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.timothyKornish.hibernate.demo.entity.Instructor;
import com.timothyKornish.hibernate.demo.entity.InstructorDetail;
import com.timothyKornish.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Instructor.class)
									 .addAnnotatedClass(InstructorDetail.class)
									 .buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
	
			// use the session object to save Java object
			// create the objects
			Instructor tempInstructor = new Instructor("Jamal", "Jamalason", "jamal@coding.com");
						
			InstructorDetail tempInstructorDetail =  new InstructorDetail(
																"http;//www.jamalCoding.com/youtube",
																"coding all da time");
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
						
			Instructor tempInstructor2 = new Instructor("Timooothy", "Jamalason", "timooothy@coding.com");
						
			InstructorDetail tempInstructorDetail2 =  new InstructorDetail(
														"http;//www.timooothyCoding.com/youtube",
														"doing dat programmin");
			// associate the objects
			tempInstructor2.setInstructorDetail(tempInstructorDetail2);
						
			// start a transaction
			System.out.println("Beginning transaction...");
			session.beginTransaction();
						
			// save the instructor
			//
			// Note: this will also save the details object because of CascadeType.ALL
			System.out.println("Saving instructor " + tempInstructor);
			session.save(tempInstructor);
			session.save(tempInstructor2);
						
			// commit transaction
			session.getTransaction().commit();
			System.out.println("transaction done!");
			
		} finally {
			factory.close();
		}
	}

}
