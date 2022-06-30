package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				               .addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		 try {
			 System.out.println("create four new student object..");
			 Student student=new Student("suraj","kumar","suraj@gmail.com");
			 Student student1=new Student("raju","kumar","raju@gmail.com");
			 Student student2=new Student("nadeem","kumar","nadeem@gmail.com");
			 Student student3=new Student("niteesh","kumar","niteesh@gmail.com");

			Transaction transaction=session.beginTransaction();
			session.save(student);
			session.save(student1);
			session.save(student2);
			session.save(student3);

			transaction.commit();
		
			 
		} finally {
            session.close();
		}
	}

}
