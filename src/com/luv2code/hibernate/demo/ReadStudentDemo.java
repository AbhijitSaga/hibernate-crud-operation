package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();
			Student tempstudent = new Student("sanu","kumar","sanu@gmail.com");
			// retrive data from database;
                
			System.out.println("Getting with student id: "+ tempstudent.getId());
			session.save(tempstudent);// save data in database
			
			Student myStudent=session.get(Student.class, tempstudent.getId());//retrive student by id one
			System.out.println("Get complete: "+myStudent);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

}
