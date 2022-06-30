package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {
public static void main(String[] args) {
	
	Configuration configuration=new Configuration();
	configuration.configure("hibernate.cfg.xml");
	configuration.addAnnotatedClass(Student.class);
	SessionFactory sessionFactory=configuration.buildSessionFactory();
	Session session=sessionFactory.getCurrentSession();
	try {
		//First Example
		session.beginTransaction();
		int theStudentId = 7;
		Student myStudent = session.get(Student.class, theStudentId);// get data by Id
		session.delete(myStudent);
		session.getTransaction().commit();
		session.flush();
		
		
		
		// Second Example
		session.beginTransaction();
		System.out.println("Delete the data of stdent where id is 6");
		session.createQuery("delete from Student where id=6").executeUpdate();
		session.getTransaction().commit();
		session.flush();
	} finally {
		sessionFactory.close();
	}
}
}
