package com.luv2code.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		//create session fectory
		SessionFactory fectory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				                                  .buildSessionFactory();
		
		//create session
		Session session=fectory.getCurrentSession();
		
		try {
			//use session object to save java object
			System.out.println("creating new student object..");
			Student student=new Student("abhijit","sagar","abhijitsagar1204@gmail.com");
			Transaction transaction=session.beginTransaction();// start transaction
			session.save(student);// save object to db
			transaction.commit();//commit the transaction
			System.out.println("done save object...");
			
		} finally {
			session.close();
		}
	
	
	}

}
