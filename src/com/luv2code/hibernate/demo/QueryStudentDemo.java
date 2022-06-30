package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;
import java.util.*;

public class QueryStudentDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();

			List<Student> thestudents = session.createQuery("from Student", Student.class).list();

			System.out.println(thestudents);

			thestudents = session.createQuery("from Student st where st.id=4", Student.class).list();

			System.out.println(thestudents);

			session.getTransaction().commit();
		} finally {
			session.close();
		}

	}
}
