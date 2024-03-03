package com.abhi;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.abhi.entities.Student;
import com.abhi.entities.Teacher;

public class App {
	public static void main(String[] args) throws IOException {

		Configuration mconfiguration = null;
		Configuration pconfiguration = null;

		SessionFactory msessionFactory = null;
		SessionFactory psessionFactory = null;

		Session msession = null;
		Session psession = null;
 
		Transaction mtxn = null;
		Transaction ptxn = null;


		try {

			mconfiguration = new Configuration();
			mconfiguration.configure("mysql.cfg.xml");
			
			pconfiguration = new Configuration();
			pconfiguration.configure("postgresql.cfg.xml");

			msessionFactory = mconfiguration.buildSessionFactory();
			psessionFactory = pconfiguration.buildSessionFactory();

			
			msession = msessionFactory.openSession();
			psession = psessionFactory.openSession();

			mtxn = msession.beginTransaction();
			ptxn = psession.beginTransaction();

			

			//while (true) {
				
				Student s = new Student();
				Teacher t=new Teacher();
				

				s.setRno(103);
				s.setName("AAA");
				s.setPer(80.50);
				
				t.setTno(1);
				t.setTname("BBB");
				t.setSalary(1000);
			
				msession.save(s);
				psession.save(s);
				
				msession.save(t);
				psession.save(t);
				

				mtxn.commit(); 
				ptxn.commit();

				System.out.println(" done project");
			//}
			

		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
			msession.close();
			psession.close();

			
			msessionFactory.close();
			psessionFactory.close();
		}

	}
}
