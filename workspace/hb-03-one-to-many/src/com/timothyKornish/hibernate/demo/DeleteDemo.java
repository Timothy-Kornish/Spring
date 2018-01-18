package com.timothyKornish.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.timothyKornish.hibernate.demo.entity.Instructor;
import com.timothyKornish.hibernate.demo.entity.InstructorDetail;
import com.timothyKornish.hibernate.demo.entity.Student;

public class DeleteDemo {

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
			
			
			// start a transaction
			System.out.println("Beginning transaction...");
			session.beginTransaction();
						
			// get instructor by primary key / id
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
						
			System.out.println("Founr instructor: " + tempInstructor);
			// delete the instructor
			if(tempInstructor != null) {
				System.out.println("Deleting: " + tempInstructor);
							
				// Note: will ALso delete associated "details" object because of CasacadeType.ALL
				session.delete(tempInstructor);
			}
						
			// commit transaction
			session.getTransaction().commit();
			System.out.println("transaction done!");
			
		} finally {
			factory.close();
		}
	}

}
