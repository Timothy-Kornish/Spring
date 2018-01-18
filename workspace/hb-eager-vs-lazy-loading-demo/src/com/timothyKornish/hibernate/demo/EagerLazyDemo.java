package com.timothyKornish.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.timothyKornish.hibernate.demo.entity.Course;
import com.timothyKornish.hibernate.demo.entity.Instructor;
import com.timothyKornish.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

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
						
			// start a transaction
			System.out.println("Beginning transaction...");
			session.beginTransaction();
						
			// get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Instructor: " + tempInstructor);
			
			System.out.println("Courses: " + tempInstructor.getCourses());
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("transaction done!");
			session.close();
			System.out.println("\nSession is now closed\n");
			// since the courses are lazy loaded... this should fail
			
			// option 1: call getter method before session closes,
			// and lazy loading will work after session closes
			
			
			// get course for the instructor
			System.out.println("Courses: " + tempInstructor.getCourses());
						
			
			
		} finally {
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}
