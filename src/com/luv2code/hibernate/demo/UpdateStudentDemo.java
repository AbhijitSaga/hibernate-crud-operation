package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Student.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		int theStudentId = 1;
		try {

			// FIRST EXAMPLE
			session.beginTransaction();
			System.out.println("update data by student id: " + theStudentId);
			Student myStudent = session.get(Student.class, theStudentId);// it get data by student id
			myStudent.setFirstname("niteen");// update data
			session.getTransaction().commit();

			
			
			// SECOND EXAMPLE
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			// update email for all student
			System.out.println("update email for all student");
			session.createQuery("update Student set email='abhijtSagar1204@gmail.com' ").executeUpdate();
			session.getTransaction().commit();
			
		} finally {
			session.close();
		}

	}

}
