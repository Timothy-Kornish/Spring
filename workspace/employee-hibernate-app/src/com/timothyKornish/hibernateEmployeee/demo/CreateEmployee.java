package com.timothyKornish.hibernateEmployeee.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.timothyKornish.hibernatEmployee.demo.entity.Employee;

public class CreateEmployee {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
	
		Session session = factory.getCurrentSession();
		try {
			saveEmployee(session, new Employee("Bob", "Builder", "Building Inc."));
		} finally {
			factory.close();
		}
	}
	
	public static void saveEmployee(Session session, Employee myEmployee) {
		
			// begin transaction
			session.beginTransaction();
			
			// save employee
			session.save(myEmployee);
			
			// commit transaction
			session.getTransaction().commit();

	}
}