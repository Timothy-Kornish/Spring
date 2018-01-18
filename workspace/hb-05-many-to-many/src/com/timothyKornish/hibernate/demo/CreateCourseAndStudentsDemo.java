package com.timothyKornish.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.timothyKornish.hibernate.demo.entity.Course;
import com.timothyKornish.hibernate.demo.entity.Instructor;
import com.timothyKornish.hibernate.demo.entity.InstructorDetail;
import com.timothyKornish.hibernate.demo.entity.Review;
import com.timothyKornish.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
						
			// create a course
			Course tempCourse = new Course("Linear Algebra");
			
			
			System.out.println("\nSaving the course...");
			session.save(tempCourse);
			System.out.println("Saved the course: " + tempCourse);
			
			// create the students
			Student tempStudent1 = new Student("John", "Doe", "john@coding.com");
			Student tempStudent2 = new Student("Mary", "Jane", "Mary.Jane@coding.com");
			Student tempStudent3 = new Student("Jamal", "Jamalason", "jamal@coding.com");
			
			// add students to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			tempCourse.addStudent(tempStudent3);
			
			// save the students
			System.out.println("\nSaving the students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			System.out.println("Saved the students: " + tempCourse.getStudents());
			
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
