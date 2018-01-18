package com.timothyKornish.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.timothyKornish.hibernate.demo.entity.Course;
import com.timothyKornish.hibernate.demo.entity.Instructor;
import com.timothyKornish.hibernate.demo.entity.InstructorDetail;
import com.timothyKornish.hibernate.demo.entity.Review;
import com.timothyKornish.hibernate.demo.entity.Student;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Instructor.class)
									 .addAnnotatedClass(InstructorDetail.class)
									 .addAnnotatedClass(Student.class)
									 .addAnnotatedClass(Course.class)
									 .addAnnotatedClass(Review.class)
									 .buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {						
						
			// start a transaction
			System.out.println("Beginning transaction...");
			session.beginTransaction();
						
			// get the Linear Algebra course from db
			int courseId = 10;
			Course tempCourse = session.get(Course.class, courseId);
			
			System.out.println("Got course from db: " + tempCourse);
			
			// delete the course
			System.out.println("Deleting course...");
			session.delete(tempCourse);
			
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
